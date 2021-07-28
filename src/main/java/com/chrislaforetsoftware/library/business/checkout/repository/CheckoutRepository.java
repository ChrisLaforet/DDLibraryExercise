package com.chrislaforetsoftware.library.business.checkout.repository;

import com.chrislaforetsoftware.library.business.catalog.entities.Book;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.business.checkout.entities.Checkout;
import com.chrislaforetsoftware.library.business.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.io.catalog.repository.BookJpaRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.CatalogJpaRepository;
import com.chrislaforetsoftware.library.io.checkout.repository.CheckoutJpaRepository;
import com.chrislaforetsoftware.library.io.patron.repository.PatronJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutRepository implements ICheckoutRepository {

    private final CheckoutJpaRepository repository;
    private final CatalogJpaRepository catalogRepository;
    private final BookJpaRepository bookRepository;
    private final PatronJpaRepository patronRepository;

    @Autowired
    public CheckoutRepository(CheckoutJpaRepository repository,
                              CatalogJpaRepository catalogRepository,
                              BookJpaRepository bookRepository,
                              PatronJpaRepository patronRepository) {
        this.repository = repository;
        this.catalogRepository = catalogRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public List<ICheckout> getCheckoutsForTitle(ITitle title) {
        final List<ICheckout> list = new ArrayList<>();
        bookRepository.findByIsbn(title.getISBN())
                .forEach(book -> {
                    Optional<com.chrislaforetsoftware.library.io.checkout.entities.Checkout> checkout =
                                        repository.findByBookId(book.getId());
                    checkout.ifPresent(value -> list.add(convertDbCheckout(value)));
                });
        return list;
    }

    private ICheckout convertDbCheckout(com.chrislaforetsoftware.library.io.checkout.entities.Checkout dbCheckout) {
        com.chrislaforetsoftware.library.io.patron.entities.Patron patron =
                        patronRepository.findById(dbCheckout.getPatronId()).orElseThrow(() -> new IllegalStateException("Cannot locate patron"));
        com.chrislaforetsoftware.library.io.catalog.entities.Book book =
                        bookRepository.findById(dbCheckout.getBookId()).orElseThrow(() -> new IllegalStateException("Cannot locate book"));
        com.chrislaforetsoftware.library.io.catalog.entities.Catalog catalog =
                        catalogRepository.findByIsbn(book.getIsbn()).orElseThrow(() -> new IllegalStateException("Cannot locate catalog entry"));
        ITitle title = new Title(catalog.getIsbn(), catalog.getTitle(), catalog.getAuthor());
        return new Checkout(dbCheckout.getId(),
                                new Patron(Integer.toString(patron.getId()), patron.getName(), patron.isResearcher() ? IPatron.PatronType.RESEARCHER : IPatron.PatronType.NONRESEARCHER),
                                new Book(book.getId(), title, book.getPrice(), book.isRestricted() ? IBook.AssignedUse.RESTRICTED : IBook.AssignedUse.CIRCULATING),
                                dbCheckout.getCheckedOut());
    }

    @Override
    public List<ICheckout> getCheckoutsForPatron(IPatron patron) {
        final List<ICheckout> list = new ArrayList<>();
        repository.findByPatronId(Integer.getInteger(patron.getId())).forEach(value -> list.add(convertDbCheckout(value)));
        return list;
    }

    @Override
    public ICheckout checkoutBook(IBook book, IPatron patron) {
        if (repository.findByBookId(book.getId()).isPresent()) {
            throw new IllegalStateException("Book is already checked out");
        }

        com.chrislaforetsoftware.library.io.checkout.entities.Checkout checkout =
                new com.chrislaforetsoftware.library.io.checkout.entities.Checkout();
        checkout.setBookId(book.getId());
        checkout.setPatronId(Integer.getInteger(patron.getId()));
        checkout.setCheckedOut(new Date());
        repository.save(checkout);

        return convertDbCheckout(checkout);
    }

    @Override
    public void checkinBook(IBook book) {
        Optional<com.chrislaforetsoftware.library.io.checkout.entities.Checkout> checkout =
                repository.findByBookId(book.getId());
        if (!checkout.isPresent()) {
            throw new IllegalStateException("Book is not checked out");
        }
        repository.delete(checkout.get());
    }
}

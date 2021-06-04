package com.chrislaforetsoftware.library.business.catalog.repository;

import com.chrislaforetsoftware.library.business.catalog.entities.Book;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.repository.IBookRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.BookJpaRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.CatalogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookRepository implements IBookRepository {

    private final BookJpaRepository repository;
    private final CatalogJpaRepository catalogRepository;

    @Autowired
    public BookRepository(BookJpaRepository repository,
                          CatalogJpaRepository catalogRepository) {
        this.repository = repository;
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Optional<IBook> getBookById(int id) {
        Optional<com.chrislaforetsoftware.library.io.catalog.entities.Book> dbBook = repository.findById(id);
        if (!dbBook.isPresent()) {
            return Optional.empty();
        }
        Optional<com.chrislaforetsoftware.library.io.catalog.entities.Catalog> dbCatalog =
                catalogRepository.findByIsbn(dbBook.get().getIsbn());
        if (!dbCatalog.isPresent()) {
            throw new IllegalStateException("Cannot find catalog referenced by existing book");
        }
        Title title = new Title(dbCatalog.get().getIsbn(), dbCatalog.get().getTitle(), dbCatalog.get().getAuthor());
        return Optional.of(convertDbBook(dbBook.get(), title));
    }

    private IBook convertDbBook(com.chrislaforetsoftware.library.io.catalog.entities.Book dbBook, Title title) {
        return new Book(dbBook.getId(), title, dbBook.getPrice(), dbBook.isRestricted() ? IBook.AssignedUse.RESTRICTED : IBook.AssignedUse.CIRCULATING);
    }
}

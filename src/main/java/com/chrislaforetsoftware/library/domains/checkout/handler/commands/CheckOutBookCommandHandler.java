package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.repository.IBookRepository;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutBookCommandHandler implements ICommandHandler<CheckOutBookCommand, ICheckout> {

    private final ICheckoutRepository repository;
    private final IBookRepository bookRepository;
    private final IPatronRepository patronRepository;

    @Autowired
    public CheckOutBookCommandHandler(ICheckoutRepository repository,
                                      IBookRepository bookRepository,
                                      IPatronRepository patronRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public ICheckout handle(CheckOutBookCommand command) {
        IBook book = bookRepository.getBookById(command.getBookId())
                        .orElseThrow(() -> new IllegalStateException("Cannot find book to check out"));
        IPatron patron = patronRepository.findPatronById(Integer.toString(command.getPatronId()))
                        .orElseThrow(() -> new IllegalStateException("Cannot find patron to check out book"));

        return repository.checkoutBook(book, patron);
    }
}

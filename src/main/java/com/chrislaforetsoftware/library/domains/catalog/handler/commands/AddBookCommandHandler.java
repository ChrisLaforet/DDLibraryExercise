package com.chrislaforetsoftware.library.domains.catalog.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddBookCommand;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.domains.catalog.rules.CatalogRules;
import com.chrislaforetsoftware.library.domains.checkout.events.BookCheckedIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AddBookCommandHandler implements ICommandHandler<AddBookCommand, IBook> {

    private final ICatalogRepository repository;
    private final CatalogRules rules;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AddBookCommandHandler(ICatalogRepository repository,
                                 CatalogRules rules,
                                 ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.rules = rules;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public IBook handle(AddBookCommand command) {
        assertTitleIsValid(command);
        assertBookPropertiesAreValid(command);

        IBook newBook = repository.addBookToCatalog(command.getBook().getTitleInstance().getISBN(),
                command.getBook().getPrice(),
                command.getBook().getAssignedUse());
        applicationEventPublisher.publishEvent(new BookCheckedIn(this, newBook));
        return newBook;
    }

    private void assertTitleIsValid(AddBookCommand command) {
        if (command.getBook().getTitleInstance() == null) {
            throw new IllegalStateException("Cannot add new book instance to catalog - missing title");
        }

        repository.findTitleByISBN(command.getBook().getTitleInstance().getISBN())
                .orElseThrow(() -> new IllegalStateException("Cannot add new book instance to catalog - ISBN not found"));
    }

    private void assertBookPropertiesAreValid(AddBookCommand command) {
        if (command.getBook().getTitleInstance() == null) {
            throw new IllegalStateException("Cannot add new book instance to catalog - missing title");
        }
        if (!rules.isBookEligibleForAdding(command.getBook().getTitleInstance().getISBN(),
                command.getBook().getTitleInstance().getTitle(),
                command.getBook().getPrice())) {
            throw new IllegalStateException("Cannot add new book instance to catalog - missing key information");
        }
    }
}

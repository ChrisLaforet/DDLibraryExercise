package com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.catalog.entities.Book;
import lombok.Getter;

@Getter
public class AddBookCommand implements ICommand {
    private final Book book;

    public AddBookCommand(final Book book) {
        this.book = book;
    }
}

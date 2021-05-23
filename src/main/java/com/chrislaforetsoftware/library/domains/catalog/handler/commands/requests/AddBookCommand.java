package com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import lombok.Getter;

@Getter
public class AddBookCommand implements ICommand {
    private final IBook book;

    public AddBookCommand(final IBook book) {
        this.book = book;
    }
}

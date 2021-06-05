package com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import lombok.Getter;

@Getter
public class CheckInBookCommand implements ICommand {
    private final IBook book;

    public CheckInBookCommand(IBook book) {
        this.book = book;
    }
}

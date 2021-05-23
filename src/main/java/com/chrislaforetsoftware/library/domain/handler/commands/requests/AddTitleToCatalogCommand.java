package com.chrislaforetsoftware.library.domain.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import lombok.Getter;

@Getter
public class AddTitleToCatalogCommand implements ICommand {
    private final String ISBN;
    private final String titlw;

    public AddTitleToCatalogCommand(final String ISBN, final String title) {
        this.ISBN = ISBN;
        this.titlw = title;
    }
}

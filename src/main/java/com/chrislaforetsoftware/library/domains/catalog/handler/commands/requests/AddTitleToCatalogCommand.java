package com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import lombok.Getter;

@Getter
public class AddTitleToCatalogCommand implements ICommand {
    private final String ISBN;
    private final String title;
    private final String author;

    public AddTitleToCatalogCommand(final String ISBN, final String title, final String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
}

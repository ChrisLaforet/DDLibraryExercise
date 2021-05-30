package com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetBooksByISBNQuery implements IQuery {
    private final String isbn;

    public GetBooksByISBNQuery(String isbn) {
        this.isbn = isbn;
    }
}
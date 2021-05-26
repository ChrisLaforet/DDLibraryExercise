package com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetTitleByISBNQuery implements IQuery {
    private final String ISBN;

    public GetTitleByISBNQuery(String ISBN) {
        this.ISBN = ISBN;
    }
}
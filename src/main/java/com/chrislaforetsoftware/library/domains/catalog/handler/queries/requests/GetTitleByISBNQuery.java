package com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetTitleByISBNQuery implements IQuery {
    private final String id;

    public GetTitleByISBNQuery(String id) {
        this.id = id;
    }
}
package com.chrislaforetsoftware.library.domains.patron.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetPatronsByNameQuery implements IQuery {
    private final String name;

    public GetPatronsByNameQuery(String name) {
        this.name = name;
    }
}

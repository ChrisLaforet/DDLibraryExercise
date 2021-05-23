package com.chrislaforetsoftware.library.domains.patron.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetPatronByIdQuery implements IQuery {
    private final String id;

    public GetPatronByIdQuery(String id) {
        this.id = id;
    }
}

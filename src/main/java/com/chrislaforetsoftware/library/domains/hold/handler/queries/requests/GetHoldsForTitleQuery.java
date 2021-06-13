package com.chrislaforetsoftware.library.domains.hold.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;

@Getter
public class GetHoldsForTitleQuery implements IQuery {
    private final ITitle title;

    public GetHoldsForTitleQuery(ITitle title) {
        this.title = title;
    }
}

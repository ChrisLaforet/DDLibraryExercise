package com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

@Getter
public class GetBooksForPatronQuery implements IQuery {
    private IPatron patron;

    public GetBooksForPatronQuery(IPatron patron) {
        this.patron = patron;
    }
}

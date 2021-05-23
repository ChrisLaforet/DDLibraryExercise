package com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import lombok.Getter;

@Getter
public class GetBooksForPatronQuery implements IQuery {
    private Patron patron;

    public GetBooksForPatronQuery(Patron patron) {
        this.patron = patron;
    }
}

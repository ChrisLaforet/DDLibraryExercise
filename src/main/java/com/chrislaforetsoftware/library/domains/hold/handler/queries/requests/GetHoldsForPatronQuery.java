package com.chrislaforetsoftware.library.domains.hold.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import lombok.Getter;

@Getter
public class GetHoldsForPatronQuery implements IQuery {
    private Patron patron;

    public GetHoldsForPatronQuery(Patron patron) {
        this.patron = patron;
    }
}

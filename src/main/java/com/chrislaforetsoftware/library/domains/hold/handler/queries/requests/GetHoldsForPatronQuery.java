package com.chrislaforetsoftware.library.domains.hold.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

@Getter
public class GetHoldsForPatronQuery implements IQuery {
    private final IPatron patron;

    public GetHoldsForPatronQuery(IPatron patron) {
        this.patron = patron;
    }
}

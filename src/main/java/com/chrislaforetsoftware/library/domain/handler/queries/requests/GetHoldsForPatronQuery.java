package com.chrislaforetsoftware.library.domain.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import com.chrislaforetsoftware.library.domain.entity.Patron;
import lombok.Getter;

@Getter
public class GetHoldsForPatronQuery implements IQuery {
    private Patron patron;

    public GetHoldsForPatronQuery(Patron patron) {
        this.patron = patron;
    }
}

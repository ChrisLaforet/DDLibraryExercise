package com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetCheckoutForBookQuery implements IQuery {
    private int id;

    public GetCheckoutForBookQuery(int id) {
        this.id = id;
    }
}

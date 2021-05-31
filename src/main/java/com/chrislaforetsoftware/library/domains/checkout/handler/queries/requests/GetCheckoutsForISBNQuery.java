package com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests;

import com.chrislaforetsoftware.library.common.cqs.IQuery;
import lombok.Getter;

@Getter
public class GetCheckoutsForISBNQuery implements IQuery {
    private String isbn;

    public GetCheckoutsForISBNQuery(String isbn) {
        this.isbn = isbn;
    }
}

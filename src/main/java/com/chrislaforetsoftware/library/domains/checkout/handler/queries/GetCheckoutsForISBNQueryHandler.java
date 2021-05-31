package com.chrislaforetsoftware.library.domains.checkout.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetBooksForPatronQuery;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutsForISBNQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCheckoutsForISBNQueryHandler implements IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> {

    @Autowired
    public GetCheckoutsForISBNQueryHandler() {

    }

    @Override
    public List<ICheckout> handle(GetCheckoutsForISBNQuery query) {
        return null;
    }
}

package com.chrislaforetsoftware.library.domains.checkout.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetBooksForPatronQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksForPatronQueryHandler implements IQueryHandler<GetBooksForPatronQuery, List<ICheckout>> {

    @Autowired
    public GetBooksForPatronQueryHandler() {

    }

    @Override
    public List<ICheckout> handle(GetBooksForPatronQuery query) {
        return null;
    }
}

package com.chrislaforetsoftware.library.domains.checkout.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetBooksForPatronQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksForPatronQueryHandler implements IQueryHandler<GetBooksForPatronQuery, List<IBook>> {

    @Autowired
    public GetBooksForPatronQueryHandler() {

    }

    @Override
    public List<IBook> handle(GetBooksForPatronQuery query) {
        return null;
    }
}

package com.chrislaforetsoftware.library.domain.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domain.entity.Book;
import com.chrislaforetsoftware.library.domain.handler.queries.requests.GetBooksForPatronQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksForPatronQueryHandler implements IQueryHandler<GetBooksForPatronQuery, List<Book>> {

    @Autowired
    public GetBooksForPatronQueryHandler() {

    }

    @Override
    public List<Book> handle(GetBooksForPatronQuery query) {
        return null;
    }
}

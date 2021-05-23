package com.chrislaforetsoftware.library.domains.catalog.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetTitleByISBNQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksByISBNQueryHandler implements IQueryHandler<GetTitleByISBNQuery, List<IBook>> {

    @Autowired
    public GetBooksByISBNQueryHandler() {

    }

    @Override
    public List<IBook> handle(GetTitleByISBNQuery query) {
        return null;
    }
}

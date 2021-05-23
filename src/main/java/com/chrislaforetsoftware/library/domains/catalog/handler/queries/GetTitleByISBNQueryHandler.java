package com.chrislaforetsoftware.library.domains.catalog.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetTitleByISBNQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTitleByISBNQueryHandler implements IQueryHandler<GetTitleByISBNQuery, Optional<ITitle>> {

    @Autowired
    public GetTitleByISBNQueryHandler() {

    }

    @Override
    public Optional<ITitle> handle(GetTitleByISBNQuery query) {
        return null;
    }
}

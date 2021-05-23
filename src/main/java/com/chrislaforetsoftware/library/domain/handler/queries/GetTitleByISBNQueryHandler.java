package com.chrislaforetsoftware.library.domain.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domain.entities.Title;
import com.chrislaforetsoftware.library.domain.handler.queries.requests.GetTitleByISBNQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTitleByISBNQueryHandler implements IQueryHandler<GetTitleByISBNQuery, Optional<Title>> {

    @Autowired
    public GetTitleByISBNQueryHandler() {

    }

    @Override
    public Optional<Title> handle(GetTitleByISBNQuery query) {
        return null;
    }
}

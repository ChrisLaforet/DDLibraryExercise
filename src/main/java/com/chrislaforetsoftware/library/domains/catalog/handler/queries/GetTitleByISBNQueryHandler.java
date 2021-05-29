package com.chrislaforetsoftware.library.domains.catalog.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetTitleByISBNQuery;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTitleByISBNQueryHandler implements IQueryHandler<GetTitleByISBNQuery, Optional<ICatalog>> {

    private final ICatalogRepository repository;

    @Autowired
    public GetTitleByISBNQueryHandler(ICatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ICatalog> handle(GetTitleByISBNQuery query) {
        return repository.findTitleByISBN(query.getISBN());
    }
}

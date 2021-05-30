package com.chrislaforetsoftware.library.domains.catalog.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetBooksByISBNQuery;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksByISBNQueryHandler implements IQueryHandler<GetBooksByISBNQuery, List<IBook>> {

    private final ICatalogRepository repository;

    @Autowired
    public GetBooksByISBNQueryHandler(ICatalogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IBook> handle(GetBooksByISBNQuery query) {
        return repository.findBooksByISBN(query.getIsbn());
    }
}

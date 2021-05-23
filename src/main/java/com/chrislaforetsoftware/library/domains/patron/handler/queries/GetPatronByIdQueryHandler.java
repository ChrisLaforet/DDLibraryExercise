package com.chrislaforetsoftware.library.domains.patron.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronByIdQuery;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPatronByIdQueryHandler implements IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> {

    private final IPatronRepository repository;

    @Autowired
    public GetPatronByIdQueryHandler(IPatronRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<IPatron> handle(GetPatronByIdQuery query) {
        return repository.findPatronById(query.getId());
    }
}

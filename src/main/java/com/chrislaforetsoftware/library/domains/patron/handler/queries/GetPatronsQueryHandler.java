package com.chrislaforetsoftware.library.domains.patron.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronsQuery;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPatronsQueryHandler implements IQueryHandler<GetPatronsQuery, List<IPatron>> {

    private final IPatronRepository repository;

    @Autowired
    public GetPatronsQueryHandler(IPatronRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IPatron> handle(GetPatronsQuery query) {
        return repository.findAllPatrons();
    }
}

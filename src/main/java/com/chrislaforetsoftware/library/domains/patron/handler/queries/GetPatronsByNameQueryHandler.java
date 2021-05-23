package com.chrislaforetsoftware.library.domains.patron.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronsByNameQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPatronsByNameQueryHandler implements IQueryHandler<GetPatronsByNameQuery, List<IPatron>> {

    @Autowired
    public GetPatronsByNameQueryHandler() {

    }

    @Override
    public List<IPatron> handle(GetPatronsByNameQuery query) {
        return null;
    }
}

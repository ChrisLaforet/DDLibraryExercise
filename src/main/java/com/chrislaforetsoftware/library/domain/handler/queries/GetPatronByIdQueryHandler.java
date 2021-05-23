package com.chrislaforetsoftware.library.domain.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domain.entities.Patron;
import com.chrislaforetsoftware.library.domain.handler.queries.requests.GetPatronsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPatronByIdQueryHandler implements IQueryHandler<GetPatronsQuery, Optional<Patron>> {

    @Autowired
    public GetPatronByIdQueryHandler() {

    }

    @Override
    public Optional<Patron> handle(GetPatronsQuery query) {
        return null;
    }
}

package com.chrislaforetsoftware.library.domains.patron.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPatronsQueryHandler implements IQueryHandler<GetPatronsQuery, List<Patron>> {

    @Autowired
    public GetPatronsQueryHandler() {

    }

    @Override
    public List<Patron> handle(GetPatronsQuery query) {
        return null;
    }
}

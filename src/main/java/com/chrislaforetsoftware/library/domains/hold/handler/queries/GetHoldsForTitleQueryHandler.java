package com.chrislaforetsoftware.library.domains.hold.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForTitleQuery;
import com.chrislaforetsoftware.library.domains.hold.repository.IHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHoldsForTitleQueryHandler implements IQueryHandler< GetHoldsForTitleQuery, List<IHold>> {

    IHoldRepository repository;

    @Autowired
    public GetHoldsForTitleQueryHandler(IHoldRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IHold> handle(GetHoldsForTitleQuery query) {
        return repository.getHoldsForTitle(query.getTitle());
    }
}

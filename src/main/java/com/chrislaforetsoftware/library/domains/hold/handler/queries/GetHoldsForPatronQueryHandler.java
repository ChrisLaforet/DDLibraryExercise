package com.chrislaforetsoftware.library.domains.hold.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForPatronQuery;
import com.chrislaforetsoftware.library.domains.hold.repository.IHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHoldsForPatronQueryHandler implements IQueryHandler< GetHoldsForPatronQuery, List<IHold>> {

    private final IHoldRepository repository;

    @Autowired
    public GetHoldsForPatronQueryHandler(IHoldRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IHold> handle(GetHoldsForPatronQuery query) {
        return repository.getHoldsForPatron(query.getPatron());
    }
}

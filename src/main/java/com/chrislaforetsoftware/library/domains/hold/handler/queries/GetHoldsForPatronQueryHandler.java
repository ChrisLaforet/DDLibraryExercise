package com.chrislaforetsoftware.library.domains.hold.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForPatronQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHoldsForPatronQueryHandler implements IQueryHandler< GetHoldsForPatronQuery, List<IHold>> {

    @Autowired
    public GetHoldsForPatronQueryHandler() {

    }

    @Override
    public List<IHold> handle(GetHoldsForPatronQuery query) {
        return null;
    }
}

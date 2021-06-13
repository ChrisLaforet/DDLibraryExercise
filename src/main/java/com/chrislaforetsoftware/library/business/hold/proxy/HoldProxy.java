package com.chrislaforetsoftware.library.business.hold.proxy;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForPatronQuery;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForTitleQuery;
import com.chrislaforetsoftware.library.io.titlehold.dtos.TitleHoldResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HoldProxy {

    private IQueryHandler<GetHoldsForPatronQuery, List<IHold>> getHoldsForPatronQueryHandler;
    private IQueryHandler<GetHoldsForTitleQuery, List<IHold>> getHoldsForTitleQueryHandler;

    @Autowired
    public HoldProxy(IQueryHandler<GetHoldsForPatronQuery, List<IHold>> getHoldsForPatronQueryHandler,
                     IQueryHandler<GetHoldsForTitleQuery, List<IHold>> getHoldsForTitleQueryHandler) {
        this.getHoldsForPatronQueryHandler = getHoldsForPatronQueryHandler;
        this.getHoldsForTitleQueryHandler = getHoldsForTitleQueryHandler;
    }

    public List<TitleHoldResponseDTO> getHoldsForBooksByISBN(String isbn) {
    }

    public List<TitleHoldResponseDTO> getHoldsForBooksForPatron(int patronId) {
    }
}

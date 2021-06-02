package com.chrislaforetsoftware.library.domains.checkout.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutForBookQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCheckoutForBookQueryHandler implements IQueryHandler<GetCheckoutForBookQuery, Optional<ICheckout>> {

    @Autowired
    public GetCheckoutForBookQueryHandler() {

    }

    @Override
    public Optional<ICheckout> handle(GetCheckoutForBookQuery query) {
        return null;
    }
}

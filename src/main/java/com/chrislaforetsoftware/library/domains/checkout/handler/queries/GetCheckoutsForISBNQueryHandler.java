package com.chrislaforetsoftware.library.domains.checkout.handler.queries;

import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutsForISBNQuery;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCheckoutsForISBNQueryHandler implements IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> {

    private final ICheckoutRepository repository;
    private final ICatalogRepository catalogRepository;


    @Autowired
    public GetCheckoutsForISBNQueryHandler(ICheckoutRepository repository,
                                           ICatalogRepository catalogRepository) {
        this.repository = repository;
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<ICheckout> handle(GetCheckoutsForISBNQuery query) {
        ICatalog catalog = catalogRepository.findTitleByISBN(query.getIsbn())
                            .orElseThrow(() -> new IllegalStateException("Cannot find catalog entry for ISBN"));
        return repository.getCheckoutsForTitle(catalog.getTitleInstance());
    }
}

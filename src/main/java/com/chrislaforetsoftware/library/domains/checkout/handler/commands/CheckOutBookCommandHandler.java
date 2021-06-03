package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutBookCommandHandler implements ICommandHandler<CheckOutBookCommand, ICheckout> {

    private final ICheckoutRepository repository;
    private final ICatalogRepository catalogRepository;
    private final IPatronRepository patronRepository;

    @Autowired
    public CheckOutBookCommandHandler(ICheckoutRepository repository,
                                      ICatalogRepository catalogRepository,
                                      IPatronRepository patronRepository) {
        this.repository = repository;
        this.catalogRepository = catalogRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public ICheckout handle(CheckOutBookCommand command) {


        return null;
    }
}

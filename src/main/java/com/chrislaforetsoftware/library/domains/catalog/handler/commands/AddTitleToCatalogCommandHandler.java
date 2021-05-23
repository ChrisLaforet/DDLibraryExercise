package com.chrislaforetsoftware.library.domains.catalog.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddTitleToCatalogCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTitleToCatalogCommandHandler implements ICommandHandler<AddTitleToCatalogCommand, Void> {

    @Autowired
    public AddTitleToCatalogCommandHandler() {

    }

    @Override
    public Void handle(AddTitleToCatalogCommand command) {
        return null;
    }
}

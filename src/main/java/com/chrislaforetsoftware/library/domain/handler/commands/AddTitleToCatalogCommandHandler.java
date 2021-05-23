package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.AddTitleToCatalogCommand;
import org.springframework.beans.factory.annotation.Autowired;

public class AddTitleToCatalogCommandHandler implements ICommandHandler<AddTitleToCatalogCommand, Void> {

    @Autowired
    public AddTitleToCatalogCommandHandler() {

    }
    
    @Override
    public Void handle(AddTitleToCatalogCommand command) {
        return null;
    }
}

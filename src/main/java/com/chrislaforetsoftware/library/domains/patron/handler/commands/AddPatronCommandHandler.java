package com.chrislaforetsoftware.library.domains.patron.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPatronCommandHandler implements ICommandHandler<AddPatronCommand, Void> {

    @Autowired
    public AddPatronCommandHandler() {
    }

    @Override
    public Void handle(AddPatronCommand command) {

        return null;
    }
}

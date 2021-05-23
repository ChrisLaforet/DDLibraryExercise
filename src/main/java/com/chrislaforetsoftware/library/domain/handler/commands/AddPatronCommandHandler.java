package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.AddHoldCommand;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.AddPatronCommand;
import com.chrislaforetsoftware.library.domain.handler.events.HoldCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

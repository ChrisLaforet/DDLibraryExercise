package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.AddHoldCommand;
import com.chrislaforetsoftware.library.domain.handler.events.HoldCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AddHoldCommandHandler implements ICommandHandler<AddHoldCommand, Void> {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AddHoldCommandHandler(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Void handle(AddHoldCommand command) {

        if (true) {
            applicationEventPublisher.publishEvent(new HoldCreated(this, command.getTitle()));
        }
        return null;
    }
}

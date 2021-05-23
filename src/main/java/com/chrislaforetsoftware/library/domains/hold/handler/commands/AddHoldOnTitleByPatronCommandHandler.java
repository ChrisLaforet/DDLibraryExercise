package com.chrislaforetsoftware.library.domains.hold.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.hold.handler.commands.requests.AddHoldOnTitleByPatronCommand;
import com.chrislaforetsoftware.library.domains.hold.events.HoldCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AddHoldOnTitleByPatronCommandHandler implements ICommandHandler<AddHoldOnTitleByPatronCommand, Void> {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AddHoldOnTitleByPatronCommandHandler(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Void handle(AddHoldOnTitleByPatronCommand command) {

        if (true) {
            applicationEventPublisher.publishEvent(new HoldCreated(this, command.getTitle()));
        }
        return null;
    }
}

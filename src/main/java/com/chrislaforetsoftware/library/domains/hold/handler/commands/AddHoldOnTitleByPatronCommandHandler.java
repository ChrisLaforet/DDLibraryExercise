package com.chrislaforetsoftware.library.domains.hold.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.commands.requests.AddHoldOnTitleByPatronCommand;
import com.chrislaforetsoftware.library.domains.hold.events.HoldCreated;
import com.chrislaforetsoftware.library.domains.hold.repository.IHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AddHoldOnTitleByPatronCommandHandler implements ICommandHandler<AddHoldOnTitleByPatronCommand, Void> {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final IHoldRepository repository;

    @Autowired
    public AddHoldOnTitleByPatronCommandHandler(IHoldRepository repository,
                                                ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.repository = repository;
    }

    @Override
    public Void handle(AddHoldOnTitleByPatronCommand command) {
        repository.addHold(command.getTitle(), command.getPatron());
        applicationEventPublisher.publishEvent(new HoldCreated(this, command.getTitle()));
        return null;
    }
}

package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.CheckInBookCommand;
import com.chrislaforetsoftware.library.domain.handler.events.BookCheckedIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CheckInBookCommandHandler implements ICommandHandler<CheckInBookCommand, Boolean> {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CheckInBookCommandHandler(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Boolean handle(CheckInBookCommand command) {

        if (true) {
            applicationEventPublisher.publishEvent(new BookCheckedIn(this, command.getCheckout().getBook()));
        }
        return null;
    }
}

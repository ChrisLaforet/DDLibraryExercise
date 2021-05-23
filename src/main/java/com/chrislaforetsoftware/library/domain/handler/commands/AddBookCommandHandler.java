package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.AddBookCommand;
import com.chrislaforetsoftware.library.domain.handler.events.BookCheckedIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AddBookCommandHandler implements ICommandHandler<AddBookCommand, Boolean> {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AddBookCommandHandler(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Boolean handle(AddBookCommand command) {

        if (true) {
            applicationEventPublisher.publishEvent(new BookCheckedIn(this, command.getBook()));
        }
        return null;
    }
}

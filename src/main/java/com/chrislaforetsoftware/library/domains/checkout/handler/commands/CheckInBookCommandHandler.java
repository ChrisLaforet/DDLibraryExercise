package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.catalog.repository.IBookRepository;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckInBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.events.BookCheckedIn;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CheckInBookCommandHandler implements ICommandHandler<CheckInBookCommand, Boolean> {

    private final ICheckoutRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CheckInBookCommandHandler(ICheckoutRepository repository,
                                     ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Boolean handle(CheckInBookCommand command) {
        repository.checkinBook(command.getBook());
        applicationEventPublisher.publishEvent(new BookCheckedIn(this, command.getBook()));
        return true;
    }
}

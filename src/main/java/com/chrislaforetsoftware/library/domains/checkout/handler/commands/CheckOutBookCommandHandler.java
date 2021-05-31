package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.checkout.events.BookCheckedIn;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckInBookCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CheckOutBookCommandHandler implements ICommandHandler<CheckOutBookCommand, ICheckout> {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CheckOutBookCommandHandler() {

    }

    @Override
    public ICheckout handle(CheckOutBookCommand command) {


        return null;
    }
}

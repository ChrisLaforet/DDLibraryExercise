package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutBookCommandHandler implements ICommandHandler<CheckOutBookCommand, ICheckout> {

    @Autowired
    public CheckOutBookCommandHandler() {

    }

    @Override
    public ICheckout handle(CheckOutBookCommand command) {


        return null;
    }
}

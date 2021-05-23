package com.chrislaforetsoftware.library.domain.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domain.entities.Checkout;

public class CheckInBookCommand implements ICommand {
    private final Checkout checkout;

    public CheckInBookCommand(Checkout checkout) {
        this.checkout = checkout;
    }
}

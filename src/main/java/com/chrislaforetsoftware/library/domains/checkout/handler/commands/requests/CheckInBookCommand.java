package com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.checkout.entities.Checkout;
import lombok.Getter;

@Getter
public class CheckInBookCommand implements ICommand {
    private final Checkout checkout;

    public CheckInBookCommand(Checkout checkout) {
        this.checkout = checkout;
    }
}

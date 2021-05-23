package com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import lombok.Getter;

@Getter
public class CheckInBookCommand implements ICommand {
    private final ICheckout checkout;

    public CheckInBookCommand(ICheckout checkout) {
        this.checkout = checkout;
    }
}

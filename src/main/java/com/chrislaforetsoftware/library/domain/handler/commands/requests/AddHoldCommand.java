package com.chrislaforetsoftware.library.domain.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domain.entities.Checkout;
import com.chrislaforetsoftware.library.domain.entities.Title;
import lombok.Getter;

@Getter
public class AddHoldCommand implements ICommand {
    private final Title title;

    public AddHoldCommand(final Title title) {
        this.title = title;
    }
}

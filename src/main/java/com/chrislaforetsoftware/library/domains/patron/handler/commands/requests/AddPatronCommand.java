package com.chrislaforetsoftware.library.domains.patron.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

@Getter
public class AddPatronCommand implements ICommand {
    private final IPatron patron;

    public AddPatronCommand(final IPatron patron) {
        this.patron = patron;
    }
}

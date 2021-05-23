package com.chrislaforetsoftware.library.domains.patron.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import lombok.Getter;

@Getter
public class AddPatronCommand implements ICommand {
    private final Patron patron;

    public AddPatronCommand(final Patron patron) {
        this.patron = patron;
    }
}

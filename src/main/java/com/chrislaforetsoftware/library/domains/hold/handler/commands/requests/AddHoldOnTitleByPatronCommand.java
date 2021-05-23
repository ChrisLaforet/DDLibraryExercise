package com.chrislaforetsoftware.library.domains.hold.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.catalog.entities.Title;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import lombok.Getter;

@Getter
public class AddHoldOnTitleByPatronCommand implements ICommand {
    private final Title title;
    private final Patron patron;

    public AddHoldOnTitleByPatronCommand(final Title title, final Patron patron) {
        this.title = title;
        this.patron = patron;
    }
}

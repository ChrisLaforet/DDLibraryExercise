package com.chrislaforetsoftware.library.domains.hold.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

@Getter
public class AddHoldOnTitleByPatronCommand implements ICommand {
    private final ITitle title;
    private final IPatron patron;

    public AddHoldOnTitleByPatronCommand(final ITitle title, final IPatron patron) {
        this.title = title;
        this.patron = patron;
    }
}

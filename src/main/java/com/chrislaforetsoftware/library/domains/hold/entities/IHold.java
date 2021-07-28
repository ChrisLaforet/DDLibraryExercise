package com.chrislaforetsoftware.library.domains.hold.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;

public interface IHold {

    public enum HoldType {
        OPEN_ENDED,
        CLOSED_ENDED
    }

    int getId();
    IPatron getPatron();
    ITitle getTitle();
    HoldType getHoldType();
}

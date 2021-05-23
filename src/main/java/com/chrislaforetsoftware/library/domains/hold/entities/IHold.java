package com.chrislaforetsoftware.library.domains.hold.entities;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;

public interface IHold {

    public enum HoldType {
        OPEN_ENDED,
        CLOSED_ENDED
    }

    IPatron getPatron();
    ITitle getTitle();
    HoldType getHoldType();
}

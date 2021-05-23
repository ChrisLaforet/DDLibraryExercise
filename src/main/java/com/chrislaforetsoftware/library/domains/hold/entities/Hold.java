package com.chrislaforetsoftware.library.domains.hold.entities;

import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.catalog.entities.Title;

public interface Hold {

    public enum HoldType {
        OPEN_ENDED,
        CLOSED_ENDED
    }

    Patron getPatron();
    Title getTitle();
    HoldType getHoldType();
}

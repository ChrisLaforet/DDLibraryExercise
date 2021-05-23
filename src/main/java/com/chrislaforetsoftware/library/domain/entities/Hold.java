package com.chrislaforetsoftware.library.domain.entities;

public interface Hold {

    public enum HoldType {
        OPEN_ENDED,
        CLOSED_ENDED
    }

    Patron getPatron();
    Title getTitle();
    HoldType getHoldType();
}

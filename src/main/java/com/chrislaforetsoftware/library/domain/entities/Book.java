package com.chrislaforetsoftware.library.domain.entities;

public interface Book {

    public enum AssignedUse {
        CIRCULATING,
        RESTRICTED
    }

    Title getTitle();
    AssignedUse getAssignedUse();
    Double getPrice();
}

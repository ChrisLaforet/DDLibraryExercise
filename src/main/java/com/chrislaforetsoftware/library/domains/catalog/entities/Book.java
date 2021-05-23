package com.chrislaforetsoftware.library.domains.catalog.entities;

public interface Book {

    public enum AssignedUse {
        CIRCULATING,
        RESTRICTED
    }

    Title getTitle();
    AssignedUse getAssignedUse();
    Double getPrice();
}

package com.chrislaforetsoftware.library.domains.catalog.entities;

public interface IBook {

    public enum AssignedUse {
        CIRCULATING,
        RESTRICTED
    }

    ITitle getTitle();
    AssignedUse getAssignedUse();
    Double getPrice();
}

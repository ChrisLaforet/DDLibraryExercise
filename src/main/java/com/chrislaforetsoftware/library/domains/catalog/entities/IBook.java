package com.chrislaforetsoftware.library.domains.catalog.entities;

public interface IBook {

    public enum AssignedUse {
        CIRCULATING,
        RESTRICTED
    }

    int getId();
    ITitle getTitleInstance();
    AssignedUse getAssignedUse();
    double getPrice();
}

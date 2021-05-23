package com.chrislaforetsoftware.library.domains.patron.entities;

public interface Patron {
    public enum PatronType {
        REGULAR,
        RESEARCHER
    }

    String getId();
    String getName();
    PatronType getPatronType();
}

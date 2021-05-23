package com.chrislaforetsoftware.library.domain.entities;

public interface Patron {
    public enum PatronType {
        REGULAR,
        RESEARCHER
    }

    String getId();
    String getName();
    PatronType getPatronType();
}

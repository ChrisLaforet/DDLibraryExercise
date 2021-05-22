package com.chrislaforetsoftware.library.domain.entity;

public interface Patron {
    public enum PatronType {
        REGULAR,
        RESEARCHER
    }

    String getId();
    String getName();
    PatronType getPatronType();
}

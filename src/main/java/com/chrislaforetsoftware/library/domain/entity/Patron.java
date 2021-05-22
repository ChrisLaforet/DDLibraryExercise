package com.chrislaforetsoftware.library.domain.entity;

public interface Patron {
    public enum PatronType {
        REGULAR,
        RESESRCHER
    }

    String getName();
    PatronType getPatronType();
}

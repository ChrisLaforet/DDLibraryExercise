package com.chrislaforetsoftware.library.domains.patron.entities;

public interface IPatron {
    public enum PatronType {
        REGULAR,
        RESEARCHER
    }

    String getId();
    String getName();
    PatronType getPatronType();
}

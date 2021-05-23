package com.chrislaforetsoftware.library.domains.patron.entities;

public interface IPatron {
    public enum PatronType {
		NONRESEARCHER,
        RESEARCHER
    }

    String getId();
    String getName();
    PatronType getPatronType();
}

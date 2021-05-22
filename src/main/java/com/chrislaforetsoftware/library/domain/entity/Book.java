package com.chrislaforetsoftware.library.domain.entity;

public interface Book {

    public enum AssignedUse {
        CIRCULATING,
        RESTRICTED
    }

    Title getTitle();
    AssignedUse getAssignedUse();
}

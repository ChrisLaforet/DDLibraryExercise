package com.chrislaforetsoftware.library.common.events;

import lombok.Getter;

@Getter
public abstract class EventBase {
    protected final Object eventSource;

    protected EventBase(final Object eventSource) {
        this.eventSource = eventSource;
    }
}

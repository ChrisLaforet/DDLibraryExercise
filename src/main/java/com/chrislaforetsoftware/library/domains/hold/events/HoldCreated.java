package com.chrislaforetsoftware.library.domains.hold.events;

import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class HoldCreated extends ApplicationEvent {
    private final ITitle title;

    public HoldCreated(Object eventSource, final ITitle title) {
        super(eventSource);
        this.title = title;
    }
}

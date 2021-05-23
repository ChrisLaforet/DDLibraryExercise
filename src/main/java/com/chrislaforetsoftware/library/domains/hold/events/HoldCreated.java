package com.chrislaforetsoftware.library.domains.hold.events;

import com.chrislaforetsoftware.library.domains.catalog.entities.Title;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class HoldCreated extends ApplicationEvent {
    private final Title title;

    public HoldCreated(Object eventSource, final Title title) {
        super(eventSource);
        this.title = title;
    }
}

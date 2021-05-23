package com.chrislaforetsoftware.library.domains.checkout.events;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookCheckedIn extends ApplicationEvent {
    private final IBook book;

    public BookCheckedIn(Object eventSource, final IBook book) {
        super(eventSource);
        this.book = book;
    }
}

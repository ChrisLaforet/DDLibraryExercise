package com.chrislaforetsoftware.library.domains.checkout.events;

import com.chrislaforetsoftware.library.domains.catalog.entities.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookCheckedIn extends ApplicationEvent {
    private final Book book;

    public BookCheckedIn(Object eventSource, final Book book) {
        super(eventSource);
        this.book = book;
    }
}

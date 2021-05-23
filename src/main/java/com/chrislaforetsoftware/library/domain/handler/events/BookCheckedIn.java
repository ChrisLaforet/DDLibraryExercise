package com.chrislaforetsoftware.library.domain.handler.events;

import com.chrislaforetsoftware.library.domain.entities.Book;
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

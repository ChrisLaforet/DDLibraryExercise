package com.chrislaforetsoftware.library.domain.handler.events;

import com.chrislaforetsoftware.library.common.events.EventBase;
import com.chrislaforetsoftware.library.domain.entities.Book;
import lombok.Getter;

@Getter
public class BookCheckedIn extends EventBase {
    private final Book book;

    public BookCheckedIn(Object eventSource, final Book book) {
        super(eventSource);
        this.book = book;
    }
}

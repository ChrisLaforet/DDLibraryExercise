package com.chrislaforetsoftware.library.domain.entities;

import java.util.Collection;

public interface Catalog {
    Title findTitleByISBN(String ISBN);
    Collection<Book> getInstances();
    void addInstance(Book book);
    void removeInstance(Book book);
}

package com.chrislaforetsoftware.library.domains.catalog.entities;

import java.util.Collection;

public interface ICatalog {
    ITitle findTitleByISBN(String ISBN);
    Collection<IBook> getInstances();
    void addInstance(IBook book);
    void removeInstance(IBook book);
}

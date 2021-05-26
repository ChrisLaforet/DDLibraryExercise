package com.chrislaforetsoftware.library.domains.catalog.entities;

import java.util.Collection;

public interface ICatalog {
    ITitle getTitle();
    Collection<IBook> getInstances();
}

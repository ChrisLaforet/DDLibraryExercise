package com.chrislaforetsoftware.library.domains.catalog.entities;

import java.util.Collection;

public interface ICatalog {
    ITitle getTitleInstance();
    Collection<IBook> getInstances();
}

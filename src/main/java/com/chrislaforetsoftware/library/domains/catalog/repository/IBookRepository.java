package com.chrislaforetsoftware.library.domains.catalog.repository;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;

import java.util.Optional;

public interface IBookRepository {
    Optional<IBook> getBookById(int id);
}

package com.chrislaforetsoftware.library.io.catalog.repository;

import com.chrislaforetsoftware.library.io.catalog.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookJpaRepository extends CrudRepository<Book, Integer> {

	List<Book> findByIsbn(String isbn);
}

package com.chrislaforetsoftware.library.io.catalog.repository;

import com.chrislaforetsoftware.library.io.catalog.entities.Catalog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CatalogJpaRepository extends CrudRepository<Catalog, String> {
    Optional<Catalog> findByIsbn(String isbn);
}

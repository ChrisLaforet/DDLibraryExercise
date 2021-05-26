package com.chrislaforetsoftware.library.io.catalog.repository;

import com.chrislaforetsoftware.library.io.catalog.entities.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogJpaRepository extends CrudRepository<Catalog, String> {
}

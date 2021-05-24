package com.chrislaforetsoftware.library.io.patron.repository;

import com.chrislaforetsoftware.library.io.patron.entity.Patron;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatronJpaRepository extends CrudRepository<Patron, Integer> {

	List<Patron> findByName(String name);
}

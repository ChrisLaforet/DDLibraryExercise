package com.chrislaforetsoftware.library.io.titlehold.repository;

import com.chrislaforetsoftware.library.io.titlehold.entities.TitleHold;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleHoldJpaRepository extends CrudRepository<TitleHold, Integer> {

    List<TitleHold> findByPatronId(int patronId);
    List<TitleHold> findByIsbn(String isbn);

}

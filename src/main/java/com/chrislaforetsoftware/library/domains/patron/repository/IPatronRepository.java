package com.chrislaforetsoftware.library.domains.patron.repository;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;

import java.util.List;
import java.util.Optional;

public interface IPatronRepository {

    IPatron addPatron(String name, boolean isResearcher);
    Optional<IPatron> findPatronById(String id);
    List<IPatron> findPatronsByName(String name);
    List<IPatron> findAllPatrons();
}

package com.chrislaforetsoftware.library.business.patron.repository;

import com.chrislaforetsoftware.library.business.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PatronRepository implements IPatronRepository {

    private final com.chrislaforetsoftware.library.io.patron.repository.PatronRepository repository;

    @Autowired
    public PatronRepository(
            com.chrislaforetsoftware.library.io.patron.repository.PatronRepository repository) {
        this.repository = repository;
    }

    public IPatron addPatron(String name, boolean isResearcher) {
        com.chrislaforetsoftware.library.io.patron.entity.Patron patron =
                new com.chrislaforetsoftware.library.io.patron.entity.Patron();
        patron.setName(patron.getName());
        patron.setResearcher(isResearcher);
        repository.save(patron);
        return createPatronFromRecord(patron);
    }

    public Optional<IPatron> findPatronById(String id) {
        return repository.findById(Integer.valueOf(id)).map(this::createPatronFromRecord);
    }

    public List<IPatron> findPatronsByName(String name) {
        return repository.findByName(name).stream()
                .map(this::createPatronFromRecord)
                .collect(Collectors.toList());
    }

    public List<IPatron> findAllPatrons() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(this::createPatronFromRecord)
                .collect(Collectors.toList());
    }

    private Patron createPatronFromRecord(com.chrislaforetsoftware.library.io.patron.entity.Patron patron) {
        return new Patron(Integer.toString(patron.getId()),
                patron.getName(),
                patron.isResearcher() ? IPatron.PatronType.RESEARCHER : IPatron.PatronType.NONRESEARCHER);
    }
}

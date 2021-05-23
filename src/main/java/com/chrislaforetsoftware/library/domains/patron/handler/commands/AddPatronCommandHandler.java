package com.chrislaforetsoftware.library.domains.patron.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPatronCommandHandler implements ICommandHandler<AddPatronCommand, IPatron> {

    private final IPatronRepository repository;

    @Autowired
    public AddPatronCommandHandler(IPatronRepository repository) {
        this.repository = repository;
    }

    @Override
    public IPatron handle(AddPatronCommand command) {
        assertNameIsNotBlank(command.getName());
        return repository.addPatron(command.getName(), command.isResearcher());
    }

    private void assertNameIsNotBlank(String name) {
        if (StringUtils.isBlank(name) || name.trim().isEmpty()) {
            throw new IllegalStateException("Patron cannot have empty name");
        }
    }
}

package com.chrislaforetsoftware.library.domain.handler.commands;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domain.handler.commands.requests.CheckInBookCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInBookCommandHandler implements ICommandHandler<CheckInBookCommand, Boolean> {

    @Autowired
    public CheckInBookCommandHandler() {

    }

    @Override
    public Boolean handle(CheckInBookCommand command) {
        return null;
    }
}

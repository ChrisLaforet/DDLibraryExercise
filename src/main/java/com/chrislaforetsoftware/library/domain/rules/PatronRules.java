package com.chrislaforetsoftware.library.domain.rules;

import com.chrislaforetsoftware.library.domain.entity.Book;
import com.chrislaforetsoftware.library.domain.entity.Patron;
import org.springframework.stereotype.Service;

@Service
public class PatronRules {

    public boolean isPatronResearcher() {

    }

    public boolean isPatronAllowedHoldOn(Book desiredBook, Patron patron) {

    }
}

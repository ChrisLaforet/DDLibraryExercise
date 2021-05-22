package com.chrislaforetsoftware.library.domain.rules;

import com.chrislaforetsoftware.library.domain.entity.Book;
import com.chrislaforetsoftware.library.domain.entity.Checkout;
import com.chrislaforetsoftware.library.domain.entity.Hold;
import com.chrislaforetsoftware.library.domain.entity.Patron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronRules {

    public static final int MAX_HOLDS_PERMITTED = 5;

    public boolean isPatronAllowedHoldOn(Book desiredBook, Patron patron,
                                         List<Hold> currentHoldsForPatron,
                                         List<Checkout> currentCheckoutsForPatron) {
        if (!patron.getPatronType().equals(Patron.PatronType.RESEARCHER) &&
            (desiredBook.getAssignedUse().equals(Book.AssignedUse.RESTRICTED) ||
                    currentHoldsForPatron.size() >= MAX_HOLDS_PERMITTED)) {
            return false;
        }
        if (currentCheckoutsForPatron.stream()
                .filter()
                .count() >= 2) {
            return false;
        }
        return true;
    }
}

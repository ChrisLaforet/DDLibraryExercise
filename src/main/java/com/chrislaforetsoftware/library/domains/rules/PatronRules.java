package com.chrislaforetsoftware.library.domains.rules;

import com.chrislaforetsoftware.library.domains.catalog.entities.Book;
import com.chrislaforetsoftware.library.domains.checkout.entities.Checkout;
import com.chrislaforetsoftware.library.domains.hold.entities.Hold;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
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
                .filter(Checkout::isOverdue)
                .count() >= 2) {
            return false;
        }
        return true;
    }
}

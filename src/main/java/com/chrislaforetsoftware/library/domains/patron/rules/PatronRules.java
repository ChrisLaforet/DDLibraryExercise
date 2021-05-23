package com.chrislaforetsoftware.library.domains.patron.rules;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronRules {

    public static final int MAX_HOLDS_PERMITTED = 5;

    public boolean isPatronAllowedHoldOn(IBook desiredBook, IPatron patron,
                                         List<IHold> currentHoldsForPatron,
                                         List<ICheckout> currentCheckoutsForPatron) {
        if (!patron.getPatronType().equals(IPatron.PatronType.RESEARCHER) &&
            (desiredBook.getAssignedUse().equals(IBook.AssignedUse.RESTRICTED) ||
                    currentHoldsForPatron.size() >= MAX_HOLDS_PERMITTED)) {
            return false;
        }
        if (currentCheckoutsForPatron.stream()
                .filter(ICheckout::isOverdue)
                .count() >= 2) {
            return false;
        }
        return true;
    }
}

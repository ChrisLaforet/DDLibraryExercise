package com.chrislaforetsoftware.library.domains.hold.rules;

import com.chrislaforetsoftware.library.domains.blends.BookWithCheckoutStatus;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoldRules {

    public boolean isHoldPermittedFor(List<BookWithCheckoutStatus> books,
                                      IPatron patron,
                                      List<IHold> currentHoldsOnTitle) {
        if (books.isEmpty()) {
            return false;
        }

        List<BookWithCheckoutStatus> available = books.stream()
                    .filter(BookWithCheckoutStatus::isNotCheckedOut)
                    .collect(Collectors.toList());
        if (available.isEmpty()) {
            return false;
        }

        if (patron.getPatronType().equals(IPatron.PatronType.RESEARCHER)) {
            return available.size() > currentHoldsOnTitle.size();
        }

        return available.stream()
                    .filter(book -> book.getBook().getAssignedUse().equals(IBook.AssignedUse.CIRCULATING))
                    .count() > currentHoldsOnTitle.size();
    }
}

package com.chrislaforetsoftware.library.domains.rules;

import com.chrislaforetsoftware.library.domains.blends.BookWithCheckoutStatus;
import com.chrislaforetsoftware.library.domains.catalog.entities.Book;
import com.chrislaforetsoftware.library.domains.hold.entities.Hold;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoldRules {

    public boolean isHoldPermittedFor(List<BookWithCheckoutStatus> books,
                                      Patron patron,
                                      List<Hold> currentHoldsOnTitle) {
        if (books.isEmpty()) {
            return false;
        }

        List<BookWithCheckoutStatus> available = books.stream()
                    .filter(BookWithCheckoutStatus::isNotCheckedOut)
                    .collect(Collectors.toList());
        if (available.isEmpty()) {
            return false;
        }

        if (patron.getPatronType().equals(Patron.PatronType.RESEARCHER)) {
            return available.size() > currentHoldsOnTitle.size();
        }

        return available.stream()
                    .filter(book -> book.getBook().getAssignedUse().equals(Book.AssignedUse.CIRCULATING))
                    .count() > currentHoldsOnTitle.size();
    }
}

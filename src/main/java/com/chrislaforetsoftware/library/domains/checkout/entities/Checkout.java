package com.chrislaforetsoftware.library.domains.checkout.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.Book;
import com.chrislaforetsoftware.library.domains.patron.entities.Patron;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public interface Checkout {

    public static final int MAX_CHECKOUT_DAYS = 60;

    Patron getPatron();
    Book getBook();
    Date getCheckoutDate();

    public static boolean isOverdue(Checkout checkout) {
        LocalDate today = LocalDate.now();
        LocalDate checkedOut = checkout.getCheckoutDate()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(today, checkedOut) > MAX_CHECKOUT_DAYS;
    }
}

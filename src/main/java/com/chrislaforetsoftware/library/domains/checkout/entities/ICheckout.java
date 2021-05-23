package com.chrislaforetsoftware.library.domains.checkout.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public interface ICheckout {

    public static final int MAX_CHECKOUT_DAYS = 60;

    IPatron getPatron();
    IBook getBook();
    Date getCheckoutDate();

    public static boolean isOverdue(ICheckout checkout) {
        LocalDate today = LocalDate.now();
        LocalDate checkedOut = checkout.getCheckoutDate()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(today, checkedOut) > MAX_CHECKOUT_DAYS;
    }
}

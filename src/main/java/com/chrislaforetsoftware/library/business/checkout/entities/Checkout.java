package com.chrislaforetsoftware.library.business.checkout.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

import java.util.Date;

@Getter
public class Checkout implements ICheckout {
    private final int id;
    private final IPatron patron;
    private final IBook book;
    private final Date checkoutDate;

    public Checkout(int id, IPatron patron, IBook book, Date checkoutDate) {
        this.id = id;
        this.patron = patron;
        this.book = book;
        this.checkoutDate = checkoutDate;
    }
}

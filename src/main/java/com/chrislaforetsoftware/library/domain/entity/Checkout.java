package com.chrislaforetsoftware.library.domain.entity;

import java.util.Date;

public interface Checkout {

    Patron getPatron();
    Book getBook();
    Date getCheckoutDate();
}

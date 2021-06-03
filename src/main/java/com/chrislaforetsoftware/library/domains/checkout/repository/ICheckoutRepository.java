package com.chrislaforetsoftware.library.domains.checkout.repository;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;

import java.util.List;

public interface ICheckoutRepository {

    List<ICheckout> getCheckoutsForTitle(ITitle title);
    List<ICheckout> getCheckoutsForPatron(IPatron patron);
    ICheckout checkoutBook(IBook book, IPatron patron);
    void checkinBook(IBook book);
}

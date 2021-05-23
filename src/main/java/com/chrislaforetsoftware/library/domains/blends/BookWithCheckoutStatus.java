package com.chrislaforetsoftware.library.domains.blends;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import lombok.Getter;

import java.util.Optional;

@Getter
public class BookWithCheckoutStatus {
    private final IBook book;
    private final Optional<ICheckout> checkout;

    public BookWithCheckoutStatus(final IBook book) {
        this.book = book;
        this.checkout = Optional.empty();
    }

    public BookWithCheckoutStatus(final IBook book, final ICheckout checkout) {
        this.book = book;
        this.checkout = Optional.of(checkout);
    }

    public boolean isCheckedOut() {
        return checkout.isPresent();
    }

    public boolean isNotCheckedOut() {
        return !isCheckedOut();
    }
}

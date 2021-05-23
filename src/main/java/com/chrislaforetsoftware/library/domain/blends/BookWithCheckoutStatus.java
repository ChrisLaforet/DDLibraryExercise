package com.chrislaforetsoftware.library.domain.blends;

import com.chrislaforetsoftware.library.domain.entities.Book;
import com.chrislaforetsoftware.library.domain.entities.Checkout;
import lombok.Getter;

import java.util.Optional;

@Getter
public class BookWithCheckoutStatus {
    private final Book book;
    private final Optional<Checkout> checkout;

    public BookWithCheckoutStatus(final Book book) {
        this.book = book;
        this.checkout = Optional.empty());
    }

    public BookWithCheckoutStatus(final Book book, final Checkout checkout) {
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

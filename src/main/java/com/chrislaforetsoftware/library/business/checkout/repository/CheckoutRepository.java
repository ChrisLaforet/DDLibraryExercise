package com.chrislaforetsoftware.library.business.checkout.repository;

import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import com.chrislaforetsoftware.library.io.checkout.repository.CheckoutJpaRepository;

public class CheckoutRepository implements ICheckoutRepository {

    private final CheckoutJpaRepository repository;

    public CheckoutRepository(CheckoutJpaRepository repository) {
        this.repository = repository;
    }


}

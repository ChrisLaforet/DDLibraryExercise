package com.chrislaforetsoftware.library.io.checkout.repository;

import com.chrislaforetsoftware.library.io.checkout.entities.Checkout;
import org.springframework.data.repository.CrudRepository;

public interface CheckoutJpaRepository extends CrudRepository<Checkout, Integer> {
}

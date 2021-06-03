package com.chrislaforetsoftware.library.io.checkout.repository;

import com.chrislaforetsoftware.library.io.checkout.entities.Checkout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CheckoutJpaRepository extends CrudRepository<Checkout, Integer> {
    Optional<Checkout> findByBookId(int bookId);
    List<Checkout> findByPatronId(int patronId);
}

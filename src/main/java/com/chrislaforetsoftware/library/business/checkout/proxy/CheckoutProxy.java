package com.chrislaforetsoftware.library.business.checkout.proxy;

import com.chrislaforetsoftware.library.io.checkout.dto.AddCheckoutRequestDTO;
import com.chrislaforetsoftware.library.io.checkout.dto.CheckoutResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutProxy {

    @Autowired
    public CheckoutProxy() {

    }

    public Optional<CheckoutResponseDTO> getCheckoutForBookById(int id) {

    }

    public List<CheckoutResponseDTO> getCheckoutsForBooksByISBN(String isbn) {

    }

    public List<CheckoutResponseDTO> getCheckoutsForPatronById(int id) {

    }

    public CheckoutResponseDTO addCheckoutForBook(AddCheckoutRequestDTO request) {

    }

    public void deleteCheckout(int id) {

    }
}

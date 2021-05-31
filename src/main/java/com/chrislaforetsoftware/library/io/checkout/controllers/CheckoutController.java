package com.chrislaforetsoftware.library.io.checkout.controllers;

import com.chrislaforetsoftware.library.io.catalog.dtos.AddBookRequestDTO;
import com.chrislaforetsoftware.library.io.catalog.dtos.BookResponseDTO;
import com.chrislaforetsoftware.library.io.checkout.dto.AddCheckoutRequestDTO;
import com.chrislaforetsoftware.library.io.checkout.dto.CheckoutResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutProxy proxy;

    @Autowired
    public CheckoutController(CheckoutProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/book/{id}")
    public Optional<CheckoutResponseDTO> getCheckoutForBookById(@PathVariable int id) {
        return proxy.getCheckoutForBookById(id);
    }

    @GetMapping("/books/{isbn}")
    public List<CheckoutResponseDTO> getCheckoutsForBooksByISBN(@PathVariable String isbn) {
        return proxy.getCheckoutForBooksByISBN(isbn);
    }

    @GetMapping("/patron/{id}")
    public List<CheckoutResponseDTO> getCheckoutsForPatronById(@PathVariable int id) {
        return proxy.getCheckoutsForPatronById(id);
    }

    @PutMapping("/book")
    public CheckoutResponseDTO addCheckoutForBook(
            @RequestBody AddCheckoutRequestDTO request) {
        return proxy.addCheckoutForBook(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckout(@PathVariable int id) {
        proxy.deleteCheckout(id);
    }
}

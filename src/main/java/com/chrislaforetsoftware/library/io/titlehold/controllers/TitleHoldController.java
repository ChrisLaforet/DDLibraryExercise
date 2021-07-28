package com.chrislaforetsoftware.library.io.titlehold.controllers;

import com.chrislaforetsoftware.library.business.hold.proxy.HoldProxy;
import com.chrislaforetsoftware.library.io.titlehold.dtos.TitleHoldResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/title-hold")
public class TitleHoldController {

    private final HoldProxy proxy;

    @Autowired
    public TitleHoldController(HoldProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/for-patron/{patronId}")
    public List<TitleHoldResponseDTO> getTitleHoldsForPatronById(@PathVariable int patronId) {
        return proxy.getHoldsForBooksForPatron(patronId);
    }

    @GetMapping("/books/{isbn}")
    public List<TitleHoldResponseDTO> getTitleHoldsByISBN(@PathVariable String isbn) {
        return proxy.getHoldsForBooksByISBN(isbn);
    }

}

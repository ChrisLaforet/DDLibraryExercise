package com.chrislaforetsoftware.library.io.catalog.controllers;

import com.chrislaforetsoftware.library.business.catalog.proxy.CatalogProxy;
import com.chrislaforetsoftware.library.io.catalog.dtos.AddBookRequestDTO;
import com.chrislaforetsoftware.library.io.catalog.dtos.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/book")
public class BookController {

	private final CatalogProxy catalogProxy;

	@Autowired
	public BookController(CatalogProxy catalogProxy) {
		this.catalogProxy = catalogProxy;
	}

	@GetMapping("/{isbn}")
	public List<BookResponseDTO> getBooksByIsbn(@PathVariable String isbn) {
		return catalogProxy.getBooksByIsbn(isbn);
	}

	@PutMapping("/add")
	public BookResponseDTO addBook(
			@RequestBody AddBookRequestDTO request) {
		return catalogProxy.addBook(request);
	}
}

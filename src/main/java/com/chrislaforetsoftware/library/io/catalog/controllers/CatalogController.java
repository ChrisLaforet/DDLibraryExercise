package com.chrislaforetsoftware.library.io.catalog.controllers;

import com.chrislaforetsoftware.library.business.catalog.proxy.CatalogProxy;
import com.chrislaforetsoftware.library.io.catalog.dtos.AddTitleRequestDTO;
import com.chrislaforetsoftware.library.io.catalog.dtos.TitleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/catalog")
public class CatalogController {

	private final CatalogProxy catalogProxy;

	@Autowired
	public CatalogController(CatalogProxy catalogProxy) {
		this.catalogProxy = catalogProxy;
	}

	@GetMapping("/{isbn}")
	public Optional<TitleResponseDTO> getTitleByIsbn(@PathVariable String isbn) {
		return catalogProxy.getTitleByIsbn(isbn);
	}

	@PutMapping("/addTitle")
	public TitleResponseDTO addTitle(
			@RequestBody AddTitleRequestDTO request) {
		return catalogProxy.addTitle(request);
	}
}
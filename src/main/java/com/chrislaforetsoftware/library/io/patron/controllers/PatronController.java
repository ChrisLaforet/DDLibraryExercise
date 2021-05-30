package com.chrislaforetsoftware.library.io.patron.controllers;

import com.chrislaforetsoftware.library.business.patron.proxy.PatronProxy;
import com.chrislaforetsoftware.library.io.patron.dtos.AddPatronRequestDTO;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/patron")
public class PatronController {

	private final PatronProxy patronProxy;

	@Autowired
	public PatronController(PatronProxy patronProxy) {
		this.patronProxy = patronProxy;
	}

	@GetMapping("/all")
	public List<PatronResponseDTO> getAllPatrons() {
		return patronProxy.getAllPatrons();
	}

	@GetMapping("/{id}")
	public Optional<PatronResponseDTO> getPatronById(@PathVariable String id) {
		return patronProxy.getPatronById(id);
	}

	@GetMapping("/byName/{name}")
	public List<PatronResponseDTO> getPatronsByName(@PathVariable String name) {
		return patronProxy.getPatronsByName(name);
	}

	@PutMapping("/addPatron")
	public PatronResponseDTO addPatron(
			@RequestBody AddPatronRequestDTO request) {
		return patronProxy.addPatron(request);
	}
}

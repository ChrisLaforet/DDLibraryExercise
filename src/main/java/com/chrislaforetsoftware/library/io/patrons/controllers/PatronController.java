package com.chrislaforetsoftware.library.io.patrons.controllers;

import com.chrislaforetsoftware.library.io.patrons.dtos.PatronResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patron")
public class PatronController {

	@Autowired
	public PatronController() {

	}

	@GetMapping("/allPatrons")
	public List<PatronResponseDTO> getAllPatrons() {

	}

	@PutMapping("/addPatron")
	public PatronResponseDTO addPatron(
			@RequestBody AddPatronRequestDTO addPatronDTO) {
	}
}

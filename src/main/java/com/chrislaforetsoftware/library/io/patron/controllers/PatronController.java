package com.chrislaforetsoftware.library.io.patron.controllers;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import com.chrislaforetsoftware.library.io.patron.dtos.AddPatronRequestDTO;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patron")
public class PatronController {

	private final ICommandHandler<AddPatronCommand, IPatron> addPatronCommandHandler;

	@Autowired
	public PatronController(ICommandHandler<AddPatronCommand, IPatron> addPatronCommandHandler) {
		this.addPatronCommandHandler = addPatronCommandHandler;
	}

	@GetMapping("/allPatrons")
	public List<PatronResponseDTO> getAllPatrons() {
return null;
	}

	@PutMapping("/addPatron")
	public PatronResponseDTO addPatron(
			@RequestBody AddPatronRequestDTO addPatronDTO) {
return null;
	}
}

package com.chrislaforetsoftware.library.io.patron.controllers;

import com.chrislaforetsoftware.library.adapters.patron.mappers.PatronDTOMappers;
import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronByIdQuery;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronsByNameQuery;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronsQuery;
import com.chrislaforetsoftware.library.io.patron.dtos.AddPatronRequestDTO;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patron")
public class PatronController {

	private final ICommandHandler<AddPatronCommand, IPatron> addPatronCommandHandler;
	private final IQueryHandler<GetPatronsQuery, List<IPatron>> getPatronsQueryHandler;
	private final IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler;
	private final IQueryHandler<GetPatronsByNameQuery, List<IPatron>> getPatronsByNameQueryHandler;

	@Autowired
	public PatronController(
			ICommandHandler<AddPatronCommand, IPatron> addPatronCommandHandler,
			IQueryHandler<GetPatronsQuery, List<IPatron>> getPatronsQueryHandler,
			IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler,
			IQueryHandler<GetPatronsByNameQuery, List<IPatron>> getPatronsByNameQueryHandler) {
		this.addPatronCommandHandler = addPatronCommandHandler;
		this.getPatronsQueryHandler = getPatronsQueryHandler;
		this.getPatronByIdQueryHandler = getPatronByIdQueryHandler;
		this.getPatronsByNameQueryHandler = getPatronsByNameQueryHandler;
	}

	@GetMapping("/all")
	public List<PatronResponseDTO> getAllPatrons() {
		return getPatronsQueryHandler.handle(new GetPatronsQuery()).stream()
				.map(PatronDTOMappers::mapPatronToPatronResponseDTO)
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Optional<PatronResponseDTO> getPatronById(@PathVariable String id) {
		Optional<IPatron> patron = getPatronByIdQueryHandler.handle(new GetPatronByIdQuery(id));
		return patron.map(PatronDTOMappers::mapPatronToPatronResponseDTO);
	}

	@GetMapping("/byName/{name}")
	public List<PatronResponseDTO> getPatronsByName(@PathVariable String name) {
		return getPatronsByNameQueryHandler.handle(new GetPatronsByNameQuery(name)).stream()
				.map(PatronDTOMappers::mapPatronToPatronResponseDTO)
				.collect(Collectors.toList());
	}

	@PutMapping("/addPatron")
	public PatronResponseDTO addPatron(
			@RequestBody AddPatronRequestDTO request) {
		IPatron patron = addPatronCommandHandler.handle(new AddPatronCommand(request.getName(), request.isResearcher()));
		return PatronDTOMappers.mapPatronToPatronResponseDTO(patron);
	}
}

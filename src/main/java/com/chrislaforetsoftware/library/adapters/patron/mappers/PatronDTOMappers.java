package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;

public class PatronDTOMappers {

	private PatronDTOMappers() {
		// keeps class static
	}

	public static PatronResponseDTO mapPatronToPatronResponseDTO(IPatron patron) {
		PatronResponseDTO response = new PatronResponseDTO();
		response.setId(patron.getId());
		response.setName(patron.getName());
		response.setResearcher(patron.getPatronType() == IPatron.PatronType.RESEARCHER);
		return response;
	}
}

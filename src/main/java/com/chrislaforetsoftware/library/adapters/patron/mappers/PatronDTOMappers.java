package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;

public class PatronDTOMappers {

	public static PatronResponseDTO mapPatronToPatronResponseDTO(Patron patron) {
		PatronResponseDTO response = new PatronResponseDTO();
		response.setId(patron.getId());
		response.setName(patron.getName());
		return response;
	}
}

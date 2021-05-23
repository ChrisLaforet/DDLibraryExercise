package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.business.patron.entities.Patron;
import com.chrislaforetsoftware.library.io.patron.dtos.PatronResponseDTO;

public class PatronDTOMappers {

	private PatronDTOMappers() {
		// keeps class static
	}

	public static PatronResponseDTO mapPatronToPatronResponseDTO(Patron patron) {
		PatronResponseDTO response = new PatronResponseDTO();
		response.setId(patron.getId());
		response.setName(patron.getName());
		return response;
	}
}

package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.io.catalog.dtos.TitleResponseDTO;

public class CatalogDTOMappers {

	private CatalogDTOMappers() {
		// keep class static only
	}

	public static TitleResponseDTO mapCatalogToTitleResponseDTO(ICatalog catalog) {
		TitleResponseDTO response = new TitleResponseDTO();
		response.setISBN(catalog.getTitleInstance().getISBN());
		response.setTitle(catalog.getTitleInstance().getTitle());
		response.setAuthor(catalog.getTitleInstance().getAuthor());
		return response;
	}
}

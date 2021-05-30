package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.io.catalog.dtos.BookResponseDTO;
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

	public static BookResponseDTO mapBookToBookResponseDTO(IBook book) {
		BookResponseDTO response = new BookResponseDTO();
		response.setId(book.getId());
		response.setAuthor(book.getTitleInstance().getAuthor());
		response.setIsbn(book.getTitleInstance().getISBN());
		response.setPrice(book.getPrice());;
		response.setRestricted(book.getAssignedUse().equals(IBook.AssignedUse.RESTRICTED));
		return response;
	}
}

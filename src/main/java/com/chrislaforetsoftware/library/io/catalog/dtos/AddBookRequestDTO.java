package com.chrislaforetsoftware.library.io.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class AddBookRequestDTO {
	@JsonAlias({"isbn", "ISBN"})
	private String isbn;
	private double price;

	@JsonAlias({"isRestricted"})
	private boolean restricted;
}

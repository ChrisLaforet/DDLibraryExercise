package com.chrislaforetsoftware.library.io.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {
	private int id;
	@JsonAlias({"ISBN"})
	private String isbn;
	private String title;
	private String author;
	private double price;
	@JsonAlias({"isRestricted"})
	private boolean restricted;
}

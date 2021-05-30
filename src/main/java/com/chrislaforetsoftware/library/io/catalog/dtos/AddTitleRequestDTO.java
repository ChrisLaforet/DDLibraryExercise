package com.chrislaforetsoftware.library.io.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class AddTitleRequestDTO {
	@JsonAlias({"isbn", "ISBN"})
	private String isbn;
	private String title;
	private String author;
}

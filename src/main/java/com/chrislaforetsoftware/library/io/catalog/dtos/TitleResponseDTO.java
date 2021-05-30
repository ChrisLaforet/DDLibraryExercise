package com.chrislaforetsoftware.library.io.catalog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitleResponseDTO {
	private String ISBN;
	private String title;
	private String author;
}

package com.chrislaforetsoftware.library.io.titlehold.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;


@Getter
public class AddHoldRequestDTO {
	@JsonAlias({"isbn", "ISBN"})
	private String isbn;
	private int patronId;
}
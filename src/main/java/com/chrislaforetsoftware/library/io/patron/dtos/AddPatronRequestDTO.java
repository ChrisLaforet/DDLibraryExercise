package com.chrislaforetsoftware.library.io.patron.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class AddPatronRequestDTO {
	private String name;

	@JsonAlias({"isResearcher"})
	private boolean researcher;
}

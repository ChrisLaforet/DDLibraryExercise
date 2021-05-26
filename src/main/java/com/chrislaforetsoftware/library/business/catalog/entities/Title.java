package com.chrislaforetsoftware.library.business.catalog.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;

@Getter
public class Title implements ITitle {

	private final String ISBN;
	private final String title;
	private final String author;

	public Title(String ISBN, String title, String author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}
}

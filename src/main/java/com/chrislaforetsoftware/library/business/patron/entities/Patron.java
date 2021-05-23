package com.chrislaforetsoftware.library.business.patron.entities;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patron implements IPatron {
	private int id;
	private String name;
	private IPatron.PatronType patronType;

	public Patron(int id, String name, IPatron.PatronType patronType) {
		this.id = id;
		this.name = name;
		this.patronType = patronType;
	}
}

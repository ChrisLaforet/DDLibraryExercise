package com.chrislaforetsoftware.library.business.catalog.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Book implements IBook {
	private final ITitle titleInstance;
	private final double price;
	private final IBook.AssignedUse assignedUse;

	@Setter
	private int id;

	public Book(ITitle titleInstance, double price, IBook.AssignedUse assignedUse) {
		this.titleInstance = titleInstance;
		this.price = price;
		this.assignedUse = assignedUse;
	}

	public Book(int id, ITitle titleInstance, double price, IBook.AssignedUse assignedUse) {
		this(titleInstance, price, assignedUse);
		this.id = id;
	}
}

package com.chrislaforetsoftware.library.business.catalog.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Book implements IBook {
	private final ITitle title;
	private final double price;
	private final IBook.AssignedUse assignedUse;

	@Setter
	private int id;

	public Book(ITitle title, double price, IBook.AssignedUse assignedUse) {
		this.title = title;
		this.price = price;
		this.assignedUse = assignedUse;
	}

	public Book(int id, ITitle title, double price, IBook.AssignedUse assignedUse) {
		this(title, price, assignedUse);
		this.id = id;
	}
}

package com.chrislaforetsoftware.library.business.catalog.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class Catalog implements ICatalog {

	private final ITitle title;
	private final Collection<IBook> instances = new ArrayList<>();

	public Catalog(ITitle title) {
		this.title = title;
	}

	public Catalog(ITitle title, Collection<IBook> instances) {
		this(title);
		this.instances.addAll(instances);
	}
}

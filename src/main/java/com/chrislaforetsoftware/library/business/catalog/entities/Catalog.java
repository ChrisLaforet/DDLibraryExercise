package com.chrislaforetsoftware.library.business.catalog.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class Catalog implements ICatalog {

	private final ITitle titleInstance;
	private final Collection<IBook> instances = new ArrayList<>();

	public Catalog(ITitle titleInstance) {
		this.titleInstance = titleInstance;
	}

	public Catalog(ITitle titleInstance, Collection<IBook> instances) {
		this(titleInstance);
		this.instances.addAll(instances);
	}
}

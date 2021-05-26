package com.chrislaforetsoftware.library.domains.catalog.repository;

import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;

import java.util.List;
import java.util.Optional;

public interface ICatalogRepository {

	ICatalog addTitleToCatalog(String ISBN, String title, String author);
	Optional<ICatalog> findTitleByISBN(String ISBN);
	List<ICatalog> findAllTitles();

	IBook addBookToCatalog(String ISBN, double price, IBook.AssignedUse assignedUse);
	List<IBook> findBooksByISBN(String ISBN);
}

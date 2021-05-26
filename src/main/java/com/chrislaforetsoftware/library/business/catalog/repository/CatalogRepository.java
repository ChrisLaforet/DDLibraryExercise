package com.chrislaforetsoftware.library.business.catalog.repository;

import com.chrislaforetsoftware.library.business.catalog.entities.Book;
import com.chrislaforetsoftware.library.business.catalog.entities.Catalog;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.BookJpaRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.CatalogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CatalogRepository implements ICatalogRepository {

	private final CatalogJpaRepository catalogRepository;
	private final BookJpaRepository bookRepository;

	@Autowired
	public CatalogRepository(CatalogJpaRepository catalogRepository,
							 BookJpaRepository bookRepository) {
		this.catalogRepository = catalogRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public ICatalog addTitleToCatalog(String ISBN, String title, String author) {
		com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog =
				new com.chrislaforetsoftware.library.io.catalog.entities.Catalog();
		dbCatalog.setIsbn(ISBN);
		dbCatalog.setTitle(title);
		dbCatalog.setAuthor(author);
		catalogRepository.save(dbCatalog);

		return convertDbCatalog(dbCatalog);
	}

	private ICatalog convertDbCatalog(com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog) {
		return new Catalog(new Title(dbCatalog.getIsbn(), dbCatalog.getTitle(), dbCatalog.getAuthor()));
	}

	@Override
	public Optional<ICatalog> findTitleByISBN(String ISBN) {
		Optional<com.chrislaforetsoftware.library.io.catalog.entities.Catalog> dbCatalog =
				catalogRepository.findById(ISBN);
		if (!dbCatalog.isPresent()) {
			return Optional.empty();
		}

		List<com.chrislaforetsoftware.library.io.catalog.entities.Book> dbBooks = bookRepository.findByIsbn(ISBN);
		return Optional.of(convertDbCatalog(dbCatalog.get(), dbBooks));
	}

	private ICatalog convertDbCatalog(com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog,
									  List<com.chrislaforetsoftware.library.io.catalog.entities.Book> dbBooks) {
		Title title = new Title(dbCatalog.getIsbn(), dbCatalog.getTitle(), dbCatalog.getAuthor());
		List<IBook> instances = dbBooks.stream().map(dbBook -> convertDbBook(dbBook, title)).collect(Collectors.toList());
		return new Catalog(title, instances);
	}

	private IBook convertDbBook(com.chrislaforetsoftware.library.io.catalog.entities.Book dbBook, Title title) {
		return new Book(dbBook.getId(), title, dbBook.getPrice(), dbBook.isRestricted() ? IBook.AssignedUse.RESTRICTED : IBook.AssignedUse.CIRCULATING);
	}

	@Override
	public List<ICatalog> findAllTitles() {
		return null;
	}

	@Override
	public IBook addBookToCatalog(String ISBN, double price, IBook.AssignedUse assignedUse) {
		return null;
	}

	@Override
	public List<IBook> findBooksByISBN(String ISBN) {
		return null;
	}
}

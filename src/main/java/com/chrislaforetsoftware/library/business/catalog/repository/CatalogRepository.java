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

	private final CatalogJpaRepository repository;
	private final BookJpaRepository bookRepository;

	@Autowired
	public CatalogRepository(CatalogJpaRepository repository,
							 BookJpaRepository bookRepository) {
		this.repository = repository;
		this.bookRepository = bookRepository;
	}

	@Override
	public ICatalog addTitleToCatalog(String isbn, String title, String author) {
		com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog =
				new com.chrislaforetsoftware.library.io.catalog.entities.Catalog();
		dbCatalog.setIsbn(isbn);
		dbCatalog.setTitle(title);
		dbCatalog.setAuthor(author);
		repository.save(dbCatalog);

		return convertDbCatalog(dbCatalog);
	}

	private ICatalog convertDbCatalog(com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog) {
		return new Catalog(new Title(dbCatalog.getIsbn(), dbCatalog.getTitle(), dbCatalog.getAuthor()));
	}

	@Override
	public Optional<ICatalog> findTitleByISBN(String isbn) {
		Optional<com.chrislaforetsoftware.library.io.catalog.entities.Catalog> dbCatalog =
				repository.findById(isbn);
		if (!dbCatalog.isPresent()) {
			return Optional.empty();
		}

		List<com.chrislaforetsoftware.library.io.catalog.entities.Book> dbBooks = bookRepository.findByIsbn(isbn);
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
		// not implemented yet
		return new ArrayList<>();
	}

	@Override
	public IBook addBookToCatalog(String isbn, double price, IBook.AssignedUse assignedUse) {
		com.chrislaforetsoftware.library.io.catalog.entities.Catalog dbCatalog =
				repository.findById(isbn).orElseThrow(() -> new IllegalStateException("ISBN for new book instance cannot be found in catalog"));
		Title title = new Title(dbCatalog.getIsbn(), dbCatalog.getTitle(), dbCatalog.getAuthor());

		com.chrislaforetsoftware.library.io.catalog.entities.Book newBook =
				new com.chrislaforetsoftware.library.io.catalog.entities.Book();
		newBook.setIsbn(isbn);
		newBook.setPrice(price);
		newBook.setRestricted(assignedUse.equals(IBook.AssignedUse.RESTRICTED));
		bookRepository.save(newBook);

		return convertDbBook(newBook, title);
	}

	@Override
	public List<IBook> findBooksByISBN(String isbn) {
		Optional<com.chrislaforetsoftware.library.io.catalog.entities.Catalog> dbCatalog =
				repository.findById(isbn);
		if (!dbCatalog.isPresent()) {
			return new ArrayList<>();
		}
		Title title = new Title(dbCatalog.get().getIsbn(), dbCatalog.get().getTitle(), dbCatalog.get().getAuthor());

		List<com.chrislaforetsoftware.library.io.catalog.entities.Book> dbBooks = bookRepository.findByIsbn(isbn);
		return dbBooks.stream().map(dbBook -> convertDbBook(dbBook, title)).collect(Collectors.toList());
	}
}

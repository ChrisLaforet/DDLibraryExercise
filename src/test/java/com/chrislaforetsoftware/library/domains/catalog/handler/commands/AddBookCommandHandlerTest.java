package com.chrislaforetsoftware.library.domains.catalog.handler.commands;

import com.chrislaforetsoftware.library.business.catalog.entities.Book;
import com.chrislaforetsoftware.library.business.catalog.entities.Catalog;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddBookCommand;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.domains.catalog.rules.CatalogRules;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AddBookCommandHandlerTest {

    private static final String ISBN = "1234";
    private static final String TITLE = "Title";
    private static final String AUTHOR = "Author";
    private static final double PRICE = 19.99;

    private AddBookCommandHandler sut;

    @Mock
    private ICatalogRepository repository;

    private CatalogRules rules = new CatalogRules();

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @Before
    public void setup() {
        sut = new AddBookCommandHandler(repository, rules, applicationEventPublisher);
    }

    @Test(expected = IllegalStateException.class)
    public void givenANewBookInstance_whenAddingToCatalogWithNullTitle_thenThrowsException() {
        IBook book = new Book(null, PRICE, IBook.AssignedUse.RESTRICTED);
        sut.handle(new AddBookCommand(book));
    }

    @Test(expected = IllegalStateException.class)
    public void givenANewBookInstance_whenAddingToCatalogWithoutTitle_thenThrowsException() {
        ITitle title = new Title(ISBN, TITLE, AUTHOR);
        IBook book = new Book(title, PRICE, IBook.AssignedUse.RESTRICTED);
        sut.handle(new AddBookCommand(book));
    }

    @Test
    public void givenANewBookInstance_whenAddingToCatalog_thenAddsBookInstance() {
        ITitle title = new Title(ISBN, TITLE, AUTHOR);
        Mockito.when(repository.findTitleByISBN(Mockito.any())).thenReturn(Optional.of(new Catalog(title)));

        IBook book = new Book(title, PRICE, IBook.AssignedUse.RESTRICTED);
        Mockito.when(repository.addBookToCatalog(ISBN, PRICE, book.getAssignedUse())).thenReturn(book);
        IBook result = sut.handle(new AddBookCommand(book));
        assertNotNull(result);
    }
}
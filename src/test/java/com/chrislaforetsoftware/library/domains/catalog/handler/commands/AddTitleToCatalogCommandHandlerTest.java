package com.chrislaforetsoftware.library.domains.catalog.handler.commands;

import com.chrislaforetsoftware.library.business.catalog.entities.Catalog;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.business.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddTitleToCatalogCommand;
import com.chrislaforetsoftware.library.domains.catalog.repository.ICatalogRepository;
import com.chrislaforetsoftware.library.domains.catalog.rules.CatalogRules;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AddTitleToCatalogCommandHandlerTest {

    public static final String ISBN = "1234";
    public static final String TITLE = "Title";
    public static final String AUTHOR = "Author";

    @InjectMocks
    private AddTitleToCatalogCommandHandler sut;

    @Mock
    private ICatalogRepository repository;

    @Mock
    private CatalogRules catalogRules;

    @Test(expected = IllegalStateException.class)
    public void givenAddTitleToCatalogCommandHandler_whenAddingWithNullISBN_thenThrowsException() {
        sut.handle(new AddTitleToCatalogCommand(null, TITLE, AUTHOR));
    }

    @Test(expected = IllegalStateException.class)
    public void givenAddTitleToCatalogCommandHandler_whenAddingWithNullTitle_thenThrowsException() {
        sut.handle(new AddTitleToCatalogCommand(ISBN, null, AUTHOR));
    }

    @Test(expected = IllegalStateException.class)
    public void givenAddTitleToCatalogCommandHandler_whenAddingWithNullAuthor_thenThrowsException() {
        sut.handle(new AddTitleToCatalogCommand(ISBN, TITLE, null));
    }

    @Test
    public void givenAddTitleToCatalogCommandHandler_whenAddingWithValidStrings_thenAddsPatron() {
        Title title = new Title(ISBN, TITLE, AUTHOR);
        Catalog response = new Catalog(title);
        Mockito.when(repository.addTitleToCatalog(ISBN, TITLE, AUTHOR))
                .thenReturn(response);

        Mockito.when(catalogRules.isTitleEligibleForAdding(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);

        ICatalog catalog = sut.handle(new AddTitleToCatalogCommand(ISBN, TITLE, AUTHOR));
        assertNotNull(catalog);
    }
}
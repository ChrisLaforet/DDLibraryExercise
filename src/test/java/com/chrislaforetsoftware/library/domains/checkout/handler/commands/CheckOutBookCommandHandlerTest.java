package com.chrislaforetsoftware.library.domains.checkout.handler.commands;

import com.chrislaforetsoftware.library.business.catalog.entities.Book;
import com.chrislaforetsoftware.library.business.catalog.entities.Catalog;
import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.domains.catalog.entities.IBook;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddBookCommand;
import com.chrislaforetsoftware.library.domains.catalog.repository.IBookRepository;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.repository.ICheckoutRepository;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutBookCommandHandlerTest {

    private static final String ISBN = "1234";
    private static final String TITLE = "Title";
    private static final String AUTHOR = "Author";
    private static final double PRICE = 19.99;

    @InjectMocks
    CheckOutBookCommandHandler sut;

    @Mock
    private ICheckoutRepository repository;

    @Mock
    private IBookRepository bookRepository;

    @Mock
    private IPatronRepository patronRepository;

    @Test(expected = IllegalStateException.class)
    public void givenANonExistentBook_whenCheckingOut_thenThrowsException() {
        CheckOutBookCommand command = new CheckOutBookCommand(1, 1);
        when(bookRepository.getBookById(Mockito.anyInt())).thenReturn(Optional.empty());
        sut.handle(command);
    }

    @Test(expected = IllegalStateException.class)
    public void givenANonExistentPatron_whenCheckingOut_thenThrowsException() {
        CheckOutBookCommand command = new CheckOutBookCommand(1, 1);

        ITitle title = new Title(ISBN, TITLE, AUTHOR);
        IBook book = new Book(title, PRICE, IBook.AssignedUse.RESTRICTED);
        when(bookRepository.getBookById(Mockito.anyInt())).thenReturn(Optional.of(book));
        when(patronRepository.findPatronById(Mockito.anyString())).thenReturn(Optional.empty());
        sut.handle(command);
    }
}

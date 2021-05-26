package com.chrislaforetsoftware.library.domains.patron.handler.commands;

import com.chrislaforetsoftware.library.business.patron.entities.Patron;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.commands.requests.AddPatronCommand;
import com.chrislaforetsoftware.library.domains.patron.repository.IPatronRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddPatronCommandHandlerTest {

	public static final String JOHN_DOE = "John Doe";

	@InjectMocks
	private AddPatronCommandHandler sut;

	@Mock
	private IPatronRepository repository;

	@Test(expected = IllegalStateException.class)
	public void givenAddPatronCommandHandler_whenAddingWithNullName_thenThrowsException() {
		sut.handle(new AddPatronCommand(null, true));
	}

	@Test(expected = IllegalStateException.class)
	public void givenAddPatronCommandHandler_whenAddingWithEmptyName_thenThrowsException() {
		sut.handle(new AddPatronCommand(StringUtils.EMPTY, true));
	}

	@Test(expected = IllegalStateException.class)
	public void givenAddPatronCommandHandler_whenAddingWithEmptyString_thenThrowsException() {
		sut.handle(new AddPatronCommand("    ", true));
	}

	@Test
	public void givenAddPatronCommandHandler_whenAddingWithValidString_thenAddsPatron() {
		Patron response = new Patron("1", JOHN_DOE, IPatron.PatronType.RESEARCHER);
		Mockito.when(repository.addPatron(JOHN_DOE, true))
				.thenReturn(response);

		IPatron patron = sut.handle(new AddPatronCommand(JOHN_DOE, true));
		assertNotNull(patron);
	}
}
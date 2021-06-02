package com.chrislaforetsoftware.library.business.checkout.proxy;

import com.chrislaforetsoftware.library.adapters.patron.mappers.CheckoutDTOMappers;
import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckInBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetBooksForPatronQuery;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutForBookQuery;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutsForISBNQuery;
import com.chrislaforetsoftware.library.io.checkout.dto.AddCheckoutRequestDTO;
import com.chrislaforetsoftware.library.io.checkout.dto.CheckoutResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutProxy {

    private final ICommandHandler<CheckInBookCommand, Boolean> checkInBookCommandHandler;
    private final ICommandHandler<CheckOutBookCommand, ICheckout> checkOutBookCommandHandler;
    private final IQueryHandler<GetBooksForPatronQuery, List<ICheckout>> getBooksForPatronQueryHandler;
    private final IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> getCheckoutsForISBNQueryHandler;
    private final IQueryHandler<GetCheckoutForBookQuery, Optional<ICheckout>> getCheckoutForBookQueryHandler);

    @Autowired
    public CheckoutProxy(
            ICommandHandler<CheckInBookCommand, Boolean> checkInBookCommandHandler,
            ICommandHandler<CheckOutBookCommand, ICheckout> checkOutBookCommandHandler,
            IQueryHandler<GetBooksForPatronQuery, List<ICheckout>> getBooksForPatronQueryHandler,
            IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> getCheckoutsForISBNQueryHandler,
            IQueryHandler<GetCheckoutForBookQuery, Optional<ICheckout>> getCheckoutForBookQueryHandler) {
        this.checkInBookCommandHandler = checkInBookCommandHandler;
        this.checkOutBookCommandHandler = checkOutBookCommandHandler;
        this.getBooksForPatronQueryHandler = getBooksForPatronQueryHandler;
        this.getCheckoutsForISBNQueryHandler = getCheckoutsForISBNQueryHandler;
        this.getCheckoutForBookQueryHandler = getCheckoutForBookQueryHandler;
    }

    public Optional<CheckoutResponseDTO> getCheckoutForBookById(int id) {
        Optional<ICheckout> checkout = getCheckoutForBookQueryHandler.handle(new GetCheckoutForBookQuery(id));
        if (!checkout.isPresent()) {
            return Optional.empty();
        }
        return checkout.map(CheckoutDTOMappers::mapCheckoutToCheckoutResponseDTO);
    }

    public List<CheckoutResponseDTO> getCheckoutForBooksByISBN(String isbn) {

    }

    public List<CheckoutResponseDTO> getCheckoutsForPatronById(int id) {

    }

    public CheckoutResponseDTO addCheckoutForBook(AddCheckoutRequestDTO request) {

    }

    public void deleteCheckout(int id) {

    }
}

package com.chrislaforetsoftware.library.business.checkout.proxy;

import com.chrislaforetsoftware.library.adapters.patron.mappers.CheckoutDTOMappers;
import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckInBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests.CheckOutBookCommand;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetBooksForPatronQuery;
import com.chrislaforetsoftware.library.domains.checkout.handler.queries.requests.GetCheckoutsForISBNQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronByIdQuery;
import com.chrislaforetsoftware.library.io.checkout.dto.AddCheckoutRequestDTO;
import com.chrislaforetsoftware.library.io.checkout.dto.CheckoutResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckoutProxy {

    private final ICommandHandler<CheckInBookCommand, Boolean> checkInBookCommandHandler;
    private final ICommandHandler<CheckOutBookCommand, ICheckout> checkOutBookCommandHandler;
    private final IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler;
    private final IQueryHandler<GetBooksForPatronQuery, List<ICheckout>> getBooksForPatronQueryHandler;
    private final IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> getCheckoutsForISBNQueryHandler;

    @Autowired
    public CheckoutProxy(
            ICommandHandler<CheckInBookCommand, Boolean> checkInBookCommandHandler,
            ICommandHandler<CheckOutBookCommand, ICheckout> checkOutBookCommandHandler,
            IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler,
            IQueryHandler<GetBooksForPatronQuery, List<ICheckout>> getBooksForPatronQueryHandler,
            IQueryHandler<GetCheckoutsForISBNQuery, List<ICheckout>> getCheckoutsForISBNQueryHandler) {
        this.checkInBookCommandHandler = checkInBookCommandHandler;
        this.checkOutBookCommandHandler = checkOutBookCommandHandler;
        this.getPatronByIdQueryHandler = getPatronByIdQueryHandler;
        this.getBooksForPatronQueryHandler = getBooksForPatronQueryHandler;
        this.getCheckoutsForISBNQueryHandler = getCheckoutsForISBNQueryHandler;
    }

    public List<CheckoutResponseDTO> getCheckoutsForBooksByISBN(String isbn) {
        List<ICheckout> checkouts = getCheckoutsForISBNQueryHandler.handle(new GetCheckoutsForISBNQuery(isbn));
        return checkouts.stream().map(CheckoutDTOMappers::mapCheckoutToCheckoutResponseDTO).collect(Collectors.toList());
    }

    public List<CheckoutResponseDTO> getCheckoutsForPatronById(int id) {
        IPatron patron = getPatronByIdQueryHandler.handle(new GetPatronByIdQuery(Integer.toString(id)))
                            .orElseThrow(() -> new IllegalStateException("Cannot find patron"));
        List<ICheckout> checkouts = getBooksForPatronQueryHandler.handle(new GetBooksForPatronQuery(patron));
        return checkouts.stream().map(CheckoutDTOMappers::mapCheckoutToCheckoutResponseDTO).collect(Collectors.toList());
    }

    public CheckoutResponseDTO addCheckoutForBook(AddCheckoutRequestDTO request) {
        CheckOutBookCommand command = new CheckOutBookCommand(request.getBookId(), request.getPatronId());
        return CheckoutDTOMappers.mapCheckoutToCheckoutResponseDTO(checkOutBookCommandHandler.handle(command));
    }

    public void deleteCheckout(int id) {

    }
}

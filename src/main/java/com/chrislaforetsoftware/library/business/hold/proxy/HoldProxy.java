package com.chrislaforetsoftware.library.business.hold.proxy;

import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetTitleByISBNQuery;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.handler.commands.requests.AddHoldOnTitleByPatronCommand;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForPatronQuery;
import com.chrislaforetsoftware.library.domains.hold.handler.queries.requests.GetHoldsForTitleQuery;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.domains.patron.handler.queries.requests.GetPatronByIdQuery;
import com.chrislaforetsoftware.library.io.titlehold.dtos.TitleHoldResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HoldProxy {

    private final IQueryHandler<GetHoldsForPatronQuery, List<IHold>> getHoldsForPatronQueryHandler;
    private final IQueryHandler<GetHoldsForTitleQuery, List<IHold>> getHoldsForTitleQueryHandler;
    private final IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler;
    private final IQueryHandler<GetTitleByISBNQuery, Optional<ICatalog>> getTitleByISBNQueryHandler;
    private final ICommandHandler<AddHoldOnTitleByPatronCommand, Void> addHoldOnTitleByPatronCommandHandler;

    @Autowired
    public HoldProxy(IQueryHandler<GetHoldsForPatronQuery, List<IHold>> getHoldsForPatronQueryHandler,
                     IQueryHandler<GetHoldsForTitleQuery, List<IHold>> getHoldsForTitleQueryHandler,
                     IQueryHandler<GetPatronByIdQuery, Optional<IPatron>> getPatronByIdQueryHandler,
                     IQueryHandler<GetTitleByISBNQuery, Optional<ICatalog>> getTitleByISBNQueryHandler,
                     ICommandHandler<AddHoldOnTitleByPatronCommand, Void> addHoldOnTitleByPatronCommandHandler) {
        this.getHoldsForPatronQueryHandler = getHoldsForPatronQueryHandler;
        this.getHoldsForTitleQueryHandler = getHoldsForTitleQueryHandler;
        this.getPatronByIdQueryHandler = getPatronByIdQueryHandler;
        this.getTitleByISBNQueryHandler = getTitleByISBNQueryHandler;
        this.addHoldOnTitleByPatronCommandHandler = addHoldOnTitleByPatronCommandHandler;
    }

    public List<TitleHoldResponseDTO> getHoldsForBooksByISBN(String isbn) {
        ICatalog catalog = getTitleByISBNQueryHandler.handle(new GetTitleByISBNQuery(isbn))
                        .orElseThrow(() -> new IllegalStateException("Unable to find catalog title by isbn"));
        return mapHoldsToResponses(getHoldsForTitleQueryHandler.handle(new GetHoldsForTitleQuery(catalog.getTitleInstance())));
    }

    public List<TitleHoldResponseDTO> getHoldsForBooksForPatron(int patronId) {
        IPatron patron = getPatronByIdQueryHandler.handle(new GetPatronByIdQuery(Integer.toString(patronId)))
                            .orElseThrow(() -> new IllegalStateException("Unable to find patron by id"));
        return mapHoldsToResponses(getHoldsForPatronQueryHandler.handle(new GetHoldsForPatronQuery(patron)));
    }

    public void addTitleHold(String isbn, int patronId) {
        ICatalog catalog = getTitleByISBNQueryHandler.handle(new GetTitleByISBNQuery(isbn))
                .orElseThrow(() -> new IllegalStateException("Unable to find catalog title by isbn"));
        IPatron patron = getPatronByIdQueryHandler.handle(new GetPatronByIdQuery(Integer.toString(patronId)))
                .orElseThrow(() -> new IllegalStateException("Unable to find patron by id"));

        addHoldOnTitleByPatronCommandHandler.handle(new AddHoldOnTitleByPatronCommand(catalog.getTitleInstance(), patron));
    }

    private List<TitleHoldResponseDTO> mapHoldsToResponses(List<IHold> holds) {
        return holds.stream().map(hold -> {
                TitleHoldResponseDTO response = new TitleHoldResponseDTO();
                response.setId(hold.getId());
                response.setPatronId(hold.getPatron().getId());
                response.setPatronName(hold.getPatron().getName());
                response.setIsbn(hold.getTitle().getISBN());
                response.setTitle(hold.getTitle().getTitle());
                return response;
            }).collect(Collectors.toList());
    }
}

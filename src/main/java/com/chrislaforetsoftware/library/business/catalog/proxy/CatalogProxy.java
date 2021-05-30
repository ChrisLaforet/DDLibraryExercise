package com.chrislaforetsoftware.library.business.catalog.proxy;

import com.chrislaforetsoftware.library.adapters.patron.mappers.CatalogDTOMappers;
import com.chrislaforetsoftware.library.common.cqs.ICommandHandler;
import com.chrislaforetsoftware.library.common.cqs.IQueryHandler;
import com.chrislaforetsoftware.library.domains.catalog.entities.ICatalog;
import com.chrislaforetsoftware.library.domains.catalog.handler.commands.requests.AddTitleToCatalogCommand;
import com.chrislaforetsoftware.library.domains.catalog.handler.queries.requests.GetTitleByISBNQuery;
import com.chrislaforetsoftware.library.io.catalog.dtos.AddTitleRequestDTO;
import com.chrislaforetsoftware.library.io.catalog.dtos.TitleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogProxy {

	private final ICommandHandler<AddTitleToCatalogCommand, ICatalog> addTitleToCatalogCommandHandler;
	private final IQueryHandler<GetTitleByISBNQuery, Optional<ICatalog>> getTitleByISBNQueryHandler;

	@Autowired
	public CatalogProxy(ICommandHandler<AddTitleToCatalogCommand, ICatalog> addTitleToCatalogCommandHandler,
						IQueryHandler<GetTitleByISBNQuery, Optional<ICatalog>> getTitleByISBNQueryHandler) {
		this.addTitleToCatalogCommandHandler = addTitleToCatalogCommandHandler;
		this.getTitleByISBNQueryHandler = getTitleByISBNQueryHandler;
	}

	public Optional<TitleResponseDTO> getTitleByIsbn(String isbn) {
		Optional<ICatalog> catalog = getTitleByISBNQueryHandler.handle(new GetTitleByISBNQuery(isbn));
		return catalog.map(CatalogDTOMappers::mapCatalogToTitleResponseDTO);
	}

	public TitleResponseDTO addTitle(AddTitleRequestDTO requestDTO) {
		AddTitleToCatalogCommand command = new AddTitleToCatalogCommand(requestDTO.getIsbn(), requestDTO.getTitle(), requestDTO.getAuthor());
		return CatalogDTOMappers.mapCatalogToTitleResponseDTO(addTitleToCatalogCommandHandler.handle(command));
	}
}

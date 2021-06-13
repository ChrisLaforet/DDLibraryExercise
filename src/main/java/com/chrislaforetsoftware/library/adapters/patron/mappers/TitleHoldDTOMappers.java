package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.io.titlehold.dtos.TitleHoldResponseDTO;

public class TitleHoldDTOMappers {

    private TitleHoldDTOMappers() {
        // keeps class static
    }

    public static TitleHoldResponseDTO mapHoldToTitleHoldResponseDTO(IHold hold) {
        TitleHoldResponseDTO response = new TitleHoldResponseDTO();
        response.setId(hold.getId());
        response.setBookId(hold.getBook().getId());
        response.setIsbn(hold.getBook().getTitleInstance().getISBN());
        response.setTitle(hold.getBook().getTitleInstance().getTitle());
        response.setPatronId(hold.getPatron().getId());
        response.setPatronName(hold.getPatron().getName());
        return response;
    }
}

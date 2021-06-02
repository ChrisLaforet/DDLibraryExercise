package com.chrislaforetsoftware.library.adapters.patron.mappers;

import com.chrislaforetsoftware.library.domains.checkout.entities.ICheckout;
import com.chrislaforetsoftware.library.io.checkout.dto.CheckoutResponseDTO;

public class CheckoutDTOMappers {

    private CheckoutDTOMappers() {
        // keep class as static
    }

    public static CheckoutResponseDTO mapCheckoutToCheckoutResponseDTO(ICheckout checkout) {
        CheckoutResponseDTO response = new CheckoutResponseDTO();
        response.setId(checkout.getBook().getId());
        response.setIsbn(checkout.getBook().getTitleInstance().getISBN());
        response.setTitle(checkout.getBook().getTitleInstance().getTitle());
        response.setPatronId(checkout.getPatron().getId());
        response.setPatronName(checkout.getPatron().getName());
        response.setCheckedOut(checkout.getCheckoutDate());
        response.setOverdue(ICheckout.isOverdue(checkout));
        return response;
    }
}

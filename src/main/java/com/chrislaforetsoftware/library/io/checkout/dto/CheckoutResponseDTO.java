package com.chrislaforetsoftware.library.io.checkout.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CheckoutResponseDTO {

    private int id;

    @JsonAlias({"ISBN"})
    private String isbn;
    private String title;

    private String patronId;
    private String patronName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkedOut;
}

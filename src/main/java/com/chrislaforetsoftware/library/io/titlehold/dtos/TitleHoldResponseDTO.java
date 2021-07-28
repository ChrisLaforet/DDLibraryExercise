package com.chrislaforetsoftware.library.io.titlehold.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

import java.util.Date;

@Setter
public class TitleHoldResponseDTO {
    private int id;

    @JsonAlias({"ISBN"})
    private String isbn;
    private String title;

    private String patronId;
    private String patronName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date notified;
}

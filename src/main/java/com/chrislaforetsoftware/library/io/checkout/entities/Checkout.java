package com.chrislaforetsoftware.library.io.checkout.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name="BOOK_ID")
    private int bookId;

    @Column(name="PATRON_ID")
    private int patronId;

    @Column(name="CHECKED_OUT")
    private Date checkedOut;
}

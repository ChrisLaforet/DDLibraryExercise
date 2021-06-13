package com.chrislaforetsoftware.library.io.titlehold.entities;

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
public class TitleHold implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name="ISBN")
    private String isbn;

    @Column(name="IS_CLOSED_ENDED")
    private boolean closedEnded;

    @Column(name="PATRON_ID")
    private int patronId;

    @Column(name="NOTIFIED")
    private Date notified;
}

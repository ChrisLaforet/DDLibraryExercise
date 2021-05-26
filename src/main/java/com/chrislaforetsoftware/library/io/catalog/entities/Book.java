package com.chrislaforetsoftware.library.io.catalog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String isbn;
	private double price;

	@Column(name="IS_RESTRICTED_COPY")
	private boolean restricted;
}

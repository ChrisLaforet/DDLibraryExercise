package com.chrislaforetsoftware.library.io.catalog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;
	private String title;
	private String author;
}

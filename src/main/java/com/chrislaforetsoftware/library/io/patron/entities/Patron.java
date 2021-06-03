package com.chrislaforetsoftware.library.io.patron.entities;

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
public class Patron implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="FULL_NAME")
	private String name;
	private boolean isResearcher;
}

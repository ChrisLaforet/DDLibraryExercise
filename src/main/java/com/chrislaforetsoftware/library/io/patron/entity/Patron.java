package com.chrislaforetsoftware.library.io.patron.entity;

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
public class Patron implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	private boolean isResearcher;
}

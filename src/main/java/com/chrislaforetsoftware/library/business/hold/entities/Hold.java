package com.chrislaforetsoftware.library.business.hold.entities;

import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import lombok.Getter;

@Getter
public class Hold implements IHold {

	private final int id;
	private final IPatron patron;
	private final ITitle title;
	private final HoldType holdType;

	public Hold(int id, IPatron patron, ITitle title, HoldType holdType) {
		this.id = id;
		this.patron = patron;
		this.title = title;
		this.holdType = holdType;
	}
}

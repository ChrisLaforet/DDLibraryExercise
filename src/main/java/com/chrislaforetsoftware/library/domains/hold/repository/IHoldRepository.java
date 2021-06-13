package com.chrislaforetsoftware.library.domains.hold.repository;

import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.io.titlehold.entities.TitleHold;

import java.util.List;

public interface IHoldRepository extends CrudRepository<TitleHold, Integer> {
    List<IHold> getHoldsForPatron(IPatron patron);
    List<IHold> getHoldsForTitle(ITitle title);
    IHold addHold(ITitle title, IPatron patron);
}

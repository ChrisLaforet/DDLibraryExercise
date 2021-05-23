package com.chrislaforetsoftware.library.domains.patron.repository;

import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;

public interface IPatronRepository {

    IPatron savePatron(IPatron patron);
}

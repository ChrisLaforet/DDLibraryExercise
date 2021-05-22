package com.chrislaforetsoftware.library.common.cqs;

public interface IQueryHandler<Q extends IQuery, R> {

	public R handle(Q query);
}

package com.chrislaforetsoftware.library.common.cqs;

public interface ICommandHandler<C extends ICommand, R> {

	public R handle(C command);
}

package com.chrislaforetsoftware.library.domains.checkout.handler.commands.requests;

import com.chrislaforetsoftware.library.common.cqs.ICommand;

@Getter
public class CheckOutBookCommand implements ICommand {
    private int bookId;
    private int patronId;

    public CheckOutBookCommand(int bookId, int patronId) {
        this.bookId = bookId;
        this.patronId = patronId;
    }
}

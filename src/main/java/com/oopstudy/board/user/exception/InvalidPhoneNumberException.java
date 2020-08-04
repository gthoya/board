package com.oopstudy.board.user.exception;

public class InvalidPhoneNumberException extends IllegalArgumentException {
    public InvalidPhoneNumberException(final String message) {
        super(message);
    }
}

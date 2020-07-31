package com.oopstudy.board.user.exception;

public class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(final String message) {
        super(message);
    }
}

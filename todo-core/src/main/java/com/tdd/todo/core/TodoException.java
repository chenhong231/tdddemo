package com.tdd.todo.core;

public class TodoException extends RuntimeException {

    public TodoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

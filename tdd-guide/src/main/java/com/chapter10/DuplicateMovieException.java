package com.chapter10;

public class DuplicateMovieException extends RuntimeException {

    DuplicateMovieException(String message) {
        super(message);
    }
}

package com.stack.apibooklovers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookByIdNotFound extends RuntimeException {

    public BookByIdNotFound(String message) {
        super(message);
    }
}

package com.stack.apibooklovers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictIsbn extends RuntimeException {
    public ConflictIsbn(String message) {
        super(message);
    }
}

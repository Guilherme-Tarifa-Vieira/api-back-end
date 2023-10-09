package com.stack.apibooklovers.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictIsbn extends RuntimeException {
    public ConflictIsbn(String message) {
        super(message);
    }
}

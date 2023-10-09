package com.stack.apibooklovers.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentList extends RuntimeException {
    public NoContentList(String message) {
        super(message);
    }
}


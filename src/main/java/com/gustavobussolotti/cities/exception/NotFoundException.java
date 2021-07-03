package com.gustavobussolotti.cities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(Long id) {
        super(String.format("Country with id %s not found in the system.", id));
    }
}
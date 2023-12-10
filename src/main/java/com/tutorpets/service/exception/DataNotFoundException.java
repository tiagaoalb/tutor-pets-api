package com.tutorpets.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DataNotFoundException extends ResponseStatusException {
    public DataNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}

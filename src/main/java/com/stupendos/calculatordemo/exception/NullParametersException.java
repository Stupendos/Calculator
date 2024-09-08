package com.stupendos.calculatordemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NullParametersException extends RuntimeException {
    public NullParametersException(String message) {
        super(message);
    }
}

package com.codemagic.inventoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistException extends RuntimeException {
    private String message;

    public ProductAlreadyExistException(String message) {
        super(message);
        //this.message = message;
    }
}

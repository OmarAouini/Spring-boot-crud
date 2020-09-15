package com.aouin.springbootcrud.service.exceptions;

public class UserValidationException extends Throwable {
    public UserValidationException(String msg) {
        super(msg);
    }
}

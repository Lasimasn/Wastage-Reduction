package com.stackroute.registrationserver.exceptions;

public class EntityNotExistsException extends Exception {

    private String message;

    public EntityNotExistsException() {

    }

    public EntityNotExistsException(String message) {
        super(message);
        this.message = message;
    }
}
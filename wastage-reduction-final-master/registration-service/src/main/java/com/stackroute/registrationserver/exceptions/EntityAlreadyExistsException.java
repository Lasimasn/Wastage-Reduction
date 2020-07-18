package com.stackroute.registrationserver.exceptions;

public class EntityAlreadyExistsException extends Exception {

    private String message;

    public EntityAlreadyExistsException() {

    }

    public EntityAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

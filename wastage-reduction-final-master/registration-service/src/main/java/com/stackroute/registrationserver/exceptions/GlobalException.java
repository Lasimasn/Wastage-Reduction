package com.stackroute.registrationserver.exceptions;

import com.stackroute.registrationserver.response.ResponseForError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<ResponseForError> globalEntityAlreadyExistsException(EntityAlreadyExistsException e) throws Exception {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(responseForError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotExistsException.class})
    public ResponseEntity<ResponseForError> globalEntityNotExistsException(EntityNotExistsException e) throws Exception {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(responseForError, HttpStatus.BAD_REQUEST);
    }
}
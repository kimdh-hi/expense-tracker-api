package com.dhk.expensetrackerapi.exception;

import com.dhk.expensetrackerapi.exception.entity.ErrorObject;
import com.dhk.expensetrackerapi.exception.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFountException(ResourceNotFoundException ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorObject.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleInternalServerError(Exception ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

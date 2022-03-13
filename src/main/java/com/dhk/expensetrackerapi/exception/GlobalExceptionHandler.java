package com.dhk.expensetrackerapi.exception;

import com.dhk.expensetrackerapi.exception.entity.ErrorObject;
import com.dhk.expensetrackerapi.exception.exceptions.ItemAlreadyExistsException;
import com.dhk.expensetrackerapi.exception.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFountException(ResourceNotFoundException ex) {
        ErrorObject errorObject = generateErrorObject(ex, HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorObject errorObject = generateErrorObject(ex, HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorObject> handleItemAlreadyExistsException(ItemAlreadyExistsException ex) {
        ErrorObject errorObject = generateErrorObject(ex, HttpStatus.CONTINUE.value());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleInternalServerError(Exception ex) {
        ErrorObject errorObject = generateErrorObject(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorObject generateErrorObject(Exception ex, int statusCode) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        errorObject.setStatusCode(statusCode);
        errorObject.setTimestamp(LocalDateTime.now());

        LOG.error("[error] statusCode={}, class={}, message={}", statusCode, ex.getClass().getName(), ex.getMessage());

        return errorObject;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new HashMap<>();

        body.put("statusCode", HttpStatus.BAD_REQUEST);
        body.put("timestamp", LocalDateTime.now());

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("messages", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}

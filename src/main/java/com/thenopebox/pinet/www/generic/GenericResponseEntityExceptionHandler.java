package com.thenopebox.pinet.www.generic;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GenericResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { NoSuchElementException.class })
    protected ResponseEntity<Object> handleOptionalUnwrapping(RuntimeException exception, WebRequest request) {
        String bodyOfResponse = "This should be application specific.";

        return handleExceptionInternal(exception, "{\"error\": \"hmmm.\"}", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}

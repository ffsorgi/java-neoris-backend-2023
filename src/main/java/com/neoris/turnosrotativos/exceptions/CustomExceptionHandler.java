package com.neoris.turnosrotativos.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Federico Fernando Sorgi Rosenthal
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", status.value());

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        responseBody.put("errors", errors);
        return new ResponseEntity<>(responseBody, headers, status);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(ConflictException ex, WebRequest req) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest req) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleErrorServerException(NotFoundException ex, WebRequest req){

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ErrorServerExeption.class)
    public ResponseEntity<Object> handleErrorServerException(BadRequestException ex, WebRequest req) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

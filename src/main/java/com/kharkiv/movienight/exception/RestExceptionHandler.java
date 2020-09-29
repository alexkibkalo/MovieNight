package com.kharkiv.movienight.exception;

import com.kharkiv.movienight.exception.user.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserWithSuchEmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserWithSuchEmailAlreadyExistsException(UserWithSuchEmailAlreadyExistsException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<Object> handlePasswordMismatchException(PasswordMismatchException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserWithSuchPhoneAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserWithSuchPhoneAlreadyExistsException(UserWithSuchPhoneAlreadyExistsException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserWithSuchUserNameAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserWithSuchUserNameAlreadyExistsException(UserWithSuchUserNameAlreadyExistsException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDateOfBirthInvalidException.class)
    public ResponseEntity<Object> handleUserDateOfBirthInvalidException(UserDateOfBirthInvalidException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserBadCredentialsException.class)
    public ResponseEntity<Object> handleUserBadCredentialsException(UserBadCredentialsException exception, WebRequest request) {
        return getObjectResponseEntity(request, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> getObjectResponseEntity(WebRequest request, String message, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        body.put("path", request.getContextPath());

        return new ResponseEntity<>(body, status);
    }

}

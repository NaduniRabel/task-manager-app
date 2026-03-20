package com.task_manager.backend.error;

import com.task_manager.backend.error.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
    /*Resource not found exception */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
                ResourceNotFoundException ex, 
                HttpServletRequest request ){
        ErrorResponse response =  new ErrorResponse(
            LocalDateTime.now(), 
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(), 
            ex.getMessage(),
            request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /*Validation errors */
    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationErrors(
                MethodArgumentNotValidException ex,
                HttpServletRequest request) {

            Map<String, String> errors = new HashMap<>();

            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );

            String message = errors.values()
                .stream()
                .findFirst()
                .orElse("Validation error");

            ErrorResponse response = new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    "Validation Failed",
                    message,
                    request.getRequestURI()
            );

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
   
}

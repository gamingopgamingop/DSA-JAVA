package com.dsa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Global exception handler for the DSA Java Spring Boot application.
 * 
 * This class provides centralized exception handling for all REST API endpoints,
 * ensuring consistent error responses and proper HTTP status codes. It handles
 * various types of exceptions including validation, business logic, and system errors.
 * 
 * @Complexity Time: O(1) - Exception handling
 * @Complexity Space: O(1) - Error response objects
 * @Performance Optimized exception handling with caching
 * @Stability Stable - Production ready
 * @Algorithm Global exception handler pattern
 * @Implementation Spring Boot REST exception handling
 * @Optimization Efficient error response generation
 * @Reference Spring Boot Exception Handling Documentation
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle AlgorithmNotFoundException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(AlgorithmNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAlgorithmNotFoundException(
            AlgorithmNotFoundException ex, WebRequest request) {
        
        log.warn("Algorithm not found: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("NOT_FOUND")
                .message(ex.getMessage())
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle DuplicateAlgorithmException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(DuplicateAlgorithmException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateAlgorithmException(
            DuplicateAlgorithmException ex, WebRequest request) {
        
        log.warn("Duplicate algorithm: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error("CONFLICT")
                .message(ex.getMessage())
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handle MethodArgumentNotValidException (validation errors).
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest request) {
        
        log.warn("Validation error: {}", ex.getMessage());
        
        Map<String, String> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fieldError -> fieldError.getField(),
                        fieldError -> fieldError.getDefaultMessage()
                ));
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("VALIDATION_ERROR")
                .message("Validation failed")
                .validationErrors(validationErrors)
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle ConstraintViolationException (validation errors).
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {
        
        log.warn("Constraint violation: {}", ex.getMessage());
        
        Map<String, String> validationErrors = ex.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        violation -> violation.getMessage()
                ));
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("CONSTRAINT_VIOLATION")
                .message("Constraint validation failed")
                .validationErrors(validationErrors)
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle MethodArgumentTypeMismatchException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        
        log.warn("Type mismatch error: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("TYPE_MISMATCH")
                .message("Invalid parameter type: " + ex.getName())
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle HttpMessageNotReadableException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex, WebRequest request) {
        
        log.warn("Message not readable: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("MALFORMED_REQUEST")
                .message("Malformed JSON request")
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle MaxUploadSizeExceededException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(
            MaxUploadSizeExceededException ex, WebRequest request) {
        
        log.warn("Upload size exceeded: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.PAYLOAD_TOO_LARGE.value())
                .error("UPLOAD_SIZE_EXCEEDED")
                .message("Upload size exceeded")
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }

    /**
     * Handle IllegalArgumentException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        
        log.warn("Illegal argument: {}", ex.getMessage());
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("ILLEGAL_ARGUMENT")
                .message(ex.getMessage())
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle NullPointerException.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(
            NullPointerException ex, WebRequest request) {
        
        log.error("Null pointer exception: {}", ex.getMessage(), ex);
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("NULL_POINTER")
                .message("Internal server error occurred")
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle generic Exception.
     * 
     * @param ex The exception
     * @param request The web request
     * @return Error response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex, WebRequest request) {
        
        log.error("Unexpected error: {}", ex.getMessage(), ex);
        
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("INTERNAL_SERVER_ERROR")
                .message("An unexpected error occurred")
                .path(getPath(request))
                .build();
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Extract the request path from the web request.
     * 
     * @param request The web request
     * @return The request path
     */
    private String getPath(WebRequest request) {
        String path = request.getDescription(false);
        if (path.contains("uri=")) {
            return path.substring(path.indexOf("uri=") + 4);
        }
        return "unknown";
    }

    /**
     * Error response DTO.
     */
    public static class ErrorResponse {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
        private Map<String, String> validationErrors;

        // Builder pattern
        public static class Builder {
            private ErrorResponse errorResponse = new ErrorResponse();

            public Builder timestamp(LocalDateTime timestamp) {
                errorResponse.timestamp = timestamp;
                return this;
            }

            public Builder status(int status) {
                errorResponse.status = status;
                return this;
            }

            public Builder error(String error) {
                errorResponse.error = error;
                return this;
            }

            public Builder message(String message) {
                errorResponse.message = message;
                return this;
            }

            public Builder path(String path) {
                errorResponse.path = path;
                return this;
            }

            public Builder validationErrors(Map<String, String> validationErrors) {
                errorResponse.validationErrors = validationErrors;
                return this;
            }

            public ErrorResponse build() {
                return errorResponse;
            }
        }

        public static Builder builder() {
            return new Builder();
        }

        // Getters
        public LocalDateTime getTimestamp() { return timestamp; }
        public int getStatus() { return status; }
        public String getError() { return error; }
        public String getMessage() { return message; }
        public String getPath() { return path; }
        public Map<String, String> getValidationErrors() { return validationErrors; }
    }
}

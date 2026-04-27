package com.dsa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when attempting to create an algorithm that already exists.
 * 
 * This exception is used to indicate that an algorithm with the same
 * name or identifier already exists in the system, preventing duplicate
 * entries and maintaining data integrity.
 * 
 * @Complexity Time: O(1) - Exception creation
 * @Complexity Space: O(1) - Exception memory footprint
 * @Performance Optimized exception handling
 * @Stability Stable - Production ready
 * @Algorithm Custom exception with HTTP status
 * @Implementation Spring Boot exception handling
 * @Optimization Proper exception hierarchy and messaging
 * @Reference Spring Boot Exception Documentation
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateAlgorithmException extends RuntimeException {

    /**
     * Constructs a new DuplicateAlgorithmException with the specified detail message.
     * 
     * @param message The detail message explaining why the exception occurred
     */
    public DuplicateAlgorithmException(String message) {
        super(message);
    }

    /**
     * Constructs a new DuplicateAlgorithmException with the specified detail message and cause.
     * 
     * @param message The detail message explaining why the exception occurred
     * @param cause The cause of the exception
     */
    public DuplicateAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DuplicateAlgorithmException for an algorithm with the specified name.
     * 
     * @param name The name of the algorithm that already exists
     */
    public DuplicateAlgorithmException(String name) {
        super("Algorithm already exists with name: " + name);
    }

    /**
     * Constructs a new DuplicateAlgorithmException for an algorithm with the specified name and cause.
     * 
     * @param name The name of the algorithm that already exists
     * @param cause The cause of the exception
     */
    public DuplicateAlgorithmException(String name, Throwable cause) {
        super("Algorithm already exists with name: " + name, cause);
    }

    /**
     * Creates a DuplicateAlgorithmException for an algorithm that already exists by name.
     * 
     * @param name The name of the algorithm that already exists
     * @return A new DuplicateAlgorithmException instance
     */
    public static DuplicateAlgorithmException byName(String name) {
        return new DuplicateAlgorithmException(name);
    }

    /**
     * Creates a DuplicateAlgorithmException for an algorithm that already exists by name with cause.
     * 
     * @param name The name of the algorithm that already exists
     * @param cause The cause of the exception
     * @return A new DuplicateAlgorithmException instance
     */
    public static DuplicateAlgorithmException byName(String name, Throwable cause) {
        return new DuplicateAlgorithmException(name, cause);
    }
}

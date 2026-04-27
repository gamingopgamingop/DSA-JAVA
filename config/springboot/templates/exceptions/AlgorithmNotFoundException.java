package com.dsa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Exception thrown when an algorithm is not found in the system.
 * 
 * This exception is used to indicate that a requested algorithm
 * could not be found by its ID, name, or other identifier.
 * It extends RuntimeException for unchecked exception handling.
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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlgorithmNotFoundException extends RuntimeException {

    /**
     * Constructs a new AlgorithmNotFoundException with the specified detail message.
     * 
     * @param message The detail message explaining why the exception occurred
     */
    public AlgorithmNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new AlgorithmNotFoundException with the specified detail message and cause.
     * 
     * @param message The detail message explaining why the exception occurred
     * @param cause The cause of the exception
     */
    public AlgorithmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new AlgorithmNotFoundException for an algorithm with the specified ID.
     * 
     * @param id The ID of the algorithm that was not found
     */
    public AlgorithmNotFoundException(UUID id) {
        super("Algorithm not found with ID: " + id);
    }

    /**
     * Constructs a new AlgorithmNotFoundException for an algorithm with the specified name.
     * 
     * @param name The name of the algorithm that was not found
     */
    public AlgorithmNotFoundException(String name) {
        super("Algorithm not found with name: " + name);
    }

    /**
     * Constructs a new AlgorithmNotFoundException for an algorithm with the specified ID.
     * 
     * @param id The ID of the algorithm that was not found
     * @param cause The cause of the exception
     */
    public AlgorithmNotFoundException(UUID id, Throwable cause) {
        super("Algorithm not found with ID: " + id, cause);
    }

    /**
     * Constructs a new AlgorithmNotFoundException for an algorithm with the specified name.
     * 
     * @param name The name of the algorithm that was not found
     * @param cause The cause of the exception
     */
    public AlgorithmNotFoundException(String name, Throwable cause) {
        super("Algorithm not found with name: " + name, cause);
    }

    /**
     * Creates an AlgorithmNotFoundException for an algorithm that was not found by ID.
     * 
     * @param id The ID of the algorithm that was not found
     * @return A new AlgorithmNotFoundException instance
     */
    public static AlgorithmNotFoundException byId(UUID id) {
        return new AlgorithmNotFoundException(id);
    }

    /**
     * Creates an AlgorithmNotFoundException for an algorithm that was not found by name.
     * 
     * @param name The name of the algorithm that was not found
     * @return A new AlgorithmNotFoundException instance
     */
    public static AlgorithmNotFoundException byName(String name) {
        return new AlgorithmNotFoundException(name);
    }

    /**
     * Creates an AlgorithmNotFoundException for an algorithm that was not found by ID with cause.
     * 
     * @param id The ID of the algorithm that was not found
     * @param cause The cause of the exception
     * @return A new AlgorithmNotFoundException instance
     */
    public static AlgorithmNotFoundException byId(UUID id, Throwable cause) {
        return new AlgorithmNotFoundException(id, cause);
    }

    /**
     * Creates an AlgorithmNotFoundException for an algorithm that was not found by name with cause.
     * 
     * @param name The name of the algorithm that was not found
     * @param cause The cause of the exception
     * @return A new AlgorithmNotFoundException instance
     */
    public static AlgorithmNotFoundException byName(String name, Throwable cause) {
        return new AlgorithmNotFoundException(name, cause);
    }
}

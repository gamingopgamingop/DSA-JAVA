package com.dsa.controllers;

import com.dsa.dto.AlgorithmRequest;
import com.dsa.dto.AlgorithmResponse;
import com.dsa.dto.AlgorithmExecutionRequest;
import com.dsa.dto.AlgorithmExecutionResponse;
import com.dsa.dto.AlgorithmAnalysisRequest;
import com.dsa.dto.AlgorithmAnalysisResponse;
import com.dsa.services.AlgorithmService;
import com.dsa.services.AlgorithmExecutionService;
import com.dsa.services.AlgorithmAnalysisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;

/**
 * REST Controller for managing algorithms in the DSA Java Application.
 * 
 * This controller provides endpoints for algorithm management, execution,
 * analysis, and visualization. It supports caching, security, and comprehensive
 * error handling.
 * 
 * @Complexity Time: O(1) - Controller method dispatch
 * @Complexity Space: O(1) - Request/Response objects
 * @Performance Optimized with caching and pagination
 * @Stability Stable - Production ready
 * @Algorithm REST API controller pattern
 * @Implementation Spring Boot 3.2 REST controller
 * @Optimization Response caching and pagination
 * @Reference Spring Boot REST Documentation
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/algorithms")
@RequiredArgsConstructor
@Tag(name = "Algorithm Management", description = "APIs for managing algorithms, execution, and analysis")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlgorithmController {

    private final AlgorithmService algorithmService;
    private final AlgorithmExecutionService executionService;
    private final AlgorithmAnalysisService analysisService;

    /**
     * Get all available algorithms with pagination.
     * 
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    @GetMapping
    @Operation(summary = "Get all algorithms", description = "Retrieve all available algorithms with pagination")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved algorithms"),
        @ApiResponse(responseCode = "400", description = "Invalid pagination parameters"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Cacheable(value = "algorithms", key = "#pageable.toString()")
    public ResponseEntity<Page<AlgorithmResponse>> getAllAlgorithms(
            @Parameter(description = "Pagination and sorting parameters") 
            @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) 
            Pageable pageable) {
        
        log.debug("Request to get all algorithms with pagination: {}", pageable);
        
        try {
            Page<AlgorithmResponse> algorithms = algorithmService.getAllAlgorithms(pageable);
            log.info("Successfully retrieved {} algorithms", algorithms.getTotalElements());
            return ResponseEntity.ok(algorithms);
        } catch (Exception e) {
            log.error("Error retrieving algorithms", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get algorithm by ID.
     * 
     * @param id Algorithm ID
     * @return Algorithm response
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get algorithm by ID", description = "Retrieve a specific algorithm by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved algorithm"),
        @ApiResponse(responseCode = "404", description = "Algorithm not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Cacheable(value = "algorithm", key = "#id")
    public ResponseEntity<AlgorithmResponse> getAlgorithmById(
            @Parameter(description = "Algorithm ID") 
            @PathVariable UUID id) {
        
        log.debug("Request to get algorithm by ID: {}", id);
        
        try {
            AlgorithmResponse algorithm = algorithmService.getAlgorithmById(id);
            log.info("Successfully retrieved algorithm: {}", algorithm.getName());
            return ResponseEntity.ok(algorithm);
        } catch (Exception e) {
            log.error("Error retrieving algorithm with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Get algorithms by category.
     * 
     * @param category Algorithm category
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    @GetMapping("/category/{category}")
    @Operation(summary = "Get algorithms by category", description = "Retrieve algorithms filtered by category")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved algorithms"),
        @ApiResponse(responseCode = "400", description = "Invalid category"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Cacheable(value = "algorithms-by-category", key = "#category + '-' + #pageable.toString()")
    public ResponseEntity<Page<AlgorithmResponse>> getAlgorithmsByCategory(
            @Parameter(description = "Algorithm category") 
            @PathVariable String category,
            @Parameter(description = "Pagination and sorting parameters") 
            @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) 
            Pageable pageable) {
        
        log.debug("Request to get algorithms by category: {} with pagination: {}", category, pageable);
        
        try {
            Page<AlgorithmResponse> algorithms = algorithmService.getAlgorithmsByCategory(category, pageable);
            log.info("Successfully retrieved {} algorithms for category: {}", algorithms.getTotalElements(), category);
            return ResponseEntity.ok(algorithms);
        } catch (Exception e) {
            log.error("Error retrieving algorithms for category: {}", category, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Create a new algorithm.
     * 
     * @param algorithmRequest Algorithm creation request
     * @return Created algorithm response
     */
    @PostMapping
    @Operation(summary = "Create algorithm", description = "Create a new algorithm")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created algorithm"),
        @ApiResponse(responseCode = "400", description = "Invalid algorithm data"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize("hasRole('ADMIN') or hasRole('ALGORITHM_MANAGER')")
    @CacheEvict(value = {"algorithms", "algorithms-by-category"}, allEntries = true)
    public ResponseEntity<AlgorithmResponse> createAlgorithm(
            @Parameter(description = "Algorithm creation request") 
            @Valid @RequestBody AlgorithmRequest algorithmRequest) {
        
        log.debug("Request to create algorithm: {}", algorithmRequest.getName());
        
        try {
            AlgorithmResponse createdAlgorithm = algorithmService.createAlgorithm(algorithmRequest);
            log.info("Successfully created algorithm: {}", createdAlgorithm.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAlgorithm);
        } catch (Exception e) {
            log.error("Error creating algorithm", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Update an existing algorithm.
     * 
     * @param id Algorithm ID
     * @param algorithmRequest Algorithm update request
     * @return Updated algorithm response
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update algorithm", description = "Update an existing algorithm")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated algorithm"),
        @ApiResponse(responseCode = "400", description = "Invalid algorithm data"),
        @ApiResponse(responseCode = "404", description = "Algorithm not found"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize("hasRole('ADMIN') or hasRole('ALGORITHM_MANAGER')")
    @CacheEvict(value = {"algorithm", "algorithms", "algorithms-by-category"}, allEntries = true)
    public ResponseEntity<AlgorithmResponse> updateAlgorithm(
            @Parameter(description = "Algorithm ID") 
            @PathVariable UUID id,
            @Parameter(description = "Algorithm update request") 
            @Valid @RequestBody AlgorithmRequest algorithmRequest) {
        
        log.debug("Request to update algorithm with ID: {}", id);
        
        try {
            AlgorithmResponse updatedAlgorithm = algorithmService.updateAlgorithm(id, algorithmRequest);
            log.info("Successfully updated algorithm: {}", updatedAlgorithm.getName());
            return ResponseEntity.ok(updatedAlgorithm);
        } catch (Exception e) {
            log.error("Error updating algorithm with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Delete an algorithm.
     * 
     * @param id Algorithm ID
     * @return No content
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete algorithm", description = "Delete an algorithm by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted algorithm"),
        @ApiResponse(responseCode = "404", description = "Algorithm not found"),
        @ApiResponse(responseCode = "403", description = "Access denied"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize("hasRole('ADMIN')")
    @CacheEvict(value = {"algorithm", "algorithms", "algorithms-by-category"}, allEntries = true)
    public ResponseEntity<Void> deleteAlgorithm(
            @Parameter(description = "Algorithm ID") 
            @PathVariable UUID id) {
        
        log.debug("Request to delete algorithm with ID: {}", id);
        
        try {
            algorithmService.deleteAlgorithm(id);
            log.info("Successfully deleted algorithm with ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleting algorithm with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Execute an algorithm with given input data.
     * 
     * @param id Algorithm ID
     * @param executionRequest Algorithm execution request
     * @return Algorithm execution response
     */
    @PostMapping("/{id}/execute")
    @Operation(summary = "Execute algorithm", description = "Execute an algorithm with given input data")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully executed algorithm"),
        @ApiResponse(responseCode = "400", description = "Invalid execution request"),
        @ApiResponse(responseCode = "404", description = "Algorithm not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<AlgorithmExecutionResponse> executeAlgorithm(
            @Parameter(description = "Algorithm ID") 
            @PathVariable UUID id,
            @Parameter(description = "Algorithm execution request") 
            @Valid @RequestBody AlgorithmExecutionRequest executionRequest) {
        
        log.debug("Request to execute algorithm with ID: {}", id);
        
        try {
            AlgorithmExecutionResponse response = executionService.executeAlgorithm(id, executionRequest);
            log.info("Successfully executed algorithm: {} with execution ID: {}", id, response.getExecutionId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error executing algorithm with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Get execution status and results.
     * 
     * @param executionId Execution ID
     * @return Algorithm execution response
     */
    @GetMapping("/execution/{executionId}")
    @Operation(summary = "Get execution results", description = "Get execution status and results by execution ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved execution results"),
        @ApiResponse(responseCode = "404", description = "Execution not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<AlgorithmExecutionResponse> getExecutionResults(
            @Parameter(description = "Execution ID") 
            @PathVariable UUID executionId) {
        
        log.debug("Request to get execution results for ID: {}", executionId);
        
        try {
            AlgorithmExecutionResponse response = executionService.getExecutionResults(executionId);
            log.info("Successfully retrieved execution results for ID: {}", executionId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error retrieving execution results for ID: {}", executionId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Analyze algorithm performance and complexity.
     * 
     * @param id Algorithm ID
     * @param analysisRequest Algorithm analysis request
     * @return Algorithm analysis response
     */
    @PostMapping("/{id}/analyze")
    @Operation(summary = "Analyze algorithm", description = "Analyze algorithm performance and complexity")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully analyzed algorithm"),
        @ApiResponse(responseCode = "400", description = "Invalid analysis request"),
        @ApiResponse(responseCode = "404", description = "Algorithm not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<AlgorithmAnalysisResponse> analyzeAlgorithm(
            @Parameter(description = "Algorithm ID") 
            @PathVariable UUID id,
            @Parameter(description = "Algorithm analysis request") 
            @Valid @RequestBody AlgorithmAnalysisRequest analysisRequest) {
        
        log.debug("Request to analyze algorithm with ID: {}", id);
        
        try {
            AlgorithmAnalysisResponse response = analysisService.analyzeAlgorithm(id, analysisRequest);
            log.info("Successfully analyzed algorithm: {} with analysis ID: {}", id, response.getAnalysisId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error analyzing algorithm with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Get algorithm analysis results.
     * 
     * @param analysisId Analysis ID
     * @return Algorithm analysis response
     */
    @GetMapping("/analysis/{analysisId}")
    @Operation(summary = "Get analysis results", description = "Get algorithm analysis results by analysis ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved analysis results"),
        @ApiResponse(responseCode = "404", description = "Analysis not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<AlgorithmAnalysisResponse> getAnalysisResults(
            @Parameter(description = "Analysis ID") 
            @PathVariable UUID analysisId) {
        
        log.debug("Request to get analysis results for ID: {}", analysisId);
        
        try {
            AlgorithmAnalysisResponse response = analysisService.getAnalysisResults(analysisId);
            log.info("Successfully retrieved analysis results for ID: {}", analysisId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error retrieving analysis results for ID: {}", analysisId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Search algorithms by name or description.
     * 
     * @param query Search query
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    @GetMapping("/search")
    @Operation(summary = "Search algorithms", description = "Search algorithms by name or description")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully searched algorithms"),
        @ApiResponse(responseCode = "400", description = "Invalid search query"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Page<AlgorithmResponse>> searchAlgorithms(
            @Parameter(description = "Search query") 
            @RequestParam String query,
            @Parameter(description = "Pagination and sorting parameters") 
            @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) 
            Pageable pageable) {
        
        log.debug("Request to search algorithms with query: {}", query);
        
        try {
            Page<AlgorithmResponse> algorithms = algorithmService.searchAlgorithms(query, pageable);
            log.info("Successfully searched algorithms with query: {}, found {} results", query, algorithms.getTotalElements());
            return ResponseEntity.ok(algorithms);
        } catch (Exception e) {
            log.error("Error searching algorithms with query: {}", query, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Get algorithm categories.
     * 
     * @return List of algorithm categories
     */
    @GetMapping("/categories")
    @Operation(summary = "Get algorithm categories", description = "Retrieve all available algorithm categories")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved categories"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Cacheable(value = "algorithm-categories")
    public ResponseEntity<List<String>> getAlgorithmCategories() {
        
        log.debug("Request to get algorithm categories");
        
        try {
            List<String> categories = algorithmService.getAlgorithmCategories();
            log.info("Successfully retrieved {} algorithm categories", categories.size());
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            log.error("Error retrieving algorithm categories", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get popular algorithms.
     * 
     * @param limit Maximum number of algorithms to return
     * @return List of popular algorithms
     */
    @GetMapping("/popular")
    @Operation(summary = "Get popular algorithms", description = "Retrieve most popular algorithms")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved popular algorithms"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Cacheable(value = "popular-algorithms")
    public ResponseEntity<List<AlgorithmResponse>> getPopularAlgorithms(
            @Parameter(description = "Maximum number of algorithms") 
            @RequestParam(defaultValue = "10") int limit) {
        
        log.debug("Request to get {} popular algorithms", limit);
        
        try {
            List<AlgorithmResponse> algorithms = algorithmService.getPopularAlgorithms(limit);
            log.info("Successfully retrieved {} popular algorithms", algorithms.size());
            return ResponseEntity.ok(algorithms);
        } catch (Exception e) {
            log.error("Error retrieving popular algorithms", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get algorithm statistics.
     * 
     * @return Algorithm statistics
     */
    @GetMapping("/statistics")
    @Operation(summary = "Get algorithm statistics", description = "Retrieve algorithm usage and performance statistics")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PreAuthorize("hasRole('ADMIN') or hasRole('ANALYST')")
    public ResponseEntity<Object> getAlgorithmStatistics() {
        
        log.debug("Request to get algorithm statistics");
        
        try {
            Object statistics = algorithmService.getAlgorithmStatistics();
            log.info("Successfully retrieved algorithm statistics");
            return ResponseEntity.ok(statistics);
        } catch (Exception e) {
            log.error("Error retrieving algorithm statistics", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

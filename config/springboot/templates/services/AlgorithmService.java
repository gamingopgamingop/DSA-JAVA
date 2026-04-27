package com.dsa.services;

import com.dsa.dto.AlgorithmRequest;
import com.dsa.dto.AlgorithmResponse;
import com.dsa.entities.Algorithm;
import com.dsa.repositories.AlgorithmRepository;
import com.dsa.exceptions.AlgorithmNotFoundException;
import com.dsa.exceptions.DuplicateAlgorithmException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

/**
 * Service class for managing algorithms in the DSA Java Application.
 * 
 * This service provides business logic for algorithm CRUD operations,
 * caching, validation, and data transformation. It integrates with
 * the repository layer and provides a clean API for controllers.
 * 
 * @Complexity Time: O(n) - Where n is the number of algorithms being processed
 * @Complexity Space: O(n) - For storing algorithm data
 * @Performance Optimized with caching and pagination
 * @Stability Stable - Production ready
 * @Algorithm Service layer pattern with caching
 * @Implementation Spring Boot service with JPA
 * @Optimization Caching and efficient data access
 * @Reference Spring Boot Service Documentation
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    /**
     * Get all algorithms with pagination.
     * 
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    @Cacheable(value = "algorithms", key = "#pageable.toString()")
    public Page<AlgorithmResponse> getAllAlgorithms(Pageable pageable) {
        log.debug("Fetching all algorithms with pagination: {}", pageable);
        
        Page<Algorithm> algorithms = algorithmRepository.findAll(pageable);
        
        log.info("Successfully retrieved {} algorithms", algorithms.getTotalElements());
        return algorithms.map(this::convertToResponse);
    }

    /**
     * Get algorithm by ID.
     * 
     * @param id Algorithm ID
     * @return Algorithm response
     * @throws AlgorithmNotFoundException if algorithm not found
     */
    @Cacheable(value = "algorithm", key = "#id")
    public AlgorithmResponse getAlgorithmById(UUID id) {
        log.debug("Fetching algorithm by ID: {}", id);
        
        Algorithm algorithm = algorithmRepository.findById(id)
                .orElseThrow(() -> new AlgorithmNotFoundException("Algorithm not found with ID: " + id));
        
        log.info("Successfully retrieved algorithm: {}", algorithm.getName());
        return convertToResponse(algorithm);
    }

    /**
     * Get algorithms by category with pagination.
     * 
     * @param category Algorithm category
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    @Cacheable(value = "algorithms-by-category", key = "#category + '-' + #pageable.toString()")
    public Page<AlgorithmResponse> getAlgorithmsByCategory(String category, Pageable pageable) {
        log.debug("Fetching algorithms by category: {} with pagination: {}", category, pageable);
        
        Page<Algorithm> algorithms = algorithmRepository.findByCategoryIgnoreCase(category, pageable);
        
        log.info("Successfully retrieved {} algorithms for category: {}", algorithms.getTotalElements(), category);
        return algorithms.map(this::convertToResponse);
    }

    /**
     * Create a new algorithm.
     * 
     * @param algorithmRequest Algorithm creation request
     * @return Created algorithm response
     * @throws DuplicateAlgorithmException if algorithm already exists
     */
    @CacheEvict(value = {"algorithms", "algorithms-by-category"}, allEntries = true)
    @Transactional
    public AlgorithmResponse createAlgorithm(AlgorithmRequest algorithmRequest) {
        log.debug("Creating new algorithm: {}", algorithmRequest.getName());
        
        // Check if algorithm already exists
        if (algorithmRepository.existsByNameIgnoreCase(algorithmRequest.getName())) {
            throw new DuplicateAlgorithmException("Algorithm already exists with name: " + algorithmRequest.getName());
        }
        
        Algorithm algorithm = convertToEntity(algorithmRequest);
        algorithm.setCreatedAt(java.time.LocalDateTime.now());
        algorithm.setUpdatedAt(java.time.LocalDateTime.now());
        
        Algorithm savedAlgorithm = algorithmRepository.save(algorithm);
        
        log.info("Successfully created algorithm: {}", savedAlgorithm.getName());
        return convertToResponse(savedAlgorithm);
    }

    /**
     * Update an existing algorithm.
     * 
     * @param id Algorithm ID
     * @param algorithmRequest Algorithm update request
     * @return Updated algorithm response
     * @throws AlgorithmNotFoundException if algorithm not found
     */
    @CacheEvict(value = {"algorithm", "algorithms", "algorithms-by-category"}, allEntries = true)
    @Transactional
    public AlgorithmResponse updateAlgorithm(UUID id, AlgorithmRequest algorithmRequest) {
        log.debug("Updating algorithm with ID: {}", id);
        
        Algorithm existingAlgorithm = algorithmRepository.findById(id)
                .orElseThrow(() -> new AlgorithmNotFoundException("Algorithm not found with ID: " + id));
        
        // Check if name is being changed and if it conflicts with existing algorithm
        if (!existingAlgorithm.getName().equalsIgnoreCase(algorithmRequest.getName()) &&
            algorithmRepository.existsByNameIgnoreCase(algorithmRequest.getName())) {
            throw new DuplicateAlgorithmException("Algorithm already exists with name: " + algorithmRequest.getName());
        }
        
        updateAlgorithmFromRequest(existingAlgorithm, algorithmRequest);
        existingAlgorithm.setUpdatedAt(java.time.LocalDateTime.now());
        
        Algorithm updatedAlgorithm = algorithmRepository.save(existingAlgorithm);
        
        log.info("Successfully updated algorithm: {}", updatedAlgorithm.getName());
        return convertToResponse(updatedAlgorithm);
    }

    /**
     * Delete an algorithm.
     * 
     * @param id Algorithm ID
     * @throws AlgorithmNotFoundException if algorithm not found
     */
    @CacheEvict(value = {"algorithm", "algorithms", "algorithms-by-category"}, allEntries = true)
    @Transactional
    public void deleteAlgorithm(UUID id) {
        log.debug("Deleting algorithm with ID: {}", id);
        
        Algorithm algorithm = algorithmRepository.findById(id)
                .orElseThrow(() -> new AlgorithmNotFoundException("Algorithm not found with ID: " + id));
        
        algorithmRepository.delete(algorithm);
        
        log.info("Successfully deleted algorithm: {}", algorithm.getName());
    }

    /**
     * Search algorithms by name or description.
     * 
     * @param query Search query
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    public Page<AlgorithmResponse> searchAlgorithms(String query, Pageable pageable) {
        log.debug("Searching algorithms with query: {}", query);
        
        Page<Algorithm> algorithms = algorithmRepository.searchAlgorithms(query, pageable);
        
        log.info("Successfully searched algorithms with query: {}, found {} results", query, algorithms.getTotalElements());
        return algorithms.map(this::convertToResponse);
    }

    /**
     * Get all algorithm categories.
     * 
     * @return List of algorithm categories
     */
    @Cacheable(value = "algorithm-categories")
    public List<String> getAlgorithmCategories() {
        log.debug("Fetching algorithm categories");
        
        List<String> categories = algorithmRepository.findAllCategories();
        
        log.info("Successfully retrieved {} algorithm categories", categories.size());
        return categories;
    }

    /**
     * Get popular algorithms based on usage or ratings.
     * 
     * @param limit Maximum number of algorithms to return
     * @return List of popular algorithms
     */
    @Cacheable(value = "popular-algorithms")
    public List<AlgorithmResponse> getPopularAlgorithms(int limit) {
        log.debug("Fetching {} popular algorithms", limit);
        
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "popularityScore"));
        Page<Algorithm> algorithms = algorithmRepository.findByOrderByPopularityScoreDesc(pageable);
        
        List<AlgorithmResponse> popularAlgorithms = algorithms.getContent().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        
        log.info("Successfully retrieved {} popular algorithms", popularAlgorithms.size());
        return popularAlgorithms;
    }

    /**
     * Get algorithm statistics.
     * 
     * @return Algorithm statistics
     */
    public Map<String, Object> getAlgorithmStatistics() {
        log.debug("Fetching algorithm statistics");
        
        Map<String, Object> statistics = new HashMap<>();
        
        // Total algorithms
        long totalAlgorithms = algorithmRepository.count();
        statistics.put("totalAlgorithms", totalAlgorithms);
        
        // Algorithms by category
        Map<String, Long> algorithmsByCategory = new HashMap<>();
        List<String> categories = getAlgorithmCategories();
        for (String category : categories) {
            long count = algorithmRepository.countByCategoryIgnoreCase(category);
            algorithmsByCategory.put(category, count);
        }
        statistics.put("algorithmsByCategory", algorithmsByCategory);
        
        // Average complexity scores
        double avgTimeComplexity = algorithmRepository.findAverageTimeComplexityScore();
        double avgSpaceComplexity = algorithmRepository.findAverageSpaceComplexityScore();
        statistics.put("averageTimeComplexityScore", avgTimeComplexity);
        statistics.put("averageSpaceComplexityScore", avgSpaceComplexity);
        
        // Most popular algorithm
        Algorithm mostPopular = algorithmRepository.findTopByOrderByPopularityScoreDesc();
        if (mostPopular != null) {
            statistics.put("mostPopularAlgorithm", convertToResponse(mostPopular));
        }
        
        // Recently added algorithms
        Pageable recentPageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "createdAt"));
        List<AlgorithmResponse> recentAlgorithms = algorithmRepository.findAll(recentPageable)
                .getContent().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        statistics.put("recentlyAddedAlgorithms", recentAlgorithms);
        
        log.info("Successfully retrieved algorithm statistics");
        return statistics;
    }

    /**
     * Check if algorithm exists by name.
     * 
     * @param name Algorithm name
     * @return true if algorithm exists, false otherwise
     */
    public boolean existsByName(String name) {
        log.debug("Checking if algorithm exists by name: {}", name);
        return algorithmRepository.existsByNameIgnoreCase(name);
    }

    /**
     * Get algorithm by name.
     * 
     * @param name Algorithm name
     * @return Algorithm response
     * @throws AlgorithmNotFoundException if algorithm not found
     */
    public AlgorithmResponse getAlgorithmByName(String name) {
        log.debug("Fetching algorithm by name: {}", name);
        
        Algorithm algorithm = algorithmRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new AlgorithmNotFoundException("Algorithm not found with name: " + name));
        
        log.info("Successfully retrieved algorithm: {}", algorithm.getName());
        return convertToResponse(algorithm);
    }

    /**
     * Get algorithms by complexity level.
     * 
     * @param timeComplexity Time complexity level
     * @param spaceComplexity Space complexity level
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    public Page<AlgorithmResponse> getAlgorithmsByComplexity(String timeComplexity, String spaceComplexity, Pageable pageable) {
        log.debug("Fetching algorithms by time complexity: {} and space complexity: {}", timeComplexity, spaceComplexity);
        
        Page<Algorithm> algorithms = algorithmRepository.findByTimeComplexityAndSpaceComplexity(timeComplexity, spaceComplexity, pageable);
        
        log.info("Successfully retrieved {} algorithms for complexity levels", algorithms.getTotalElements());
        return algorithms.map(this::convertToResponse);
    }

    /**
     * Get algorithms by popularity score range.
     * 
     * @param minScore Minimum popularity score
     * @param maxScore Maximum popularity score
     * @param pageable Pagination and sorting parameters
     * @return Page of algorithm responses
     */
    public Page<AlgorithmResponse> getAlgorithmsByPopularityRange(double minScore, double maxScore, Pageable pageable) {
        log.debug("Fetching algorithms by popularity range: {} - {}", minScore, maxScore);
        
        Page<Algorithm> algorithms = algorithmRepository.findByPopularityScoreBetween(minScore, maxScore, pageable);
        
        log.info("Successfully retrieved {} algorithms for popularity range", algorithms.getTotalElements());
        return algorithms.map(this::convertToResponse);
    }

    /**
     * Convert Algorithm entity to AlgorithmResponse DTO.
     * 
     * @param algorithm Algorithm entity
     * @return Algorithm response DTO
     */
    private AlgorithmResponse convertToResponse(Algorithm algorithm) {
        return AlgorithmResponse.builder()
                .id(algorithm.getId())
                .name(algorithm.getName())
                .description(algorithm.getDescription())
                .category(algorithm.getCategory())
                .timeComplexity(algorithm.getTimeComplexity())
                .spaceComplexity(algorithm.getSpaceComplexity())
                .timeComplexityScore(algorithm.getTimeComplexityScore())
                .spaceComplexityScore(algorithm.getSpaceComplexityScore())
                .popularityScore(algorithm.getPopularityScore())
                .implementation(algorithm.getImplementation())
                .author(algorithm.getAuthor())
                .version(algorithm.getVersion())
                .createdAt(algorithm.getCreatedAt())
                .updatedAt(algorithm.getUpdatedAt())
                .tags(algorithm.getTags())
                .examples(algorithm.getExamples())
                .references(algorithm.getReferences())
                .build();
    }

    /**
     * Convert AlgorithmRequest DTO to Algorithm entity.
     * 
     * @param request Algorithm request DTO
     * @return Algorithm entity
     */
    private Algorithm convertToEntity(AlgorithmRequest request) {
        return Algorithm.builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .timeComplexity(request.getTimeComplexity())
                .spaceComplexity(request.getSpaceComplexity())
                .timeComplexityScore(calculateComplexityScore(request.getTimeComplexity()))
                .spaceComplexityScore(calculateComplexityScore(request.getSpaceComplexity()))
                .popularityScore(0.0) // Default value, will be updated based on usage
                .implementation(request.getImplementation())
                .author(request.getAuthor())
                .version(request.getVersion())
                .tags(request.getTags())
                .examples(request.getExamples())
                .references(request.getReferences())
                .build();
    }

    /**
     * Update existing algorithm from request.
     * 
     * @param algorithm Existing algorithm entity
     * @param request Algorithm request DTO
     */
    private void updateAlgorithmFromRequest(Algorithm algorithm, AlgorithmRequest request) {
        algorithm.setName(request.getName());
        algorithm.setDescription(request.getDescription());
        algorithm.setCategory(request.getCategory());
        algorithm.setTimeComplexity(request.getTimeComplexity());
        algorithm.setSpaceComplexity(request.getSpaceComplexity());
        algorithm.setTimeComplexityScore(calculateComplexityScore(request.getTimeComplexity()));
        algorithm.setSpaceComplexityScore(calculateComplexityScore(request.getSpaceComplexity()));
        algorithm.setImplementation(request.getImplementation());
        algorithm.setAuthor(request.getAuthor());
        algorithm.setVersion(request.getVersion());
        algorithm.setTags(request.getTags());
        algorithm.setExamples(request.getExamples());
        algorithm.setReferences(request.getReferences());
    }

    /**
     * Calculate complexity score based on complexity notation.
     * 
     * @param complexity Complexity notation (e.g., "O(1)", "O(n)", "O(n log n)")
     * @return Complexity score (lower is better)
     */
    private double calculateComplexityScore(String complexity) {
        if (complexity == null || complexity.trim().isEmpty()) {
            return 10.0; // Default score for unknown complexity
        }
        
        String normalizedComplexity = complexity.toUpperCase().trim();
        
        // Map common complexities to scores (lower is better)
        Map<String, Double> complexityScores = Map.of(
            "O(1)", 1.0,
            "O(LOG N)", 2.0,
            "O(LOGN)", 2.0,
            "O(N)", 3.0,
            "O(N LOG N)", 4.0,
            "O(NLOGN)", 4.0,
            "O(N^2)", 6.0,
            "O(N^2)", 6.0,
            "O(N^3)", 8.0,
            "O(N^3)", 8.0,
            "O(2^N)", 9.0,
            "O(2N)", 9.0,
            "O(N!)", 10.0,
            "O(N!)", 10.0
        );
        
        return complexityScores.getOrDefault(normalizedComplexity, 10.0);
    }
}

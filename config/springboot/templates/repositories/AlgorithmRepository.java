package com.dsa.repositories;

import com.dsa.entities.Algorithm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for Algorithm entities.
 * 
 * This repository provides database access methods for algorithms,
 * including custom queries for searching, filtering, and analytics.
 * It extends JpaRepository to provide standard CRUD operations.
 * 
 * @Complexity Time: O(n) - Where n is the number of records affected
 * @Complexity Space: O(1) - Repository interface overhead
 * @Performance Optimized with proper indexing and query optimization
 * @Stability Stable - Production ready
 * @Algorithm Spring Data JPA repository pattern
 * @Implementation Spring Data JPA with Hibernate
 * @Optimization Custom queries with proper indexing
 * @Reference Spring Data JPA Documentation
 */
@Repository
public interface AlgorithmRepository extends JpaRepository<Algorithm, UUID> {

    /**
     * Find algorithm by name (case-insensitive).
     * 
     * @param name Algorithm name
     * @return Optional containing the algorithm if found
     */
    Optional<Algorithm> findByNameIgnoreCase(String name);

    /**
     * Check if algorithm exists by name (case-insensitive).
     * 
     * @param name Algorithm name
     * @return true if algorithm exists, false otherwise
     */
    boolean existsByNameIgnoreCase(String name);

    /**
     * Find algorithms by category (case-insensitive).
     * 
     * @param category Algorithm category
     * @param pageable Pagination parameters
     * @return Page of algorithms in the specified category
     */
    Page<Algorithm> findByCategoryIgnoreCase(String category, Pageable pageable);

    /**
     * Count algorithms by category (case-insensitive).
     * 
     * @param category Algorithm category
     * @return Number of algorithms in the category
     */
    long countByCategoryIgnoreCase(String category);

    /**
     * Find all distinct categories.
     * 
     * @return List of distinct algorithm categories
     */
    @Query("SELECT DISTINCT a.category FROM Algorithm a ORDER BY a.category")
    List<String> findAllCategories();

    /**
     * Search algorithms by name or description (case-insensitive).
     * 
     * @param query Search query
     * @param pageable Pagination parameters
     * @return Page of algorithms matching the search query
     */
    @Query("SELECT a FROM Algorithm a WHERE " +
           "LOWER(a.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(a.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Algorithm> searchAlgorithms(@Param("query") String query, Pageable pageable);

    /**
     * Find algorithms by time complexity and space complexity.
     * 
     * @param timeComplexity Time complexity notation
     * @param spaceComplexity Space complexity notation
     * @param pageable Pagination parameters
     * @return Page of algorithms with specified complexities
     */
    Page<Algorithm> findByTimeComplexityAndSpaceComplexity(String timeComplexity, String spaceComplexity, Pageable pageable);

    /**
     * Find algorithms by popularity score range.
     * 
     * @param minScore Minimum popularity score
     * @param maxScore Maximum popularity score
     * @param pageable Pagination parameters
     * @return Page of algorithms within popularity score range
     */
    Page<Algorithm> findByPopularityScoreBetween(Double minScore, Double maxScore, Pageable pageable);

    /**
     * Find algorithms by time complexity score range.
     * 
     * @param minScore Minimum time complexity score
     * @param maxScore Maximum time complexity score
     * @param pageable Pagination parameters
     * @return Page of algorithms within time complexity score range
     */
    Page<Algorithm> findByTimeComplexityScoreBetween(Double minScore, Double maxScore, Pageable pageable);

    /**
     * Find algorithms by space complexity score range.
     * 
     * @param minScore Minimum space complexity score
     * @param maxScore Maximum space complexity score
     * @param pageable Pagination parameters
     * @return Page of algorithms within space complexity score range
     */
    Page<Algorithm> findBySpaceComplexityScoreBetween(Double minScore, Double maxScore, Pageable pageable);

    /**
     * Find algorithms by author.
     * 
     * @param author Author name
     * @param pageable Pagination parameters
     * @return Page of algorithms by the specified author
     */
    Page<Algorithm> findByAuthorIgnoreCase(String author, Pageable pageable);

    /**
     * Find algorithms by tags containing the specified tag.
     * 
     * @param tag Tag to search for
     * @param pageable Pagination parameters
     * @return Page of algorithms containing the specified tag
     */
    @Query("SELECT a FROM Algorithm a WHERE :tag MEMBER OF a.tags")
    Page<Algorithm> findByTag(@Param("tag") String tag, Pageable pageable);

    /**
     * Find algorithms created within a date range.
     * 
     * @param startDate Start date
     * @param endDate End date
     * @param pageable Pagination parameters
     * @return Page of algorithms created within the date range
     */
    @Query("SELECT a FROM Algorithm a WHERE a.createdAt BETWEEN :startDate AND :endDate")
    Page<Algorithm> findByCreatedAtBetween(@Param("startDate") java.time.LocalDateTime startDate, 
                                           @Param("endDate") java.time.LocalDateTime endDate, 
                                           Pageable pageable);

    /**
     * Find algorithms updated within a date range.
     * 
     * @param startDate Start date
     * @param endDate End date
     * @param pageable Pagination parameters
     * @return Page of algorithms updated within the date range
     */
    @Query("SELECT a FROM Algorithm a WHERE a.updatedAt BETWEEN :startDate AND :endDate")
    Page<Algorithm> findByUpdatedAtBetween(@Param("startDate") java.time.LocalDateTime startDate, 
                                           @Param("endDate") java.time.LocalDateTime endDate, 
                                           Pageable pageable);

    /**
     * Find algorithms with popularity score greater than or equal to specified value.
     * 
     * @param minScore Minimum popularity score
     * @param pageable Pagination parameters
     * @return Page of algorithms with popularity score >= minScore
     */
    Page<Algorithm> findByPopularityScoreGreaterThanEqual(Double minScore, Pageable pageable);

    /**
     * Find algorithms with time complexity score less than or equal to specified value.
     * 
     * @param maxScore Maximum time complexity score
     * @param pageable Pagination parameters
     * @return Page of algorithms with time complexity score <= maxScore
     */
    Page<Algorithm> findByTimeComplexityScoreLessThanEqual(Double maxScore, Pageable pageable);

    /**
     * Find algorithms with space complexity score less than or equal to specified value.
     * 
     * @param maxScore Maximum space complexity score
     * @param pageable Pagination parameters
     * @return Page of algorithms with space complexity score <= maxScore
     */
    Page<Algorithm> findBySpaceComplexityScoreLessThanEqual(Double maxScore, Pageable pageable);

    /**
     * Find top algorithm by popularity score.
     * 
     * @return The algorithm with highest popularity score
     */
    Algorithm findTopByOrderByPopularityScoreDesc();

    /**
     * Find top N algorithms by popularity score.
     * 
     * @param pageable Pageable with limit
     * @return Page of top algorithms by popularity
     */
    Page<Algorithm> findTopByOrderByPopularityScoreDesc(Pageable pageable);

    /**
     * Find algorithms with no examples.
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms without examples
     */
    @Query("SELECT a FROM Algorithm a WHERE a.examples IS EMPTY OR a.examples IS NULL")
    Page<Algorithm> findAlgorithmsWithoutExamples(Pageable pageable);

    /**
     * Find algorithms with no references.
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms without references
     */
    @Query("SELECT a FROM Algorithm a WHERE a.references IS EMPTY OR a.references IS NULL")
    Page<Algorithm> findAlgorithmsWithoutReferences(Pageable pageable);

    /**
     * Calculate average time complexity score across all algorithms.
     * 
     * @return Average time complexity score
     */
    @Query("SELECT AVG(a.timeComplexityScore) FROM Algorithm a")
    Double findAverageTimeComplexityScore();

    /**
     * Calculate average space complexity score across all algorithms.
     * 
     * @return Average space complexity score
     */
    @Query("SELECT AVG(a.spaceComplexityScore) FROM Algorithm a")
    Double findAverageSpaceComplexityScore();

    /**
     * Calculate average popularity score across all algorithms.
     * 
     * @return Average popularity score
     */
    @Query("SELECT AVG(a.popularityScore) FROM Algorithm a")
    Double findAveragePopularityScore();

    /**
     * Count algorithms by time complexity.
     * 
     * @param timeComplexity Time complexity notation
     * @return Number of algorithms with the specified time complexity
     */
    long countByTimeComplexity(String timeComplexity);

    /**
     * Count algorithms by space complexity.
     * 
     * @param spaceComplexity Space complexity notation
     * @return Number of algorithms with the specified space complexity
     */
    long countBySpaceComplexity(String spaceComplexity);

    /**
     * Count algorithms by author.
     * 
     * @param author Author name
     * @return Number of algorithms by the specified author
     */
    long countByAuthorIgnoreCase(String author);

    /**
     * Find algorithms by multiple categories.
     * 
     * @param categories List of categories
     * @param pageable Pagination parameters
     * @return Page of algorithms in any of the specified categories
     */
    @Query("SELECT a FROM Algorithm a WHERE a.category IN :categories")
    Page<Algorithm> findByCategoryIn(@Param("categories") List<String> categories, Pageable pageable);

    /**
     * Find algorithms by name pattern (case-insensitive).
     * 
     * @param namePattern Name pattern
     * @param pageable Pagination parameters
     * @return Page of algorithms matching the name pattern
     */
    @Query("SELECT a FROM Algorithm a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :namePattern, '%'))")
    Page<Algorithm> findByNameContainingIgnoreCase(@Param("namePattern") String namePattern, Pageable pageable);

    /**
     * Find algorithms with implementation containing specific text.
     * 
     * @param implementationText Text to search for in implementation
     * @param pageable Pagination parameters
     * @return Page of algorithms with implementation containing the text
     */
    @Query("SELECT a FROM Algorithm a WHERE LOWER(a.implementation) LIKE LOWER(CONCAT('%', :implementationText, '%'))")
    Page<Algorithm> findByImplementationContainingIgnoreCase(@Param("implementationText") String implementationText, Pageable pageable);

    /**
     * Update popularity score for an algorithm.
     * 
     * @param id Algorithm ID
     * @param popularityScore New popularity score
     */
    @Modifying
    @Query("UPDATE Algorithm a SET a.popularityScore = :popularityScore, a.updatedAt = CURRENT_TIMESTAMP WHERE a.id = :id")
    void updatePopularityScore(@Param("id") UUID id, @Param("popularityScore") Double popularityScore);

    /**
     * Increment popularity score for an algorithm.
     * 
     * @param id Algorithm ID
     * @param increment Amount to increment by
     */
    @Modifying
    @Query("UPDATE Algorithm a SET a.popularityScore = a.popularityScore + :increment, a.updatedAt = CURRENT_TIMESTAMP WHERE a.id = :id")
    void incrementPopularityScore(@Param("id") UUID id, @Param("increment") Double increment);

    /**
     * Decrement popularity score for an algorithm.
     * 
     * @param id Algorithm ID
     * @param decrement Amount to decrement by
     */
    @Modifying
    @Query("UPDATE Algorithm a SET a.popularityScore = GREATEST(a.popularityScore - :decrement, 0), a.updatedAt = CURRENT_TIMESTAMP WHERE a.id = :id")
    void decrementPopularityScore(@Param("id") UUID id, @Param("decrement") Double decrement);

    /**
     * Find algorithms that need examples (examples empty or null).
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms needing examples
     */
    @Query("SELECT a FROM Algorithm a WHERE a.examples IS NULL OR SIZE(a.examples) = 0")
    Page<Algorithm> findAlgorithmsNeedingExamples(Pageable pageable);

    /**
     * Find algorithms that need references (references empty or null).
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms needing references
     */
    @Query("SELECT a FROM Algorithm a WHERE a.references IS NULL OR SIZE(a.references) = 0")
    Page<Algorithm> findAlgorithmsNeedingReferences(Pageable pageable);

    /**
     * Find algorithms with specific time complexity and minimum popularity score.
     * 
     * @param timeComplexity Time complexity notation
     * @param minPopularityScore Minimum popularity score
     * @param pageable Pagination parameters
     * @return Page of algorithms matching criteria
     */
    @Query("SELECT a FROM Algorithm a WHERE a.timeComplexity = :timeComplexity AND a.popularityScore >= :minPopularityScore")
    Page<Algorithm> findByTimeComplexityAndPopularityScoreGreaterThanEqual(@Param("timeComplexity") String timeComplexity, 
                                                                              @Param("minPopularityScore") Double minPopularityScore, 
                                                                              Pageable pageable);

    /**
     * Find algorithms with specific space complexity and minimum popularity score.
     * 
     * @param spaceComplexity Space complexity notation
     * @param minPopularityScore Minimum popularity score
     * @param pageable Pagination parameters
     * @return Page of algorithms matching criteria
     */
    @Query("SELECT a FROM Algorithm a WHERE a.spaceComplexity = :spaceComplexity AND a.popularityScore >= :minPopularityScore")
    Page<Algorithm> findBySpaceComplexityAndPopularityScoreGreaterThanEqual(@Param("spaceComplexity") String spaceComplexity, 
                                                                                @Param("minPopularityScore") Double minPopularityScore, 
                                                                                Pageable pageable);

    /**
     * Find algorithms created by a specific author within a date range.
     * 
     * @param author Author name
     * @param startDate Start date
     * @param endDate End date
     * @param pageable Pagination parameters
     * @return Page of algorithms by author within date range
     */
    @Query("SELECT a FROM Algorithm a WHERE a.author ILIKE :author AND a.createdAt BETWEEN :startDate AND :endDate")
    Page<Algorithm> findByAuthorAndCreatedAtBetween(@Param("author") String author, 
                                                      @Param("startDate") java.time.LocalDateTime startDate, 
                                                      @Param("endDate") java.time.LocalDateTime endDate, 
                                                      Pageable pageable);

    /**
     * Find recently created algorithms (within last N days).
     * 
     * @param days Number of days to look back
     * @param pageable Pagination parameters
     * @return Page of recently created algorithms
     */
    @Query("SELECT a FROM Algorithm a WHERE a.createdAt >= :cutoffDate")
    Page<Algorithm> findRecentlyCreated(@Param("cutoffDate") java.time.LocalDateTime cutoffDate, Pageable pageable);

    /**
     * Find recently updated algorithms (within last N days).
     * 
     * @param days Number of days to look back
     * @param pageable Pagination parameters
     * @return Page of recently updated algorithms
     */
    @Query("SELECT a FROM Algorithm a WHERE a.updatedAt >= :cutoffDate")
    Page<Algorithm> findRecentlyUpdated(@Param("cutoffDate") java.time.LocalDateTime cutoffDate, Pageable pageable);

    /**
     * Find algorithms with complexity analysis completed (scores calculated).
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms with complexity analysis
     */
    @Query("SELECT a FROM Algorithm a WHERE a.timeComplexityScore IS NOT NULL AND a.spaceComplexityScore IS NOT NULL")
    Page<Algorithm> findAlgorithmsWithComplexityAnalysis(Pageable pageable);

    /**
     * Find algorithms without complexity analysis (scores null).
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms without complexity analysis
     */
    @Query("SELECT a FROM Algorithm a WHERE a.timeComplexityScore IS NULL OR a.spaceComplexityScore IS NULL")
    Page<Algorithm> findAlgorithmsWithoutComplexityAnalysis(Pageable pageable);

    /**
     * Count algorithms without complexity analysis.
     * 
     * @return Number of algorithms without complexity analysis
     */
    @Query("SELECT COUNT(a) FROM Algorithm a WHERE a.timeComplexityScore IS NULL OR a.spaceComplexityScore IS NULL")
    long countAlgorithmsWithoutComplexityAnalysis();

    /**
     * Count algorithms without examples.
     * 
     * @return Number of algorithms without examples
     */
    @Query("SELECT COUNT(a) FROM Algorithm a WHERE a.examples IS NULL OR SIZE(a.examples) = 0")
    long countAlgorithmsWithoutExamples();

    /**
     * Count algorithms without references.
     * 
     * @return Number of algorithms without references
     */
    @Query("SELECT COUNT(a) FROM Algorithm a WHERE a.references IS NULL OR SIZE(a.references) = 0")
    long countAlgorithmsWithoutReferences();

    /**
     * Find algorithms with complete documentation (has examples and references).
     * 
     * @param pageable Pagination parameters
     * @return Page of algorithms with complete documentation
     */
    @Query("SELECT a FROM Algorithm a WHERE a.examples IS NOT NULL AND SIZE(a.examples) > 0 AND a.references IS NOT NULL AND SIZE(a.references) > 0")
    Page<Algorithm> findAlgorithmsWithCompleteDocumentation(Pageable pageable);

    /**
     * Count algorithms with complete documentation.
     * 
     * @return Number of algorithms with complete documentation
     */
    @Query("SELECT COUNT(a) FROM Algorithm a WHERE a.examples IS NOT NULL AND SIZE(a.examples) > 0 AND a.references IS NOT NULL AND SIZE(a.references) > 0")
    long countAlgorithmsWithCompleteDocumentation();

    /**
     * Find algorithms by multiple tags (must contain all specified tags).
     * 
     * @param tags List of tags
     * @param pageable Pagination parameters
     * @return Page of algorithms containing all specified tags
     */
    @Query("SELECT a FROM Algorithm a WHERE (:tags) <= a.tags")
    Page<Algorithm> findByTagsContainingAll(@Param("tags") List<String> tags, Pageable pageable);

    /**
     * Find algorithms by multiple tags (contain any of the specified tags).
     * 
     * @param tags List of tags
     * @param pageable Pagination parameters
     * @return Page of algorithms containing any of the specified tags
     */
    @Query("SELECT a FROM Algorithm a WHERE a.tags && :tags")
    Page<Algorithm> findByTagsContainingAny(@Param("tags") List<String> tags, Pageable pageable);

    /**
     * Find algorithms with implementation complexity analysis.
     * 
     * @param minLines Minimum number of lines in implementation
     * @param maxLines Maximum number of lines in implementation
     * @param pageable Pagination parameters
     * @return Page of algorithms within implementation line range
     */
    @Query("SELECT a FROM Algorithm a WHERE LENGTH(a.implementation) BETWEEN :minLines AND :maxLines")
    Page<Algorithm> findByImplementationLengthBetween(@Param("minLines") Integer minLines, 
                                                      @Param("maxLines") Integer maxLines, 
                                                      Pageable pageable);

    /**
     * Find algorithms with short implementations (for educational purposes).
     * 
     * @param maxLines Maximum number of lines
     * @param pageable Pagination parameters
     * @return Page of algorithms with short implementations
     */
    @Query("SELECT a FROM Algorithm a WHERE LENGTH(a.implementation) <= :maxLines")
    Page<Algorithm> findAlgorithmsWithShortImplementation(@Param("maxLines") Integer maxLines, Pageable pageable);

    /**
     * Find algorithms with long implementations (for comprehensive examples).
     * 
     * @param minLines Minimum number of lines
     * @param pageable Pagination parameters
     * @return Page of algorithms with long implementations
     */
    @Query("SELECT a FROM Algorithm a WHERE LENGTH(a.implementation) >= :minLines")
    Page<Algorithm> findAlgorithmsWithLongImplementation(@Param("minLines") Integer minLines, Pageable pageable);

    /**
     * Find algorithms by version.
     * 
     * @param version Algorithm version
     * @param pageable Pagination parameters
     * @return Page of algorithms with specified version
     */
    Page<Algorithm> findByVersion(String version, Pageable pageable);

    /**
     * Find algorithms with version greater than or equal to specified version.
     * 
     * @param version Minimum version
     * @param pageable Pagination parameters
     * @return Page of algorithms with version >= specified version
     */
    @Query("SELECT a FROM Algorithm a WHERE a.version >= :version")
    Page<Algorithm> findByVersionGreaterThanEqual(@Param("version") String version, Pageable pageable);

    /**
     * Find algorithms with version less than or equal to specified version.
     * 
     * @param version Maximum version
     * @param pageable Pagination parameters
     * @return Page of algorithms with version <= specified version
     */
    @Query("SELECT a FROM Algorithm a WHERE a.version <= :version")
    Page<Algorithm> findByVersionLessThanEqual(@Param("version") String version, Pageable pageable);

    /**
     * Find algorithms by creation date.
     * 
     * @param date Creation date
     * @param pageable Pagination parameters
     * @return Page of algorithms created on the specified date
     */
    @Query("SELECT a FROM Algorithm a WHERE DATE(a.createdAt) = DATE(:date)")
    Page<Algorithm> findByCreationDate(@Param("date") java.time.LocalDateTime date, Pageable pageable);

    /**
     * Find algorithms by update date.
     * 
     * @param date Update date
     * @param pageable Pagination parameters
     * @return Page of algorithms updated on the specified date
     */
    @Query("SELECT a FROM Algorithm a WHERE DATE(a.updatedAt) = DATE(:date)")
    Page<Algorithm> findByUpdateDate(@Param("date") java.time.LocalDateTime date, Pageable pageable);
}

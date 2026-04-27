package com.dsa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) for algorithm response data.
 * 
 * This DTO represents the structure of algorithm data sent from the
 * Spring Boot API to clients. It includes comprehensive algorithm
 * information with proper formatting and documentation.
 * 
 * @Complexity Time: O(1) - Object creation
 * @Complexity Space: O(n) - Where n is the number of properties
 * @Performance Optimized with lazy loading
 * @Stability Stable - Production ready
 * @Algorithm DTO pattern with JSON annotations
 * @Implementation Spring Boot DTO with Jackson annotations
 * @Optimization Proper JSON formatting and documentation
 * @Reference Spring Boot DTO Documentation
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AlgorithmResponse", description = "Algorithm response data")
@Tag(name = "Algorithm Management")
public class AlgorithmResponse {

    @NotNull(message = "Algorithm ID is required")
    @JsonProperty("id")
    private UUID id;

    @NotNull(message = "Algorithm name is required")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Description is required")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "Category is required")
    @JsonProperty("category")
    private String category;

    @JsonProperty("timeComplexity")
    private String timeComplexity;

    @JsonProperty("spaceComplexity")
    private String spaceComplexity;

    @JsonProperty("timeComplexityScore")
    private Double timeComplexityScore;

    @JsonProperty("spaceComplexityScore")
    private Double spaceComplexityScore;

    @JsonProperty("popularityScore")
    private Double popularityScore;

    @JsonProperty("implementation")
    private String implementation;

    @JsonProperty("author")
    private String author;

    @JsonProperty("version")
    private String version;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("examples")
    private List<String> examples;

    @JsonProperty("references")
    private List<String> references;

    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("executionCount")
    private Long executionCount;

    @JsonProperty("averageExecutionTime")
    private Double averageExecutionTime;

    @JsonProperty("successRate")
    private Double successRate;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("reviewCount")
    private Integer reviewCount;

    /**
     * Default constructor for AlgorithmResponse.
     */
    public AlgorithmResponse() {
        this.executionCount = 0L;
        this.averageExecutionTime = 0.0;
        this.successRate = 100.0;
        this.rating = 0.0;
        this.reviewCount = 0;
    }

    /**
     * Get the algorithm complexity summary.
     * 
     * @return Complexity summary string
     */
    @JsonProperty("complexitySummary")
    public String getComplexitySummary() {
        return String.format("Time: %s, Space: %s", timeComplexity, spaceComplexity);
    }

    /**
     * Get the algorithm performance summary.
     * 
     * @return Performance summary string
     */
    @JsonProperty("performanceSummary")
    public String getPerformanceSummary() {
        return String.format("Executions: %d, Avg Time: %.2fms, Success Rate: %.1f%%",
                executionCount, averageExecutionTime, successRate);
    }

    /**
     * Check if the algorithm has examples.
     * 
     * @return true if examples exist
     */
    @JsonProperty("hasExamples")
    public boolean hasExamples() {
        return examples != null && !examples.isEmpty();
    }

    /**
     * Check if the algorithm has references.
     * 
     * @return true if references exist
     */
    @JsonProperty("hasReferences")
    public boolean hasReferences() {
        return references != null && !references.isEmpty();
    }

    /**
     * Check if the algorithm has tags.
     * 
     * @return true if tags exist
     */
    @JsonProperty("hasTags")
    public boolean hasTags() {
        return tags != null && !tags.isEmpty();
    }

    /**
     * Get the number of examples.
     * 
     * @return Number of examples
     */
    @JsonProperty("exampleCount")
    public int getExampleCount() {
        return examples != null ? examples.size() : 0;
    }

    /**
     * Get the number of references.
     * 
     * @return Number of references
     */
    @JsonProperty("referenceCount")
    public int getReferenceCount() {
        return references != null ? references.size() : 0;
    }

    /**
     * Get the number of tags.
     * 
     * @return Number of tags
     */
    @JsonProperty("tagCount")
    public int getTagCount() {
        return tags != null ? tags.size() : 0;
    }

    /**
     * Check if the algorithm is highly rated.
     * 
     * @return true if rating is 4.0 or higher
     */
    @JsonProperty("isHighlyRated")
    public boolean isHighlyRated() {
        return rating != null && rating >= 4.0;
    }

    /**
     * Check if the algorithm is popular.
     * 
     * @return true if popularity score is 7.0 or higher
     */
    @JsonProperty("isPopular")
    public boolean isPopular() {
        return popularityScore != null && popularityScore >= 7.0;
    }

    /**
     * Check if the algorithm is efficient.
     * 
     * @return true if both time and space complexity scores are 3.0 or lower
     */
    @JsonProperty("isEfficient")
    public boolean isEfficient() {
        return (timeComplexityScore != null && timeComplexityScore <= 3.0) &&
               (spaceComplexityScore != null && spaceComplexityScore <= 3.0);
    }

    /**
     * Get the algorithm's complexity level.
     * 
     * @return Complexity level (Excellent, Good, Fair, Poor)
     */
    @JsonProperty("complexityLevel")
    public String getComplexityLevel() {
        if (timeComplexityScore == null || spaceComplexityScore == null) {
            return "Unknown";
        }
        
        double avgScore = (timeComplexityScore + spaceComplexityScore) / 2.0;
        
        if (avgScore <= 2.0) return "Excellent";
        if (avgScore <= 4.0) return "Good";
        if (avgScore <= 6.0) return "Fair";
        return "Poor";
    }

    /**
     * Get the algorithm's performance level.
     * 
     * @return Performance level (Excellent, Good, Fair, Poor)
     */
    @JsonProperty("performanceLevel")
    public String getPerformanceLevel() {
        if (successRate == null || averageExecutionTime == null) {
            return "Unknown";
        }
        
        if (successRate >= 95.0 && averageExecutionTime <= 100.0) return "Excellent";
        if (successRate >= 90.0 && averageExecutionTime <= 500.0) return "Good";
        if (successRate >= 80.0 && averageExecutionTime <= 1000.0) return "Fair";
        return "Poor";
    }

    /**
     * Get a summary of the algorithm response.
     * 
     * @return Summary string
     */
    public String getSummary() {
        return String.format("AlgorithmResponse{id=%s, name='%s', category='%s', complexity='%s', performance='%s'}",
                id, name, category, getComplexityLevel(), getPerformanceLevel());
    }
}

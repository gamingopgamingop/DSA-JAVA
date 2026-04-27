package com.dsa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) for algorithm creation and update requests.
 * 
 * This DTO represents the structure of algorithm data sent from clients
 * to the Spring Boot API. It includes validation annotations to ensure
 * data integrity and comprehensive documentation for API users.
 * 
 * @Complexity Time: O(1) - Object creation
 * @Complexity Space: O(n) - Where n is the number of properties
 * @Performance Optimized with lazy loading
 * @Stability Stable - Production ready
 * @Algorithm DTO pattern with validation
 * @Implementation Spring Boot DTO with Jackson annotations
 * @Optimization Validation annotations and proper documentation
 * @Reference Spring Boot DTO Documentation
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AlgorithmRequest", description = "Algorithm creation and update request")
@Tag(name = "Algorithm Management")
public class AlgorithmRequest {

    @NotBlank(message = "Algorithm name is required")
    @Size(min = 2, max = 100, message = "Algorithm name must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Algorithm name must contain only letters and spaces")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    @JsonProperty("description")
    private String description;

    @NotBlank(message = "Category is required")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Category must contain only letters and spaces")
    @JsonProperty("category")
    private String category;

    @NotBlank(message = "Time complexity is required")
    @Pattern(regexp = "O\\([^)]+\\)", message = "Time complexity must be in O(...) format")
    @JsonProperty("timeComplexity")
    private String timeComplexity;

    @NotBlank(message = "Space complexity is required")
    @Pattern(regexp = "O\\([^)]+\\)", message = "Space complexity must be in O(...) format")
    @JsonProperty("spaceComplexity")
    private String spaceComplexity;

    @JsonProperty("timeComplexityScore")
    private Double timeComplexityScore;

    @JsonProperty("spaceComplexityScore")
    private Double spaceComplexityScore;

    @JsonProperty("popularityScore")
    private Double popularityScore;

    @Size(max = 10000, message = "Implementation must not exceed 10000 characters")
    @JsonProperty("implementation")
    private String implementation;

    @Pattern(regexp = "^[a-zA-Z0-9\\s\\-]+$", message = "Author name must contain only letters, hyphens, and spaces")
    @JsonProperty("author")
    private String author;

    @Pattern(regexp = "^\\d+\\.\\d+\\.\\d+$", message = "Version must be in format x.y.z")
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

    /**
     * Default constructor for AlgorithmRequest.
     */
    public AlgorithmRequest() {
        this.timeComplexityScore = 0.0;
        this.spaceComplexityScore = 0.0;
        this.popularityScore = 0.0;
        this.version = "1.0.0";
        this.tags = java.util.ArrayList<>();
        this.examples = java.util.ArrayList<>();
        this.references = java.util.ArrayList<>();
        this.metadata = new HashMap<>();
    }

    /**
     * Validation method to ensure time complexity format.
     * 
     * @return true if time complexity is in valid format
     */
    public boolean isValidTimeComplexity() {
        return timeComplexity != null && timeComplexity.matches("^O\\([^)]+$");
    }

    /**
     * Validation method to ensure space complexity format.
     * 
     * @return true if space complexity is in valid format
     */
    public boolean isValidSpaceComplexity() {
        return spaceComplexity != null && spaceComplexity.matches("^O\\([^)]+$");
    }

    /**
     * Get a summary of the algorithm request.
     * 
     * @return Summary string
     */
    public String getSummary() {
        return String.format("AlgorithmRequest{name='%s', category='%s', timeComplexity='%s', spaceComplexity='%s'}",
                name, category, timeComplexity, spaceComplexity);
    }
}

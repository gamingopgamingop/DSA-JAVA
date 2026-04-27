package com.dsa.utils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class for algorithm-related operations and calculations.
 * 
 * This class provides utility methods for algorithm complexity analysis,
 * validation, scoring, and other common operations used throughout
 * the DSA Java application.
 * 
 * @Complexity Time: O(1) - Utility method operations
 * @Complexity Space: O(1) - Utility method memory footprint
 * @Performance Optimized utility methods
 * @Stability Stable - Production ready
 * @Algorithm Utility class with helper methods
 * @Implementation Java utility class with static methods
 * @Optimization Efficient algorithms and caching
 * @Reference Java Utility Class Documentation
 */
@Slf4j
public class AlgorithmUtils {

    // Regex patterns for complexity notation validation
    private static final Pattern COMPLEXITY_PATTERN = Pattern.compile("^O\\([^)]+\\)$");
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("^O\\(n\\^?\\d*\\)$");
    private static final Pattern LOG_PATTERN = Pattern.compile("^O\\(log\\s*n\\)$");
    private static final Pattern CONSTANT_PATTERN = Pattern.compile("^O\\(1\\)$");
    private static final Pattern LINEAR_PATTERN = Pattern.compile("^O\\(n\\)$");
    private static final Pattern EXPONENTIAL_PATTERN = Pattern.compile("^O\\(2\\^n\\)$");
    private static final Pattern FACTORIAL_PATTERN = Pattern.compile("^O\\(n!\\)$");

    // Complexity score mappings
    private static final Map<String, Double> COMPLEXITY_SCORES = Map.of(
        "O(1)", 1.0,
        "O(log n)", 2.0,
        "O(n)", 3.0,
        "O(n log n)", 4.0,
        "O(n^2)", 6.0,
        "O(n^3)", 8.0,
        "O(2^n)", 9.0,
        "O(n!)", 10.0
    );

    /**
     * Validates if a complexity notation is in the correct format.
     * 
     * @param complexity The complexity notation to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidComplexity(String complexity) {
        if (complexity == null || complexity.trim().isEmpty()) {
            return false;
        }
        return COMPLEXITY_PATTERN.matcher(complexity.trim()).matches();
    }

    /**
     * Calculates a complexity score based on the complexity notation.
     * Lower scores indicate better performance.
     * 
     * @param complexity The complexity notation
     * @return Complexity score (1-10, where 1 is best)
     */
    public static double calculateComplexityScore(String complexity) {
        if (!isValidComplexity(complexity)) {
            return 10.0; // Default score for invalid complexity
        }

        String normalizedComplexity = complexity.trim().toLowerCase();
        
        // Check exact matches first
        if (COMPLEXITY_SCORES.containsKey(normalizedComplexity)) {
            return COMPLEXITY_SCORES.get(normalizedComplexity);
        }

        // Handle variations and patterns
        if (CONSTANT_PATTERN.matcher(normalizedComplexity).matches()) {
            return 1.0;
        }
        
        if (LOG_PATTERN.matcher(normalizedComplexity).matches()) {
            return 2.0;
        }
        
        if (LINEAR_PATTERN.matcher(normalizedComplexity).matches()) {
            return 3.0;
        }
        
        if (POLYNOMIAL_PATTERN.matcher(normalizedComplexity).matches()) {
            return calculatePolynomialScore(normalizedComplexity);
        }
        
        if (EXPONENTIAL_PATTERN.matcher(normalizedComplexity).matches()) {
            return 9.0;
        }
        
        if (FACTORIAL_PATTERN.matcher(normalizedComplexity).matches()) {
            return 10.0;
        }

        // Default score for unknown patterns
        return 10.0;
    }

    /**
     * Calculates complexity score for polynomial time complexities.
     * 
     * @param complexity The polynomial complexity notation
     * @return Complexity score
     */
    private static double calculatePolynomialScore(String complexity) {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(complexity);
        if (matcher.matches()) {
            String polynomial = matcher.group();
            if (polynomial.equals("O(n)")) {
                return 3.0;
            } else if (polynomial.equals("O(n^2)")) {
                return 6.0;
            } else if (polynomial.equals("O(n^3)")) {
                return 8.0;
            }
            // For n^k where k > 3
            int exponent = extractExponent(polynomial);
            return Math.min(10.0, 4.0 + (exponent - 1) * 2.0);
        }
        return 10.0;
    }

    /**
     * Extracts the exponent from a polynomial complexity notation.
     * 
     * @param polynomial The polynomial complexity notation
     * @return The exponent value
     */
    private static int extractExponent(String polynomial) {
        if (polynomial.equals("O(n)")) {
            return 1;
        }
        
        Matcher matcher = Pattern.compile("^O\\(n\\^(\\d+)\\)$").matcher(polynomial);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }
        
        return 1; // Default
    }

    /**
     * Categorizes the complexity level based on the complexity score.
     * 
     * @param score The complexity score
     * @return Complexity level (Excellent, Good, Fair, Poor)
     */
    public static String categorizeComplexityLevel(double score) {
        if (score <= 2.0) return "Excellent";
        if (score <= 4.0) return "Good";
        if (score <= 6.0) return "Fair";
        return "Poor";
    }

    /**
     * Determines if an algorithm is efficient based on its complexity scores.
     * 
     * @param timeScore Time complexity score
     * @param spaceScore Space complexity score
     * @return true if efficient, false otherwise
     */
    public static boolean isEfficient(double timeScore, double spaceScore) {
        return timeScore <= 3.0 && spaceScore <= 3.0;
    }

    /**
     * Calculates the overall efficiency score for an algorithm.
     * 
     * @param timeScore Time complexity score
     * @param spaceScore Space complexity score
     * @return Overall efficiency score (1-10, where 1 is best)
     */
    public static double calculateEfficiencyScore(double timeScore, double spaceScore) {
        return (timeScore + spaceScore) / 2.0;
    }

    /**
     * Normalizes an algorithm name by removing special characters and converting to lowercase.
     * 
     * @param name The algorithm name to normalize
     * @return Normalized algorithm name
     */
    public static String normalizeAlgorithmName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        }
        
        return name.trim()
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-");
    }

    /**
     * Generates a unique algorithm identifier based on name and category.
     * 
     * @param name The algorithm name
     * @param category The algorithm category
     * @return Unique algorithm identifier
     */
    public static String generateAlgorithmId(String name, String category) {
        String normalizedName = normalizeAlgorithmName(name);
        String normalizedCategory = normalizeAlgorithmName(category);
        
        return String.format("%s-%s-%d", normalizedCategory, normalizedName, 
                (normalizedName + normalizedCategory).hashCode() & 0x7FFFFFFF);
    }

    /**
     * Validates if an algorithm implementation is syntactically correct.
     * 
     * @param implementation The algorithm implementation code
     * @return true if syntactically correct, false otherwise
     */
    public static boolean validateImplementation(String implementation) {
        if (implementation == null || implementation.trim().isEmpty()) {
            return false;
        }

        // Basic syntax checks
        String code = implementation.trim();
        
        // Check for balanced braces
        int braceBalance = 0;
        for (char c : code.toCharArray()) {
            if (c == '{') braceBalance++;
            else if (c == '}') braceBalance--;
        }
        
        if (braceBalance != 0) {
            return false;
        }

        // Check for balanced parentheses
        int parenBalance = 0;
        for (char c : code.toCharArray()) {
            if (c == '(') parenBalance++;
            else if (c == ')') parenBalance--;
        }
        
        if (parenBalance != 0) {
            return false;
        }

        // Check for balanced brackets
        int bracketBalance = 0;
        for (char c : code.toCharArray()) {
            if (c == '[') bracketBalance++;
            else if (c == ']') bracketBalance--;
        }
        
        if (bracketBalance != 0) {
            return false;
        }

        // Check for basic Java syntax elements
        if (!code.contains("class") && !code.contains("interface")) {
            return false;
        }

        return true;
    }

    /**
     * Extracts the main method signature from an algorithm implementation.
     * 
     * @param implementation The algorithm implementation code
     * @return The main method signature, or null if not found
     */
    public static String extractMainMethod(String implementation) {
        if (implementation == null || implementation.trim().isEmpty()) {
            return null;
        }

        Pattern mainMethodPattern = Pattern.compile(
            "public\\s+static\\s+void\\s+main\\s*\\([^)]*\\)\\s*\\{",
            Pattern.MULTILINE
        );

        Matcher matcher = mainMethodPattern.matcher(implementation);
        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /**
     * Calculates the complexity of an algorithm implementation based on code analysis.
     * 
     * @param implementation The algorithm implementation code
     * @return Estimated complexity notation
     */
    public static String estimateComplexity(String implementation) {
        if (implementation == null || implementation.trim().isEmpty()) {
            return "O(1)";
        }

        String code = implementation.toLowerCase();
        
        // Simple heuristics for complexity estimation
        if (code.contains("for") && code.contains("for")) {
            // Nested loops suggest O(n^2) or higher
            long forLoopCount = code.chars().filter(ch -> ch == 'f').count();
            if (forLoopCount >= 2) {
                return "O(n^2)";
            }
        }
        
        if (code.contains("while") && code.contains("while")) {
            // Nested while loops
            return "O(n^2)";
        }
        
        if (code.contains("for") || code.contains("while")) {
            // Single loop
            return "O(n)";
        }
        
        if (code.contains("binary") || code.contains("divide") || code.contains("half")) {
            // Binary search or divide and conquer
            return "O(log n)";
        }
        
        if (code.contains("recursive") && code.contains("divide")) {
            // Recursive divide and conquer
            return "O(n log n)";
        }
        
        // Default to linear time
        return "O(n)";
    }

    /**
     * Formats a complexity notation for display.
     * 
     * @param complexity The complexity notation
     * @return Formatted complexity notation
     */
    public static String formatComplexity(String complexity) {
        if (complexity == null || complexity.trim().isEmpty()) {
            return "Unknown";
        }

        String formatted = complexity.trim();
        
        // Ensure proper spacing
        formatted = formatted.replaceAll("O\\s+", "O(");
        formatted = formatted.replaceAll("\\s+\\)", ")");
        formatted = formatted.replaceAll("\\s+", " ");
        
        return formatted;
    }

    /**
     * Compares two complexity notations and returns which is better.
     * 
     * @param complexity1 First complexity notation
     * @param complexity2 Second complexity notation
     * @return -1 if first is better, 1 if second is better, 0 if equal
     */
    public static int compareComplexity(String complexity1, String complexity2) {
        double score1 = calculateComplexityScore(complexity1);
        double score2 = calculateComplexityScore(complexity2);
        
        return Double.compare(score1, score2);
    }

    /**
     * Gets the complexity category (e.g., "Constant", "Linear", "Polynomial").
     * 
     * @param complexity The complexity notation
     * @return Complexity category
     */
    public static String getComplexityCategory(String complexity) {
        if (!isValidComplexity(complexity)) {
            return "Unknown";
        }

        String normalized = complexity.trim().toLowerCase();
        
        if (CONSTANT_PATTERN.matcher(normalized).matches()) {
            return "Constant";
        }
        
        if (LOG_PATTERN.matcher(normalized).matches()) {
            return "Logarithmic";
        }
        
        if (LINEAR_PATTERN.matcher(normalized).matches()) {
            return "Linear";
        }
        
        if (POLYNOMIAL_PATTERN.matcher(normalized).matches()) {
            return "Polynomial";
        }
        
        if (EXPONENTIAL_PATTERN.matcher(normalized).matches()) {
            return "Exponential";
        }
        
        if (FACTORIAL_PATTERN.matcher(normalized).matches()) {
            return "Factorial";
        }
        
        return "Other";
    }

    /**
     * Calculates the performance rating for an algorithm based on complexity scores.
     * 
     * @param timeScore Time complexity score
     * @param spaceScore Space complexity score
     * @return Performance rating (A, B, C, D, F)
     */
    public static String calculatePerformanceRating(double timeScore, double spaceScore) {
        double avgScore = (timeScore + spaceScore) / 2.0;
        
        if (avgScore <= 2.0) return "A";
        if (avgScore <= 4.0) return "B";
        if (avgScore <= 6.0) return "C";
        if (avgScore <= 8.0) return "D";
        return "F";
    }

    /**
     * Generates a summary of algorithm characteristics.
     * 
     * @param name Algorithm name
     * @param category Algorithm category
     * @param timeComplexity Time complexity
     * @param spaceComplexity Space complexity
     * @return Summary string
     */
    public static String generateSummary(String name, String category, 
                                         String timeComplexity, String spaceComplexity) {
        double timeScore = calculateComplexityScore(timeComplexity);
        double spaceScore = calculateComplexityScore(spaceComplexity);
        String rating = calculatePerformanceRating(timeScore, spaceScore);
        String efficiency = isEfficient(timeScore, spaceScore) ? "Efficient" : "Inefficient";
        
        return String.format("%s (%s): %s, %s - Rating: %s, %s", 
                name, category, timeComplexity, spaceComplexity, rating, efficiency);
    }

    /**
     * Validates algorithm parameters and constraints.
     * 
     * @param name Algorithm name
     * @param description Algorithm description
     * @param category Algorithm category
     * @return Validation result with errors
     */
    public static ValidationResult validateAlgorithmParameters(String name, String description, String category) {
        List<String> errors = new ArrayList<>();
        
        if (name == null || name.trim().isEmpty()) {
            errors.add("Algorithm name is required");
        } else if (name.trim().length() < 2 || name.trim().length() > 100) {
            errors.add("Algorithm name must be between 2 and 100 characters");
        }
        
        if (description == null || description.trim().isEmpty()) {
            errors.add("Description is required");
        } else if (description.trim().length() < 10 || description.trim().length() > 1000) {
            errors.add("Description must be between 10 and 1000 characters");
        }
        
        if (category == null || category.trim().isEmpty()) {
            errors.add("Category is required");
        } else if (category.trim().length() > 50) {
            errors.add("Category must not exceed 50 characters");
        }
        
        return new ValidationResult(errors.isEmpty(), errors);
    }

    /**
     * Validation result class.
     */
    public static class ValidationResult {
        private final boolean valid;
        private final List<String> errors;

        public ValidationResult(boolean valid, List<String> errors) {
            this.valid = valid;
            this.errors = errors;
        }

        public boolean isValid() {
            return valid;
        }

        public List<String> getErrors() {
            return errors;
        }

        @Override
        public String toString() {
            if (valid) {
                return "Valid";
            } else {
                return "Invalid: " + String.join(", ", errors);
            }
        }
    }
}

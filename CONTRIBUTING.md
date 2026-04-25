# Contributing to DSA Java

Thank you for your interest in contributing to the DSA Java project! This document provides guidelines for contributing algorithms, tests, and documentation.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Naming Conventions](#naming-conventions)
- [Adding a New Algorithm](#adding-a-new-algorithm)
- [Test Requirements](#test-requirements)
- [Documentation Requirements](#documentation-requirements)
- [Submission Process](#submission-process)
- [Review Process](#review-process)

## Code of Conduct

Please be respectful and professional in all interactions. This project is for educational purposes and collaboration.

## Getting Started

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/algorithm-name`
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## Naming Conventions

### Algorithm Files
- **Format**: `PascalCase` with descriptive name
- **Examples**: `QuickSortAlgorithm.java`, `BinarySearch.java`, `LinkedListWithAddresses.java`
- **Suffix**: End with `Algorithm` for sorting algorithms
- **Avoid**: Abbreviations, unclear names

### Test Files
- **Format**: `AlgorithmName_Test.java`
- **Examples**: `QuickSortAlgorithm_Test.java`, `BinarySearch_Test.java`
- **Location**: Same directory as algorithm file
- **Content**: Comprehensive test suite

### Documentation Files
- **Algorithm Documentation**: `AlgorithmName_Documentation.md`
- **Test Documentation**: `AlgorithmName_Test_Documentation.md`
- **Location**: Same directory as algorithm file
- **Format**: Markdown with consistent structure

### Package Structure
- **No packages**: All files in root directory (current structure)
- **Future**: Consider organizing by category (sorting, data-structures, etc.)

## Adding a New Algorithm

### 1. Algorithm Implementation

Create the main algorithm file following this template:

```java
import java.text.MessageFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
// ... include all 63 imports from existing files

/**
 * AlgorithmName - Brief description of the algorithm.
 * 
 * Detailed description including:
 * - Algorithm type (sorting, searching, data structure, etc.)
 * - Time complexity
 * - Space complexity
 * - Use cases
 * - Key characteristics
 */
public class AlgorithmName implements Runnable {
    
    /**
     * Reads an integer from the console with input validation.
     */
    private static int readInt(Scanner scanner, String prompt) {
        // ... implementation (copy from existing files)
    }

    /**
     * Main algorithm implementation.
     */
    public static void algorithmMethod(/* parameters */) {
        // ... algorithm implementation
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Interactive user interface
            // Input validation
            // Algorithm execution
            // Result display
        }
    }

    public static void main(String[] args) {
        new AlgorithmName().run();
    }
}
```

### Requirements for Algorithm Files:
- ✅ Include all 63 imports from existing files
- ✅ Implement `Runnable` interface
- ✅ Provide interactive user interface
- ✅ Include input validation
- ✅ Use `MessageFormat` for output
- ✅ Demonstrate various Java imports
- ✅ Add comprehensive JavaDoc comments
- ✅ Handle exceptions gracefully

### 2. Test Implementation

Create a comprehensive test file:

```java
import java.text.MessageFormat;
// ... include all 63 imports

/**
 * Test class for AlgorithmName validation
 */
public class AlgorithmName_Test {
    
    private static final String TEST_RESULTS_FILE = "algorithm_name_test_results.txt";
    private static PrintStream writer;
    
    public static void main(String[] args) {
        try {
            writer = new PrintStream(new BufferedOutputStream(
                new FileOutputStream(TEST_RESULTS_FILE), true));
            
            writer.println("=== AlgorithmName Test Results ===");
            writer.println("Timestamp: " + new Date());
            writer.println();
            
            // Test 1: Basic functionality
            testBasicFunctionality();
            
            // Test 2: Edge cases
            testEdgeCases();
            
            // Test 3: Performance tests
            testPerformance();
            
            // ... include all 12 test methods
            
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing test results: " + e.getMessage());
        }
    }
    
    /**
     * Test basic algorithm functionality
     */
    private static void testBasicFunctionality() {
        writer.println("=== Basic Functionality Tests ===");
        // ... implementation
    }
    
    // ... include all test methods
}
```

### Required Test Methods (12 total):
1. `testBasicFunctionality()` - Core behavior validation
2. `testEdgeCases()` - Boundary conditions
3. `testPerformance()` - Performance analysis
4. `testAlgorithmProperties()` - Mathematical properties
5. `testLargeDataset()` - Stress testing
6. `testMemoryEfficiency()` - Memory analysis
7. `testAdvancedOperations()` - Complex scenarios
8. `testDifferentDataTypes()` - Type compatibility
9. `testAlgorithmComparison()` - Compare with alternatives
10. `testErrorHandling()` - Exception management
11. `testBoundaryConditions()` - Extreme values
12. `testPerformanceComparison()` - Performance metrics

### 3. Documentation

#### Algorithm Documentation (`AlgorithmName_Documentation.md`)

```markdown
# AlgorithmName Documentation

## Overview
[Brief description and purpose]

## Algorithm Summary
[Technical details, complexity, applications]

## Class Structure
[Implementation details]

## Core Algorithm
[Step-by-step explanation]

## Algorithm Analysis
[Time/space complexity]

## User Interface
[Interactive features]

## Usage Examples
[Practical examples]

## Comparison with Other Algorithms
[Trade-offs and alternatives]

## Best Practices
[Implementation guidelines]

## Conclusion
[Summary and key takeaways]
```

#### Test Documentation (`AlgorithmName_Test_Documentation.md`)

```markdown
# AlgorithmName Test Documentation

## Overview
[Test suite purpose]

## Algorithm Summary
[Algorithm context]

## Test Coverage
[Comprehensive test list]

## Test Implementation Details
[Technical testing approach]

## Performance Analysis
[Metrics and analysis]

## Core Operations Tested
[Specific operations]

## Edge Case Handling
[Boundary testing]

## Usage Examples
[Test examples]

## Integration with Main Algorithm
[Dependencies]

## Best Practices Demonstrated
[Testing methodology]

## Conclusion
[Test suite summary]
```

## Test Requirements

### Test Coverage Must Include:
- ✅ **Basic Functionality**: Core algorithm behavior
- ✅ **Edge Cases**: Empty, single element, boundary values
- ✅ **Performance**: Time/space complexity validation
- ✅ **Large Datasets**: Stress testing (50,000+ elements)
- ✅ **Memory Efficiency**: Space complexity analysis
- ✅ **Advanced Operations**: Complex scenarios
- ✅ **Different Data Types**: Type compatibility
- ✅ **Error Handling**: Exception management
- ✅ **Algorithm Comparison**: Performance vs alternatives
- ✅ **Boundary Conditions**: Extreme values
- ✅ **Performance Comparison**: Detailed metrics

### Test Output Requirements:
- ✅ Save results to `*_test_results.txt`
- ✅ Include timestamp and test summary
- ✅ Provide performance metrics
- ✅ Show pass/fail status
- ✅ Include memory usage analysis
- ✅ Display recursion depth (if applicable)

## Documentation Requirements

### Algorithm Documentation Must Include:
- ✅ **Overview**: Purpose and context
- ✅ **Algorithm Summary**: Technical details
- ✅ **Class Structure**: Implementation details
- ✅ **Core Algorithm**: Step-by-step explanation
- ✅ **Algorithm Analysis**: Complexity analysis
- ✅ **User Interface**: Interactive features
- ✅ **Usage Examples**: Practical examples
- ✅ **Comparison**: Alternatives and trade-offs
- ✅ **Best Practices**: Implementation guidelines
- ✅ **Conclusion**: Summary and key takeaways

### Test Documentation Must Include:
- ✅ **Overview**: Test suite purpose
- ✅ **Test Coverage**: Comprehensive test list
- ✅ **Implementation Details**: Technical approach
- ✅ **Performance Analysis**: Metrics and analysis
- ✅ **Core Operations**: Specific operations tested
- ✅ **Edge Cases**: Boundary testing
- ✅ **Usage Examples**: Test examples
- ✅ **Integration**: Dependencies and relationships
- ✅ **Best Practices**: Testing methodology
- ✅ **Conclusion**: Test suite summary

## Submission Process

### Before Submitting:
1. **Test Your Algorithm**: Run all tests successfully
2. **Check Documentation**: Ensure all docs are complete
3. **Verify Naming**: Follow naming conventions
4. **Format Code**: Use consistent formatting
5. **Update README**: Add your algorithm to the list

### Pull Request Requirements:
- ✅ Clear title and description
- ✅ Link to relevant issues
- ✅ Include screenshots if applicable
- ✅ Test results summary
- ✅ Documentation updates

### Files to Include:
- ✅ `AlgorithmName.java` - Main implementation
- ✅ `AlgorithmName_Test.java` - Test suite
- ✅ `AlgorithmName_Documentation.md` - Algorithm docs
- ✅ `AlgorithmName_Test_Documentation.md` - Test docs
- ✅ Updated `README.md` - Add to algorithm list

## Review Process

### Automated Checks:
- ✅ Code compiles without errors
- ✅ Tests run successfully
- ✅ Documentation format is correct
- ✅ Naming conventions followed

### Manual Review:
- ✅ Algorithm correctness
- ✅ Test completeness
- ✅ Documentation quality
- ✅ Code style and readability
- ✅ Educational value

### Approval Criteria:
- ✅ Algorithm is correct and efficient
- ✅ Tests are comprehensive
- ✅ Documentation is complete
- ✅ Code follows project standards
- ✅ Educational value is demonstrated

## Getting Help

### Resources:
- Check existing algorithms for examples
- Review test files for patterns
- Use documentation templates
- Ask questions in issues

### Contact:
- Create an issue for questions
- Tag maintainers for review
- Join discussions in pull requests

## Thank You!

Your contributions help make this project better for everyone. Whether you're adding a new algorithm, improving tests, or enhancing documentation, your efforts are appreciated!

---

## Quick Checklist

Before submitting, ensure:

- [ ] Algorithm implementation follows the template
- [ ] All 63 imports are included
- [ ] Test file has all 12 required test methods
- [ ] Documentation files follow the template
- [ ] Naming conventions are followed
- [ ] Code compiles and runs without errors
- [ ] Tests pass successfully
- [ ] Documentation is complete and accurate
- [ ] README.md is updated
- [ ] Pull request description is clear

Happy coding! 🚀

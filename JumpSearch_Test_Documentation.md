# JumpSearch_Test.java - Documentation

## Overview
This documentation covers the test suite for the `JumpSearch` implementation. The test class follows the repository's standard for validation, which includes logging results to an external file and demonstrating comprehensive import usage.

## Test Suite Structure

### Output
The test results are written to: `jump_search_test_results.txt`

### Test Cases

#### 1. `testBasicFunctionality()`
- **Goal**: Verify that the algorithm can find a target element in a standard sorted array.
- **Scenario**: Search for `55` in a Fibonacci sequence array.
- **Expected Outcome**: Correct index returned.

#### 2. `testEdgeCases()`
- **Goal**: Ensure the algorithm handles boundary conditions gracefully.
- **Scenarios**:
  - Empty array (Should return `-1`).
  - Single-element array where element is found (Should return `0`).
  - Single-element array where element is NOT found (Should return `-1`).

#### 3. `testLargeDataset()`
- **Goal**: Validate performance and correctness with a larger set of data.
- **Scenario**: 10,000 elements (all even numbers).
- **Metric**: Execution time in nanoseconds.

#### 4. `testElementNotFound()`
- **Goal**: Confirm the algorithm correctly returns `-1` when the target is absent but within the array range.
- **Scenario**: Search for `25` in `[10, 20, 30, 40, 50]`.

## How to Run the Tests
1. Compile both files:
   ```bash
   javac JumpSearch.java JumpSearch_Test.java
   ```
2. Execute the test class:
   ```bash
   java JumpSearch_Test
   ```
3. Check the `jump_search_test_results.txt` file for detailed logs.

## Dependencies
- `JumpSearch.java`: The core algorithm implementation.
- Standard Java 8+ libraries.

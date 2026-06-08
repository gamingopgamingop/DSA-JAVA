# JumpSearch.java - Documentation

## Overview
This Java program implements the **Jump Search** algorithm. Similar to `BinarySearch.java`, it follows the repository's style of including comprehensive Java imports and utilizing functional interfaces for logic implementation.

## Algorithm Logic

### Jump Search Algorithm
Jump Search is an efficient algorithm for searching in a **sorted** array. It works by skipping a fixed number of elements (block size) to reduce the number of comparisons compared to a Linear Search.

The optimal block size is typically **√n**, where *n* is the length of the array.

#### Time Complexity: O(√n)
#### Space Complexity: O(1)

### Core Methods

#### 1. `jumpSearch(int[] arr, int target)`
- **Purpose**: Performs Jump Search on a sorted integer array.
- **Parameters**: 
  - `arr`: Sorted array of integers.
  - `target`: Integer value to search for.
- **Returns**: Index of target element if found, -1 if not found.
- **Logic**:
  ```java
  int n = arr.length;
  int step = (int) Math.floor(Math.sqrt(n));
  int prev = 0;
  IntBinaryOperator comparator = (a, b) -> Integer.compare(a, b);
  ```

### Comparison with Other Searching Algorithms

| Algorithm | Time Complexity (Average) | Best For |
| :--- | :--- | :--- |
| **Linear Search** | O(n) | Unsorted data, small arrays |
| **Binary Search** | O(log n) | Sorted data, large arrays |
| **Jump Search** | O(√n) | Sorted data, when jumping is cheaper than backtracking |

## Implementation Details
- **Block Size**: Calculated as `Math.sqrt(n)`.
- **Comparison**: Uses `java.util.function.IntBinaryOperator` to match the functional style of the repository.
- **Safety**: Includes checks for empty arrays and boundaries.

## Demonstration
The class includes a `main` method that:
1. Defines a Fibonacci sequence array (sorted).
2. Searches for a specific value.
3. Prints the result.
4. Calls `demonstrateAllImports()` to show usage of various Java utility classes.

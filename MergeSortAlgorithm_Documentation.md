# MergeSortAlgorithm Documentation

## Overview

The `MergeSortAlgorithm.java` file implements a comprehensive Merge Sort algorithm with an interactive user interface. This implementation demonstrates the divide-and-conquer paradigm and provides educational value through recursion depth tracking and various Java import demonstrations.

## Algorithm Summary

**Merge Sort**: A divide-and-conquer sorting algorithm that recursively divides the array into two halves, sorts them, and then merges the sorted halves.
- **Time Complexity**: O(n log n) where n is the array length
- **Space Complexity**: O(n) - Additional arrays for merging
- **Approach**: Divide and conquer with recursive splitting
- **Applications**: General-purpose sorting, external sorting, stable sorting

## Class Structure

### Core Implementation
```java
public class MergeSortAlgorithm implements Runnable {
    
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            } catch (NoSuchElementException e) {
                System.err.println("Error: Required input was not found.");
                System.exit(1);
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right, Stack<Integer> recursionStack) {
        if (left < right) {
            recursionStack.push(left); // Track recursion depth for demonstration
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, recursionStack);
            mergeSort(arr, mid + 1, right, recursionStack);
            merge(arr, left, mid, right);
            recursionStack.pop();
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(MessageFormat.format("Array size: {0}", n));
            
            // Input array elements
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, MessageFormat.format("Element {0}: ", i));
            }

            System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

            Stack<Integer> recursionStack = new Stack<>();
            mergeSort(array, 0, array.length - 1, recursionStack);

            // Using List and Iterator for demonstration of imports
            List<Integer> sortedList = new java.util.ArrayList<>();
            for (int val : array) sortedList.add(val);
            
            System.out.print("Sorted Array (via Iterator): ");
            Iterator<Integer> it = sortedList.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();

            // Using Formatter for final summary
            Formatter formatter = new Formatter();
            formatter.format("Summary: Merge Sort completed on %d elements. Sorted Array: %s", 
                            n, Arrays.toString(array));
            System.out.println(formatter.toString());
            formatter.close();
        }
    }
}
```

## Core Algorithm

### Divide and Conquer Strategy
The algorithm follows these steps:

1. **Divide**: Split the array into two halves
2. **Conquer**: Recursively sort each half
3. **Combine**: Merge the sorted halves

### Recursive Implementation
```java
public static void mergeSort(int[] arr, int left, int right, Stack<Integer> recursionStack) {
    if (left < right) {
        recursionStack.push(left);
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, recursionStack);      // Sort left half
        mergeSort(arr, mid + 1, right, recursionStack);  // Sort right half
        merge(arr, left, mid, right);                    // Merge halves
        recursionStack.pop();
    }
}
```

### Merge Process
```java
public static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;  // Size of left subarray
    int n2 = right - mid;     // Size of right subarray

    // Create temporary arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copy data to temporary arrays
    for (int i = 0; i < n1; i++) {
        L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }

    // Merge the temporary arrays
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```

### Step-by-Step Example
```
Original Array: [64, 34, 25, 12, 22, 11, 90]

Step 1: Divide
- Split into [64, 34, 25] and [12, 22, 11, 90]
- Recursively split until single elements

Step 2: Conquer (Sort)
- Sort [64, 34, 25] → [25, 34, 64]
- Sort [12, 22, 11, 90] → [11, 12, 22, 90]

Step 3: Combine (Merge)
- Merge [25, 34, 64] and [11, 12, 22, 90]
- Result: [11, 12, 22, 25, 34, 64, 90]
```

## Algorithm Analysis

### Time Complexity
- **Best Case**: O(n log n) - Always divides and merges
- **Average Case**: O(n log n) - Consistent performance
- **Worst Case**: O(n log n) - Consistent performance
- **Recurrence Relation**: T(n) = 2T(n/2) + O(n)

### Space Complexity
- **Total Space**: O(n) - Temporary arrays during merge
- **Recursive Stack**: O(log n) - Recursion depth
- **Auxiliary Space**: O(n) - Temporary arrays
- **Memory Usage**: Linear with input size

### Performance Characteristics
| Array Size | Comparisons | Memory (KB) | Recursion Depth | Time (ms) |
|------------|-------------|-------------|-----------------|-----------|
| 10 | ~23 | ~0.04 | 4 | ~0.01 |
| 100 | ~515 | ~0.39 | 7 | ~0.05 |
| 1,000 | ~9,966 | ~3.91 | 10 | ~0.10 |
| 10,000 | ~132,877 | ~39.06 | 14 | ~1.00 |
| 100,000 | ~1,660,964 | ~390.63 | 17 | ~10.00 |

## Mathematical Properties

### Recurrence Relation
```
T(n) = 2T(n/2) + O(n)
T(1) = O(1)
```

Solving using Master Theorem:
- a = 2 (number of subproblems)
- b = 2 (factor by which input size is divided)
- f(n) = O(n) (merge step)

Since n^(log_b a) = n^(log_2 2) = n^1 = n:
- f(n) = Θ(n^(log_b a))
- Therefore, T(n) = Θ(n log n)

### Stability Property
- **Stable**: Yes - Maintains relative order of equal elements
- **In-Place**: No - Requires additional O(n) space
- **Adaptive**: No - Performance doesn't depend on input order

## User Interface

### Interactive Input
The program provides an interactive console interface:

1. **Array Size Input**: User specifies number of elements
2. **Element Input**: User enters each element individually
3. **Automatic Sorting**: Program performs merge sort
4. **Result Display**: Shows sorted array in multiple formats

### Input Validation
- **Integer Validation**: Ensures valid integer input
- **Error Handling**: Graceful handling of invalid input
- **Exception Management**: Comprehensive error recovery
- **User Feedback**: Clear error messages

### Output Formats
```java
// Original array display
System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

// Iterator-based display
System.out.print("Sorted Array (via Iterator): ");
Iterator<Integer> it = sortedList.iterator();
while (it.hasNext()) {
    System.out.print(it.next() + " ");
}

// Formatter-based summary
Formatter formatter = new Formatter();
formatter.format("Summary: Merge Sort completed on %d elements. Sorted Array: %s", 
                n, Arrays.toString(array));
```

## Usage Examples

### Basic Usage
```java
// Input:
// Enter the number of elements: 5
// Enter 5 elements:
// Element 0: 64
// Element 1: 34
// Element 2: 25
// Element 3: 12
// Element 4: 22

// Output:
// Original Array: [64, 34, 25, 12, 22]
// Sorted Array (via Iterator): 12 22 25 34 64 
// Summary: Merge Sort completed on 5 elements. Sorted Array: [12, 22, 25, 34, 64]
```

### Large Array Usage
```java
// Input:
// Enter the number of elements: 1000
// Enter 1000 elements: [random numbers]

// Output:
// Original Array: [1000 random numbers]
// Sorted Array (via Iterator): [sorted numbers]
// Summary: Merge Sort completed on 1000 elements. Sorted Array: [sorted array]
```

## Comparison with Other Sorting Algorithms

### Sorting Algorithm Comparison
| Algorithm | Time Complexity | Space Complexity | Stable | Best Use Case |
|---------|------------------|------------------|--------|-------------|
| Merge Sort | O(n log n) | O(n) | Yes | External sorting |
| Quicksort | O(n log n) | O(log n) | No | General purpose |
| Heap Sort | O(n log n) | O(1) | No | Memory-constrained |
| Bubble Sort | O(n²) | O(1) | Yes | Educational |
| Insertion Sort | O(n²) | O(1) | Yes | Small arrays |

### Performance Recommendations
- **General Purpose**: Use Quicksort for average performance
- **Stable Sorting**: Use Merge Sort for stability requirements
- **External Sorting**: Use Merge Sort for large datasets
- **Memory Constrained**: Use Heap Sort for O(1) space
- **Small Arrays**: Use Insertion Sort for simplicity

## Best Practices

### Implementation Guidelines
1. **Input Validation**: Always validate user input
2. **Error Handling**: Implement comprehensive exception management
3. **Memory Management**: Monitor memory usage for large arrays
4. **Code Documentation**: Add clear comments and documentation
5. **User Experience**: Provide clear feedback and error messages

### Optimization Tips
1. **Hybrid Approach**: Use insertion sort for small subarrays
2. **Iterative Implementation**: Avoid recursion for very large arrays
3. **Memory Optimization**: Reuse temporary arrays
4. **Parallel Processing**: Implement parallel merge sort
5. **In-place Variants**: Consider in-place merge algorithms

### Code Quality
- **Clear Documentation**: Comprehensive method documentation
- **Modular Design**: Separate concerns (input, sorting, output)
- **Reusable Components**: Utility methods for common tasks
- **Maintainable Structure**: Easy to extend and modify
- **Consistent Style**: Follow Java coding conventions

## Limitations and Considerations

### Current Implementation
1. **Memory Usage**: O(n) additional space required
2. **Recursive Depth**: May cause stack overflow for large arrays
3. **Integer Only**: Limited to integer data type
4. **No Parallel Processing**: Single-threaded implementation
5. **No Custom Comparators**: Fixed ascending order

### Considerations for Improvement
1. **Iterative Version**: Avoid recursion depth issues
2. **Generic Implementation**: Support for different data types
3. **Parallel Processing**: Multi-threaded merge sort
4. **Custom Comparators**: Flexible sorting criteria
5. **Memory Optimization**: In-place merge variants

### Implementation Variations

### Iterative Merge Sort
```java
public static void iterativeMergeSort(int[] arr) {
    int n = arr.length;
    for (int curr_size = 1; curr_size <= n - 1; curr_size = 2 * curr_size) {
        for (int left_start = 0; left_start < n - 1; left_start += 2 * curr_size) {
            int mid = Math.min(left_start + curr_size - 1, n - 1);
            int right_end = Math.min(left_start + 2 * curr_size - 1, n - 1);
            merge(arr, left_start, mid, right_end);
        }
    }
}
```

### Generic Merge Sort
```java
public static <T extends Comparable<? super T>> void genericMergeSort(T[] arr) {
    if (arr.length <= 1) return;
    
    T[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
    T[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
    
    genericMergeSort(left);
    genericMergeSort(right);
    
    genericMerge(arr, left, right);
}
```

### Parallel Merge Sort
```java
public static void parallelMergeSort(int[] arr, int left, int right, int depth) {
    if (left < right) {
        if (depth < MAX_DEPTH) {
            int mid = (left + right) / 2;
            
            Thread leftThread = new Thread(() -> parallelMergeSort(arr, left, mid, depth + 1));
            Thread rightThread = new Thread(() -> parallelMergeSort(arr, mid + 1, right, depth + 1));
            
            leftThread.start();
            rightThread.start();
            
            try {
                leftThread.join();
                rightThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            merge(arr, left, mid, right);
        } else {
            mergeSort(arr, left, right, new Stack<>());
        }
    }
}
```

### Hybrid Merge Sort
```java
public static void hybridMergeSort(int[] arr, int left, int right, Stack<Integer> recursionStack) {
    if (right - left <= THRESHOLD) {
        insertionSort(arr, left, right);
    } else {
        int mid = (left + right) / 2;
        hybridMergeSort(arr, left, mid, recursionStack);
        hybridMergeSort(arr, mid + 1, right, recursionStack);
        merge(arr, left, mid, right);
    }
}
```

## Debugging and Troubleshooting

### Common Issues
1. **Stack Overflow**: Deep recursion for large arrays
2. **Memory Issues**: Large temporary array allocation
3. **Index Errors**: Incorrect array bounds in merge
4. **Logic Errors**: Wrong merge implementation

### Debugging Techniques
1. **Recursion Tracking**: Use recursion stack for debugging
2. **Step-by-Step**: Trace merge process manually
3. **Array Visualization**: Display arrays before/after merge
4. **Performance Profiling**: Measure time and space usage
5. **Error Logging**: Add debug output for each step

### Debug Output Example
```java
public void debugMergeSort(int[] array) {
    System.out.println("=== Merge Sort Debug ===");
    System.out.println("Original array: " + Arrays.toString(array));
    
    Stack<Integer> recursionStack = new Stack<>();
    mergeSort(array, 0, array.length - 1, recursionStack);
    
    System.out.println("Sorted array: " + Arrays.toString(array));
    System.out.println("Recursion depth: " + recursionStack.size());
    System.out.println("Max stack size: " + getMaxStackSize(recursionStack));
}
```

## Real-World Applications

### Data Processing
- **Database Sorting**: Large dataset sorting
- **File Processing**: External file sorting
- **Data Analysis**: Sorting for statistical analysis
- **Report Generation**: Ordered data presentation

### Computer Science
- **Algorithm Education**: Teaching divide and conquer
- **Performance Analysis**: Benchmarking sorting algorithms
- **Data Structures**: Implementing priority queues
- **Operating Systems**: Process scheduling

### Software Engineering
- **Log Analysis**: Sorting log entries by timestamp
- **User Interfaces**: Sorting lists and tables
- **Search Optimization**: Pre-sorting for binary search
- **Data Compression**: Sorting for compression algorithms

## Conclusion

The `MergeSortAlgorithm.java` implementation provides a comprehensive demonstration of the merge sort algorithm with educational features and robust error handling. While the basic implementation has limitations, it effectively illustrates the divide-and-conquer paradigm and serves as an excellent foundation for understanding more advanced sorting algorithms and optimization techniques.

## Key Takeaways
- **Divide and Conquer**: Recursive splitting strategy
- **Time Complexity**: O(n log n) consistent performance
- **Space Complexity**: O(n) for temporary arrays
- **Stability**: Maintains relative order of equal elements
- **External Sorting**: Best for external sorting applications
- **Educational Value**: Foundation for understanding sorting algorithms
- **Performance**: Consistent regardless of input distribution
- **Memory Usage**: Higher memory usage but stable sorting

## Related Files
- **MergeSortAlgorithm.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **MergeSortAlgorithm_Documentation.md**: Algorithm documentation
- **merge_sort_algorithm_test_results.txt**: Generated test results
- **MergeSortAlgorithm_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Divide and Conquer**: Recursive splitting strategy
- **Time Complexity**: O(n log n) consistent performance
- **Space Complexity**: O(n) for temporary arrays
- **Stability**: Maintains relative order of equal elements
- **External Sorting**: Best for external sorting applications
- **Educational Value**: Foundation for understanding sorting algorithms
- **Performance**: Consistent regardless of input distribution
- **Memory Usage**: Higher memory usage but stable sorting
- **Algorithm Comparison**: Trade-offs with other sorting algorithms
- **Real-World Applications**: External sorting, stable sorting requirements

## Related Files
- **MergeSortAlgorithm.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **MergeSortAlgorithm_Documentation.md**: Algorithm documentation
- **merge_sort_algorithm_test_results.txt**: Generated test results
- **MergeSortAlgorithm_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Divide and Conquer**: Recursive splitting strategy
- **Time Complexity**: O(n log n) consistent performance
- **Space Complexity**: O(n) for temporary arrays
- **Stability**: Maintains relative order of equal elements
- **External Sorting**: Best for external sorting applications
- **Educational Value**: Foundation for understanding sorting algorithms
- **Performance**: Consistent regardless of input distribution
- **Memory Usage**: Higher memory usage but stable sorting
- **Algorithm Comparison**: Trade-offs with other sorting algorithms
- **Real-World Applications**: External sorting, stable sorting requirements

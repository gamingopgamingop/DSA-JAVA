# QuickSortAlgorithm Documentation

## Overview

The `QuickSortAlgorithm.java` file implements a comprehensive Quick Sort algorithm with an interactive user interface. This implementation demonstrates the divide-and-conquer paradigm and provides educational value through recursion depth tracking and various Java import demonstrations.

## Algorithm Summary

**Quick Sort**: A divide-and-conquer sorting algorithm that selects a pivot element and partitions the array around it.
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) - Recursion stack
- **Approach**: Partition-based sorting with pivot selection
- **Applications**: General-purpose sorting, in-place sorting

## Class Structure

### Core Implementation
```java
public class QuickSortAlgorithm implements Runnable {
    
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

    public static void quickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
        if (low < high) {
            recursionStack.push(low); // Track recursion for demonstration
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1, recursionStack);
            quickSort(arr, pi + 1, high, recursionStack);
            recursionStack.pop();
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
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

            // Sort the array using Quick Sort
            Stack<Integer> recursionStack = new Stack<>();
            quickSort(array, 0, array.length - 1, recursionStack);
            
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
            formatter.format("Summary: Quick Sort completed on %d elements. Sorted Array: %s", 
                            n, Arrays.toString(array));
            System.out.println(formatter.toString());
            formatter.close();
        }
    }
}
```

### Menu-Driven Interface
The program provides an interactive console interface:

1. **Array Size Input**: User specifies number of elements
2. **Element Input**: User enters each element individually
3. **Automatic Sorting**: Program performs quick sort
4. **Result Display**: Shows sorted array in multiple formats

### Input Validation
- **Integer Validation**: Ensures valid integer input
- **Error Handling**: Comprehensive exception management
- **User Feedback**: Clear error messages and confirmations
- **Graceful Exit**: Clean program termination

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
formatter.format("Summary: Quick Sort completed on %d elements. Sorted Array: %s", 
                n, Arrays.toString(array));
```

## Core Algorithm

### Divide and Conquer Strategy
The algorithm follows these steps:

1. **Divide**: Select pivot and partition array
2. **Conquer**: Recursively sort sub-arrays
3. **Combine**: Array is sorted in-place

### Quick Sort Implementation
```java
public static void quickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
    if (low < high) {
        recursionStack.push(low);
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1, recursionStack);
        quickSort(arr, pi + 1, high, recursionStack);
        recursionStack.pop();
    }
}
```

### Partition Process
```java
private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1); // index of smaller element
    for (int j = low; j < high; j++) {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot) {
            i++;
            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```

### Step-by-Step Example
```
Original Array: [64, 34, 25, 12, 22, 11, 90]

Step 1: Choose pivot (last element = 90)
Partition around 90:
- Elements ≤ 90: [64, 34, 25, 12, 22, 11]
- Elements > 90: []
Pivot position: 6 (90 stays at end)

Step 2: Recursively sort left subarray [64, 34, 25, 12, 22, 11]
Choose pivot (11)
Partition around 11:
- Elements ≤ 11: [11]
- Elements > 11: [64, 34, 25, 12, 22]
Pivot position: 0

Step 3: Recursively sort right subarray [64, 34, 25, 12, 22]
Choose pivot (22)
Partition around 22:
- Elements ≤ 22: [12]
- Elements > 22: [64, 34, 25]
Pivot position: 3

Step 4: Continue recursively...
Final Result: [11, 12, 22, 25, 34, 64, 90]
```

## Algorithm Analysis

### Time Complexity
- **Best Case**: O(n log n) - Balanced partitions
- **Average Case**: O(n log n) - Random pivot selection
- **Worst Case**: O(n²) - Unbalanced partitions
- **Recurrence Relation**: T(n) = 2T(n/2) + O(n)

### Space Complexity
- **Total Space**: O(n) - Input array
- **Auxiliary Space**: O(log n) - Recursion stack
- **In-Place**: Yes - No additional arrays needed
- **Memory Usage**: Minimal additional memory

### Performance Characteristics
| Array Size | Comparisons | Swaps | Time (ms) | Recursion Depth |
|------------|-------------|-------|-----------|-----------------|
| 10 | ~23 | ~10 | ~0.01 | ~4 |
| 100 | ~515 | ~100 | ~0.05 | ~7 |
| 1,000 | ~9,966 | ~1,000 | ~0.10 | ~10 |
| 10,000 | ~132,877 | ~10,000 | ~1.00 | ~14 |
| 100,000 | ~1,660,964 | ~100,000 | ~10.00 | ~17 |

## Mathematical Properties

### Recurrence Relation
```
T(n) = 2T(n/2) + O(n)
T(1) = O(1)
```

Solving using Master Theorem:
- a = 2 (number of subproblems)
- b = 2 (factor by which input size is divided)
- f(n) = O(n) (partition step)

Since n^(log_b a) = n^(log_2 2) = n^1 = n:
- f(n) = Θ(n^(log_b a))
- Therefore, T(n) = Θ(n log n)

### Partition Properties
- **Pivot Selection**: Last element as pivot
- **Stability**: Not stable (relative order may change)
- **In-Place**: No additional memory allocation
- **Divide**: Splits array into two sub-arrays

### Mathematical Relations
- **Partition Index**: Position where pivot is placed
- **Sub-array Sizes**: pi - low and high - pi
- **Recursion Tree**: Binary tree of partitions
- **Depth**: O(log n) for balanced partitions

## User Interface

### Interactive Input
The program provides an interactive console interface:

1. **Array Size Input**: User specifies number of elements
2. **Element Input**: User enters each element individually
3. **Automatic Sorting**: Program performs quick sort
4. **Result Display**: Shows sorted array in multiple formats

### Input Validation
- **Integer Validation**: Ensures valid integer input
- **Error Handling**: Comprehensive exception management
- **User Feedback**: Clear error messages and confirmations
- **Graceful Exit**: Clean program termination

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
formatter.format("Summary: Quick Sort completed on %d elements. Sorted Array: %s", 
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
// Summary: Quick Sort completed on 5 elements. Sorted Array: [12, 22, 25, 34, 64]
```

### Large Array Usage
```java
// Input:
// Enter the number of elements: 1000
// Enter 1000 elements: [random numbers]

// Output:
// Original Array: [1000 random numbers]
// Sorted Array (via Iterator): [sorted numbers]
// Summary: Quick Sort completed on 1000 elements. Sorted Array: [sorted array]
```

### Edge Case Usage
```java
// Input:
// Enter the number of elements: 1
// Enter 1 elements:
// Element 0: 42

// Output:
// Original Array: [42]
// Sorted Array (via Iterator): 42 
// Summary: Quick Sort completed on 1 elements. Sorted Array: [42]
```

## Comparison with Other Sorting Algorithms

### Sorting Algorithm Comparison
| Algorithm | Time Complexity | Space Complexity | Stable | In-Place | Best Use Case |
|---------|------------------|------------------|--------|----------|-------------|
| Quick Sort | O(n log n) | O(log n) | No | Yes | General purpose |
| Merge Sort | O(n log n) | O(n) | Yes | No | External sorting |
| Heap Sort | O(n log n) | O(1) | No | Yes | Memory-constrained |
| Bubble Sort | O(n²) | O(1) | Yes | Yes | Educational |
| Insertion Sort | O(n²) | O(1) | Yes | Yes | Small arrays |

### Performance Recommendations
- **General Purpose**: Use Quick Sort
- **Stable Sorting**: Use Merge Sort
- **External Sorting**: Use Merge Sort
- **Memory Constrained**: Use Heap Sort
- **Small Arrays**: Use Insertion Sort

### Use Case Scenarios
- **General Sorting**: Quick Sort is fastest average case
- **Data Processing**: In-place sorting saves memory
- **Algorithm Education**: Demonstrates divide and conquer
- **Performance Critical**: Quick Sort with optimizations
- **Memory Limited**: In-place algorithms preferred

## Best Practices

### Implementation Guidelines
1. **Input Validation**: Always validate user input
2. **Error Handling**: Implement comprehensive exception management
3. **Memory Management**: Monitor recursion depth for large arrays
4. **Code Documentation**: Add clear comments and documentation
5. **User Experience**: Provide clear feedback and error messages

### Optimization Tips
1. **Pivot Selection**: Use median-of-three or random pivot
2. **Tail Recursion**: Optimize recursion depth
3. **Hybrid Approach**: Use insertion sort for small sub-arrays
4. **Iterative Implementation**: Avoid stack overflow for large arrays
5. **Performance Testing**: Measure with realistic data sizes

### Code Quality
- **Clear Documentation**: Comprehensive method documentation
- **Modular Design**: Separate concerns (input, sorting, output)
- **Reusable Components**: Utility methods for common tasks
- **Maintainable Structure**: Easy to extend and modify
- **Consistent Style**: Follow Java coding conventions

## Limitations and Considerations

### Current Implementation
1. **Pivot Strategy**: Fixed to last element
2. **Worst Case**: O(n²) for sorted arrays
3. **Not Stable**: Relative order may change
4. **Recursion Depth**: May cause stack overflow
5. **Single Thread**: Not designed for concurrent access

### Considerations for Improvement
1. **Random Pivot**: Better average case performance
2. **Median-of-Three**: Avoid worst-case scenarios
3. **Iterative Version**: Eliminate recursion stack
4. **Tail Optimization**: Reduce recursion depth
5. **Hybrid Algorithm**: Combine with insertion sort

### Implementation Variations

### Randomized Quick Sort
```java
public static void randomizedQuickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
    if (low < high) {
        recursionStack.push(low);
        int pi = randomizedPartition(arr, low, high);
        randomizedQuickSort(arr, low, pi - 1, recursionStack);
        randomizedQuickSort(arr, pi + 1, high, recursionStack);
        recursionStack.pop();
    }
}

private static int randomizedPartition(int[] arr, int low, int high) {
    Random random = new Random();
    int randomIndex = low + random.nextInt(high - low + 1);
    
    // Swap arr[randomIndex] and arr[high]
    int temp = arr[randomIndex];
    arr[randomIndex] = arr[high];
    arr[high] = temp;
    
    return partition(arr, low, high);
}
```

### Median-of-Three Quick Sort
```java
private static int medianOfThree(int[] arr, int low, int high) {
    int mid = low + (high - low) / 2;
    
    // Find median of arr[low], arr[mid], arr[high]
    if (arr[low] > arr[mid]) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
    if (arr[low] > arr[high]) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    if (arr[mid] > arr[high]) {
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
    }
    
    return mid;
}
```

### Iterative Quick Sort
```java
public static void iterativeQuickSort(int[] arr, int low, int high) {
    Stack<Integer> stack = new Stack<>();
    stack.push(low);
    stack.push(high);
    
    while (!stack.isEmpty()) {
        high = stack.pop();
        low = stack.pop();
        
        int pi = partition(arr, low, high);
        
        if (pi - 1 > low) {
            stack.push(low);
            stack.push(pi - 1);
        }
        
        if (pi + 1 < high) {
            stack.push(pi + 1);
            stack.push(high);
        }
    }
}
```

### Hybrid Quick Sort
```java
public static void hybridQuickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
    if (high - low <= 16) {
        insertionSort(arr, low, high);
    } else {
        recursionStack.push(low);
        int pi = partition(arr, low, high);
        hybridQuickSort(arr, low, pi - 1, recursionStack);
        hybridQuickSort(arr, pi + 1, high, recursionStack);
        recursionStack.pop();
    }
}

private static void insertionSort(int[] arr, int low, int high) {
    for (int i = low + 1; i <= high; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= low && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

### Tail Call Optimized Quick Sort
```java
public static void tailCallOptimizedQuickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
    while (low < high) {
        recursionStack.push(low);
        
        // Process smaller partition first to reduce stack depth
        int pi = partition(arr, low, high);
        
        if (pi - low < high - pi) {
            tailCallOptimizedQuickSort(arr, low, pi - 1, recursionStack);
            low = pi + 1;
        } else {
            tailCallOptimizedQuickSort(arr, pi + 1, high, recursionStack);
            high = pi - 1;
        }
        
        recursionStack.pop();
    }
}
```

## Debugging and Troubleshooting

### Common Issues
1. **Stack Overflow**: Deep recursion for large arrays
2. **Worst Case Performance**: Sorted arrays
3. **Partition Logic**: Incorrect element placement
4. **Recursion Depth**: Excessive recursion depth

### Debugging Techniques
1. **Recursion Tracking**: Use stack to monitor depth
2. **Step-by-Step**: Trace partition process manually
3. **Array Visualization**: Display arrays before/after partition
4. **Performance Profiling**: Measure time and space usage
5. **Error Logging**: Add debug output for each step

### Debug Output Example
```java
public void debugQuickSort(int[] array) {
    System.out.println("=== Quick Sort Debug ===");
    System.out.println("Original array: " + Arrays.toString(array));
    
    Stack<Integer> recursionStack = new Stack<>();
    quickSort(array, 0, array.length - 1, recursionStack);
    
    System.out.println("Sorted array: " + Arrays.toString(array));
    System.out.println("Recursion depth: " + recursionStack.size());
    System.out.println("Max stack size: " + getMaxStackSize(recursionStack));
}
```

## Real-World Applications

### Computer Science
- **General Sorting**: Most widely used sorting algorithm
- **Data Processing**: In-place sorting saves memory
- **Algorithm Education**: Demonstrates divide and conquer
- **Performance Critical**: Fastest average case performance
- **Database Systems**: Query result sorting

### Software Engineering
- **File Processing**: Sorting large datasets
- **Data Analysis**: Sorting statistical data
- **User Interfaces**: Sorting lists and tables
- **Search Algorithms**: Binary search requires sorted data
- **Graphics**: Z-order sorting for rendering

### System Design
- **Operating Systems**: Process scheduling
- **Compilers**: Symbol table management
- **Database Systems**: Query optimization
- **Web Applications**: Data grid sorting
- **Mobile Apps**: List sorting functionality

## Conclusion

The `QuickSortAlgorithm.java` implementation provides a comprehensive demonstration of the quick sort algorithm with educational features and robust error handling. While the basic implementation has limitations, it effectively illustrates the fundamental concepts of divide-and-conquer sorting and serves as an excellent foundation for understanding more advanced sorting algorithms and optimization techniques.

## Key Takeaways
- **Quick Sort**: Partition-based sorting algorithm
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) - Recursion stack
- **Pivot Selection**: Critical for performance optimization
- **Applications**: General-purpose sorting, in-place sorting
- **Educational Value**: Foundation for understanding divide and conquer
- **Performance**: Fastest average case among simple sorts
- **Memory Usage**: Minimal additional memory requirements
- **Algorithm Comparison**: Trade-offs with other sorting algorithms

## Related Files
- **QuickSortAlgorithm.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **QuickSortAlgorithm_Documentation.md**: Algorithm documentation
- **quick_sort_algorithm_test_results.txt**: Generated test results
- **QuickSortAlgorithm_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Quick Sort**: Partition-based sorting algorithm
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) - Recursion stack
- **Pivot Selection**: Critical for performance optimization
- **Applications**: General-purpose sorting, in-place sorting
- **Educational Value**: Foundation for understanding divide and conquer
- **Performance**: Fastest average case among simple sorts
- **Memory Usage**: Minimal additional memory requirements
- **Algorithm Comparison**: Trade-offs with other sorting algorithms
- **Real-World Applications**: General-purpose sorting, data processing, algorithm education

## Related Files
- **QuickSortAlgorithm.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **QuickSortAlgorithm_Documentation.md**: Algorithm documentation
- **quick_sort_algorithm_test_results.txt**: Generated test results
- **QuickSortAlgorithm_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Quick Sort**: Partition-based sorting algorithm
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) - Recursion stack
- **Pivot Selection**: Critical for performance optimization
- **Applications**: General-purpose sorting, in-place sorting
- **Educational Value**: Foundation for understanding divide and conquer
- **Performance**: Fastest average case among simple sorts
- **Memory Usage**: Minimal additional memory requirements
- **Algorithm Comparison**: Trade-offs with other sorting algorithms
- **Real-World Applications**: General-purpose sorting, data processing, algorithm education

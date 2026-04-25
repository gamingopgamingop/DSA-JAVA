# SmallestLargest.java - Documentation

## Overview
This Java program finds the smallest and largest elements in an array with comprehensive demonstrations of all Java imports. It provides efficient algorithms for finding extremal values while showcasing extensive Java API usage, functional programming, and modern Java features.

## Algorithm Logic

### Finding Smallest and Largest Elements
The program implements efficient algorithms to find the minimum and maximum values in an array through a single pass, demonstrating optimal O(n) time complexity.

#### Core Algorithm
```java
public static void findSmallestLargest(int[] arr) {
    if (arr == null || arr.length == 0) {
        System.out.println("Array is empty.");
        return;
    }
    
    int smallest = arr[0];
    int largest = arr[0];
    
    // Single pass to find both smallest and largest
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < smallest) {
            smallest = arr[i];
        } else if (arr[i] > largest) {
            largest = arr[i];
        }
    }
    
    System.out.println("Smallest: " + smallest);
    System.out.println("Largest: " + largest);
}
```

#### Time Complexity
- **Single Pass Algorithm**: O(n) - one traversal through the array
- **Space Complexity**: O(1) - constant extra space
- **Optimal**: Cannot be better than O(n) for unsorted data

### Key Features

#### 1. Efficient Algorithm
- Single pass through array
- Simultaneous min/max finding
- Optimal time complexity

#### 2. Comprehensive Import Usage
- All 63 specified imports are actively used
- Demonstrates real-world applications of various Java APIs
- Educational value through practical examples

#### 3. Multiple Approaches
- Traditional loop-based approach
- Java Collections framework approach
- Functional programming approach
- Stream API approach

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Smallest element: {0}", smallest)
  ```
- **DecimalFormat**: Pattern-based decimal formatting
  ```java
  DecimalFormat("#,###.##").format(3.14159265359)
  ```
- **SimpleDateFormat**: Date and time formatting
  ```java
  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
  ```

### Collections Framework (`java.util.*`)
- **List Interface**: Ordered collections with duplicates
  ```java
  List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
  Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
  LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));
  ```
- **Stack Class**: LIFO data structure
  ```java
  Stack<Integer> stack = new Stack<>();
  stack.push(1); stack.push(2); stack.push(3);
  ```
- **Queue Interface**: FIFO collections
  ```java
  Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));
  ```

### Set Implementations
```java
Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
Set<Thread.State> enumSet = EnumSet.noneOf(Thread.State.class);
```

### Map Implementations
```java
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
Hashtable<String, Integer> hashtable = new Hashtable<>();
SortedMap<String, Integer> sortedMap = new TreeMap<>();
NavigableMap<String, Integer> navigableMap = new TreeMap<>();
```

### Functional Programming (`java.util.function.*`)
- **Consumer<T>**: Accepts input, performs action
  ```java
  Consumer<String> printer = str -> System.out.println("Consumer: " + str);
  ```
- **Predicate<T>**: Boolean-valued function
  ```java
  Predicate<Integer> isEven = num -> num % 2 == 0;
  ```
- **Function<T,R>**: Input-output transformation
  ```java
  Function<String, Integer> stringLength = String::length;
  ```
- **Supplier<T>**: Value provider
  ```java
  Supplier<Double> randomSupplier = () -> new Random().nextDouble();
  ```

### Primitive Functional Interfaces
```java
IntUnaryOperator square = x -> x * x;
IntBinaryOperator multiply = (a, b) -> a * b;
IntPredicate isPositive = x -> x > 0;
IntConsumer printInt = x -> System.out.println("Int: " + x);
IntFunction<String> intToString = Integer::toString;
```

### I/O Operations (`java.io.*`)
- **PrintStream**: Buffered output stream
  ```java
  PrintStream printStream = new PrintStream(new BufferedOutputStream(
      new FileOutputStream("smallest_largest_demo.txt")), true);
  ```
- **FileOutputStream**: File-based output
- **IOException**: I/O exception hierarchy
- **StreamTokenizer**: Tokenizes input streams

### Character Encoding (`java.nio.charset.*`)
- **StandardCharsets**: Standard charset constants
  ```java
  byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
  ```

### Desktop Integration (`java.awt.*`)
- **Desktop**: System integration operations
  ```java
  if (Desktop.isDesktopSupported()) {
      Desktop desktop = Desktop.getDesktop();
      System.out.println("Desktop operations supported: " + 
          desktop.isSupported(Desktop.Action.BROWSE));
  }
  ```
- **PrinterJob**: Print job control
- **PageFormat**: Page layout configuration
- **Book**: Multi-page document container

## Demonstration Methods

### `demonstrateAllImports()`
Comprehensive demonstration covering all imports:

#### Multiple Algorithm Approaches
```java
// Traditional approach
public static void findMinMaxTraditional(int[] arr) {
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < min) min = arr[i];
        if (arr[i] > max) max = arr[i];
    }
    System.out.println("Traditional - Min: " + min + ", Max: " + max);
}

// Collections approach
public static void findMinMaxCollections(int[] arr) {
    List<Integer> list = Arrays.stream(arr).boxed().toList();
    int min = Collections.min(list);
    int max = Collections.max(list);
    System.out.println("Collections - Min: " + min + ", Max: " + max);
}

// Stream approach
public static void findMinMaxStream(int[] arr) {
    IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
    System.out.println("Stream - Min: " + stats.getMin() + ", Max: " + stats.getMax());
}
```

#### Functional Programming Examples
```java
// Using functional interfaces for min/max finding
public static void findMinMaxFunctional(int[] arr) {
    List<Integer> list = Arrays.stream(arr).boxed().toList();
    
    // Using reduce for min
    Optional<Integer> min = list.stream().reduce(Integer::min);
    
    // Using reduce for max
    Optional<Integer> max = list.stream().reduce(Integer::max);
    
    System.out.println("Functional - Min: " + min.orElse(0) + ", Max: " + max.orElse(0));
}

// Using custom comparator
public static void findMinMaxWithComparator(int[] arr) {
    List<Integer> list = Arrays.stream(arr).boxed().toList();
    
    Comparator<Integer> naturalOrder = Comparator.naturalOrder();
    int min = list.stream().min(naturalOrder).orElse(0);
    int max = list.stream().max(naturalOrder).orElse(0);
    
    System.out.println("Comparator - Min: " + min + ", Max: " + max);
}
```

#### Collection Framework Integration
```java
// Using different collection types for min/max
public static void demonstrateCollectionsMinMax(int[] arr) {
    // ArrayList
    List<Integer> arrayList = new ArrayList<>(Arrays.stream(arr).boxed().toList());
    System.out.println("ArrayList - Min: " + Collections.min(arrayList) + 
                      ", Max: " + Collections.max(arrayList));
    
    // TreeSet (automatically sorted)
    Set<Integer> treeSet = new TreeSet<>(Arrays.stream(arr).boxed().toList());
    System.out.println("TreeSet - Min: " + treeSet.first() + 
                      ", Max: " + treeSet.last());
    
    // Priority Queue (min-heap)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.stream(arr).boxed().toList());
    System.out.println("PriorityQueue (Min) - Min: " + minHeap.peek());
    
    // Priority Queue (max-heap)
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    maxHeap.addAll(Arrays.stream(arr).boxed().toList());
    System.out.println("PriorityQueue (Max) - Max: " + maxHeap.peek());
}
```

## Advanced Algorithms

### Find Kth Smallest and Largest
```java
public static void findKthSmallestLargest(int[] arr, int k) {
    if (k <= 0 || k > arr.length) {
        System.out.println("Invalid k value: " + k);
        return;
    }
    
    // Sort and find kth elements
    int[] sorted = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sorted);
    
    System.out.println(k + "th smallest: " + sorted[k-1]);
    System.out.println(k + "th largest: " + sorted[arr.length-k]);
}
```

### Find Second Smallest and Largest
```java
public static void findSecondSmallestLargest(int[] arr) {
    if (arr.length < 2) {
        System.out.println("Array must have at least 2 elements");
        return;
    }
    
    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    for (int num : arr) {
        // Find smallest and second smallest
        if (num < smallest) {
            secondSmallest = smallest;
            smallest = num;
        } else if (num < secondSmallest && num != smallest) {
            secondSmallest = num;
        }
        
        // Find largest and second largest
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num > secondLargest && num != largest) {
            secondLargest = num;
        }
    }
    
    System.out.println("Second smallest: " + secondSmallest);
    System.out.println("Second largest: " + secondLargest);
}
```

### Range Analysis
```java
public static void analyzeRange(int[] arr) {
    if (arr == null || arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    int min = arr[0];
    int max = arr[0];
    int sum = 0;
    
    for (int num : arr) {
        if (num < min) min = num;
        if (num > max) max = num;
        sum += num;
    }
    
    double average = (double) sum / arr.length;
    int range = max - min;
    
    System.out.println("Range Analysis:");
    System.out.println("Minimum: " + min);
    System.out.println("Maximum: " + max);
    System.out.println("Range: " + range);
    System.out.println("Average: " + average);
    System.out.println("Sum: " + sum);
}
```

### Statistical Analysis
```java
public static void statisticalAnalysis(int[] arr) {
    if (arr == null || arr.length == 0) return;
    
    // Basic statistics
    IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
    
    // Additional statistics
    double variance = Arrays.stream(arr)
        .mapToDouble(x -> Math.pow(x - stats.getAverage(), 2))
        .average()
        .orElse(0.0);
    
    double stdDeviation = Math.sqrt(variance);
    
    // Median
    int[] sorted = Arrays.stream(arr).sorted().toArray();
    double median;
    if (sorted.length % 2 == 0) {
        median = (sorted[sorted.length/2 - 1] + sorted[sorted.length/2]) / 2.0;
    } else {
        median = sorted[sorted.length/2];
    }
    
    System.out.println("Statistical Analysis:");
    System.out.println("Count: " + stats.getCount());
    System.out.println("Min: " + stats.getMin());
    System.out.println("Max: " + stats.getMax());
    System.out.println("Average: " + stats.getAverage());
    System.out.println("Sum: " + stats.getSum());
    System.out.println("Median: " + median);
    System.out.println("Variance: " + variance);
    System.out.println("Std Deviation: " + stdDeviation);
}
```

## Performance Analysis

### Algorithm Comparison
| Approach | Time Complexity | Space Complexity | Best For |
|----------|------------------|------------------|----------|
| Single Pass | O(n) | O(1) | General purpose |
| Sort + Index | O(n log n) | O(1) | Multiple queries |
| Collections.min/max | O(n) | O(n) | Integration with collections |
| Stream API | O(n) | O(1) | Functional programming |
| Priority Queue | O(n log n) | O(n) | Dynamic min/max |

### Optimization Techniques
```java
// Early termination for sorted arrays
public static void findMinMaxSorted(int[] arr) {
    if (isSorted(arr)) {
        System.out.println("Sorted array - Min: " + arr[0] + ", Max: " + arr[arr.length-1]);
        return;
    }
    // Use standard algorithm for unsorted
    findSmallestLargest(arr);
}

// Parallel processing for large arrays
public static void findMinMaxParallel(int[] arr) {
    if (arr.length < 10000) {
        findSmallestLargest(arr);
        return;
    }
    
    IntSummaryStatistics stats = Arrays.stream(arr).parallel().summaryStatistics();
    System.out.println("Parallel - Min: " + stats.getMin() + ", Max: " + stats.getMax());
}
```

## Usage Examples

### Basic Usage
```java
int[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};

// Find smallest and largest
findSmallestLargest(numbers);

// Find second smallest and largest
findSecondSmallestLargest(numbers);

// Find kth elements
findKthSmallestLargest(numbers, 3);
```

### Advanced Usage
```java
// Statistical analysis
statisticalAnalysis(numbers);

// Range analysis
analyzeRange(numbers);

// Different approaches
findMinMaxTraditional(numbers);
findMinMaxCollections(numbers);
findMinMaxStream(numbers);
findMinMaxFunctional(numbers);
```

### Collection Integration
```java
// Convert to collections and use their methods
List<Integer> list = Arrays.stream(numbers).boxed().toList();

// Use Collections utility
int min = Collections.min(list);
int max = Collections.max(list);

// Use TreeSet for automatic sorting
Set<Integer> sortedSet = new TreeSet<>(list);
int treeMin = sortedSet.first();
int treeMax = sortedSet.last();
```

## Error Handling

### Input Validation
```java
public static void validateArray(int[] arr) {
    if (arr == null) {
        throw new IllegalArgumentException("Array cannot be null");
    }
    if (arr.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty");
    }
}

public static void validateK(int k, int arrayLength) {
    if (k <= 0) {
        throw new IllegalArgumentException("k must be positive");
    }
    if (k > arrayLength) {
        throw new IllegalArgumentException("k cannot be larger than array length");
    }
}
```

### Exception Handling
```java
public static void safeFindMinMax(int[] arr) {
    try {
        validateArray(arr);
        findSmallestLargest(arr);
    } catch (IllegalArgumentException e) {
        System.err.println("Validation error: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
    }
}
```

## Learning Outcomes

After studying this code, you will understand:

1. **Algorithm Optimization**: Single-pass vs. multiple-pass approaches
2. **Java Collections**: Integration with standard collections
3. **Functional Programming**: Modern Java features for data processing
4. **Performance Analysis**: Time and space complexity considerations
5. **Statistical Analysis**: Basic statistical computations
6. **Error Handling**: Robust validation and exception management
7. **API Usage**: Comprehensive Java API demonstration
8. **Algorithm Design**: Multiple approaches to the same problem

## Compilation and Execution

```bash
javac SmallestLargest.java
java SmallestLargest
```

The program will:
1. Demonstrate all Java imports with examples
2. Show multiple algorithm approaches
3. Provide comprehensive statistical analysis
4. Handle various input scenarios
5. Save results to file

## Extensions and Applications

### Possible Enhancements
1. **Generic Implementation**: Support any comparable type
2. **Multiple Queries**: Efficient handling of multiple min/max queries
3. **Window Operations**: Find min/max in sliding windows
4. **Performance Benchmarking**: Compare different approaches
5. **GUI Interface**: Visual representation of results
6. **Data Visualization**: Charts and graphs for statistical analysis

### Real-World Applications
1. **Data Analysis**: Finding outliers and extremes in datasets
2. **Quality Control**: Monitoring min/max values in processes
3. **Financial Analysis**: Stock price extremes
4. **Sensor Data**: Temperature/pressure monitoring
5. **Game Development**: Score tracking and leaderboards
6. **Scientific Computing**: Experimental data analysis

### Advanced Implementations
```java
// Generic min/max finder
public class MinMaxFinder<T extends Comparable<T>> {
    public MinMax<T> findMinMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
        T min = list.get(0);
        T max = list.get(0);
        
        for (T item : list) {
            if (item.compareTo(min) < 0) min = item;
            if (item.compareTo(max) > 0) max = item;
        }
        
        return new MinMax<>(min, max);
    }
}

// MinMax value holder
public class MinMax<T> {
    private final T min;
    private final T max;
    
    public MinMax(T min, T max) {
        this.min = min;
        this.max = max;
    }
    
    public T getMin() { return min; }
    public T getMax() { return max; }
}

// Sliding window min/max
public static class SlidingWindowMinMax {
    public static int[] slidingWindowMin(int[] arr, int k) {
        // Implementation using deque
        // O(n) time complexity
        return new int[0]; // Placeholder
    }
}
```

## Best Practices Demonstrated

1. **Algorithm Optimization**: Single-pass approach for efficiency
2. **Multiple Approaches**: Different solutions for different scenarios
3. **Input Validation**: Comprehensive error checking
4. **Code Documentation**: Extensive method documentation
5. **Performance Analysis**: Complexity considerations
6. **API Integration**: Comprehensive Java API usage
7. **Testing**: Multiple test cases and scenarios
8. **Modular Design**: Separation of concerns

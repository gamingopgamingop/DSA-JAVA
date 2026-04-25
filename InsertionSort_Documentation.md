# InsertionSort.java - Documentation

## Overview
This Java program implements the Insertion Sort algorithm with comprehensive demonstrations of all Java imports. It provides a complete sorting implementation along with extensive examples of Java collections, functional interfaces, and utility classes.

## Algorithm Logic

### Insertion Sort Algorithm
Insertion Sort builds the final sorted array one item at a time. It's much like the way you would sort playing cards in your hands. The algorithm iterates through the input elements and inserts each element into its proper position in the sorted portion of the array.

#### Time Complexity: O(n²)
#### Space Complexity: O(1)

### Core Algorithm
```java
for (int i = 1; i < n; i++) {
    int key = arr[i];
    int j = i - 1;
    
    // Move elements of arr[0..i-1] that are greater than key
    // to one position ahead of their current position
    while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
    }
    arr[j + 1] = key;
}
```

### Key Features

#### 1. Adaptive Algorithm
- **Best Case**: O(n) when array is already sorted
- **Worst Case**: O(n²) when array is reverse sorted
- **Average Case**: O(n²) for random data
- **Online Algorithm**: Can sort as it receives data

#### 2. Stable Sorting
- Maintains relative order of equal elements
- Important for multi-key sorting scenarios

#### 3. In-Place Sorting
- Requires only O(1) additional space
- No auxiliary arrays needed

### Demonstration Methods

#### `demonstrateAllImports()`
Comprehensive demonstration covering all 63 imports:

##### Collections Framework Usage
```java
// List implementations
List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));

// Stack operations
Stack<Integer> stack = new Stack<>();
stack.push(1); stack.push(2); stack.push(3);

// Queue implementations
Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));
```

##### Set Implementations
```java
Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
Set<Thread.State> enumSet = EnumSet.noneOf(Thread.State.class);
```

##### Map Implementations
```java
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
Hashtable<String, Integer> hashtable = new Hashtable<>();
SortedMap<String, Integer> sortedMap = new TreeMap<>();
NavigableMap<String, Integer> navigableMap = new TreeMap<>();
```

##### Functional Interfaces Demonstration
```java
// Object-based functional interfaces
Consumer<String> printer = str -> System.out.println("Consumer: " + str);
Predicate<Integer> isEven = num -> num % 2 == 0;
Function<String, Integer> stringLength = String::length;
Supplier<Double> randomSupplier = () -> new Random().nextDouble();

// Primitive functional interfaces
IntUnaryOperator square = x -> x * x;
IntBinaryOperator multiply = (a, b) -> a * b;
IntPredicate isPositive = x -> x > 0;
IntConsumer printInt = x -> System.out.println("Int: " + x);
IntFunction<String> intToString = Integer::toString;
```

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Enter {0} array elements:", size)
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
  - **ArrayList**: Resizable array implementation
  - **Vector**: Thread-safe legacy implementation
  - **LinkedList**: Doubly-linked list implementation

- **Stack Class**: LIFO data structure
  ```java
  Stack<Integer> stack = new Stack<>();
  stack.push(element);
  int top = stack.pop();
  ```

- **Queue Interface**: FIFO collections
  - **ArrayDeque**: Array-based deque implementation
  - **PriorityQueue**: Heap-based priority queue

- **Set Interface**: Collections with unique elements
  - **HashSet**: Hash-based implementation
  - **LinkedHashSet**: Maintains insertion order
  - **TreeSet**: Sorted implementation
  - **EnumSet**: Optimized for enum types

- **Map Interface**: Key-value pair collections
  - **HashMap**: Hash-based implementation
  - **LinkedHashMap**: Maintains insertion order
  - **TreeMap**: Sorted implementation
  - **Hashtable**: Thread-safe legacy implementation

### Functional Programming (`java.util.function.*`)
- **Consumer<T>**: Accepts input, performs action
- **Predicate<T>**: Boolean-valued function
- **Function<T,R>**: Input-output transformation
- **Supplier<T>**: Value provider
- **Primitive Specializations**: Performance-optimized primitive versions

### I/O Operations (`java.io.*`)
- **PrintStream**: Buffered output stream
- **PrintWriter**: Character output with formatting
- **BufferedOutputStream**: Buffered binary output
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
- **PrinterException**: Printing-related exceptions
- **PrinterJob**: Print job control
- **PageFormat**: Page layout configuration
- **Book**: Multi-page document container

## Algorithm Analysis

### Insertion Sort Characteristics

#### Advantages
1. **Simple Implementation**: Easy to understand and code
2. **Adaptive**: Efficient for nearly sorted data (O(n) best case)
3. **Stable**: Maintains relative order of equal elements
4. **Online**: Can sort as it receives data
5. **Space Efficient**: O(1) auxiliary space
6. **Low Overhead**: Minimal constant factors

#### Disadvantages
1. **Time Complexity**: O(n²) for random data
2. **Inefficient**: Poor performance on large datasets
3. **Many Shifts**: Requires shifting elements

#### Performance Analysis
- **Comparisons**: 
  - Best Case: n-1
  - Average Case: n(n-1)/4
  - Worst Case: n(n-1)/2
- **Swaps/Moves**: 
  - Best Case: 0
  - Average Case: n(n-1)/4
  - Worst Case: n(n-1)/2

### Usage Examples

#### Basic Insertion Sort
```java
public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        
        // Move elements greater than key one position ahead
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
```

#### Binary Insertion Sort (Optimized)
```java
public static void binaryInsertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = Math.abs(Arrays.binarySearch(arr, 0, i, key) + 1);
        
        System.arraycopy(arr, j, arr, j + 1, i - j);
        arr[j] = key;
    }
}
```

#### Collection Operations
```java
// Using collections with insertion sort principles
List<Integer> list = new ArrayList<>();
for (int element : unsortedArray) {
    // Find insertion position
    int position = 0;
    while (position < list.size() && list.get(position) < element) {
        position++;
    }
    list.add(position, element);
}
```

#### Functional Programming Approach
```java
// Functional style insertion sort
public static List<Integer> functionalInsertionSort(List<Integer> list) {
    return list.stream().reduce(new ArrayList<>(), (sorted, element) -> {
        int index = IntStream.range(0, sorted.size())
            .filter(i -> sorted.get(i) > element)
            .findFirst()
            .orElse(sorted.size());
        sorted.add(index, element);
        return sorted;
    });
}
```

#### File I/O Integration
```java
// Save sorting process to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("insertion_sort_log.txt")), true)) {
    
    writer.println("Insertion Sort Process Log");
    writer.println("Original array: " + Arrays.toString(originalArray));
    
    // Log each insertion step
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        writer.printf("Step %d: Inserting %d%n", i, key);
        // ... sorting logic with logging
    }
    
    writer.println("Final array: " + Arrays.toString(sortedArray));
} catch (IOException e) {
    System.err.println("Error writing log: " + e.getMessage());
}
```

## Error Handling

### Input Validation
```java
// Validate array size
if (size <= 0) {
    System.out.println("Array size must be positive.");
    return;
}

// Handle invalid input gracefully
try {
    int element = scanner.nextInt();
    // Process element
} catch (InputMismatchException e) {
    System.err.println("Error: Please enter valid integers.");
    scanner.next(); // Clear invalid input
}
```

### Exception Handling Patterns
```java
// File operations with proper resource management
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("output.txt")), true)) {
    // File operations
} catch (IOException e) {
    System.err.println("I/O Error: " + e.getMessage());
}

// Desktop operations with fallback
try {
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        // Desktop operations
    }
} catch (Exception e) {
    System.out.println("Desktop operations not available");
}
```

## Optimization Techniques

### Standard Optimizations
1. **Binary Search**: Use binary search to find insertion position
2. **Sentinel Values**: Eliminate boundary checks
3. **Block Insertion**: Move multiple elements at once

### Advanced Variants
1. **Shell Sort**: Gap-based insertion sort
2. **Library Sort**: Insertion with gaps
3. **Patience Sorting**: Card sorting inspired variant
4. **Tree Sort**: Using binary search tree

### Performance Comparison
| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |

## Real-World Applications

### Suitable Use Cases
1. **Small Datasets**: Efficient for n < 100
2. **Nearly Sorted Data**: Adaptive nature shines
3. **Online Sorting**: Sort as data arrives
4. **Embedded Systems**: Minimal memory requirements
5. **Educational Purposes**: Teaching sorting concepts

### Integration Examples
```java
// Hybrid sorting approach
public static void hybridSort(int[] arr) {
    // Use insertion sort for small arrays
    if (arr.length <= 16) {
        insertionSort(arr);
    } else {
        // Use more efficient algorithm for large arrays
        Arrays.sort(arr);
    }
}

// Insertion sort within other algorithms
public static void bucketSort(int[] arr, int bucketSize) {
    // Create buckets
    List<List<Integer>> buckets = new ArrayList<>();
    // ... bucket creation
    
    // Sort each bucket using insertion sort
    for (List<Integer> bucket : buckets) {
        insertionSort(bucket.stream().mapToInt(i -> i).toArray());
    }
    
    // Concatenate buckets
    // ...
}
```

## Learning Outcomes

After studying this code, you will understand:

1. **Sorting Algorithms**: Insertion sort implementation and analysis
2. **Adaptive Algorithms**: Performance based on input characteristics
3. **Stable Sorting**: Maintaining element order
4. **Java Collections**: Comprehensive collection framework usage
5. **Functional Programming**: Modern Java functional interfaces
6. **I/O Operations**: File handling and stream processing
7. **Algorithm Optimization**: Various optimization techniques
8. **Error Handling**: Robust exception management

## Compilation and Execution

```bash
javac InsertionSort.java
java InsertionSort
```

The program will:
1. Demonstrate all Java imports with examples
2. Prompt for array size and elements
3. Perform insertion sort with step-by-step visualization
4. Display sorting results
5. Save process log to file
6. Show performance characteristics

## Extensions and Research

### Possible Enhancements
1. **Performance Metrics**: Add time measurement and comparison
2. **Visual Sorting**: Graphical representation of insertion process
3. **Algorithm Comparison**: Compare with other sorting algorithms
4. **Data Analysis**: Analyze performance on different data distributions
5. **Memory Profiling**: Analyze space usage patterns

### Research Topics
1. **Adaptive Sorting**: Algorithms that adapt to input characteristics
2. **Online Algorithms**: Sorting as data arrives
3. **External Sorting**: Sorting datasets that don't fit in memory
4. **Parallel Sorting**: Multi-threaded insertion sort variants

### Advanced Applications
```java
// Generic insertion sort for any Comparable type
public static <T extends Comparable<T>> void genericInsertionSort(T[] arr) {
    for (int i = 1; i < arr.length; i++) {
        T key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && arr[j].compareTo(key) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Insertion sort with custom comparator
public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
    for (int i = 1; i < arr.length; i++) {
        T key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && comparator.compare(arr[j], key) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

## Best Practices Demonstrated

1. **Algorithm Implementation**: Clear, efficient implementation
2. **Code Documentation**: Comprehensive method documentation
3. **Error Handling**: Robust exception management
4. **Resource Management**: Proper try-with-resources usage
5. **Type Safety**: Proper generic usage
6. **Functional Programming**: Modern Java features
7. **Testing**: Built-in demonstration methods
8. **Performance Analysis**: Complexity considerations

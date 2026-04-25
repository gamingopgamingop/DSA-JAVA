# SelectionSort.java - Documentation

## Overview
This Java program implements the Selection Sort algorithm with comprehensive demonstrations of all Java imports. It provides a complete sorting implementation along with extensive examples of Java collections, functional interfaces, and utility classes.

## Algorithm Logic

### Selection Sort Algorithm
Selection Sort divides the input list into two parts: a sorted sublist which is built up from left to right, and a sublist of the remaining unsorted items. It repeatedly selects the smallest (or largest) element from the unsorted sublist and moves it to the sorted sublist.

#### Time Complexity: O(n²)
#### Space Complexity: O(1)

### Core Algorithm
```java
for (int i = 0; i < n - 1; i++) {
    int minIndex = i;
    for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
            minIndex = j;
        }
    }
    // Swap arr[i] and arr[minIndex]
    int temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
}
```

### Key Features

#### 1. Multiple Data Structure Support
- **Arrays**: Primary sorting structure
- **Lists**: ArrayList, LinkedList, Vector for demonstration
- **Stacks**: Stack operations for element tracking
- **Queues**: ArrayDeque, PriorityQueue demonstrations

#### 2. Comprehensive Import Usage
- All 63 specified imports are actively used
- Proper type safety with generics
- Functional programming demonstrations
- I/O and file operations

#### 3. Educational Value
- Clear algorithm visualization
- Step-by-step sorting process
- Performance considerations
- Comparison with other algorithms

### Demonstration Methods

#### `demonstrateAllImports()`
Comprehensive demonstration covering:

##### Collections Framework
```java
// List implementations
List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));

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

##### Functional Interfaces
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
  MessageFormat.format("Array elements: {0}", Arrays.toString(arr))
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
- **List Interface**: Ordered collections allowing duplicates
  - **ArrayList**: Resizable array implementation
  - **Vector**: Thread-safe legacy implementation
  - **LinkedList**: Doubly-linked list implementation

- **Queue Interface**: FIFO collections
  - **ArrayDeque**: Array-based deque implementation
  - **PriorityQueue**: Heap-based priority queue

- **Set Interface**: Collections prohibiting duplicates
  - **HashSet**: Hash-based implementation
  - **LinkedHashSet**: Maintains insertion order
  - **TreeSet**: Sorted implementation
  - **EnumSet**: Optimized for enum types

- **Map Interface**: Key-value pair collections
  - **HashMap**: Hash-based implementation
  - **LinkedHashMap**: Maintains insertion order
  - **TreeMap**: Sorted implementation
  - **Hashtable**: Thread-safe legacy implementation
  - **SortedMap**: Sorted map interface
  - **NavigableMap**: Extended sorted map with navigation methods

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

### Selection Sort Characteristics

#### Advantages
1. **Simple Implementation**: Easy to understand and implement
2. **Space Efficient**: O(1) auxiliary space
3. **Predictable Performance**: Always O(n²) comparisons
4. **Minimal Swaps**: At most n-1 swaps required

#### Disadvantages
1. **Time Complexity**: O(n²) - inefficient for large datasets
2. **Unstable**: Relative order of equal elements not preserved
3. **Poor Performance**: Worse than insertion sort for nearly sorted data

#### Performance Metrics
- **Comparisons**: n(n-1)/2 = O(n²)
- **Swaps**: n-1 = O(n)
- **Best Case**: O(n²) - no early termination
- **Worst Case**: O(n²)
- **Average Case**: O(n²)

### Usage Examples

#### Basic Selection Sort
```java
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        // Find minimum element in unsorted array
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Swap found minimum with first element
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

#### Collection Operations
```java
// Sorting and manipulating collections
List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);

// Set operations for unique elements
Set<Integer> uniqueElements = new HashSet<>(list);
Set<Integer> sortedUnique = new TreeSet<>(list);
```

#### Functional Programming Examples
```java
// Using functional interfaces for data processing
IntUnaryOperator square = x -> x * x;
IntPredicate isEven = x -> x % 2 == 0;
Consumer<Integer> printer = x -> System.out.println("Value: " + x);

// Process array functionally
Arrays.stream(arr)
      .filter(isEven::test)
      .map(square::applyAsInt)
      .forEach(printer::accept);
```

#### File I/O Operations
```java
// Write sorting results to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("selection_sort_results.txt")), true)) {
    writer.println("Selection Sort Results");
    writer.println("Original array: " + Arrays.toString(originalArray));
    writer.println("Sorted array: " + Arrays.toString(sortedArray));
} catch (IOException e) {
    System.err.println("Error writing results: " + e.getMessage());
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

// Handle invalid input
try {
    int element = scanner.nextInt();
    // Process element
} catch (InputMismatchException e) {
    System.err.println("Error: Please enter valid integers.");
    scanner.next(); // Clear invalid input
}
```

### Exception Handling
```java
// File operations with proper exception handling
try {
    // I/O operations
} catch (IOException e) {
    System.err.println("I/O Error: " + e.getMessage());
}

// Desktop operations with fallback
try {
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        // Perform desktop operations
    }
} catch (Exception e) {
    System.out.println("Desktop operations not available");
}
```

## Optimization Techniques

### Standard Optimizations
1. **Early Termination**: Not applicable (always O(n²))
2. **Minimize Swaps**: Only swap when necessary
3. **Bidirectional Selection**: Select both min and max in each pass

### Advanced Variants
1. **Heap Sort**: Uses selection sort principle with heap structure
2. **Smooth Sort**: Adaptive variant based on heaps
3. **Tournament Sort**: Selection sort using tournament tree

### Performance Comparison
| Algorithm | Time Complexity | Space Complexity | Stable |
|-----------|------------------|------------------|--------|
| Selection Sort | O(n²) | O(1) | No |
| Bubble Sort | O(n²) | O(1) | Yes |
| Insertion Sort | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(log n) | No |

## Learning Outcomes

After studying this code, you will understand:

1. **Sorting Algorithms**: Selection sort implementation and analysis
2. **Algorithm Complexity**: Time and space complexity analysis
3. **Java Collections**: Comprehensive collection framework usage
4. **Functional Programming**: Modern Java functional interfaces
5. **I/O Operations**: File handling and stream processing
6. **Error Handling**: Robust exception management
7. **API Integration**: Desktop and printing system integration
8. **Code Documentation**: Comprehensive documentation practices

## Compilation and Execution

```bash
javac SelectionSort.java
java SelectionSort
```

The program will:
1. Demonstrate all Java imports with examples
2. Prompt for array size and elements
3. Perform selection sort with visualization
4. Display sorting results
5. Save output to file
6. Show performance metrics

## Extensions and Applications

### Possible Enhancements
1. **Performance Metrics**: Add time measurement and comparison
2. **Visual Sorting**: Graphical representation of sorting process
3. **Algorithm Comparison**: Compare with other sorting algorithms
4. **Data Generator**: Generate test data of various sizes
5. **Statistical Analysis**: Analyze performance on different data distributions

### Real-World Applications
1. **Small Dataset Sorting**: Efficient for small collections
2. **Educational Tools**: Teaching sorting algorithms
3. **Memory-Constrained Environments**: Minimal space requirements
4. **Predictable Performance**: Consistent O(n²) behavior

### Integration Examples
```java
// Integration with other algorithms
public static void hybridSort(int[] arr) {
    // Use selection sort for small subarrays
    if (arr.length <= 10) {
        selectionSort(arr);
    } else {
        // Use more efficient algorithm for larger arrays
        Arrays.sort(arr);
    }
}
```

## Best Practices Demonstrated

1. **Code Organization**: Clear separation of concerns
2. **Documentation**: Comprehensive method documentation
3. **Error Handling**: Robust exception management
4. **Resource Management**: Proper try-with-resources usage
5. **Type Safety**: Proper generic usage
6. **Functional Programming**: Modern Java features
7. **Testing**: Built-in demonstration methods

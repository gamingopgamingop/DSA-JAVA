# BubbleSort.java - Documentation

## Overview
This Java program implements the Bubble Sort algorithm with comprehensive demonstrations of all Java imports. It provides a complete sorting implementation along with extensive examples of Java collections, functional interfaces, and utility classes.

## Algorithm Logic

### Bubble Sort Algorithm
Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.

#### Time Complexity: O(n²)
#### Space Complexity: O(1)

### Core Algorithm
```java
for (int i = size - 1; i > 0; i--) {
    for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
            // Swap elements
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

### Key Features

#### 1. User Interaction
- **Input Validation**: Ensures positive array size
- **Confirmation Dialog**: Asks user before sorting
- **Progress Display**: Shows array before and after sorting

#### 2. Multiple Data Structures
- **Array**: Primary sorting structure
- **List**: Converted from array for demonstration
- **Iterator**: Used for traversing sorted list

#### 3. Formatted Output
- **MessageFormat**: Parameterized string formatting
- **Formatter**: Custom output formatting
- **Visual Display**: Clear array representation

### Demonstration Methods

#### `demonstrateAllImports()`
Comprehensive demonstration of all 63 imports:

##### Collections Framework
- **List Implementations**: ArrayList, Vector, LinkedList
- **Stack Operations**: Push/pop operations
- **Queue Implementations**: ArrayDeque, PriorityQueue
- **Set Implementations**: HashSet, LinkedHashSet, TreeSet, EnumSet
- **Map Implementations**: HashMap, LinkedHashMap, TreeMap, Hashtable, SortedMap, NavigableMap

##### I/O and File Operations
- **PrintStream**: Buffered file output
- **FileOutputStream**: File writing operations
- **IOException**: Exception handling
- **StandardCharsets**: UTF-8 encoding

##### Desktop and Printing
- **Desktop**: System integration
- **PrinterJob**: Print job management
- **PageFormat**: Page layout
- **Book**: Multi-page documents

##### Functional Programming
- **Consumer**: Action-oriented operations
- **Predicate**: Boolean testing
- **Function**: Input-output transformation
- **Supplier**: Value generation
- **Primitive Variants**: Int*, Double*, Long* for performance

##### Advanced Features
- **StreamTokenizer**: Text processing
- **Random**: Random number generation
- **Date/Time**: Current date formatting
- **DecimalFormat**: Number formatting

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Safe string formatting with parameters
  ```java
  MessageFormat.format("Enter {0} array elements:", size)
  ```
- **DecimalFormat**: Pattern-based number formatting
  ```java
  DecimalFormat("#,###.##").format(3.14159)
  ```
- **SimpleDateFormat**: Date/time patterns
  ```java
  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  ```

### Collections Framework (`java.util.*`)
- **List Interface**: Ordered collections with duplicates
  - **ArrayList**: Dynamic array implementation
  - **Vector**: Thread-safe dynamic array
  - **LinkedList**: Doubly-linked list implementation

- **Set Interface**: Collections with unique elements
  - **HashSet**: Hash-based unique elements
  - **LinkedHashSet**: Maintains insertion order
  - **TreeSet**: Sorted unique elements
  - **EnumSet**: Optimized for enum types

- **Map Interface**: Key-value pairs
  - **HashMap**: Hash-based key-value store
  - **LinkedHashMap**: Maintains insertion order
  - **TreeMap**: Sorted key-value store
  - **Hashtable**: Thread-safe legacy implementation

### Functional Interfaces (`java.util.function.*`)
- **Consumer<T>**: Accepts T, performs action
  ```java
  Consumer<String> printer = str -> System.out.println(str);
  ```
- **Predicate<T>**: Accepts T, returns boolean
  ```java
  Predicate<Integer> isEven = num -> num % 2 == 0;
  ```
- **Function<T,R>**: Accepts T, returns R
  ```java
  Function<String, Integer> stringLength = String::length;
  ```
- **Supplier<T>**: No input, returns T
  ```java
  Supplier<Double> randomSupplier = () -> new Random().nextDouble();
  ```

### Primitive Functional Interfaces
- **IntUnaryOperator**: int → int transformation
- **IntBinaryOperator**: (int, int) → int operation
- **IntPredicate**: int → boolean test
- **IntConsumer**: int → void action
- **IntFunction<R>**: int → R transformation

### I/O Operations (`java.io.*`)
- **PrintStream**: System.out-style output
- **PrintWriter**: Character output with buffering
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
  ```java
  if (Desktop.isDesktopSupported()) {
      Desktop.getDesktop().browse(uri);
  }
  ```
- **PrinterJob**: Print job management
- **PageFormat**: Page layout configuration
- **Book**: Multi-page document container

### Utilities (`java.util.*`)
- **Scanner**: Input parsing and validation
- **Arrays**: Array manipulation utilities
- **Collections**: Collection manipulation
- **Date**: Legacy date/time representation
- **Random**: Pseudo-random number generation

## Usage Examples

### Basic Bubble Sort
```java
int[] arr = {64, 34, 25, 12, 22, 11, 90};
// Sort the array
for (int i = arr.length - 1; i > 0; i--) {
    for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
            // Swap
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

### Collection Operations
```java
// Create and manipulate lists
List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);

// Set operations
Set<Integer> uniqueSet = new HashSet<>(list);
Set<Integer> sortedSet = new TreeSet<>(list);
```

### Functional Programming
```java
// Using functional interfaces
IntUnaryOperator square = x -> x * x;
Predicate<Integer> isPositive = x -> x > 0;
Consumer<String> logger = System.out::println;

// Apply operations
int result = square.applyAsInt(5);
boolean positive = isPositive.test(10);
logger.accept("Operation completed");
```

### File Operations
```java
// Write to file with buffering
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("output.txt")), true)) {
    writer.println("Bubble sort results");
} catch (IOException e) {
    System.err.println("Error writing file: " + e.getMessage());
}
```

## Error Handling

### Input Validation
```java
if (size <= 0) {
    System.out.println("Array size must be positive.");
    return;
}
```

### Exception Handling
```java
try {
    // File operations
} catch (IOException e) {
    System.err.println("I/O Error: " + e.getMessage());
}

try {
    // User input
    int n = scanner.nextInt();
} catch (InputMismatchException e) {
    System.err.println("Error: Please enter valid integers.");
}
```

## Performance Considerations

### Algorithm Efficiency
- **Time Complexity**: O(n²) - inefficient for large datasets
- **Space Complexity**: O(1) - in-place sorting
- **Best Case**: O(n) when array is already sorted
- **Worst Case**: O(n²) when array is reverse sorted

### Optimization Opportunities
- Early termination if no swaps in a pass
- Adaptive bubble sort for nearly sorted data
- Cocktail shaker sort (bidirectional bubble sort)

## Learning Outcomes

After studying this code, you will understand:

1. **Sorting Algorithms**: Bubble sort implementation and analysis
2. **Java Collections**: Comprehensive collection framework usage
3. **Functional Programming**: Modern Java functional interfaces
4. **I/O Operations**: File handling and stream processing
5. **Error Handling**: Robust exception management
6. **API Integration**: Desktop and printing system integration
7. **Code Organization**: Modular design and documentation

## Compilation and Execution

```bash
javac BubbleSort.java
java BubbleSort
```

The program will:
1. Demonstrate all Java imports with examples
2. Prompt for array size and elements
3. Show array before sorting
4. Perform bubble sort
5. Display sorted results
6. Save output to file

## Extensions and Modifications

### Possible Enhancements
1. **Performance Metrics**: Add time and space complexity measurements
2. **Visual Display**: Graphical representation of sorting process
3. **Comparison Mode**: Compare with other sorting algorithms
4. **Data Validation**: Enhanced input validation and error recovery
5. **File I/O**: Read/write arrays from/to files
6. **GUI Interface**: Swing/JavaFX graphical interface

### Algorithm Variations
1. **Optimized Bubble Sort**: Early termination optimization
2. **Cocktail Shaker Sort**: Bidirectional bubble sort
3. **Odd-Even Sort**: Parallel bubble sort variant
4. **Comb Sort**: Improved bubble sort with gap reduction

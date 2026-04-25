# BinarySearch.java - Documentation

## Overview
This Java program implements the binary search algorithm with comprehensive demonstrations of all Java imports. It provides both array-based and List-based binary search implementations, along with extensive examples of Java collections, functional interfaces, and utility classes.

## Algorithm Logic

### Binary Search Algorithm
Binary search is an efficient algorithm for finding an item from a **sorted** list of items. It works by repeatedly dividing the search interval in half.

#### Time Complexity: O(log n)
#### Space Complexity: O(1)

### Core Methods

#### 1. `binarySearch(int[] arr, int target, IntPredicate predicate)`
- **Purpose**: Performs binary search on a sorted integer array using functional interfaces
- **Parameters**: 
  - `arr`: Sorted array of integers
  - `target`: Integer value to search for
  - `predicate`: Custom predicate for comparison (optional)
- **Returns**: Index of target element if found, -1 if not found
- **Logic**:
  ```java
  int left = 0;
  int right = arr.length - 1;
  IntUnaryOperator midCalculator = l -> l + (right - l) / 2;
  IntBinaryOperator comparator = (a, b) -> Integer.compare(a, b);
  ```

#### 2. `binarySearch(List<Integer> list, int target)`
- **Purpose**: Performs binary search on a sorted List of integers
- **Returns**: Index of target element if found, -1 if not found
- **Logic**: Uses functional interfaces for mid calculation and comparison

### Demonstration Methods

#### `demonstrateDataStructures()`
Shows practical usage of various Java collections:
- **Lists**: ArrayList, Vector, LinkedList
- **Stack**: Stack operations (push, pop)
- **Queues**: ArrayDeque, PriorityQueue
- **Sets**: HashSet, TreeSet
- **Maps**: HashMap, TreeMap
- **Functional Interfaces**: Consumer, Predicate, Function, Supplier

#### `demonstrateFormatting()`
Demonstrates date and number formatting:
- **SimpleDateFormat**: Date/time formatting
- **DecimalFormat**: Number formatting with patterns

#### `demonstrateAllImports()`
Comprehensive demonstration of all 63 imports including:
- Advanced collections (LinkedHashSet, EnumSet, LinkedHashMap, etc.)
- I/O operations (PrintStream, FileOutputStream, etc.)
- Character encoding (StandardCharsets)
- Desktop operations (Desktop)
- Printing operations (PrinterJob, PageFormat, Book)
- All functional interfaces (primitive and object types)
- Stream processing (StreamTokenizer)
- Random operations (Random)

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
- **DecimalFormat**: Decimal number formatting with patterns
- **SimpleDateFormat**: Date and time formatting

### Utilities (`java.util.*`)
- **Scanner**: User input parsing
- **Arrays**: Array manipulation utilities
- **Collections**: Collection manipulation utilities
- **List, ArrayList, Vector, LinkedList**: List implementations
- **Stack**: LIFO data structure
- **Queue, ArrayDeque, PriorityQueue**: Queue implementations
- **Set, HashSet, LinkedHashSet, TreeSet, EnumSet**: Set implementations
- **Map, HashMap, LinkedHashMap, TreeMap, Hashtable, SortedMap, NavigableMap**: Map implementations

### Functional Interfaces (`java.util.function.*`)
- **Consumer**: Accepts input, performs action, no return
- **Predicate**: Accepts input, returns boolean
- **Function**: Accepts input, returns output
- **Supplier**: No input, returns output
- **Primitive variants**: Int*, Double*, Long* versions for performance

### I/O Operations (`java.io.*`)
- **PrintStream, PrintWriter**: Output writing
- **BufferedOutputStream**: Buffered output for performance
- **FileOutputStream**: File output operations
- **IOException**: I/O exception handling
- **StreamTokenizer**: Tokenizes input streams

### Character Encoding (`java.nio.charset.*`)
- **StandardCharsets**: Standard character set constants (UTF-8, etc.)

### Desktop Operations (`java.awt.*`)
- **Desktop**: Desktop integration (browse, mail, edit, print)
- **PrinterException**: Printing-related exceptions
- **PrinterJob**: Print job control
- **PageFormat**: Page layout settings
- **Book**: Multi-page document

### Date and Random (`java.util.*`)
- **Date**: Date/time representation
- **Random**: Random number generation

## Usage Examples

### Basic Binary Search
```java
int[] arr = {1, 3, 5, 7, 9, 11, 13};
int target = 7;
int index = binarySearch(arr, target, null);
```

### Using Functional Interfaces
```java
IntPredicate isEven = x -> x % 2 == 0;
IntUnaryOperator square = x -> x * x;
Consumer<String> printer = str -> System.out.println(str);
```

### Collection Operations
```java
List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
Collections.sort(list);
Collections.reverse(list);
```

## Key Features

1. **Educational Value**: Demonstrates comprehensive Java API usage
2. **Functional Programming**: Modern Java functional interfaces
3. **Type Safety**: Proper generic usage throughout
4. **Error Handling**: Comprehensive exception handling
5. **Performance**: Efficient binary search implementation
6. **Extensibility**: Modular design for easy extension

## Compilation and Execution

```bash
javac BinarySearch.java
java BinarySearch
```

The program will:
1. Demonstrate all imports with examples
2. Show data structure operations
3. Perform formatting demonstrations
4. Allow user to input array and search for elements
5. Save results to file

## Learning Outcomes

After studying this code, you will understand:
- Binary search algorithm implementation
- Java Collections Framework usage
- Functional programming concepts
- I/O operations and file handling
- Exception handling best practices
- Modern Java features and APIs

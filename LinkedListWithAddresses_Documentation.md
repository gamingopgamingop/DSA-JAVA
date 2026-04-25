# LinkedListWithAddresses.java - Documentation

## Overview
This Java program implements a custom singly linked list with memory address display functionality. It provides comprehensive demonstrations of all Java imports while showcasing linked list operations, memory management concepts, and modern Java features.

## Data Structure Logic

### Singly Linked List Structure
A singly linked list is a linear data structure where each element (node) points to the next element in the sequence. Unlike arrays, linked lists don't require contiguous memory allocation.

#### Node Structure
```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

#### Time Complexity
- **Insertion**: O(1) at beginning, O(n) at end
- **Deletion**: O(1) at beginning, O(n) at end
- **Search**: O(n)
- **Space Complexity**: O(n)

### Core Operations

#### 1. Insert Operation
```java
public void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
        head = newNode;
    } else {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
```

#### 2. Display with Addresses
```java
public void displayWithAddresses() {
    Node temp = head;
    while (temp != null) {
        String address = Integer.toHexString(System.identityHashCode(temp));
        System.out.println(MessageFormat.format("Data: {0} | Address: @{1}", temp.data, address));
        temp = temp.next;
    }
}
```

### Key Features

#### 1. Memory Address Visualization
- Uses `System.identityHashCode()` to simulate memory addresses
- Displays node data with corresponding memory locations
- Educational tool for understanding memory layout

#### 2. Menu-Driven Interface
- Interactive user interface for list operations
- Clear operation choices and feedback
- Error handling for invalid inputs

#### 3. Comprehensive Import Usage
- All 63 specified imports are actively used
- Demonstrates real-world applications of various Java APIs
- Educational value through practical examples

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Inserted {0} into the linked list.", data)
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
      new FileOutputStream("linked_list_demo.txt")), true);
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

#### Collections Framework Examples
```java
// List operations
List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Collections.sort(arrayList);
Collections.reverse(linkedList);
Collections.shuffle(vector);

// Set operations for unique elements
Set<Integer> uniqueElements = new HashSet<>(arrayList);
Set<Integer> sortedUnique = new TreeSet<>(arrayList);

// Map operations for key-value pairs
Map<String, Integer> frequencyMap = new HashMap<>();
arrayList.forEach(num -> frequencyMap.merge(
    num.toString(), 1, Integer::sum));
```

#### Functional Programming Examples
```java
// Process linked list data functionally
Consumer<String> printer = str -> System.out.println("Consumer: " + str);
Predicate<Integer> isEven = num -> num % 2 == 0;
Function<String, Integer> stringLength = String::length;

// Apply to linked list data
if (head != null) {
    printer.accept("Processing linked list: " + head.data);
    boolean even = isEven.test(head.data);
    int length = stringLength.apply(Integer.toString(head.data));
}
```

#### I/O and File Operations
```java
// Save linked list to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("linked_list_output.txt")), true)) {
    
    Node temp = head;
    while (temp != null) {
        writer.printf("Node: %d, Address: %s%n", 
            temp.data, 
            Integer.toHexString(System.identityHashCode(temp)));
        temp = temp.next;
    }
} catch (IOException e) {
    System.err.println("Error saving linked list: " + e.getMessage());
}
```

#### Stream Processing
```java
// Tokenize linked list data
String listData = "Linked 123 List 456 Data 789";
StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(listData));
while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
    System.out.println("Token: " + tokenizer.sval + " (Type: " + tokenizer.ttype + ")");
}
```

## Memory Management Concepts

### Address Visualization
```java
public void displayMemoryLayout() {
    Node temp = head;
    int position = 0;
    
    while (temp != null) {
        String address = Integer.toHexString(System.identityHashCode(temp));
        String nextAddress = temp.next != null ? 
            Integer.toHexString(System.identityHashCode(temp.next)) : "null";
        
        System.out.printf("Position %d: Data=%d, Address=@%s, Next=@%s%n",
            position, temp.data, address, nextAddress);
        
        temp = temp.next;
        position++;
    }
}
```

### Memory Usage Analysis
```java
public void analyzeMemoryUsage() {
    Runtime runtime = Runtime.getRuntime();
    long usedMemory = runtime.totalMemory() - runtime.freeMemory();
    
    System.out.println("Memory Analysis:");
    System.out.println("Used memory: " + (usedMemory / 1024) + " KB");
    
    // Estimate node memory usage
    int nodeCount = countNodes();
    long estimatedNodeMemory = nodeCount * (4 + 8); // int + reference
    System.out.println("Estimated node memory: " + estimatedNodeMemory + " bytes");
}
```

## Advanced Operations

### Linked List Reversal
```java
public void reverseList() {
    Node prev = null;
    Node current = head;
    Node next = null;
    
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
```

### Cycle Detection
```java
public boolean hasCycle() {
    if (head == null || head.next == null) {
        return false;
    }
    
    Node slow = head;
    Node fast = head.next;
    
    while (fast != null && fast.next != null) {
        if (slow == fast) {
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
```

### Middle Element Finding
```java
public Node findMiddle() {
    if (head == null) {
        return null;
    }
    
    Node slow = head;
    Node fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
}
```

## Error Handling

### Input Validation
```java
private static int readInt(Scanner scanner, String prompt) {
    while (true) {
        try {
            System.out.print(prompt);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Clear invalid input
        }
    }
}
```

### Exception Handling
```java
// File operations with proper exception handling
try {
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

## Performance Analysis

### Space Complexity
- **Node Storage**: O(n) for n nodes
- **Reference Storage**: O(n) for next references
- **Total Space**: O(n)

### Time Complexity Analysis
| Operation | Best Case | Average Case | Worst Case |
|-----------|-----------|--------------|------------|
| Insert at Beginning | O(1) | O(1) | O(1) |
| Insert at End | O(1) | O(n) | O(n) |
| Delete from Beginning | O(1) | O(1) | O(1) |
| Delete from End | O(1) | O(n) | O(n) |
| Search | O(1) | O(n) | O(n) |
| Traverse | O(n) | O(n) | O(n) |

### Memory Efficiency
- **No Resizing**: Unlike ArrayList, no capacity management needed
- **Fragmentation**: Non-contiguous memory allocation
- **Overhead**: Per-node reference overhead

## Usage Examples

### Basic Operations
```java
LinkedListWithAddresses list = new LinkedListWithAddresses();

// Insert elements
list.insert(10);
list.insert(20);
list.insert(30);

// Display with addresses
list.displayWithAddresses();

// Memory analysis
list.analyzeMemoryUsage();
```

### Advanced Operations
```java
// Reverse the list
list.reverseList();

// Check for cycles
boolean hasCycle = list.hasCycle();

// Find middle element
Node middle = list.findMiddle();
if (middle != null) {
    System.out.println("Middle element: " + middle.data);
}
```

### Collection Integration
```java
// Convert to Java collections
List<Integer> javaList = new ArrayList<>();
Node temp = head;
while (temp != null) {
    javaList.add(temp.data);
    temp = temp.next;
}

// Use collection operations
Collections.sort(javaList);
Collections.reverse(javaList);
```

## Learning Outcomes

After studying this code, you will understand:

1. **Linked List Data Structure**: Implementation and operations
2. **Memory Management**: Address visualization and memory usage
3. **Java Collections**: Integration with standard collections
4. **Functional Programming**: Modern Java features
5. **I/O Operations**: File handling and stream processing
6. **Error Handling**: Robust exception management
7. **Algorithm Analysis**: Time and space complexity
8. **Code Organization**: Modular design and documentation

## Compilation and Execution

```bash
javac LinkedListWithAddresses.java
java LinkedListWithAddresses
```

The program will:
1. Demonstrate all Java imports with examples
2. Present interactive menu for list operations
3. Show memory addresses for each node
4. Provide comprehensive error handling
5. Save operations to file
6. Display memory usage analysis

## Extensions and Applications

### Possible Enhancements
1. **Doubly Linked List**: Add previous references
2. **Circular Linked List**: Connect end to beginning
3. **Generic Implementation**: Support any data type
4. **Persistence**: Save/load linked list to/from files
5. **Visualization**: Graphical representation of list structure
6. **Performance Metrics**: Add timing and memory profiling

### Real-World Applications
1. **Browser History**: Forward/backward navigation
2. **Music Playlists**: Sequential track playback
3. **Undo/Redo Systems**: Operation history
4. **File Systems**: Directory traversal
5. **Cache Management**: LRU cache implementation

### Advanced Algorithms
```java
// Merge two sorted linked lists
public static LinkedListWithAddresses mergeSorted(
    LinkedListWithAddresses list1, 
    LinkedListWithAddresses list2) {
    
    LinkedListWithAddresses result = new LinkedListWithAddresses();
    Node p1 = list1.head;
    Node p2 = list2.head;
    
    while (p1 != null && p2 != null) {
        if (p1.data <= p2.data) {
            result.insert(p1.data);
            p1 = p1.next;
        } else {
            result.insert(p2.data);
            p2 = p2.next;
        }
    }
    
    // Add remaining elements
    while (p1 != null) {
        result.insert(p1.data);
        p1 = p1.next;
    }
    
    while (p2 != null) {
        result.insert(p2.data);
        p2 = p2.next;
    }
    
    return result;
}
```

## Best Practices Demonstrated

1. **Data Structure Implementation**: Proper linked list implementation
2. **Memory Awareness**: Address visualization and memory analysis
3. **Error Handling**: Comprehensive exception management
4. **User Interface**: Clear menu-driven interface
5. **Code Documentation**: Extensive method documentation
6. **Resource Management**: Proper resource cleanup
7. **Testing**: Built-in demonstration methods
8. **Performance Analysis**: Complexity considerations

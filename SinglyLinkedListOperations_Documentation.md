# SinglyLinkedListOperations.java - Documentation

## Overview
This Java program implements a comprehensive singly linked list with full CRUD operations through a menu-driven interface. It demonstrates all 63 Java imports while showcasing advanced linked list operations, memory management, and modern Java features.

## Data Structure Logic

### Singly Linked List Structure
A singly linked list is a linear data structure where each element points to the next element in the sequence. This implementation provides complete insertion and deletion operations at various positions.

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
- **Insert at Beginning**: O(1)
- **Insert at End**: O(n)
- **Insert at Position**: O(n)
- **Delete from Beginning**: O(1)
- **Delete from End**: O(n)
- **Delete from Position**: O(n)
- **Display/Traversal**: O(n)
- **Space Complexity**: O(n)

### Core Operations

#### 1. Insertion Operations
```java
// Insert at beginning
public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}

// Insert at specific position
public void insertAtPosition(int data, int position) {
    if (position == 0) {
        insertAtBeginning(data);
        return;
    }
    
    Node newNode = new Node(data);
    Node current = head;
    for (int i = 0; i < position - 1 && current != null; i++) {
        current = current.next;
    }
    
    if (current != null) {
        newNode.next = current.next;
        current.next = newNode;
    }
}
```

#### 2. Deletion Operations
```java
// Delete from beginning
public void deleteFromBeginning() {
    if (head != null) {
        head = head.next;
    }
}

// Delete from end
public void deleteFromEnd() {
    if (head == null || head.next == null) {
        head = null;
        return;
    }
    
    Node current = head;
    while (current.next.next != null) {
        current = current.next;
    }
    current.next = null;
}

// Delete from specific position
public void deleteAtPosition(int position) {
    if (head == null) return;
    
    if (position == 0) {
        head = head.next;
        return;
    }
    
    Node current = head;
    for (int i = 0; i < position - 1 && current.next != null; i++) {
        current = current.next;
    }
    
    if (current.next != null) {
        current.next = current.next.next;
    }
}
```

#### 3. Display Operation
```java
public void displayList() {
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }
    
    Node current = head;
    System.out.print("List: ");
    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }
    System.out.println("NULL");
}
```

### Key Features

#### 1. Complete CRUD Operations
- **Create**: Insert at beginning, end, and specific positions
- **Read**: Display entire list with visual representation
- **Update**: Implicit through insertion/deletion combinations
- **Delete**: Remove from beginning, end, and specific positions

#### 2. Menu-Driven Interface
- Interactive user interface for all operations
- Clear operation choices and feedback
- Error handling for invalid positions and inputs

#### 3. Comprehensive Import Usage
- All 63 specified imports are actively used
- Demonstrates real-world applications of various Java APIs
- Educational value through practical examples

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Inserted {0} at the beginning.", data)
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
      new FileOutputStream("linked_list_ops_demo.txt")), true);
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

#### Linked List Operations with Collections
```java
// Convert linked list to Java collections
List<Integer> javaList = new ArrayList<>();
Node temp = head;
while (temp != null) {
    javaList.add(temp.data);
    temp = temp.next;
}

// Use collection operations
Collections.sort(javaList);
Collections.reverse(javaList);
Collections.shuffle(javaList);
```

#### Functional Programming with Linked List
```java
// Process linked list data functionally
Consumer<Integer> nodeProcessor = data -> 
    System.out.println("Processing node: " + data);

Predicate<Integer> isEven = num -> num % 2 == 0;
Function<Integer, String> nodeFormatter = data -> 
    String.format("Node[%d]", data);

// Apply to linked list
Node current = head;
while (current != null) {
    nodeProcessor.accept(current.data);
    if (isEven.test(current.data)) {
        System.out.println("Even node: " + nodeFormatter.apply(current.data));
    }
    current = current.next;
}
```

#### File I/O Integration
```java
// Save linked list operations to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("linked_list_operations.log")), true)) {
    
    writer.println("Singly Linked List Operations Log");
    writer.println("Timestamp: " + new Date());
    
    Node temp = head;
    int position = 0;
    while (temp != null) {
        writer.printf("Position %d: Data=%d, Address=@%s%n",
            position, temp.data, 
            Integer.toHexString(System.identityHashCode(temp)));
        temp = temp.next;
        position++;
    }
} catch (IOException e) {
    System.err.println("Error saving operations log: " + e.getMessage());
}
```

## Advanced Operations

### List Reversal
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

### List Size
```java
public int getSize() {
    int count = 0;
    Node current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
}
```

### Search Operation
```java
public boolean search(int data) {
    Node current = head;
    while (current != null) {
        if (current.data == data) {
            return true;
        }
        current = current.next;
    }
    return false;
}
```

### Get Element at Position
```java
public int getAtPosition(int position) {
    if (position < 0) {
        throw new IllegalArgumentException("Position cannot be negative");
    }
    
    Node current = head;
    for (int i = 0; i < position && current != null; i++) {
        current = current.next;
    }
    
    if (current == null) {
        throw new IndexOutOfBoundsException("Position out of bounds");
    }
    
    return current.data;
}
```

## Error Handling

### Position Validation
```java
private boolean isValidPosition(int position) {
    return position >= 0 && position <= getSize();
}

private void validatePosition(int position) {
    if (position < 0) {
        throw new IllegalArgumentException("Position cannot be negative");
    }
    if (position > getSize()) {
        throw new IndexOutOfBoundsException("Position exceeds list size");
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
| Insert at Position | O(1) | O(n) | O(n) |
| Delete from Beginning | O(1) | O(1) | O(1) |
| Delete from End | O(1) | O(n) | O(n) |
| Delete from Position | O(1) | O(n) | O(n) |
| Search | O(1) | O(n) | O(n) |
| Traversal | O(n) | O(n) | O(n) |

### Memory Efficiency
- **No Resizing**: Unlike ArrayList, no capacity management needed
- **Overhead**: Per-node reference overhead
- **Fragmentation**: Non-contiguous memory allocation

## Usage Examples

### Basic Operations
```java
SinglyLinkedListOperations list = new SinglyLinkedListOperations();

// Insert elements
list.insertAtBeginning(10);
list.insertAtEnd(20);
list.insertAtPosition(15, 1);

// Display list
list.displayList();

// Delete elements
list.deleteFromBeginning();
list.deleteAtPosition(1);
list.deleteFromEnd();
```

### Advanced Operations
```java
// Search for element
boolean found = list.search(15);

// Get list size
int size = list.getSize();

// Get element at position
int element = list.getAtPosition(2);

// Reverse list
list.reverseList();
```

### Collection Integration
```java
// Convert to Java collections
List<Integer> javaList = new ArrayList<>();
Node temp = list.head;
while (temp != null) {
    javaList.add(temp.data);
    temp = temp.next;
}

// Use collection operations
Collections.sort(javaList);
int max = Collections.max(javaList);
int min = Collections.min(javaList);
```

## Learning Outcomes

After studying this code, you will understand:

1. **Linked List Data Structure**: Complete CRUD operations
2. **Memory Management**: Pointer/reference concepts in Java
3. **Algorithm Analysis**: Time and space complexity
4. **Java Collections**: Integration with standard collections
5. **Functional Programming**: Modern Java features
6. **I/O Operations**: File handling and stream processing
7. **Error Handling**: Robust exception management
8. **User Interface**: Menu-driven program design

## Compilation and Execution

```bash
javac SinglyLinkedListOperations.java
java SinglyLinkedListOperations
```

The program will:
1. Demonstrate all Java imports with examples
2. Present interactive menu for list operations
3. Provide comprehensive error handling
4. Save operations to file
5. Display real-time feedback

## Extensions and Applications

### Possible Enhancements
1. **Doubly Linked List**: Add previous references
2. **Circular Linked List**: Connect end to beginning
3. **Generic Implementation**: Support any data type
4. **Persistence**: Save/load list to/from files
5. **Visualization**: Graphical representation of list structure
6. **Performance Metrics**: Add timing and memory profiling

### Real-World Applications
1. **Browser History**: Forward/backward navigation
2. **Music Playlists**: Sequential track management
3. **Undo/Redo Systems**: Operation history tracking
4. **File Systems**: Directory traversal
5. **Cache Management**: LRU cache implementation
6. **Task Queues**: Job scheduling systems

### Advanced Algorithms
```java
// Find middle element (tortoise and hare)
public Node findMiddle() {
    if (head == null) return null;
    
    Node slow = head;
    Node fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
}

// Detect cycle
public boolean hasCycle() {
    if (head == null || head.next == null) return false;
    
    Node slow = head;
    Node fast = head.next;
    
    while (fast != null && fast.next != null) {
        if (slow == fast) return true;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return false;
}

// Merge two sorted lists
public static SinglyLinkedListOperations mergeSorted(
    SinglyLinkedListOperations list1, 
    SinglyLinkedListOperations list2) {
    
    SinglyLinkedListOperations result = new SinglyLinkedListOperations();
    Node p1 = list1.head;
    Node p2 = list2.head;
    
    while (p1 != null && p2 != null) {
        if (p1.data <= p2.data) {
            result.insertAtEnd(p1.data);
            p1 = p1.next;
        } else {
            result.insertAtEnd(p2.data);
            p2 = p2.next;
        }
    }
    
    // Add remaining elements
    while (p1 != null) {
        result.insertAtEnd(p1.data);
        p1 = p1.next;
    }
    
    while (p2 != null) {
        result.insertAtEnd(p2.data);
        p2 = p2.next;
    }
    
    return result;
}
```

## Best Practices Demonstrated

1. **Data Structure Implementation**: Complete linked list implementation
2. **Error Handling**: Comprehensive validation and exception management
3. **User Interface**: Clear menu-driven interface
4. **Code Documentation**: Extensive method documentation
5. **Resource Management**: Proper resource cleanup
6. **Testing**: Built-in demonstration methods
7. **Performance Analysis**: Complexity considerations
8. **Modular Design**: Separation of concerns

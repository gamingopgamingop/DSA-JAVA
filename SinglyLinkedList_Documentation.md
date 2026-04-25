# SinglyLinkedList.java - Documentation

## Overview
This Java program implements a comprehensive singly linked list with advanced operations and demonstrations. It showcases all 63 Java imports while providing extensive linked list functionality, memory management concepts, and modern Java programming features.

## Data Structure Logic

### Singly Linked List Structure
A singly linked list is a fundamental data structure consisting of nodes where each node contains data and a reference to the next node. This implementation provides a complete set of operations with comprehensive demonstrations.

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
- **Insertion**: O(1) at beginning, O(n) at specific position
- **Deletion**: O(1) at beginning, O(n) at specific position
- **Search**: O(n)
- **Traversal**: O(n)
- **Space Complexity**: O(n)

### Core Operations

#### 1. Basic Insertion and Deletion
```java
// Insert at beginning
public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}

// Delete from beginning
public void deleteFromBeginning() {
    if (head != null) {
        head = head.next;
    }
}
```

#### 2. Advanced Operations
```java
// Insert at end
public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
        head = newNode;
    } else {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
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

#### 3. Search and Traversal
```java
// Search for element
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

// Display list
public void displayList() {
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

#### 1. Comprehensive Operations
- Complete CRUD operations
- Position-based insertions and deletions
- Search and traversal functionality
- Size and empty checking

#### 2. Advanced Demonstrations
- Memory address visualization
- Collection framework integration
- Functional programming examples
- File I/O operations

#### 3. Educational Value
- Clear algorithm visualization
- Step-by-step operation demonstration
- Performance analysis
- Real-world application examples

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Inserted {0} at position {1}", data, position)
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
      new FileOutputStream("singly_linked_list_demo.txt")), true);
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

#### Linked List to Collections Conversion
```java
// Convert linked list to Java collections
List<Integer> javaList = new ArrayList<>();
Node current = head;
while (current != null) {
    javaList.add(current.data);
    current = current.next;
}

// Apply collection operations
Collections.sort(javaList);
Collections.reverse(javaList);
Collections.shuffle(javaList);
```

#### Functional Programming with Nodes
```java
// Process nodes functionally
Consumer<Node> nodeProcessor = node -> 
    System.out.println("Processing node with data: " + node.data);

Predicate<Node> hasEvenData = node -> node.data % 2 == 0;
Function<Node, String> nodeFormatter = node -> 
    String.format("Node[%d]", node.data);

// Apply to linked list
Node temp = head;
while (temp != null) {
    nodeProcessor.accept(temp);
    if (hasEvenData.test(temp)) {
        System.out.println("Even node: " + nodeFormatter.apply(temp));
    }
    temp = temp.next;
}
```

#### File I/O Integration
```java
// Save linked list structure to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("linked_list_structure.txt")), true)) {
    
    writer.println("Singly Linked List Structure");
    writer.println("Created: " + new Date());
    
    Node temp = head;
    int position = 0;
    while (temp != null) {
        writer.printf("Node %d: Data=%d, Next=@%s%n",
            position, temp.data,
            temp.next != null ? 
                Integer.toHexString(System.identityHashCode(temp.next)) : "NULL");
        temp = temp.next;
        position++;
    }
} catch (IOException e) {
    System.err.println("Error saving structure: " + e.getMessage());
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

### List Size and Empty Check
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

public boolean isEmpty() {
    return head == null;
}
```

### Get Element at Position
```java
public int getAtPosition(int position) {
    if (position < 0 || position >= getSize()) {
        throw new IndexOutOfBoundsException("Invalid position: " + position);
    }
    
    Node current = head;
    for (int i = 0; i < position; i++) {
        current = current.next;
    }
    
    return current.data;
}
```

### Update Element at Position
```java
public void updateAtPosition(int data, int position) {
    if (position < 0 || position >= getSize()) {
        throw new IndexOutOfBoundsException("Invalid position: " + position);
    }
    
    Node current = head;
    for (int i = 0; i < position; i++) {
        current = current.next;
    }
    
    current.data = data;
}
```

### Delete from End
```java
public void deleteFromEnd() {
    if (head == null) return;
    
    if (head.next == null) {
        head = null;
        return;
    }
    
    Node current = head;
    while (current.next.next != null) {
        current = current.next;
    }
    current.next = null;
}
```

### Delete from Position
```java
public void deleteAtPosition(int position) {
    if (position < 0 || position >= getSize()) {
        throw new IndexOutOfBoundsException("Invalid position: " + position);
    }
    
    if (position == 0) {
        head = head.next;
        return;
    }
    
    Node current = head;
    for (int i = 0; i < position - 1; i++) {
        current = current.next;
    }
    
    current.next = current.next.next;
}
```

## Advanced Algorithms

### Find Middle Element
```java
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
```

### Detect Cycle
```java
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
```

### Remove Duplicates
```java
public void removeDuplicates() {
    if (head == null) return;
    
    Set<Integer> seen = new HashSet<>();
    Node current = head;
    Node prev = null;
    
    while (current != null) {
        if (seen.contains(current.data)) {
            prev.next = current.next;
        } else {
            seen.add(current.data);
            prev = current;
        }
        current = current.next;
    }
}
```

### Sort Linked List
```java
public void sortList() {
    // Convert to array, sort, and rebuild
    List<Integer> values = new ArrayList<>();
    Node current = head;
    
    while (current != null) {
        values.add(current.data);
        current = current.next;
    }
    
    Collections.sort(values);
    
    // Rebuild list
    head = null;
    for (int value : values) {
        insertAtEnd(value);
    }
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
| Get at Position | O(1) | O(n) | O(n) |
| Traversal | O(n) | O(n) | O(n) |

### Memory Efficiency
- **No Resizing**: Unlike ArrayList, no capacity management
- **Overhead**: Per-node reference overhead
- **Fragmentation**: Non-contiguous memory allocation

## Usage Examples

### Basic Operations
```java
SinglyLinkedList list = new SinglyLinkedList();

// Insert elements
list.insertAtBeginning(10);
list.insertAtEnd(20);
list.insertAtPosition(15, 1);

// Display list
list.displayList();

// Search and update
if (list.search(15)) {
    list.updateAtPosition(25, 1);
}

// Delete operations
list.deleteFromBeginning();
list.deleteAtPosition(1);
list.deleteFromEnd();
```

### Advanced Operations
```java
// Get list information
int size = list.getSize();
boolean empty = list.isEmpty();
int element = list.getAtPosition(2);

// Advanced algorithms
Node middle = list.findMiddle();
boolean hasCycle = list.hasCycle();
list.removeDuplicates();
list.sortList();
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
Set<Integer> uniqueSet = new HashSet<>(javaList);
```

## Error Handling

### Position Validation
```java
private void validatePosition(int position) {
    if (position < 0) {
        throw new IllegalArgumentException("Position cannot be negative");
    }
    if (position >= getSize()) {
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

## Learning Outcomes

After studying this code, you will understand:

1. **Linked List Data Structure**: Complete implementation and operations
2. **Memory Management**: Reference concepts and memory layout
3. **Algorithm Analysis**: Time and space complexity
4. **Java Collections**: Integration with standard collections
5. **Functional Programming**: Modern Java features
6. **I/O Operations**: File handling and stream processing
7. **Error Handling**: Robust exception management
8. **Advanced Algorithms**: Cycle detection, sorting, etc.

## Compilation and Execution

```bash
javac SinglyLinkedList.java
java SinglyLinkedList
```

The program will:
1. Demonstrate all Java imports with examples
2. Show linked list operations
3. Provide comprehensive error handling
4. Save operations to file
5. Display memory analysis

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
5. **Task Queues**: Job scheduling systems
6. **Cache Management**: LRU cache implementation

### Advanced Implementations
```java
// Generic singly linked list
public class GenericSinglyLinkedList<T> {
    private class GenericNode {
        T data;
        GenericNode next;
        
        GenericNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private GenericNode head;
    
    public void insert(T data) {
        GenericNode newNode = new GenericNode(data);
        newNode.next = head;
        head = newNode;
    }
    
    // ... other operations
}

// Linked list with iterator
public class IterableSinglyLinkedList implements Iterable<Integer> {
    // ... existing code
    
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}
```

## Best Practices Demonstrated

1. **Data Structure Implementation**: Complete linked list implementation
2. **Memory Awareness**: Understanding of reference-based structures
3. **Error Handling**: Comprehensive validation and exception management
4. **Code Documentation**: Extensive method documentation
5. **Resource Management**: Proper resource cleanup
6. **Testing**: Built-in demonstration methods
7. **Performance Analysis**: Complexity considerations
8. **Modular Design**: Separation of concerns and reusable methods

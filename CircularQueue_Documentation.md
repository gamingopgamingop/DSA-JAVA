# CircularQueue Documentation

## Overview

The `CircularQueue.java` file implements a circular queue data structure using an array-based approach. This implementation provides efficient FIFO (First In, First Out) operations with constant time complexity for all basic operations, making it ideal for buffer management, task scheduling, and other applications requiring fixed-size queues.

## Algorithm Summary

**Circular Queue**: A fixed-size queue implemented using a circular array where the last position is connected to the first position, allowing efficient reuse of space and avoiding the need for shifting elements.
- **Time Complexity**: O(1) for enqueue, dequeue, peek, isEmpty, isFull
- **Space Complexity**: O(n) where n is the queue capacity
- **Structure**: Circular array with front and rear pointers
- **Applications**: Buffer management, task scheduling, circular buffers

## Class Structure

### Core Components
```java
public class CircularQueue {
    private int[] queue;      // Array to store queue elements
    private int front;        // Front pointer (index of front element)
    private int rear;         // Rear pointer (index of rear element)
    private int capacity;     // Maximum capacity of the queue
}
```

### Constructor
```java
public CircularQueue(int size) {
    queue = new int[size];    // Initialize array with specified capacity
    capacity = size;          // Set capacity
    front = -1;               // Initialize front to -1 (empty queue)
    rear = -1;                // Initialize rear to -1 (empty queue)
}
```

## Core Operations

### 1. Enqueue Operation
**Purpose**: Insert an element at the rear of the queue
**Time Complexity**: O(1)
**Algorithm**:
1. Check if queue is full
2. If queue is empty, set front to 0
3. Calculate new rear position using modulo arithmetic: `rear = (rear + 1) % capacity`
4. Insert element at rear position
5. Display success message

```java
public void enqueue(int item) {
    if (isFull()) {
        System.out.println("Queue Overflow! Cannot insert " + item);
        return;
    }
    if (front == -1) {
        front = 0;
    }
    rear = (rear + 1) % capacity;
    queue[rear] = item;
    System.out.println(MessageFormat.format("Inserted {0} into the circular queue.", item));
}
```

### 2. Dequeue Operation
**Purpose**: Remove and return the element from the front of the queue
**Time Complexity**: O(1)
**Algorithm**:
1. Check if queue is empty
2. Store front element to return
3. If queue has only one element, reset front and rear to -1
4. Otherwise, update front using modulo arithmetic: `front = (front + 1) % capacity`
5. Return the removed element

```java
public int dequeue() {
    if (isEmpty()) {
        System.out.println("Queue Underflow! Cannot delete.");
        return -1;
    }
    int item = queue[front];
    if (front == rear) {
        front = -1;
        rear = -1;
    } else {
        front = (front + 1) % capacity;
    }
    return item;
}
```

### 3. Peek Operation
**Purpose**: Return the front element without removing it
**Time Complexity**: O(1)
**Algorithm**:
1. Check if queue is empty
2. Return element at front position

```java
public int peek() {
    if (isEmpty()) {
        System.out.println("Queue is empty.");
        return -1;
    }
    return queue[front];
}
```

### 4. isEmpty Operation
**Purpose**: Check if the queue is empty
**Time Complexity**: O(1)
**Algorithm**: Return true if front is -1

```java
public boolean isEmpty() {
    return front == -1;
}
```

### 5. isFull Operation
**Purpose**: Check if the queue is full
**Time Complexity**: O(1)
**Algorithm**: Check if next rear position equals front using modulo arithmetic

```java
public boolean isFull() {
    return (rear + 1) % capacity == front;
}
```

### 6. Display Operation
**Purpose**: Display all elements in the queue
**Time Complexity**: O(n)
**Algorithm**:
1. Check if queue is empty
2. Start from front position
3. Traverse circularly until rear position is reached
4. Print each element

```java
public void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty.");
        return;
    }
    System.out.print("Circular Queue elements: ");
    int i = front;
    while (true) {
        System.out.print(queue[i] + " ");
        if (i == rear) break;
        i = (i + 1) % capacity;
    }
    System.out.println();
}
```

## Circular Behavior

### Wrap-Around Logic
The circular nature is achieved through modulo arithmetic:
- **Enqueue**: `rear = (rear + 1) % capacity`
- **Dequeue**: `front = (front + 1) % capacity`
- **Full Check**: `(rear + 1) % capacity == front`

### State Transitions
- **Empty State**: `front = -1, rear = -1`
- **Single Element**: `front = 0, rear = 0`
- **Normal State**: `front < rear` (linear)
- **Wrapped State**: `front > rear` (circular)
- **Full State**: `(rear + 1) % capacity == front`

### Visual Representation
```
Capacity = 5
Initial: [ ][ ][ ][ ][ ]  (front=-1, rear=-1)

After 1,2,3: [1][2][3][ ][ ]  (front=0, rear=2)

After 4,5: [1][2][3][4][5]  (front=0, rear=4) -> FULL

After dequeue(1): [ ][2][3][4][5]  (front=1, rear=4)

After enqueue(6): [6][2][3][4][5]  (front=1, rear=0) -> WRAPPED
```

## Menu-Driven Interface

### Main Method Features
The main method provides an interactive menu-driven interface:

```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Enter the capacity of the circular queue: ");
        int size = sc.nextInt();
        CircularQueue cq = new CircularQueue(size);

        int choice;
        do {
            System.out.println("\n--- Circular Queue Operations ---");
            System.out.println("1. Enqueue (Insert)");
            System.out.println("2. Dequeue (Delete)");
            System.out.println("3. Peek (Front)");
            System.out.println("4. Check Empty");
            System.out.println("5. Check Full");
            System.out.println("6. Display Queue");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            // Switch case for operations...
        } while (choice != 7);
    }
}
```

### Menu Options
1. **Enqueue**: Insert element into queue
2. **Dequeue**: Remove element from queue
3. **Peek**: View front element
4. **Check Empty**: Verify if queue is empty
5. **Check Full**: Verify if queue is full
6. **Display Queue**: Show all queue elements
7. **Exit**: Terminate program

## Performance Analysis

### Time Complexity
| Operation | Time Complexity | Description |
|-----------|----------------|-------------|
| Enqueue | O(1) | Constant time insertion |
| Dequeue | O(1) | Constant time removal |
| Peek | O(1) | Constant time access |
| isEmpty | O(1) | Constant time check |
| isFull | O(1) | Constant time check |
| Display | O(n) | Linear traversal |

### Space Complexity
- **Total Space**: O(n) where n is the queue capacity
- **Per Element**: O(1) - 4 bytes for each int
- **Overhead**: O(1) - Fixed queue object overhead
- **No Dynamic Growth**: Fixed memory allocation

### Performance Advantages
- **No Element Shifting**: Unlike linear queues, no need to shift elements
- **Constant Time Operations**: All basic operations are O(1)
- **Efficient Space Usage**: Reuses space automatically
- **Predictable Performance**: Consistent performance regardless of queue state

## Error Handling

### Exception Types
1. **Queue Overflow**: Attempting to enqueue into a full queue
2. **Queue Underflow**: Attempting to dequeue from an empty queue
3. **Invalid Input**: Non-integer input for menu choices
4. **No Input**: End of input stream

### Error Handling Mechanisms
```java
try (Scanner sc = new Scanner(System.in)) {
    // Main logic
} catch (InputMismatchException e) {
    System.err.println("Error: Please enter valid integers.");
} catch (NoSuchElementException e) {
    System.err.println("Error: No input provided.");
}
```

### Graceful Degradation
- **Overflow**: Displays error message, continues operation
- **Underflow**: Displays error message, returns sentinel value (-1)
- **Invalid Input**: Caught by exception handler, program continues

## Usage Examples

### Basic Operations
```java
// Create circular queue with capacity 5
CircularQueue queue = new CircularQueue(5);

// Enqueue elements
queue.enqueue(10);  // Insert 10
queue.enqueue(20);  // Insert 20
queue.enqueue(30);  // Insert 30

// Check queue state
boolean isEmpty = queue.isEmpty();  // false
boolean isFull = queue.isFull();    // false

// Peek front element
int front = queue.peek();  // 10

// Dequeue element
int removed = queue.dequeue();  // 10

// Display queue
queue.display();  // Shows: 20 30
```

### Circular Behavior Example
```java
CircularQueue queue = new CircularQueue(3);

// Fill queue completely
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
// Queue is now full: [1][2][3]

// Remove element and add new one
queue.dequeue();  // Remove 1
queue.enqueue(4); // Add 4 (wraps to position 0)
// Queue now: [4][2][3] (front=1, rear=0)

// Continue operations
queue.dequeue();  // Remove 2
queue.enqueue(5); // Add 5 (wraps to position 1)
// Queue now: [4][5][3] (front=2, rear=1)
```

## Comparison with Other Queue Implementations

### CircularQueue vs Linear Queue
| Feature | CircularQueue | Linear Queue |
|---------|---------------|-------------|
| Space Utilization | Efficient (reuses space) | Inefficient (wasted space) |
| Enqueue | O(1) | O(1) |
| Dequeue | O(1) | O(n) (needs shifting) |
| Memory Usage | Fixed | Dynamic |
| Complexity | Moderate | Simple |

### CircularQueue vs ArrayDeque
| Feature | CircularQueue | ArrayDeque |
|---------|---------------|-----------|
| Size | Fixed | Dynamic |
| Performance | O(1) operations | O(1) operations |
| Memory Usage | Predictable | Variable |
| Thread Safety | No | No |
| Use Case | Fixed buffers | General purpose |

## Applications

### Real-World Use Cases
1. **Buffer Management**: Network buffers, audio/video buffers
2. **Task Scheduling**: Round-robin scheduling algorithms
3. **Producer-Consumer**: Bounded producer-consumer problems
4. **Data Streaming**: Circular buffers for streaming data
5. **Memory Management**: Fixed-size memory pools

### Advantages in Applications
- **Predictable Memory**: Fixed size prevents memory overflow
- **Efficient Operations**: Constant time operations
- **Space Reuse**: Automatic space recycling
- **Simple Implementation**: Easy to understand and maintain

## Best Practices

### Usage Guidelines
1. **Capacity Planning**: Choose appropriate capacity based on expected load
2. **Error Checking**: Always check isEmpty/isFull before operations
3. **Resource Management**: Close resources properly in main method
4. **Input Validation**: Validate user input in menu-driven interface

### Optimization Tips
1. **Capacity Choice**: Use powers of 2 for better modulo performance
2. **Batch Operations**: Group multiple operations when possible
3. **State Monitoring**: Regularly check queue state
4. **Memory Efficiency**: Use appropriate data types

## Limitations and Considerations

### Limitations
1. **Fixed Size**: Cannot grow beyond initial capacity
2. **Integer Only**: Only supports integer data type
3. **Not Thread Safe**: Not designed for concurrent access
4. **Single Type**: Cannot store mixed data types

### Considerations
1. **Capacity Selection**: Choose capacity carefully based on requirements
2. **Error Handling**: Implement proper error handling for production use
3. **Thread Safety**: Add synchronization for multi-threaded environments
4. **Data Types**: Consider generic implementation for type flexibility

## Implementation Variations

### Generic CircularQueue
```java
public class CircularQueue<T> {
    private T[] queue;
    private int front, rear, capacity;
    
    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        queue = (T[]) new Object[size];
        capacity = size;
        front = rear = -1;
    }
    
    public void enqueue(T item) { /* implementation */ }
    public T dequeue() { /* implementation */ }
    // ... other methods
}
```

### Thread-Safe CircularQueue
```java
public class ThreadSafeCircularQueue {
    private final Object lock = new Object();
    private int[] queue;
    private int front, rear, capacity;
    
    public synchronized void enqueue(int item) {
        synchronized(lock) {
            // implementation
        }
    }
    
    public synchronized int dequeue() {
        synchronized(lock) {
            // implementation
        }
    }
}
```

## Debugging and Troubleshooting

### Common Issues
1. **Index Out of Bounds**: Incorrect modulo arithmetic
2. **State Inconsistency**: Front and rear pointer mismanagement
3. **Logic Errors**: Incorrect empty/full conditions
4. **Memory Issues**: Large capacity allocation

### Debugging Techniques
1. **State Visualization**: Print front, rear, and array contents
2. **Step-by-Step Execution**: Trace operations manually
3. **Boundary Testing**: Test with edge cases
4. **Performance Profiling**: Measure operation times

### Debug Output Example
```java
public void debugState() {
    System.out.println("=== Queue State ===");
    System.out.println("Capacity: " + capacity);
    System.out.println("Front: " + front);
    System.out.println("Rear: " + rear);
    System.out.println("Is Empty: " + isEmpty());
    System.out.println("Is Full: " + isFull());
    System.out.println("Array: " + Arrays.toString(queue));
}
```

## Conclusion

The `CircularQueue.java` implementation provides an efficient, fixed-size queue data structure with constant time operations for all basic queue operations. Its circular nature allows for efficient space utilization and makes it ideal for applications requiring bounded buffers with predictable memory usage. The implementation includes comprehensive error handling, a user-friendly menu interface, and demonstrates proper Java programming practices.

## Key Takeaways
- **Efficient Operations**: All basic operations are O(1)
- **Space Optimization**: Circular reuse of array space
- **Predictable Memory**: Fixed-size allocation
- **Simple Logic**: Clear and maintainable implementation
- **Practical Applications**: Useful in many real-world scenarios

## Related Files
- **CircularQueue_Test.java**: Comprehensive test suite
- **CircularQueue_Test_Documentation.md**: Test documentation
- **circular_queue_test_results.txt**: Generated test results
- **TestFramework.java**: Master testing infrastructure

# DequeOperations Documentation

## Overview

The `DequeOperations.java` file implements a double-ended queue (Deque) data structure using a circular array-based approach. This implementation provides efficient operations for both front and rear insertions and deletions, making it ideal for applications requiring both FIFO and LIFO operations.

## Algorithm Summary

**Deque Operations**: A fixed-size deque implemented using a circular array that allows insertion and deletion from both ends, providing efficient FIFO and LIFO operations.
- **Time Complexity**: O(1) for all basic operations
- **Space Complexity**: O(n) where n is the deque capacity
- **Structure**: Circular array with front and rear pointers
- **Applications**: Palindrome checking, sliding window problems, task scheduling

## Class Structure

### Core Components
```java
public class DequeOperations {
    private int[] deque;      // Array to store deque elements
    private int front;        // Front pointer (index of front element)
    private int rear;         // Rear pointer (index of rear element)
    private int capacity;     // Maximum capacity of the deque
}
```

### Constructor
```java
public DequeOperations(int size) {
    deque = new int[size];    // Initialize array with specified capacity
    capacity = size;          // Set capacity
    front = -1;               // Initialize front to -1 (empty deque)
    rear = -1;                // Initialize rear to -1 (empty deque)
}
```

## Core Operations

### 1. InsertFront Operation
**Purpose**: Insert an element at the front of the deque
**Time Complexity**: O(1)
**Algorithm**:
1. Check if deque is full
2. If deque is empty, set front and rear to 0
3. If front is at index 0, wrap around to capacity-1
4. Otherwise, decrement front
5. Insert element at front position
6. Display success message

```java
public void insertFront(int item) {
    if (isFull()) {
        System.out.println("Deque Overflow! Cannot insert at front.");
        return;
    }
    if (front == -1) {
        front = 0;
        rear = 0;
    } else if (front == 0) {
        front = capacity - 1;
    } else {
        front--;
    }
    deque[front] = item;
    System.out.println(MessageFormat.format("Inserted {0} at front.", item));
}
```

### 2. InsertRear Operation
**Purpose**: Insert an element at the rear of the deque
**Time Complexity**: O(1)
**Algorithm**:
1. Check if deque is full
2. If deque is empty, set front and rear to 0
3. If rear is at capacity-1, wrap around to 0
4. Otherwise, increment rear
5. Insert element at rear position
6. Display success message

```java
public void insertRear(int item) {
    if (isFull()) {
        System.out.println("Deque Overflow! Cannot insert at rear.");
        return;
    }
    if (front == -1) {
        front = 0;
        rear = 0;
    } else if (rear == capacity - 1) {
        rear = 0;
    } else {
        rear++;
    }
    deque[rear] = item;
    System.out.println(MessageFormat.format("Inserted {0} at rear.", item));
}
```

### 3. DeleteFront Operation
**Purpose**: Remove and return the element from the front of the deque
**Time Complexity**: O(1)
**Algorithm**:
1. Check if deque is empty
2. Store front element to return
3. If deque has only one element, reset front and rear to -1
4. If front is at capacity-1, wrap around to 0
5. Otherwise, increment front
6. Return the removed element

```java
public int deleteFront() {
    if (isEmpty()) {
        System.out.println("Deque Underflow! Cannot delete from front.");
        return -1;
    }
    int item = deque[front];
    if (front == rear) {
        front = -1;
        rear = -1;
    } else if (front == capacity - 1) {
        front = 0;
    } else {
        front++;
    }
    return item;
}
```

### 4. DeleteRear Operation
**Purpose**: Remove and return the element from the rear of the deque
**Time Complexity**: O(1)
**Algorithm**:
1. Check if deque is empty
2. Store rear element to return
3. If deque has only one element, reset front and rear to -1
4. If rear is at 0, wrap around to capacity-1
5. Otherwise, decrement rear
6. Return the removed element

```java
public int deleteRear() {
    if (isEmpty()) {
        System.out.println("Deque Underflow! Cannot delete from rear.");
        return -1;
    }
    int item = deque[rear];
    if (front == rear) {
        front = -1;
        rear = -1;
    } else if (rear == 0) {
        rear = capacity - 1;
    } else {
        rear--;
    }
    return item;
}
```

### 5. isEmpty Operation
**Purpose**: Check if the deque is empty
**Time Complexity**: O(1)
**Algorithm**: Return true if front is -1

```java
public boolean isEmpty() {
    return front == -1;
}
```

### 6. isFull Operation
**Purpose**: Check if the deque is full
**Time Complexity**: O(1)
**Algorithm**: Check two conditions for full deque

```java
public boolean isFull() {
    return (front == 0 && rear == capacity - 1) || (front == rear + 1);
}
```

### 7. Display Operation
**Purpose**: Display all elements in the deque
**Time Complexity**: O(n)
**Algorithm**:
1. Check if deque is empty
2. Start from front position
3. Traverse circularly until rear position is reached
4. Print each element

```java
public void display() {
    if (isEmpty()) {
        System.out.println("Deque is empty.");
        return;
    }
    System.out.print("Deque elements: ");
    int i = front;
    while (true) {
        System.out.print(deque[i] + " ");
        if (i == rear) break;
        i = (i + 1) % capacity;
    }
    System.out.println();
}
```

## Circular Behavior

### Wrap-Around Logic
The circular nature is achieved through careful pointer management:
- **InsertFront**: `front = (front == 0) ? capacity - 1 : front - 1`
- **InsertRear**: `rear = (rear == capacity - 1) ? 0 : rear + 1`
- **DeleteFront**: `front = (front == capacity - 1) ? 0 : front + 1`
- **DeleteRear**: `rear = (rear == 0) ? capacity - 1 : rear - 1`

### State Transitions
- **Empty State**: `front = -1, rear = -1`
- **Single Element**: `front = 0, rear = 0`
- **Normal State**: `front < rear` (linear)
- **Wrapped State**: `front > rear` (circular)
- **Full State**: `(front == 0 && rear == capacity - 1) || (front == rear + 1)`

### Visual Representation
```
Capacity = 5
Initial: [ ][ ][ ][ ][ ]  (front=-1, rear=-1)

After insertFront(10): [10][ ][ ][ ][ ]  (front=0, rear=0)

After insertRear(20): [10][20][ ][ ][ ]  (front=0, rear=1)

After insertFront(5): [5][10][20][ ][ ]  (front=4, rear=1) -> WRAPPED

After deleteFront(): [ ][10][20][ ][ ]  (front=0, rear=1)

After insertRear(25): [ ][10][20][25][ ]  (front=0, rear=2)
```

## Menu-Driven Interface

### Main Method Features
The main method provides an interactive menu-driven interface:

```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Enter capacity: ");
        int size = sc.nextInt();
        DequeOperations dq = new DequeOperations(size);

        int choice;
        do {
            System.out.println("\n--- Deque Operations ---");
            System.out.println("1. Insert Front  2. Insert Rear");
            System.out.println("3. Delete Front  4. Delete Rear");
            System.out.println("5. Display       6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            // Switch case for operations...
        } while (choice != 6);
    }
}
```

### Menu Options
1. **Insert Front**: Insert element at front
2. **Insert Rear**: Insert element at rear
3. **Delete Front**: Remove element from front
4. **Delete Rear**: Remove element from rear
5. **Display**: Show all deque elements
6. **Exit**: Terminate program

## Performance Analysis

### Time Complexity
| Operation | Time Complexity | Description |
|-----------|----------------|-------------|
| InsertFront | O(1) | Constant time insertion at front |
| InsertRear | O(1) | Constant time insertion at rear |
| DeleteFront | O(1) | Constant time deletion from front |
| DeleteRear | O(1) | Constant time deletion from rear |
| isEmpty | O(1) | Constant time check |
| isFull | O(1) | Constant time check |
| Display | O(n) | Linear traversal |

### Space Complexity
- **Total Space**: O(n) where n is the deque capacity
- **Per Element**: O(1) - 4 bytes for each int
- **Overhead**: O(1) - Fixed deque object overhead
- **No Dynamic Growth**: Fixed memory allocation

### Performance Advantages
- **Double-Ended Operations**: Efficient insertion/deletion from both ends
- **No Element Shifting**: Unlike linear arrays, no need to shift elements
- **Constant Time Operations**: All basic operations are O(1)
- **Efficient Space Usage**: Reuses space automatically through circular behavior

## Error Handling

### Exception Types
1. **Deque Overflow**: Attempting to insert into a full deque
2. **Deque Underflow**: Attempting to delete from an empty deque
3. **Invalid Input**: Non-integer input for menu choices
4. **No Input**: End of input stream

### Error Handling Mechanisms
```java
try (Scanner sc = new Scanner(System.in)) {
    // Main logic
} catch (Exception e) {
    System.err.println("Error occurred.");
}
```

### Graceful Degradation
- **Overflow**: Displays error message, continues operation
- **Underflow**: Displays error message, returns sentinel value (-1)
- **Invalid Input**: Caught by exception handler, program continues

## Usage Examples

### Basic Operations
```java
// Create deque with capacity 5
DequeOperations deque = new DequeOperations(5);

// Insert elements at both ends
deque.insertFront(10);  // Insert at front
deque.insertRear(20);   // Insert at rear
deque.insertFront(5);   // Insert at front
deque.insertRear(25);   // Insert at rear

// Delete elements from both ends
int deletedFront = deque.deleteFront();  // Remove from front (5)
int deletedRear = deque.deleteRear();    // Remove from rear (25)

// Display deque
deque.display();  // Shows: 10 20
```

### Circular Behavior Example
```java
DequeOperations deque = new DequeOperations(3);

// Fill deque completely
deque.insertRear(1);
deque.insertRear(2);
deque.insertRear(3);
// Deque is now full: [1][2][3]

// Remove from front and add to rear
deque.deleteFront();  // Remove 1
deque.insertRear(4); // Add 4 (wraps to position 0)
// Deque now: [4][2][3] (front=1, rear=0) -> WRAPPED

// Continue operations
deque.deleteRear();   // Remove 3
deque.insertFront(5); // Add 5 (wraps to position 2)
// Deque now: [4][2][5] (front=2, rear=2)
```

### Mixed Operations
```java
DequeOperations deque = new DequeOperations(5);

// Mixed insertions
deque.insertFront(10);
deque.insertRear(20);
deque.insertFront(5);
deque.insertRear(25);
// Deque: [5, 10, 20, 25]

// Mixed deletions
deque.deleteFront(); // Remove 5
deque.deleteRear();  // Remove 25
// Deque: [10, 20]

// More mixed operations
deque.insertFront(99); // Insert at front
deque.insertRear(88); // Insert at rear
// Final deque: [99, 10, 20, 88]
```

## Comparison with Other Deque Implementations

### DequeOperations vs ArrayDeque
| Feature | DequeOperations | ArrayDeque |
|---------|----------------|-----------|
| Size | Fixed | Dynamic |
| Performance | O(1) operations | O(1) operations |
| Memory Usage | Predictable | Variable |
| Thread Safety | No | No |
| Use Case | Fixed buffers | General purpose |

### DequeOperations vs LinkedList
| Feature | DequeOperations | LinkedList |
|---------|----------------|-----------|
| Size | Fixed | Dynamic |
| Performance | O(1) operations | O(1) operations |
| Memory Usage | Predictable | Variable |
| Thread Safety | No | No |
| Use Case | Fixed buffers | Frequent insertions |

### DequeOperations vs Stack/Queue
| Feature | DequeOperations | Stack | Queue |
|---------|----------------|-------|-------|
| Operations | Both ends | Top only | Rear only |
| Flexibility | High | Low | Medium |
| Performance | O(1) | O(1) | O(1) |
| Use Cases | Complex | Simple | Simple |

## Applications

### Real-World Use Cases
1. **Palindrome Checking**: Insert from front, compare with rear
2. **Sliding Window**: Maintain window of fixed size
3. **Task Scheduling**: Priority from both ends
4. **Undo/Redo Operations**: Maintain operation history
5. **Expression Evaluation**: Operator and operand management

### Advantages in Applications
- **Dual Operations**: Can act as both stack and queue
- **Efficient Access**: O(1) access from both ends
- **Predictable Memory**: Fixed size prevents overflow
- **Circular Reuse**: Efficient space utilization
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
3. **State Monitoring**: Regularly check deque state
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

### Generic DequeOperations
```java
public class DequeOperations<T> {
    private T[] deque;
    private int front, rear, capacity;
    
    @SuppressWarnings("unchecked")
    public DequeOperations(int size) {
        deque = (T[]) new Object[size];
        capacity = size;
        front = rear = -1;
    }
    
    public void insertFront(T item) { /* implementation */ }
    public void insertRear(T item) { /* implementation */ }
    public T deleteFront() { /* implementation */ }
    public T deleteRear() { /* implementation */ }
    // ... other methods
}
```

### Thread-Safe DequeOperations
```java
public class ThreadSafeDequeOperations {
    private final Object lock = new Object();
    private int[] deque;
    private int front, rear, capacity;
    
    public synchronized void insertFront(int item) {
        synchronized(lock) {
            // implementation
        }
    }
    
    public synchronized int deleteFront() {
        synchronized(lock) {
            // implementation
        }
    }
    
    // ... other synchronized methods
}
```

## Debugging and Troubleshooting

### Common Issues
1. **Index Out of Bounds**: Incorrect circular arithmetic
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
    System.out.println("=== Deque State ===");
    System.out.println("Capacity: " + capacity);
    System.out.println("Front: " + front);
    System.out.println("Rear: " + rear);
    System.out.println("Is Empty: " + isEmpty());
    System.out.println("Is Full: " + isFull());
    System.out.println("Array: " + Arrays.toString(deque));
}
```

## Mathematical Properties

### Circular Arithmetic
The deque uses circular arithmetic for efficient space utilization:
- **Front Movement**: `(front + capacity - 1) % capacity` for insertFront
- **Rear Movement**: `(rear + 1) % capacity` for insertRear
- **Wrap-Around**: Automatic when reaching array boundaries

### Full Condition
The deque is full when either:
1. `front == 0 && rear == capacity - 1` (linear full)
2. `front == rear + 1` (circular full)

### Empty Condition
The deque is empty when `front == -1` (and consequently `rear == -1`)

## Advanced Applications

### Palindrome Checking
```java
public static boolean isPalindrome(String str) {
    DequeOperations deque = new DequeOperations(str.length());
    
    // Insert all characters
    for (char c : str.toCharArray()) {
        deque.insertRear(c);
    }
    
    // Compare front and rear
    while (!deque.isEmpty() && deque.getDequeSize() > 1) {
        char front = (char) deque.deleteFront();
        char rear = (char) deque.deleteRear();
        if (front != rear) {
            return false;
        }
    }
    
    return true;
}
```

### Sliding Window Maximum
```java
public static int[] slidingWindowMaximum(int[] arr, int k) {
    DequeOperations deque = new DequeOperations(k);
    int[] result = new int[arr.length - k + 1];
    
    for (int i = 0; i < arr.length; i++) {
        // Remove elements out of window
        while (!deque.isEmpty() && deque.getFront() <= i - k) {
            deque.deleteFront();
        }
        
        // Remove smaller elements
        while (!deque.isEmpty() && arr[deque.getRear()] <= arr[i]) {
            deque.deleteRear();
        }
        
        deque.insertRear(i);
        
        // Add maximum to result
        if (i >= k - 1) {
            result[i - k + 1] = arr[deque.getFront()];
        }
    }
    
    return result;
}
```

## Conclusion

The `DequeOperations.java` implementation provides an efficient, fixed-size deque data structure with constant time operations for all basic deque operations. Its double-ended nature makes it versatile for various applications requiring both stack and queue operations, while its circular implementation ensures efficient space utilization and predictable memory usage.

## Key Takeaways
- **Efficient Operations**: All basic operations are O(1)
- **Double-Ended**: Supports operations from both ends
- **Circular Reuse**: Efficient space utilization
- **Predictable Memory**: Fixed-size allocation
- **Simple Logic**: Clear and maintainable implementation
- **Versatile Applications**: Useful in many real-world scenarios

## Related Files
- **DequeOperations_Test.java**: Comprehensive test suite
- **DequeOperations_Test_Documentation.md**: Test documentation
- **deque_operations_test_results.txt**: Generated test results
- **TestFramework.java**: Master testing infrastructure

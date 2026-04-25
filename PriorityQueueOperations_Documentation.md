# PriorityQueueOperations Documentation

## Overview

The `PriorityQueueOperations.java` file implements a comprehensive Priority Queue data structure using Java's built-in `PriorityQueue` class. This implementation provides a menu-driven interface for performing core priority queue operations and demonstrates the practical application of priority-based data structures.

## Algorithm Summary

**Priority Queue**: A data structure that maintains elements in priority order, allowing efficient access to the highest priority element.
- **Time Complexity**: O(log n) for insert/delete, O(1) for peek
- **Space Complexity**: O(n) - Linear with number of elements
- **Approach**: Min-heap implementation using Java's PriorityQueue
- **Applications**: Task scheduling, Dijkstra's algorithm, Huffman coding

## Class Structure

### Core Implementation
```java
public class PriorityQueueOperations {
    private PriorityQueue<Integer> pq;

    public PriorityQueueOperations() {
        pq = new PriorityQueue<>();
    }

    public void insert(int item) {
        pq.offer(item);
        System.out.println(MessageFormat.format("Inserted {0} into the priority queue.", item));
    }

    public int delete() {
        if (isEmpty()) {
            System.out.println("Priority Queue Underflow! Cannot delete.");
            return -1;
        }
        return pq.poll();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        return pq.peek();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.print("Priority Queue elements (Internal Array Order): ");
        System.out.println(pq);
    }
}
```

### Menu-Driven Interface
```java
public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        PriorityQueueOperations pqOps = new PriorityQueueOperations();

        int choice;
        do {
            System.out.println("\n--- Priority Queue Operations ---");
            System.out.println("1. Insert (Offer)");
            System.out.println("2. Delete (Poll)");
            System.out.println("3. Peek (Front)");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int item = sc.nextInt();
                    pqOps.insert(item);
                    break;
                case 2:
                    int deleted = pqOps.delete();
                    if (deleted != -1) {
                        System.out.println("Deleted (Highest Priority): " + deleted);
                    }
                    break;
                case 3:
                    int frontItem = pqOps.peek();
                    if (frontItem != -1) {
                        System.out.println("Front (Highest Priority): " + frontItem);
                    }
                    break;
                case 4:
                    pqOps.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    } catch (InputMismatchException e) {
        System.err.println("Error: Please enter valid integers.");
    } catch (NoSuchElementException e) {
        System.err.println("Error: No input provided.");
    }
}
```

## Core Algorithm

### Priority Queue Operations
The implementation provides four core operations:

1. **Insert (Offer)**: Add element to queue maintaining heap property
2. **Delete (Poll)**: Remove and return highest priority element
3. **Peek**: Return highest priority element without removal
4. **Display**: Show current queue contents

### Insert Operation
```java
public void insert(int item) {
    pq.offer(item);
    System.out.println(MessageFormat.format("Inserted {0} into the priority queue.", item));
}
```

### Delete Operation
```java
public int delete() {
    if (isEmpty()) {
        System.out.println("Priority Queue Underflow! Cannot delete.");
        return -1;
    }
    return pq.poll();
}
```

### Peek Operation
```java
public int peek() {
    if (isEmpty()) {
        System.out.println("Priority Queue is empty.");
        return -1;
    }
    return pq.peek();
}
```

### Step-by-Step Example
```
Initial State: Empty Queue

Step 1: Insert 30
Queue: [30]
Priority: 30 (highest)

Step 2: Insert 10
Queue: [10, 30]
Priority: 10 (highest)

Step 3: Insert 20
Queue: [10, 30, 20]
Priority: 10 (highest)

Step 4: Peek
Result: 10 (highest priority)
Queue: [10, 30, 20]

Step 5: Delete
Result: 10 (removed)
Queue: [20, 30]
Priority: 20 (new highest)

Step 6: Peek
Result: 20 (highest priority)
Queue: [20, 30]
```

## Algorithm Analysis

### Time Complexity
- **Insert**: O(log n) - Heap insertion with bubble-up
- **Delete**: O(log n) - Heap removal with bubble-down
- **Peek**: O(1) - Access root element
- **Display**: O(n) - Traversal of all elements

### Space Complexity
- **Total Space**: O(n) - Linear with element count
- **Per Element**: ~16 bytes (object overhead)
- **Heap Structure**: Complete binary tree
- **Memory Overhead**: Java object overhead per element

### Performance Characteristics
| Operation | Time Complexity | Space Complexity | Description |
|-----------|------------------|------------------|-------------|
| Insert | O(log n) | O(1) | Add element maintaining heap |
| Delete | O(log n) | O(1) | Remove highest priority |
| Peek | O(1) | O(1) | Access highest priority |
| Display | O(n) | O(1) | Show all elements |

## Mathematical Properties

### Heap Property
- **Min-Heap**: Parent ≤ Children for all nodes
- **Complete Binary Tree**: All levels filled except possibly last
- **Heap Order**: Elements maintain priority relationship
- **Structure**: Array representation of complete binary tree

### Priority Ordering
- **Highest Priority**: Smallest element (min-heap)
- **Extraction Order**: Ascending order
- **Insertion Order**: Not preserved
- **Stability**: Not guaranteed for equal elements

### Mathematical Relations
- **Parent Index**: (i - 1) / 2
- **Left Child**: 2i + 1
- **Right Child**: 2i + 2
- **Height**: ⌊log₂ n⌋

## User Interface

### Menu-Driven Operation
The program provides an interactive console interface:

1. **Insert (Offer)**: Add element to priority queue
2. **Delete (Poll)**: Remove highest priority element
3. **Peek (Front)**: View highest priority element
4. **Display Queue**: Show current queue contents
5. **Exit**: Terminate program

### Input Validation
- **Integer Validation**: Ensures valid integer input
- **Error Handling**: Comprehensive exception management
- **User Feedback**: Clear error messages and confirmations
- **Graceful Exit**: Clean program termination

### Output Formats
```java
// Insert confirmation
System.out.println(MessageFormat.format("Inserted {0} into the priority queue.", item));

// Delete result
System.out.println("Deleted (Highest Priority): " + deleted);

// Peek result
System.out.println("Front (Highest Priority): " + frontItem);

// Display queue
System.out.println("Priority Queue elements (Internal Array Order): " + pq);
```

## Usage Examples

### Basic Operations
```java
// Input:
// 1. Insert (Offer)
// Enter element: 30
// 1. Insert (Offer)
// Enter element: 10
// 1. Insert (Offer)
// Enter element: 20
// 3. Peek (Front)
// 2. Delete (Poll)
// 3. Peek (Front)
// 4. Display Queue
// 5. Exit

// Output:
// Inserted 30 into the priority queue.
// Inserted 10 into the priority queue.
// Inserted 20 into the priority queue.
// Front (Highest Priority): 10
// Deleted (Highest Priority): 10
// Front (Highest Priority): 20
// Priority Queue elements (Internal Array Order): [20, 30]
// Exiting...
```

### Large Dataset Operations
```java
// Insert multiple elements: 50, 20, 40, 10, 30
// Queue maintains priority order internally
// Delete operations return: 10, 20, 30, 40, 50
```

### Edge Case Operations
```java
// Empty queue operations:
// Peek: "Priority Queue is empty."
// Delete: "Priority Queue Underflow! Cannot delete."
// Display: "Priority Queue is empty."
```

## Comparison with Other Queue Implementations

### Queue Implementation Comparison
| Implementation | Time Complexity | Space Complexity | Thread-Safe | Priority Support |
|---------------|------------------|------------------|-------------|------------------|
| PriorityQueue | O(log n) | O(n) | No | Yes |
| LinkedList | O(1) | O(n) | No | No |
| ArrayDeque | O(1) | O(n) | No | No |
| Vector | O(n) | O(n) | Yes | No |

### Performance Recommendations
- **Priority Access**: Use PriorityQueue
- **Simple Queue**: Use ArrayDeque
- **Frequent Insertions**: Use LinkedList
- **Thread Safety**: Use Vector
- **Memory Efficiency**: Use ArrayDeque

### Use Case Scenarios
- **Task Scheduling**: PriorityQueue for priority-based execution
- **Event Handling**: PriorityQueue for time-based events
- **Pathfinding**: PriorityQueue for Dijkstra's algorithm
- **Data Compression**: PriorityQueue for Huffman coding
- **Load Balancing**: PriorityQueue for priority-based distribution

## Best Practices

### Implementation Guidelines
1. **Input Validation**: Always validate user input
2. **Error Handling**: Implement comprehensive exception management
3. **Memory Management**: Monitor queue size for large datasets
4. **Code Documentation**: Add clear comments and documentation
5. **User Experience**: Provide clear feedback and error messages

### Optimization Tips
1. **Initial Capacity**: Set appropriate initial capacity
2. **Bulk Operations**: Use efficient bulk insertion methods
3. **Custom Comparators**: Implement custom priority logic
4. **Memory Monitoring**: Track memory usage for large queues
5. **Performance Testing**: Measure with realistic data sizes

### Code Quality
- **Clear Documentation**: Comprehensive method documentation
- **Modular Design**: Separate concerns (UI, operations, validation)
- **Reusable Components**: Utility methods for common tasks
- **Maintainable Structure**: Easy to extend and modify
- **Consistent Style**: Follow Java coding conventions

## Limitations and Considerations

### Current Implementation
1. **Integer Only**: Limited to integer data type
2. **Min-Heap Only**: Fixed priority ordering (smallest = highest)
3. **No Thread Safety**: Not designed for concurrent access
4. **Memory Usage**: Object overhead per element
5. **No Custom Comparators**: Fixed priority logic

### Considerations for Improvement
1. **Generic Implementation**: Support for different data types
2. **Custom Comparators**: Flexible priority ordering
3. **Thread Safety**: Synchronized operations
4. **Memory Optimization**: Primitive type implementations
5. **Advanced Operations**: Bulk operations, monitoring

### Implementation Variations

### Generic Priority Queue
```java
public class GenericPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> pq;
    
    public GenericPriorityQueue() {
        pq = new PriorityQueue<>();
    }
    
    public GenericPriorityQueue(Comparator<? super T> comparator) {
        pq = new PriorityQueue<>(comparator);
    }
    
    public void insert(T item) {
        pq.offer(item);
    }
    
    public T delete() {
        return pq.poll();
    }
    
    public T peek() {
        return pq.peek();
    }
}
```

### Max-Heap Priority Queue
```java
public class MaxHeapPriorityQueue {
    private PriorityQueue<Integer> maxHeap;
    
    public MaxHeapPriorityQueue() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void insert(int item) {
        maxHeap.offer(item);
    }
    
    public int delete() {
        return maxHeap.poll();
    }
    
    public int peek() {
        return maxHeap.peek();
    }
}
```

### Custom Comparator Priority Queue
```java
public class CustomPriorityQueue {
    private PriorityQueue<String> pq;
    
    public CustomPriorityQueue() {
        pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Custom priority logic (e.g., by length)
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }
    
    public void insert(String item) {
        pq.offer(item);
    }
    
    public String delete() {
        return pq.poll();
    }
    
    public String peek() {
        return pq.peek();
    }
}
```

### Thread-Safe Priority Queue
```java
public class ThreadSafePriorityQueue {
    private PriorityQueue<Integer> pq;
    private Object lock = new Object();
    
    public ThreadSafePriorityQueue() {
        pq = new PriorityQueue<>();
    }
    
    public void insert(int item) {
        synchronized (lock) {
            pq.offer(item);
        }
    }
    
    public int delete() {
        synchronized (lock) {
            return pq.poll();
        }
    }
    
    public int peek() {
        synchronized (lock) {
            return pq.peek();
        }
    }
    
    public boolean isEmpty() {
        synchronized (lock) {
            return pq.isEmpty();
        }
    }
}
```

## Debugging and Troubleshooting

### Common Issues
1. **Priority Confusion**: Understanding min-heap behavior
2. **Empty Operations**: Handling empty queue gracefully
3. **Memory Issues**: Large queue allocation
4. **Order Confusion**: Internal vs priority order

### Debugging Techniques
1. **State Visualization**: Display queue state after operations
2. **Step-by-Step**: Trace operations manually
3. **Performance Profiling**: Measure operation times
4. **Memory Monitoring**: Track memory usage
5. **Error Logging**: Add debug output for each step

### Debug Output Example
```java
public void debugQueue() {
    System.out.println("=== Priority Queue Debug ===");
    System.out.println("Queue size: " + pq.size());
    System.out.println("Is empty: " + pq.isEmpty());
    if (!pq.isEmpty()) {
        System.out.println("Next element: " + pq.peek());
    }
    System.out.println("Internal order: " + pq.toString());
    
    System.out.println("Priority order: ");
    PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
    while (!temp.isEmpty()) {
        System.out.print(temp.poll() + " ");
    }
    System.out.println();
}
```

## Real-World Applications

### Computer Science
- **Task Scheduling**: Priority-based task execution
- **Event Handling**: Time-based event processing
- **Pathfinding**: Dijkstra's algorithm implementation
- **Data Compression**: Huffman coding tree construction
- **Load Balancing**: Priority-based request distribution

### Software Engineering
- **Job Queues**: Priority-based job processing
- **Message Queues**: Priority message handling
- **Cache Management**: LRU cache implementation
- **Resource Allocation**: Priority-based resource assignment
- **Network Routing**: Priority-based packet routing

### System Design
- **Operating Systems**: Process scheduling
- **Database Systems**: Query optimization
- **Web Servers**: Request prioritization
- **Distributed Systems**: Task distribution
- **Real-time Systems**: Priority-based interrupt handling

## Conclusion

The `PriorityQueueOperations.java` implementation provides a comprehensive demonstration of priority queue operations with an interactive user interface. While the basic implementation has limitations, it effectively illustrates the fundamental concepts of priority-based data structures and serves as an excellent foundation for understanding more advanced priority queue applications and optimizations.

## Key Takeaways
- **Priority Queue**: Priority-based element ordering
- **Time Complexity**: O(log n) for insert/delete, O(1) for peek
- **Space Complexity**: O(n) linear with elements
- **Min-Heap**: Smallest element has highest priority
- **Applications**: Task scheduling, Dijkstra's algorithm
- **Educational Value**: Foundation for understanding priority-based data structures
- **Performance**: Consistent O(log n) operations
- **Memory Usage**: Linear with number of elements
- **Queue Comparison**: Trade-offs with other queue implementations
- **Real-World Applications**: Task scheduling, event handling, pathfinding algorithms

## Related Files
- **PriorityQueueOperations.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **PriorityQueueOperations_Documentation.md**: Algorithm documentation
- **priority_queue_operations_test_results.txt**: Generated test results
- **PriorityQueueOperations_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Priority Queue**: Priority-based element ordering
- **Time Complexity**: O(log n) for insert/delete, O(1) for peek
- **Space Complexity**: O(n) linear with elements
- **Min-Heap**: Smallest element has highest priority
- **Applications**: Task scheduling, Dijkstra's algorithm
- **Educational Value**: Foundation for understanding priority-based data structures
- **Performance**: Consistent O(log n) operations
- **Memory Usage**: Linear with number of elements
- **Queue Comparison**: Trade-offs with other queue implementations
- **Real-World Applications**: Task scheduling, event handling, pathfinding algorithms

## Related Files
- **PriorityQueueOperations.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **PriorityQueueOperations_Documentation.md**: Algorithm documentation
- **priority_queue_operations_test_results.txt**: Generated test results
- **PriorityQueueOperations_Test_Documentation.md**: Test documentation

## Key Takeaways
- **Priority Queue**: Priority-based element ordering
- **Time Complexity**: O(log n) for insert/delete, O(1) for peek
- **Space Complexity**: O(n) linear with elements
- **Min-Heap**: Smallest element has highest priority
- **Applications**: Task scheduling, Dijkstra's algorithm
- **Educational Value**: Foundation for understanding priority-based data structures
- **Performance**: Consistent O(log n) operations
- **Memory Usage**: Linear with number of elements
- **Queue Comparison**: Trade-offs with other queue implementations
- **Real-World Applications**: Task scheduling, event handling, pathfinding algorithms

# Error Handling Guide

This document provides comprehensive information about error handling for all algorithms in the DSA Java project. It explains what happens for invalid/null/empty inputs and includes expected behavior and exception strategies.

## 🔍 Error Handling Overview

### Error Categories
- **Input Validation Errors**: Invalid user input
- **Boundary Condition Errors**: Edge cases and limits
- **Resource Errors**: Memory or system limitations
- **Logic Errors**: Algorithm-specific issues
- **Integration Errors**: Component interaction problems

### Error Handling Strategy
1. **Input Validation**: Validate all user input
2. **Graceful Degradation**: Handle errors without crashing
3. **Clear Messaging**: Provide helpful error messages
4. **Recovery Options**: Allow user to retry or correct input

### Expected Behavior
- **Consistent Messages**: Standardized error message format
- **User Guidance**: Clear instructions for fixing errors
- **Program Continuation**: Program continues when possible
- **Graceful Exit**: Clean termination when necessary

## 🔍 Search Algorithms

### Binary Search

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Return -1 | "Array is null" | Return -1 |
| Empty array | Return -1 | "Array is empty" | Return -1 |
| Unsorted array | May return incorrect result | "Warning: Array should be sorted" | Return -1 |
| Invalid target | Return -1 | "Element not found" | Return -1 |

#### Implementation
```java
public static int binarySearch(int[] arr, int target) {
    if (arr == null) {
        System.out.println("Array is null");
        return -1;
    }
    
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return -1;
    }
    
    // Binary search implementation
    int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1; // Target not found
}
```

### Linear Search

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Return -1 | "Array is null" | Return -1 |
| Empty array | Return -1 | "Array is empty" | Return -1 |
| Invalid target | Return -1 | "Element not found" | Return -1 |

#### Implementation
```java
public static int linearSearch(int[] arr, int target) {
    if (arr == null) {
        System.out.println("Array is null");
        return -1;
    }
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    
    return -1; // Target not found
}
```

## 🔢 Array Operations

### Insert Element

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Invalid index | Do nothing | "Invalid index: " + index | Return |
| Index out of bounds | Do nothing | "Index out of bounds: " + index | Return |
| Array full | Do nothing | "Array is full" | Return |

#### Implementation
```java
public static void insertElement(int[] arr, int index, int element) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (index < 0 || index >= arr.length) {
        System.out.println("Invalid index: " + index);
        return;
    }
    
    // Shift elements to the right
    for (int i = arr.length - 1; i > index; i--) {
        if (i < arr.length - 1) {
            arr[i] = arr[i - 1];
        }
    }
    
    arr[index] = element;
}
```

### Remove Element

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Invalid index | Do nothing | "Invalid index: " + index | Return |
| Index out of bounds | Do nothing | "Index out of bounds: " + index | Return |
| Empty array | Do nothing | "Array is empty" | Return |

#### Implementation
```java
public static void removeElement(int[] arr, int index) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (index < 0 || index >= arr.length) {
        System.out.println("Invalid index: " + index);
        return;
    }
    
    // Shift elements to the left
    for (int i = index; i < arr.length - 1; i++) {
        if (i < arr.length - 1) {
            arr[i] = arr[i + 1];
        }
    }
    
    arr[arr.length - 1] = 0; // Optional: Set last element to default
}
```

### Traversal

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |

#### Implementation
```java
public static void traverse(int[] arr) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    for (int i = 0; i < arr.length; i++) {
        System.out.println("Index " + i + ": " + arr[i]);
    }
}
```

## 📊 Sorting Algorithms

### Bubble Sort

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public static void bubbleSort(int[] arr) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    // Bubble sort implementation
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

### Insertion Sort

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public static void insertionSort(int[] arr) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    // Insertion sort implementation
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

### Selection Sort

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public static void selectionSort(int[] arr) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    // Selection sort implementation
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
```

### Merge Sort

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |
| Invalid bounds | Do nothing | "Invalid bounds" | Return |

#### Implementation
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
```

### Quick Sort

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null array | Do nothing | "Array is null" | Return |
| Empty array | Do nothing | "Array is empty" | Return |
| Stack overflow | May crash | "Stack overflow" | Handle gracefully |
| Invalid bounds | Do nothing | "Invalid bounds" | Return |

#### Implementation
```java
public static void quickSort(int[] arr, int low, int high) {
    if (arr == null) {
        System.out.println("Array is null");
        return;
    }
    
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, -1);
        quickSort(arr, pi + 1, high);
    }
}
```

## 🔗 Data Structures

### Linked List with Addresses

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null list | Do nothing | "List is null" | Return |
| Invalid position | Do nothing | "Invalid position" | Return |
| Position out of bounds | Do nothing | "Invalid position" | Return |
| Empty list | Do nothing | "List is empty" | Return |

#### Implementation
```java
public void insertAtPosition(int position, int data) {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    
    if (position < 0) {
        System.out.println("Invalid position: " + position);
        return;
    }
    
    if (position == 0) {
        insertBeginning(data);
        return;
    }
    
    Node current = head;
    int count = 0;
    
    while (current != null && count < position - 1) {
        current = current.next;
        count++;
    }
    
    if (current == null) {
        System.out.println("Invalid position: " + position);
        return;
    }
    
    Node newNode = new Node(data);
    newNode.next = current.next;
    current.next = newNode;
}
```

### Stack Operations

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null stack | Do nothing | "Stack is null" | Return |
| Empty stack | Return -1 (for peek/pop) | "Stack is empty" | Return -1 |
| Full stack | Do nothing | "Stack Overflow!" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public int pop() {
    if (stack.isEmpty()) {
        System.out.println("Stack Underflow! Cannot delete.");
        return -1;
    }
    
    return stack.pop();
}
```

### Queue Operations

#### Linear Queue

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null queue | Do nothing | "Queue is null" | Return |
| Empty queue | Return -1 (for dequeue) | "Queue Underflow! Cannot delete." | Return -1 |
| Full queue | Do nothing | "Queue Overflow!" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public int dequeue() {
    if (front == -1) {
        System.out.println("Queue Underflow! Cannot delete.");
        return -1;
    }
    
    int item = queue[front];
    
    if (front >= rear) {
        front = -1;
        rear = -1;
    } else {
        front++;
    }
    
    return item;
}
```

### Circular Queue

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null queue | Do nothing | "Queue is null" | Return |
| Empty queue | Return -1 (for dequeue) | "Queue Underflow! Cannot delete." | Return -1 |
| Full queue | Do nothing | "Queue Full" | Return |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public int dequeue() {
    if (front == -1) {
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

### Priority Queue

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null queue | Do nothing | "Priority Queue is null" | Return |
| Empty queue | Return -1 (for poll) | "Queue is empty" | Return -1 |
| Invalid element | Do nothing | "Invalid element" | Return |

#### Implementation
```java
public int poll() {
    if (priorityQueue.isEmpty()) {
        System.out.println("Priority Queue is empty");
        return -1;
    }
    
    return priorityQueue.poll();
}
```

### Deque Operations

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null deque | Do nothing | "Deque is null" | Return |
| Empty deque | Return -1 (for delete) | "Deque is empty" | Return -1 |
| Full deque | Do nothing | "Deque is full" | Return |
| Invalid position | Do nothing | "Invalid position" | Return |

#### Implementation
```java
public int deleteFront() {
    if (isEmpty()) {
        System.out.println("Deque is empty");
        return -1;
    }
    
    int item = deque[front];
    
    if (front == rear) {
        front = -1;
        rear = -1;
    } else {
        front = (front + 1) % capacity;
    }
    
    return item;
}
```

## 🔢 Matrix Operations

### Matrix Multiplication

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| Null matrix | Do nothing | "Matrix is null" | Return |
| Invalid dimensions | Do nothing | "Invalid dimensions" | Return |
| Mismatched dimensions | Do nothing | "Invalid dimensions" | Return |

#### Implementation
```java
public int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
    if (mat1 == null || mat2 == null) {
        System.out.println("Matrix is null");
        return null;
    }
    
    int rows1 = mat1.length;
    int cols1 = mat1[0].length;
    int cols2 = mat2[0].length;
    
    if (cols1 != cols2) {
        System.out.println("Invalid dimensions");
        return null;
    }
    
    int[][] result = new int[rows1][cols2];
    
    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            result[i][j] = 0;
            for (int k = 0; k < cols2; k++) {
                result[i][j] += mat1[i][k] * mat2[k][j];
            }
        }
    }
    
    return result;
}
```

## 🎯 Sample Programs

### Sample (Hello World)

#### Error Scenarios
| Error Condition | Expected Behavior | Error Message | Recovery |
|----------------|------------------|-------------|---------|
| No input required | Always works | "Hello, World!" | N/A |

#### Implementation
```java
public static void main(String[] args) {
    System.out.println("Hello, World!");
}
```

## 🔍 Common Error Patterns

### Input Validation Errors

#### Invalid Data Types
```java
// Problem: User enters text instead of numbers
Enter the number of elements: five
// Error: InputMismatchException

// Solution: Use numeric input only
Enter the number of elements: 5
```

#### Array Size Mismatch
```java
// Problem: User enters 5 elements but array size is 3
Enter the number of elements: 5
Enter 5 elements:
Element 0: 1
Element 1: 2
Element 2: 3
// Error: ArrayIndexOutOfBounds

// Solution: Match element count to array size
Enter the number of elements: 3
Enter 3 elements:
Element 0: 1
Element 1: 2
Element 2: 3
```

#### Index Out of Bounds
```java
// Problem: Invalid index for array size
Enter index to insert: 10
// Array size: 5
// Error: ArrayIndexOutOfBoundsException

// Solution: Use valid index range
Enter index to insert: 4
```

### Resource Errors

#### Memory Exhaustion
```java
// Problem: Array too large for available memory
Enter the number of elements: 10000000
// Error: OutOfMemoryError

// Solution: Use smaller array size
Enter the number of elements: 1000
```

#### Stack Overflow
```java
// Problem: Deep recursion in recursive algorithms
// Error: StackOverflowError

// Solution: Use iterative approach
// Or increase stack size: -Xss
```

### Logic Errors

#### Unsorted Input for Binary Search
```java
// Problem: Binary search on unsorted data
Enter the number of elements: 5
Enter 5 elements:
Element 0: 5
Element 1: 2
Element 2: 8
Element 3: 1
Element 4: 3
// Binary search result: wrong

// Solution: Sort array first
Enter the number of elements: 5
Enter 5 elements:
Element 0: 1
Element 1: 2
Element 2: 3
Element 3: 5
Element 4: 8
```

## 🔧 Debugging Error Handling

### Logging Best Practices
```java
// Log all error conditions
if (arr == null) {
    System.err.println("ERROR: Array is null at " + new Date());
    return;
}

// Log validation failures
if (index < 0 || index >= arr.length) {
    System.err.println("ERROR: Invalid index " + index + " at " + new Date());
    return;
}
```

### Unit Testing Error Cases
```java
@Test
public void testNullArray() {
    int[] arr = null;
    int result = binarySearch(arr, 5);
    assertEquals(-1, result);
}

@Test
public void testEmptyArray() {
    int[] arr = {};
    int result = binarySearch(arr, 5);
    assertEquals(-1, result);
}

@Test
public void testInvalidIndex() {
    int[] arr = {1, 2, 3};
    int result = binarySearch(arr, 5);
    assertEquals(-1, result);
}
```

## 🔧 Error Message Standards

### Message Format
- **Clear and Specific**: Clearly indicate the problem
- **User-Friendly**: Provide actionable guidance
- **Consistent**: Use standard message formats
- **Informative**: Include context when helpful

### Message Examples
```java
// Good: "Array is null"
// Bad: "Error: Null array"
// Good: "Invalid index: 5 (array size: 3)"
// Bad: "Index out of bounds"
// Good: "Queue Underflow! Cannot delete."
// Bad: "Queue empty"
```

### Recovery Strategies
- **Retry Mechanism**: Allow user to re-enter input
- **Default Values**: Provide sensible defaults when possible
- **Graceful Exit**: Exit cleanly when unrecoverable
- **Alternative Paths**: Offer alternative approaches

## 🔍 Algorithm-Specific Error Handling

### Search Algorithms

#### Binary Search
```java
public static int binarySearch(int[] arr, int target) {
    try {
        if (arr == null) throw new IllegalArgumentException("Array cannot be null");
        
        // Check if array is sorted
        if (!isSorted(arr)) {
            System.out.println("Warning: Array should be sorted for binary search");
        }
        
        return binarySearchInternal(arr, target);
    } catch (IllegalArgumentException e) {
        System.err.println("Error: " + e.getMessage());
        return -1;
    }
}
```

### Sorting Algorithms

#### Merge Sort
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (arr == null) {
        throw new IllegalArgumentException("Array cannot be null");
    }
    
    if (left < right) {
        try {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        } catch (StackOverflowError e) {
            System.err.println("Error: Stack overflow in merge sort");
            // Fallback to iterative approach
            iterativeMergeSort(arr, left, right);
        }
    }
}
```

### Data Structures

#### Linked List
```java
public void insertAtPosition(int position, int data) {
    if (position < 0 || position > size()) {
        throw new IllegalArgumentException("Invalid position: " + position);
    }
    
    if (position == 0) {
        insertBeginning(data);
        return;
    }
    
    // Continue with normal implementation...
}
```

## 🔍 Testing Error Handling

### Test Case Categories
```java
@Test(expected = IllegalArgumentException.class)
public void testNullArray() {
    int[] arr = null;
    assertThrows(IllegalArgumentException.class, () -> binarySearch(arr, 5));
}

@Test(expected = IndexOutOfBoundsException.class)
public void testInvalidIndex() {
    int[] arr = {1, 2, 3};
    assertThrows(IndexOutOfBoundsException.class, () -> binarySearch(arr, -1));
}
```

## 🔗 Recovery Mechanisms

### Input Retry Loop
```java
int readInt(Scanner scanner, String prompt) {
    while (true) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // consume invalid token
        } catch (NoSuchElementException e) {
            System.err.println("Error: Required input was not found.");
            System.exit(1);
        }
    }
}
```

### Default Values
```java
public int search(int[] arr, int target) {
    if (arr == null) {
        return -1; // Default for not found
    }
    // Continue with search logic...
}
```

### Validation Methods
```java
private boolean isValidArray(int[] arr) {
    return arr != null && arr.length > 0;
}

private boolean isValidIndex(int[] arr, int index) {
    return isValidArray(arr) && index >= 0 && index < arr.length;
}
```

---

## 🔗 Related Documents

### Algorithm Documentation
- [Algorithm Documentation Index](INDEX.md)
- [Algorithm Template](ALGORITHM_TEMPLATE.md)
- [Test Case Matrix](TEST_CASE_MATRIX.md)
- [Complexity Table](COMPLEXITY_TABLE.md)

### User Guides
- [Getting Started](../README.md#getting-started)
- [Contributing Guide](../CONTRIBUTING.md)
- [Code of Conduct](../CODE_OF_CONDUCT.md)
- [Security Policy](../SECURITY.md)

### Development Documentation
- [Naming Conventions](NAMING_CONVENTIONS.md)
- [FAQ](FAQ.md)
- [Learning Path](LEARNING_PATH.md)

---

*This error handling guide is continuously updated to reflect the current implementations in the DSA Java project. Last updated: April 25, 2025*

---

*For questions about specific error handling or to report unhandled error scenarios, please refer to the [Contributing Guide](../CONTRIBUTING.md) or create an issue in the project repository.*

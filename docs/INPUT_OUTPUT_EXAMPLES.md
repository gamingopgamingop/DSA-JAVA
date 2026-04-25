# Input Output Examples

This document provides sample inputs and expected outputs for all algorithms in the DSA Java project. It helps beginners understand how to run each program correctly and verify the results.

## 🔍 How to Use This Document

### For Each Algorithm:
1. **Copy the Sample Input** exactly as shown
2. **Run the Algorithm** with the sample input
3. **Compare Your Output** with the Expected Output
4. **Troubleshoot**: If outputs don't match, check input format

### Input Format
- **Console Input**: Type exactly as shown in examples
- **Data Separation**: Use spaces between numbers
- **End of Input**: Press Enter after last input

### Output Format
- **Console Output**: Should match expected output exactly
- **Spacing**: Pay attention to spaces and line breaks
- **Messages**: Program-specific messages should match

## 📊 Search Algorithms

### Binary Search

#### Sample Input
```
Enter the number of elements: 7
Enter 7 elements:
Element 0: 2
Element 1: 5
Element 2: 8
Element 3: 12
Element 4: 16
Element 5: 19
Element 6: 23
Enter element to search: 12
```

#### Expected Output
```
Array has been sorted: [2, 5, 8, 12, 16, 19, 23]
Element found at index: 3
```

#### Additional Examples

**Target Not Found:**
```
Enter element to search: 15
Element not found in the array.
```

**Single Element Array:**
```
Enter the number of elements: 1
Enter 1 elements:
Element 0: 42
Enter element to search: 42
Array has been sorted: [42]
Element found at index: 0
```

**Empty Array:**
```
Enter the number of elements: 0
Array has been sorted: []
Enter element to search: 5
Element not found in the array.
```

### Linear Search

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 20
Element 2: 30
Element 3: 40
Element 4: 50
Enter element to search: 30
```

#### Expected Output
```
Element found at index: 2
```

#### Additional Examples

**Element Not Found:**
```
Enter element to search: 25
Element not found in the array.
```

**First Element:**
```
Enter element to search: 10
Element found at index: 0
```

**Last Element:**
```
Enter element to search: 50
Element found at index: 4
```

### Linear Search With Frequency

#### Sample Input
```
Enter the number of elements: 6
Enter 6 elements:
Element 0: 1
Element 1: 2
Element 2: 3
Element 3: 2
Element 4: 4
Element 5: 5
Enter target element: 2
```

#### Expected Output
```
Target element 2 appeared 2 times.
```

#### Additional Examples

**Element Not Present:**
```
Enter target element: 6
Target element 6 appeared 0 times.
```

**All Same Elements:**
```
Enter target element: 1
Target element 1 appeared 0 times.
```

## 📊 Sorting Algorithms

### Bubble Sort

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 64
Element 1: 34
Element 2: 25
Element 3: 12
Element 4: 22
```

#### Expected Output
```
Original Array: [64, 34, 25, 12, 22]
Sorted Array: [12, 22, 25, 34, 64]
```

#### Additional Examples

**Already Sorted:**
```
Enter the number of elements: 4
Enter 4 elements:
Element 0: 1
Element 1: 2
Element 2: 3
Element 3: 4
Original Array: [1, 2, 3, 4]
Sorted Array: [1, 2, 3, 4]
```

**Reverse Sorted:**
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 5
Element 1: 4
Element 2: 3
Element 3: 2
Element 4: 1
Original Array: [5, 4, 3, 2, 1]
Sorted Array: [1, 2, 3, 4, 5]
```

### Insertion Sort

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 64
Element 1: 34
Element 2: 25
Element 3: 12
Element 4: 22
```

#### Expected Output
```
Original Array: [64, 34, 25, 12, 22]
Sorted Array: [12, 22, 25, 34, 64]
```

#### Additional Examples

**Single Element:**
```
Enter the number of elements: 1
Enter 1 elements:
Element 0: 42
Original Array: [42]
Sorted Array: [42]
```

### Selection Sort

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 64
Element 1: 34
Element 2: 25
Element 3: 12
Element 4: 22
```

#### Expected Output
```
Original Array: [64, 34, 25, 12, 22]
Sorted Array: [12, 22, 25, 34, 64]
```

#### Additional Examples

**Duplicate Elements:**
```
Enter the number of elements: 6
Enter 6 elements:
Element 0: 5
Element 1: 2
Element 2: 8
Element 3: 5
Element 4: 2
Element 5: 8
Original Array: [5, 2, 8, 5, 2, 8]
Sorted Array: [2, 2, 5, 5, 8, 8]
```

### Merge Sort

#### Sample Input
```
Enter the number of elements: 7
Enter 7 elements:
Element 0: 38
Element 1: 27
Element 2: 43
Element 3: 3
Element 4: 9
Element 5: 82
Element 6: 10
```

#### Expected Output
```
Original Array: [38, 27, 43, 3, 9, 82, 10]
Sorted Array (via Iterator): 3 9 10 27 38 43 82 
Summary: Merge Sort completed on 7 elements. Sorted Array: [3, 9, 10, 27, 38, 43, 82]
```

#### Additional Examples

**Large Array:**
```
Enter the number of elements: 1000
Enter 1000 elements:
Element 0: 500
Element 1: 250
...
Element 999: 1
Original Array: [500, 250, 125, ..., 2, 1]
Sorted Array (via Iterator): 1 2 3 4 ... 498 499 500
Summary: Merge Sort completed on 1000 elements. Sorted Array: [1, 2, 3, 4, ..., 498, 499, 500]
```

### Quick Sort

#### Sample Input
```
Enter the number of elements: 7
Enter 7 elements:
Element 0: 10
Element 1: 80
Element 2: 30
Element 3: 90
Element 4: 40
Element 5: 50
Element 6: 70
```

#### Expected Output
```
Original Array: [10, 80, 30, 90, 40, 50, 70]
Sorted Array (via Iterator): 10 30 40 50 70 80 90 
Summary: Quick Sort completed on 7 elements. Sorted Array: [10, 30, 40, 50, 70, 80, 90]
```

#### Additional Examples

**Already Sorted:**
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 1
Element 1: 2
Element 2: 3
Element 3: 4
Element 4: 5
Original Array: [1, 2, 3, 4, 5]
Sorted Array (via Iterator): 1 2 3 4 5 
Summary: Quick Sort completed on 5 elements. Sorted Array: [1, 2, 3, 4, 5]
```

## 📊 Statistical Analysis

### Second Smallest & Second Largest

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 5
Element 2: 20
Element 3: 15
Element 4: 8
```

#### Expected Output
```
Original Array: [10, 5, 20, 15, 8]
Smallest: 5
Largest: 20
```

#### Additional Examples

**All Same Elements:**
```
Enter the number of elements: 4
Enter 4 elements:
Element 0: 7
Element 1: 7
Element 2: 7
Element 3: 7
Original Array: [7, 7, 7, 7]
Smallest: 7
Largest: 7
```

### Smallest & Largest

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 5
Element 2: 20
Element 3: 15
Element 4: 8
```

#### Expected Output
```
Original Array: [10, 5, 20, 15, 8]
Smallest: 5
Largest: 20
```

## 🔗 Data Structures

### Linked List with Addresses

#### Sample Input
```
1. Insert Beginning
2. Insert End
3. Insert at Position
4. Delete Beginning
5. Delete End
6. Display
7. Exit
Enter choice: 1
Enter element: 10
Enter choice: 2
Enter element: 20
Enter choice: 3
Enter position: 2
Enter element: 15
Enter choice: 4
Enter choice: 5
Enter choice: 6
Node 1: [10] | Address: 12345
Node 2: [20] | Address: 12346
Node 3: [15] | Address: 12347
Enter choice: 7
```

#### Expected Output
```
Node 1: [10] | Address: 12345
Node 2: [20] | Address: 12346
Node 3: [15] | Address: 12347
```

### Stack Operations

#### Sample Input
```
Enter stack size: 3
1. Push
2. Pop
3. Peek
4. IsEmpty
5. IsFull
6. Display
7. Exit
Enter choice: 1
Enter element: 10
Enter choice: 1
Enter element: 20
Enter choice: 1
Enter element: 30
Enter choice: 1
Enter element: 40
Enter choice: 1
Stack Overflow!
Enter choice: 2
Popped: 40
Enter choice: 3
Top element: 30
Enter choice: 4
Stack is not empty
Enter choice: 5
Stack is not full
Enter choice: 6
Stack elements: 10 20 30
Enter choice: 7
```

#### Expected Output
```
Stack Overflow!
Popped: 40
Top element: 30
Stack is not empty
Stack is not full
Stack elements: 10 20 30
```

### Linear Queue

#### Sample Input
```
Enter queue size: 3
1. Insert
2. Delete
3. Peek
4. IsEmpty
5. IsFull
6. Display
7. Exit
Enter choice: 1
Enter element: 10
Enter choice: 1
Enter element: 20
Enter choice: 1
Enter element: 30
Enter choice: 1
Queue Overflow!
Enter choice: 2
Dequeued: 10
Enter choice: 3
Front element: 20
Enter choice: 6
Queue elements: 20 30
Enter choice: 7
```

#### Expected Output
```
Queue Overflow!
Dequeued: 10
Front element: 20
Queue elements: 20 30
```

### Circular Queue

#### Sample Input
```
Enter queue size: 3
1. Insert
2. Delete
3. Peek
4. IsEmpty
5. IsFull
6. Display
7. Exit
Enter choice: 1
Enter element: 10
Enter choice: 1
Enter element: 20
Enter choice: 1
Enter element: 30
Enter choice: 2
Dequeued: 10
Enter choice: 1
Enter element: 40
Enter choice: 6
Queue elements: 20 30 40
Enter choice: 7
```

#### Expected Output
```
Dequeued: 10
Queue elements: 20 30 40
```

### Deque Operations

#### Sample Input
```
Enter deque size: 5
1. Insert Front
2. Insert Rear
3. Delete Front
4. Delete Rear
5. Display
6. Exit
Enter choice: 1
Enter element: 10
Enter choice: 2
Enter element: 20
Enter choice: 5
Deque elements: 10 20
Enter choice: 3
Deleted from front: 10
Enter choice: 4
Deleted from rear: 20
Enter choice: 5
Deque is empty
Enter choice: 7
```

#### Expected Output
```
Deque elements: 10 20
Deleted from front: 10
Deleted from rear: 20
Deque is empty
```

### Priority Queue

#### Sample Input
```
1. Insert (Offer)
2. Delete (Poll)
3. Peek (Front)
4. Display Queue
5. Exit
Enter choice: 1
Enter element: 30
Enter choice: 1
Enter element: 10
Enter choice: 1
Enter element: 20
Enter choice: 1
Enter element: 40
Enter choice: 2
Deleted (Highest Priority): 10
Enter choice: 3
Front (Highest Priority): 20
Enter choice: 4
Priority Queue elements (Internal Array Order): [20, 40, 30]
Enter choice: 5
```

#### Expected Output
```
Deleted (Highest Priority): 10
Front (Highest Priority): 20
Priority Queue elements (Internal Array Order): [20, 40, 30]
```

### Queue Using Array

#### Sample Input
```
1.Insert 2.Delete 3.Display 4.Exit
Enter choice: 1
Enter element: 10
Enter choice: 1
Enter element: 20
Enter choice: 1
Enter element: 30
Enter choice: 1
Enter element: 40
Enter choice: 1
Enter element: 50
Enter choice: 1
Queue Full
Enter choice: 2
Deleted: 10
Enter choice: 2
Deleted: 20
Enter choice: 2
Deleted: 30
Enter choice: 2
Deleted: 40
Enter choice: 2
Deleted: 50
Enter choice: 2
Queue Underflow! Cannot delete.
Enter choice: 3
Queue elements: [0, 0, 0, 0, 0]
Enter choice: 4
Exiting...
```

#### Expected Output
```
Queue Full
Deleted: 10
Deleted: 20
Deleted: 30
Deleted: 40
Deleted: 50
Queue Underflow! Cannot delete.
Queue elements: [0, 0, 0, 0, 0]
Exiting...
```

## 🔢 Array Operations

### Insert Element

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 20
Element 2: 30
Element 3: 40
Element 4: 50
Enter index to insert: 2
Enter element to insert: 15
```

#### Expected Output
```
Original Array: [10, 20, 30, 40, 50]
Array after insertion: [10, 20, 15, 30, 40, 50]
```

#### Additional Examples

**Insert at Beginning:**
```
Enter index to insert: 0
Enter element to insert: 5
Array after insertion: [5, 10, 20, 30, 40, 50]
```

**Insert at End:**
```
Enter index to insert: 6
Enter element to insert: 60
Array after insertion: [10, 20, 30, 40, 50, 60]
```

### Remove Element

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 20
Element 2: 30
Element 3: 40
Element 4: 50
Enter index to remove: 2
```

#### Expected Output
```
Original Array: [10, 20, 30, 40, 50]
Array after removal: [10, 20, 40, 50, 0]
```

#### Additional Examples

**Remove from Beginning:**
```
Enter index to remove: 0
Original Array: [10, 20, 30, 40, 50]
Array after removal: [20, 30, 40, 50, 0]
```

**Remove from End:**
```
Enter index to remove: 4
Original Array: [10, 20, 30, 40, 50]
Array after removal: [10, 20, 30, 40, 0]
```

### Traversal

#### Sample Input
```
Enter the number of elements: 5
Enter 5 elements:
Element 0: 10
Element 1: 20
Element 2: 30
Element 3: 40
Element 4: 50
```

#### Expected Output
```
Index 0: 10
Index 1: 20
Index 2: 30
Index 3: 40
Index 4: 50
```

## 📐 Matrix Operations

### Matrix Multiplication

#### Sample Input
```
Enter the number of rows: 2
Enter the number of columns: 3
Enter number of columns: 3
Enter matrix 1 elements:
Row 1: 1, 2, 3
Row 2: 4, 5, 6
Enter matrix 2 elements:
Row 1: 7, 8, 9
Row 2: 10, 11, 12
```

#### Expected Output
```
Matrix 1:
Row 1: 1, 2, 3
Row 2: 4, 5, 6
Matrix 2:
Row 1: 7, 8, 9
Row 2: 10, 11, 12
Result Matrix:
Row 1: 58, 64, 70
Row 2: 139, 151, 163
```

#### Additional Examples

**Square Matrix:**
```
Enter the number of rows: 2
Enter the number of columns: 2
Enter number of columns: 2
Enter matrix 1 elements:
Row 1: 1, 2
Row 2: 3, 4
Enter matrix 2 elements:
Row 1: 5, 6
Row 2: 7, 8
Result Matrix:
Row 1: 19, 22
Row 2: 43, 50
```

**Rectangular Matrix:**
```
Enter the number of rows: 3
Enter the number of columns: 2
Enter number of columns: 2
Enter matrix 1 elements:
Row 1: 1, 2
Row 2: 3, 4
Row 3: 5, 6
Enter matrix 2 elements:
Row 1: 7, 8
Row 2: 9, 10
Row 3: 11, 12
Result Matrix:
Row 1: 23, 26
Row 2: 47, 50
Row 3: 71, 74
```

## 🎯 Sample Programs

### Sample (Hello World)

#### Sample Input
```
No input required
```

#### Expected Output
```
Hello, World!
```

## 🔍 Troubleshooting

### Common Input Issues

#### Invalid Input Format
**Problem**: Input doesn't match expected format
**Solution**: Check spacing and data types
**Example**: Use spaces between numbers: `1 2 3 4 5`

#### Extra Elements
**Problem**: Too many elements for specified size
**Solution**: Count elements carefully, match array size
**Example**: For size 5, provide exactly 5 elements

#### Missing Elements
**Problem**: Too few elements for specified size
**Solution**: Provide all required elements
**Example**: For size 5, provide exactly 5 elements

### Common Output Issues

#### Different Output Format
**Problem**: Output spacing or formatting differs
**Solution**: Check for extra spaces or missing spaces
**Example**: `[1, 2, 3]` vs `[1,2,3]`

#### Unexpected Messages
**Problem**: Error messages or warnings
**Solution**: Check input validation and error handling
**Example**: "Element not found" vs "Element found at index: X"

#### Algorithm-Specific Issues
**Binary Search**: Array must be sorted for binary search
**Bubble Sort**: May show intermediate steps in some implementations
**Quick Sort**: May show recursion depth or stack information

### Input Validation Tips

#### Data Types
- **Integers**: Use whole numbers (1, 2, 3, etc.)
- **Strings**: Use quotes if strings are supported
- **Characters**: Use single quotes for characters

#### Array Size
- **Exact Match**: Array size must match element count
- **Range**: Check minimum/maximum size limits
- **Zero Size**: Handle empty array case

#### Index Values
- **Zero-Based**: Most arrays use 0-based indexing
- **Range**: Ensure index is within array bounds
- **Negative**: Check if negative indices are supported

## 🔗 Quick Reference

### Algorithm Input Patterns

#### Sorting Algorithms
```
Enter the number of elements: N
Enter N elements:
Element 0: value1
...
Element N-1: valueN
```

#### Search Algorithms
```
Enter the number of elements: N
Enter N elements:
Element 0: value1
...
Element N-1: valueN
Enter element to search: target
```

#### Data Structures
```
Enter structure size: N
1. Operation 1
2. Operation 2
...
N. Operation N
Enter choice: X
[operation-specific input]
```

### Common Output Patterns

#### Success Messages
```
Element found at index: X
Sorted Array: [sorted elements]
Operation completed successfully
```

#### Error Messages
```
Element not found in the array
Queue Overflow!
Stack Underflow!
Invalid choice!
```

### Navigation Patterns
```
1. Operation 1
2. Operation 2
...
N. Operation N
Enter choice: X
```

## 📞 Algorithm-Specific Tips

### Binary Search
- **Required**: Array must be sorted
- **Validation**: Check if array is sorted before searching
- **Performance**: O(log n) for large datasets

### Bubble Sort
- **Stability**: Maintains relative order of equal elements
- **Performance**: O(n²) - not suitable for large datasets
- **Educational**: Good for understanding sorting concepts

### Merge Sort
- **Memory Usage**: Requires O(n) extra space
- **Stability**: Maintains relative order
- **Applications**: External sorting, stable sorting required

### Quick Sort
- **Performance**: Fast average case O(n log n)
- **Worst Case**: O(n²) for sorted or reverse sorted input
- **Memory**: O(log n) for recursive stack

### Linked List
- **Memory**: Each node requires extra memory for address
- **Performance**: O(1) for beginning/end, O(n) for middle
- **Flexibility**: Dynamic size, easy insertion/deletion

### Stack/Queue
- **LIFO/FIFO**: Stack uses Last In, First Out
- **Circular**: Circular queue prevents space waste
- **Priority**: Priority queue orders by element value

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

### Testing Documentation
- [Test Documentation Index](../Test_Documentation_Index.md)
- [Test Case Matrix](TEST_CASE_MATRIX.md)
- [Test Summary Report](../Test_Summary_Report.md)

---

*This input/output examples document is continuously updated to reflect the current implementations in the DSA Java project. Last updated: April 25, 2025*

---

*For questions about specific algorithm inputs/outputs or to report discrepancies, please refer to the [Contributing Guide](../CONTRIBUTING.md) or create an issue in the project repository.*

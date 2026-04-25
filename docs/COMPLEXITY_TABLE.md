# Complexity Analysis Table

This document provides a comprehensive comparison of time and space complexity for all algorithms implemented in the DSA Java project. It serves as a quick reference for algorithm selection and performance analysis.

## 📊 Complexity Overview

### Complexity Notation
- **O(1)**: Constant time - Execution time doesn't depend on input size
- **O(log n)**: Logarithmic time - Execution time grows logarithmically
- **O(n)**: Linear time - Execution time grows linearly
- **O(n log n)**: Linearithmic time - Between linear and quadratic
- **O(n²)**: Quadratic time - Execution time grows quadratically
- **O(n³)**: Cubic time - Execution time grows cubically

## 🔍 Sorting Algorithms Complexity

| Algorithm | Time Complexity | Space Complexity | Stable | In-Place | Best Case | Average Case | Worst Case |
|-----------|------------------|------------------|--------|----------|-----------|---------------|-----------|
| **Binary Search** | N/A | N/A | N/A | N/A | N/A | N/A | N/A |
| **Bubble Sort** | O(n²) | O(1) | ✅ | ✅ | O(n) | O(n²) | O(n²) |
| **Insertion Sort** | O(n²) | O(1) | ✅ | ✅ | O(n) | O(n²) | O(n²) |
| **Selection Sort** | O(n²) | O(1) | ❌ | ✅ | O(n²) | O(n²) | O(n²) |
| **Merge Sort** | O(n log n) | O(n) | ✅ | ❌ | O(n log n) | O(n log n) | O(n log n) |
| **Quick Sort** | O(n log n) | O(log n) | ❌ | ✅ | O(n log n) | O(n log n) | O(n²) |
| **Merge Sort Algorithm** | O(n log n) | O(n) | ✅ | ❌ | O(n log n) | O(n log n) | O(n log n) |
| **Quick Sort Algorithm** | O(n log n) | O(log n) | ❌ | ✅ | O(n log n) | O(n log n) | O(n²) |

### Sorting Algorithm Analysis

#### Time Complexity Comparison
- **Best Performance**: O(n log n) - Merge Sort, Quick Sort (average)
- **Worst Performance**: O(n²) - Bubble Sort, Insertion Sort, Selection Sort
- **Most Consistent**: O(n log n) algorithms
- **Least Consistent**: O(n²) algorithms

#### Space Complexity Comparison
- **Most Efficient**: O(1) - Bubble Sort, Insertion Sort, Selection Sort
- **Moderate**: O(log n) - Quick Sort (recursive stack)
- **Highest**: O(n) - Merge Sort (temporary arrays)

#### Stability Comparison
- **Stable**: Bubble Sort, Insertion Sort, Merge Sort
- **Unstable**: Selection Sort, Quick Sort
- **N/A**: Binary Search (searching algorithm)

## 🔍 Search Algorithms Complexity

| Algorithm | Time Complexity | Space Complexity | Best Case | Average Case | Worst Case | Notes |
|-----------|------------------|------------------|-----------|---------------|-----------|-------|
| **Linear Search** | O(n) | O(1) | O(1) | O(n) | O(n) | Simple implementation |
| **Linear Search With Frequency** | O(n) | O(1) | O(1) | O(n) | O(n) | Counts occurrences |
| **Binary Search** | O(log n) | O(1) | O(1) | O(log n) | O(log n) | Requires sorted input |

### Search Algorithm Analysis

#### Time Complexity Comparison
- **Best Performance**: O(1) - Linear Search (single element, first element)
- **Worst Performance**: O(n) - Linear Search (element not found)
- **Most Efficient**: O(log n) - Binary Search (large datasets)
- **Least Efficient**: O(n) - Linear Search (large datasets)

#### Space Complexity
- **All Search Algorithms**: O(1) - Constant extra space
- **No Additional Memory**: All operate in-place

#### When to Use
- **Binary Search**: Large sorted datasets, multiple searches
- **Linear Search**: Small datasets, unsorted data, simplicity preferred

## 📊 Statistical Analysis Complexity

| Algorithm | Time Complexity | Space Complexity | Best Case | Average Case | Worst Case | Notes |
|-----------|------------------|------------------|-----------|---------------|-----------|-------|
| **Second Smallest & Second Largest** | O(n) | O(1) | O(n) | O(n) | O(n) | Single pass |
| **Smallest & Largest** | O(n) | O(1) | O(n) | O(n) | O(n) | Single pass |

### Statistical Analysis Details

#### Time Complexity
- **Both Algorithms**: O(n) - Single pass through array
- **Space Complexity**: O(1) - Constant extra space
- **Implementation**: Both require single pass through array

#### Performance Characteristics
- **Consistent**: O(n) regardless of input distribution
- **Memory Efficient**: No additional memory allocation
- **Simple Implementation**: Easy to understand and implement

## 🔗 Data Structures Complexity

### Linked List Operations

| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Insert Beginning** | O(1) | O(1) | Direct access to head |
| **Insert End** | O(n) | O(1) | Must traverse to end |
| **Insert Middle** | O(n) | O(1) | Must find position |
| **Delete Beginning** | O(1) | O(1) | Direct access to head |
| **Delete End** | O(n) | O(1) | Must traverse to end |
| **Delete Middle** | O(n) | O(1) | Must find position |
| **Search** | O(n) | O(1) | Sequential search |
| **Traverse** | O(n) | O(1) | Visit all elements |

### Stack Operations

| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Push** | O(1) | O(1) | Direct array access |
| **Pop** | O(1) | O(1) | Direct array access |
| **Peek** | O(1) | O(1) | Direct array access |
| **IsEmpty** | O(1) | O(1) | Size check |
| **IsFull** | O(1) | O(1) | Size check |
| **Search** | O(n) | O(1) | Sequential search |

### Queue Operations

#### Linear Queue
| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Enqueue** | O(1) | O(1) | Direct array access |
| **Dequeue** | O(1) | O(1) | Direct array access |
| **Peek** | O(1) | O(1) | Direct array access |
| **IsEmpty** | O(1) | O(1) | Size check |
| **IsFull** | O(1) | O(1) | Size check |

#### Circular Queue
| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Enqueue** | O(1) | O(1) | Modulo arithmetic |
| **Dequeue** | O(1) | O(1) | Modulo arithmetic |
| **Peek** | O(1) | O(1) | Direct array access |
| **IsEmpty** | O(1) | O(1) | Size check |
| **IsFull** | O(1) | O(1) | Modulo check |

#### Priority Queue
| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Insert (Offer)** | O(log n) | O(1) | Heap insertion |
| **Delete (Poll)** | O(log n) | O(1) | Heap removal |
| **Peek** | O(1) | O(1) | Direct access |
| **IsEmpty** | O(1) | O(1) | Size check |

#### Deque Operations
| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Insert Front** | O(1) | O(1) | Modulo arithmetic |
| **Insert Rear** | O(1) | O(1) | Modulo arithmetic |
| **Delete Front** | O(1) | O(1) | Modulo arithmetic |
| **Delete Rear** | O(1) | O(1) | Modulo arithmetic |
| **Peek Front** | O(1) | O(1) | Direct array access |
| **Peek Rear** | O(1) | O(1) | Direct array access |

## 🔢 Array Operations Complexity

### Array Operations

| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Insert Element** | O(n) | O(1) | Shift elements right |
| **Remove Element** | O(n) | O(1) | Shift elements left |
| **Traversal** | O(n) | O(1) | Visit all elements |
| **Search** | O(n) | O(1) | Linear search |
| **Sort** | O(n log n) | O(1) | Efficient sorting |
| **Binary Search** | O(log n) | O(1) | Requires sorted input |

### Array Operation Analysis

#### Time Complexity
- **Insert/Remove**: O(n) - Need to shift elements
- **Traversal/Search**: O(n) - Linear scan
- **Sorting**: O(n log n) - Efficient sorting algorithms
- **Binary Search**: O(log n) - Very efficient for sorted data

#### Space Complexity
- **All Operations**: O(1) - In-place operations
- **No Additional Memory**: Operates directly on input array

## 📐 Matrix Operations Complexity

### Matrix Operations

| Operation | Time Complexity | Space Complexity | Notes |
|----------|------------------|------------------|-------|
| **Matrix Multiplication** | O(n³) | O(1) | Three nested loops |
| **Matrix Addition** | O(n²) | O(1) | Element-wise addition |
| **Matrix Transpose** | O(n²) | O(1) | Swap rows and columns |
| **Sparse Matrix** | O(nnz) | O(nnz) | Where nz = non-zero elements |

### Matrix Operation Analysis

#### Time Complexity
- **Multiplication**: O(n³) - Three nested loops for n×n matrices
- **Addition**: O(n²) - Element-wise operation
- **Transpose**: O(n²) - Swap elements across diagonal

#### Space Complexity
- **Dense Matrices**: O(n²) - Store all elements
- **Sparse Matrices**: O(nnz) - Store only non-zero elements
- **In-Place Operations**: O(1) - Modify existing matrices

## 📊 Complexity Comparison Summary

### By Time Complexity

| Complexity | Algorithms | Use Cases |
|------------|-------------|----------|
| **O(1)** | Stack/Queue peek, Array access | Constant time operations |
| **O(log n)** | Binary Search, Heap operations | Large datasets |
| **O(n)** | Linear Search, Array operations | Small to medium datasets |
| **O(n log n)** | Merge Sort, Quick Sort, Heap Sort | Large datasets |
| **O(n²)** | Bubble Sort, Insertion Sort, Selection Sort | Educational purposes |
| **O(n³)** | Matrix Multiplication | Matrix operations |

### By Space Complexity

| Complexity | Algorithms | Use Cases |
|------------|-------------|----------|
| **O(1)** | All in-place operations | Memory-constrained environments |
| **O(log n)** | Quick Sort (recursive) | Recursive algorithms |
| **O(n)** | Merge Sort, temporary arrays | When extra space is acceptable |
| **O(nnz)** | Sparse Matrix | Sparse data structures |

### By Algorithm Type

#### Sorting Algorithms
| Algorithm | Time | Space | Stable | In-Place | Best For |
|-----------|------|-------|--------|----------|
| **Bubble Sort** | O(n²) | O(1) | ✅ | ✅ | Educational |
| **Insertion Sort** | O(n²) | O(1) | ✅ | ✅ | Nearly sorted |
| **Selection Sort** | O(n²) | O(1) | ❌ | ✅ | Simple implementation |
| **Merge Sort** | O(n log n) | O(n) | ✅ | ❌ | External sorting |
| **Quick Sort** | O(n log n) | O(log n) | ❌ | ✅ | General purpose |

#### Search Algorithms
| Algorithm | Time | Space | Requirements | Best For |
|-----------|------|-------|-------------|----------|
| **Linear Search** | O(n) | O(1) | None | Unsorted data |
| **Binary Search** | O(log n) | O(1) | Sorted data | Large datasets |

#### Data Structures
| Structure | Insert | Delete | Search | Space | Best For |
|----------|--------|--------|--------|-------|----------|
| **Array** | O(n) | O(n) | O(n) | O(1) | Random access |
| **Linked List** | O(1) | O(n) | O(n) | O(n) | Frequent insert/delete |
| **Stack** | O(1) | O(1) | O(n) | O(1) | LIFO operations |
| **Queue** | O(1) | O(1) | O(n) | O(1) | FIFO operations |
| **Heap** | O(log n) | O(log n) | O(1) | O(n) | Priority operations |

## 🎯 Algorithm Selection Guide

### When to Use Each Algorithm

#### Sorting Algorithms
- **Bubble Sort**: Educational purposes, very small datasets
- **Insertion Sort**: Nearly sorted data, small datasets
- **Selection Sort**: Simple implementation, educational
- **Merge Sort**: External sorting, stability required
- **Quick Sort**: General purpose, best average performance

#### Search Algorithms
- **Binary Search**: Large sorted datasets, multiple searches
- **Linear Search**: Small datasets, unsorted data, simplicity

#### Data Structures
- **Array**: Random access, fixed size
- **Linked List**: Frequent insert/delete, dynamic size
- **Stack**: LIFO operations, function calls
- **Queue**: FIFO operations, task scheduling
- **Heap**: Priority operations, priority queues

## 📚 Performance Considerations

### Time vs Space Trade-offs
- **Time Optimization**: Often requires additional space
- **Space Optimization**: Often requires more time
- **Balanced Approach**: Consider both constraints

### Input Size Considerations
- **Small (n < 100)**: O(n²) algorithms may be acceptable
- **Medium (100 ≤ n ≤ 10000)**: O(n log n) algorithms preferred
- **Large (n > 10000)**: O(log n) algorithms essential

### Memory Constraints
- **Tight Memory**: Prefer O(1) space algorithms
- **Moderate Memory**: O(n) space algorithms acceptable
- **Abundant Memory**: Consider O(n log n) for better time performance

## 🔍 Complexity Analysis Guidelines

### How to Analyze Complexity
1. **Count Basic Operations**: Identify fundamental operations
2. **Count Nested Loops**: Multiply complexities of nested loops
3. **Count Recursive Calls**: Consider recursion depth
4. **Consider Data Structures**: Account for data structure overhead

### Common Patterns
- **Single Loop**: O(n)
- **Nested Loops**: O(n²), O(n³), etc.
- **Divide and Conquer**: O(n log n)
- **Recursion**: O(n) to O(log n) with memoization

### Space Analysis
- **Input Space**: Size of input data structure
- **Auxiliary Space**: Extra memory used by algorithm
- **Total Space**: Input + auxiliary space

---

## 🔗 Related Documents

### Algorithm Documentation
- [Algorithm Documentation Index](INDEX.md)
- [Algorithm Template](ALGORITHM_TEMPLATE.md)
- [Test Case Matrix](TEST_CASE_MATRIX.md)

### Performance Analysis
- [Performance Comparison](../Performance_Comparison.md)
- [Memory Usage Analysis](../Memory_Usage_Analysis.md)
- [Test Summary Report](../Test_Summary_Report.md)

### Development Documentation
- [Contributing Guide](../CONTRIBUTING.md)
- [Code of Conduct](../CODE_OF_CONDUCT.md)
- [Security Policy](../SECURITY.md)

---

*This complexity table is continuously updated to reflect the current implementations in the DSA Java project. Last updated: April 25, 2025*

---

*For questions about algorithm complexity or to suggest improvements, please refer to the [Contributing Guide](../CONTRIBUTING.md) or create an issue in the project repository.*

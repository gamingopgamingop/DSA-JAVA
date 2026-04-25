# Glossary

This glossary defines common terms and concepts used throughout the DSA Java project documentation.

## 📚 Algorithm Terms

### A
**Algorithm**
- A step-by-step procedure for solving a problem or accomplishing a task
- In this project: A Java class implementing a specific data structure or algorithm

**Array**
- A fixed-size collection of elements of the same type
- Elements are accessed using zero-based indexing
- Time complexity: O(1) for access, O(n) for search/insertion/deletion

**Average Case**
- The expected performance of an algorithm over all possible inputs
- Usually more realistic than best case or worst case analysis

### B
**Big-O Notation**
- Mathematical notation describing the limiting behavior of a function
- Used to analyze algorithm efficiency in terms of time and space complexity
- Examples: O(1), O(log n), O(n), O(n log n), O(n²)

**Binary Search**
- Search algorithm that works on sorted arrays
- Time complexity: O(log n)
- Divides the search interval in half each iteration

**Bubble Sort**
- Simple sorting algorithm that repeatedly steps through the list
- Compares adjacent elements and swaps them if they're in wrong order
- Time complexity: O(n²) average and worst case

### C
**Circular Queue**
- Queue implementation where the last position is connected back to the first position
- More efficient use of array space compared to linear queue
- Also known as circular buffer

**Complexity**
- Measure of the amount of resources required by an algorithm
- Usually expressed in terms of time complexity and space complexity

### D
**Data Structure**
- A particular way of organizing and storing data in a computer
- Enables efficient access and modification of data
- Examples: arrays, linked lists, stacks, queues, trees

**Deque**
- Double-ended queue that allows insertion and removal from both ends
- Combines functionality of both stack and queue
- Operations: addFirst, addLast, removeFirst, removeLast

**Divide and Conquer**
- Algorithm design paradigm that breaks a problem into smaller subproblems
- Solves the subproblems recursively and combines their solutions
- Examples: Merge Sort, Quick Sort, Binary Search

### E
**Edge Case**
- A situation or problem that occurs at an extreme operating parameter
- Often tests the boundaries of algorithm behavior
- Examples: empty array, single element, maximum values

### F
**FIFO (First In, First Out)**
- Principle where the first element added is the first one to be removed
- Used in queue data structures
- Contrast with LIFO

### G
**Graph**
- Non-linear data structure consisting of vertices and edges
- Used to represent relationships between objects
- Types: directed, undirected, weighted, unweighted

### H
**Heap**
- Specialized tree-based data structure that satisfies the heap property
- Used in implementing priority queues
- Types: min-heap, max-heap

**Heap Sort**
- Comparison-based sorting algorithm that uses a heap data structure
- Time complexity: O(n log n) in all cases
- Space complexity: O(1) - in-place sorting

### I
**In-Place Algorithm**
- Algorithm that transforms input using no auxiliary data structure
- Uses a small, constant amount of extra storage space
- Examples: Heap Sort, Quick Sort (average case)

**Insertion Sort**
- Simple sorting algorithm that builds the final sorted array one item at a time
- Efficient for small datasets and nearly sorted data
- Time complexity: O(n²) average, O(n) best case

### L
**Linear Queue**
- Queue implementation using a simple array
- Less efficient space utilization compared to circular queue
- Front pointer moves forward, creating unused space

**Linear Search**
- Simple search algorithm that checks each element in sequence
- Time complexity: O(n)
- Works on both sorted and unsorted arrays

**Linked List**
- Linear data structure where elements are not stored at contiguous locations
- Elements are linked using pointers
- Types: singly linked, doubly linked, circular linked

**LIFO (Last In, First Out)**
- Principle where the last element added is the first one to be removed
- Used in stack data structures
- Contrast with FIFO

### M
**Matrix**
- Two-dimensional array of numbers arranged in rows and columns
- Used in mathematical operations and transformations
- Common operations: addition, multiplication, transpose

**Merge Sort**
- Divide and conquer sorting algorithm
- Time complexity: O(n log n) in all cases
- Space complexity: O(n) - requires additional space

### O
**Optimization**
- Process of making an algorithm as efficient as possible
- Involves improving time complexity, space complexity, or both
- Trade-offs between different optimization goals

### P
**Partition**
- Process of dividing an array into two parts around a pivot element
- Key step in Quick Sort algorithm
- Elements less than pivot go to left, greater to right

**Priority Queue**
- Abstract data type where each element has an associated priority
- Elements with higher priority are served before elements with lower priority
- Often implemented using heaps

**Pivot**
- Element chosen as reference in partitioning algorithms
- Used in Quick Sort to divide the array
- Selection strategy affects algorithm performance

### Q
**Queue**
- Linear data structure following FIFO principle
- Operations: enqueue (add), dequeue (remove), peek (front element)
- Applications: task scheduling, breadth-first search

**Quick Sort**
- Divide and conquer sorting algorithm
- Average time complexity: O(n log n)
- Worst case: O(n²) - occurs with poor pivot selection

### R
**Recursion**
- Method where the solution to a problem depends on solutions to smaller instances
- Function calls itself with modified parameters
- Requires base case to prevent infinite recursion

**Recursive Algorithm**
- Algorithm that solves problems by calling itself with smaller inputs
- Examples: Merge Sort, Quick Sort, Binary Search
- Uses call stack to manage recursive calls

### S
**Search Algorithm**
- Algorithm designed to retrieve information stored within some data structure
- Types: linear search, binary search, depth-first search, breadth-first search

**Selection Sort**
- Simple sorting algorithm that divides the input into sorted and unsorted regions
- Repeatedly selects the smallest element from unsorted region
- Time complexity: O(n²) in all cases

**Sort Algorithm**
- Algorithm that puts elements of a list in a certain order
- Types: comparison-based, non-comparison-based
- Performance measured by time and space complexity

**Space Complexity**
- Amount of memory space required by an algorithm to run
- Expressed as a function of the input size
- Includes auxiliary space and input space

**Stack**
- Linear data structure following LIFO principle
- Operations: push (add), pop (remove), peek (top element)
- Applications: function calls, expression evaluation

**Stability**
- Property of sorting algorithms that maintains the relative order of equal elements
- Stable algorithms preserve original order of equal elements
- Important when sorting records by multiple keys

### T
**Time Complexity**
- Amount of time taken by an algorithm to run as a function of input size
- Expressed using Big-O notation
- Measures algorithm efficiency and scalability

**Tree**
- Non-linear hierarchical data structure with a root and connected nodes
- Each node has parent-child relationships
- Types: binary tree, binary search tree, AVL tree, red-black tree

### W
**Worst Case**
- Maximum time or space required by an algorithm for any input of size n
- Provides an upper bound on algorithm performance
- Important for real-time systems and performance guarantees

## 🔧 Implementation Terms

### Java-Specific Terms

**ArrayList**
- Resizable array implementation in Java Collections Framework
- Provides dynamic array functionality
- Time complexity: O(1) for random access, O(n) for insertion/deletion

**Collections Framework**
- Unified architecture for representing and manipulating collections
- Provides interfaces, implementations, and algorithms
- Examples: List, Set, Map, Queue

**HashMap**
- Hash table-based implementation of Map interface
- Stores key-value pairs
- Time complexity: O(1) average case for basic operations

**LinkedList**
- Doubly-linked list implementation in Java Collections Framework
- Provides efficient insertion and deletion
- Time complexity: O(1) for insertion/deletion at ends

**PriorityQueue**
- Priority queue implementation in Java Collections Framework
- Implemented as a min-heap by default
- Time complexity: O(log n) for insertion and removal

**Queue Interface**
- Linear collection that supports element insertion and removal at both ends
- Extends Collection interface
- Implementations: LinkedList, PriorityQueue, ArrayDeque

**Stack Class**
- Legacy stack implementation in Java
- Extends Vector class
- Recommended to use Deque interface instead

## 📊 Performance Terms

### Benchmarking
**Benchmark**
- Standard or reference point by which something can be measured or judged
- In algorithms: measuring performance against known standards

**Profiling**
- Dynamic analysis of program behavior to identify performance bottlenecks
- Measures execution time, memory usage, and other metrics
- Helps optimize algorithm performance

**Scalability**
- Ability of an algorithm to handle increased workload
- Measured by how performance changes with input size
- Important for real-world applications

## 🎯 Testing Terms

### Test Coverage
**Coverage**
- Measure of how much code is exercised by tests
- Types: statement coverage, branch coverage, path coverage
- Goal: achieve comprehensive testing

**Edge Case Testing**
- Testing of boundary conditions and extreme values
- Ensures algorithm behaves correctly at limits
- Examples: empty input, maximum values, minimum values

**Regression Testing**
- Re-running existing tests to ensure changes don't break functionality
- Important for maintaining code quality
- Automated testing helps with regression testing

**Unit Testing**
- Testing of individual components or functions in isolation
- Focuses on smallest testable parts of an application
- Helps identify and fix bugs early

## 🔍 Analysis Terms

### Algorithm Analysis
**Amortized Analysis**
- Analysis of algorithm performance over a sequence of operations
- Average cost per operation when expensive operations occur infrequently
- Used for data structures like dynamic arrays

**Asymptotic Analysis**
- Analysis of algorithm behavior for large input sizes
- Focuses on growth rate rather than exact values
- Uses Big-O, Big-Ω, and Big-Θ notations

**Best Case**
- Minimum time or space required by an algorithm for any input of size n
- Often unrealistic for practical analysis
- Used to establish lower bounds

**Worst Case**
- Maximum time or space required by an algorithm for any input of size n
- Provides performance guarantees
- Important for real-time systems

## 🏗️ Data Structure Terms

### Linear Data Structures
**Array**
- Fixed-size collection of elements of the same type
- Elements accessed using zero-based indexing
- Time complexity: O(1) for access, O(n) for search/insertion/deletion

**Linked List**
- Linear data structure with elements not stored at contiguous locations
- Elements linked using pointers
- Types: singly linked, doubly linked, circular linked

**Stack**
- LIFO data structure
- Operations: push, pop, peek
- Applications: function calls, expression evaluation

**Queue**
- FIFO data structure
- Operations: enqueue, dequeue, peek
- Applications: task scheduling, breadth-first search

### Non-Linear Data Structures
**Tree**
- Hierarchical data structure with root and connected nodes
- Each node has parent-child relationships
- Types: binary tree, binary search tree, AVL tree

**Graph**
- Collection of vertices and edges
- Represents relationships between objects
- Types: directed, undirected, weighted, unweighted

**Heap**
- Specialized tree-based data structure
- Satisfies heap property
- Used in priority queues and heap sort

## 🔄 Algorithm Types

### Sorting Algorithms
**Comparison-Based Sorting**
- Sorting algorithms that compare elements to determine order
- Examples: Bubble Sort, Insertion Sort, Merge Sort, Quick Sort
- Lower bound: O(n log n) comparison operations

**Non-Comparison Sorting**
- Sorting algorithms that don't compare elements
- Examples: Counting Sort, Radix Sort, Bucket Sort
- Can achieve O(n) time complexity

**Stable Sorting**
- Sorting algorithms that maintain relative order of equal elements
- Examples: Merge Sort, Insertion Sort, Bubble Sort
- Important when sorting by multiple keys

**In-Place Sorting**
- Sorting algorithms that use minimal extra space
- Examples: Heap Sort, Quick Sort (average case)
- Space complexity: O(1) or O(log n)

### Search Algorithms
**Linear Search**
- Sequential search through all elements
- Time complexity: O(n)
- Works on unsorted data

**Binary Search**
- Divide and conquer search on sorted data
- Time complexity: O(log n)
- Requires sorted input

**Depth-First Search (DFS)**
- Graph traversal algorithm
- Explores as far as possible along each branch
- Uses stack or recursion

**Breadth-First Search (BFS)**
- Graph traversal algorithm
- Explores all neighbors at current depth before moving deeper
- Uses queue

## 📈 Mathematical Terms

### Mathematical Concepts
**Factorial**
- Product of all positive integers up to n
- Notation: n!
- Used in permutation and combination calculations

**Logarithm**
- Inverse operation to exponentiation
- Base 2 (binary), base 10 (common), base e (natural)
- Used in binary search and divide and conquer algorithms

**Permutation**
- Arrangement of objects in a specific order
- Number of permutations: n!
- Important in sorting algorithm analysis

**Recurrence Relation**
- Equation that defines a sequence based on one or more previous terms
- Used to analyze recursive algorithms
- Examples: T(n) = 2T(n/2) + O(n)

## 🎯 Project-Specific Terms

### DSA Java Project Terms
**Algorithm Implementation**
- Java class implementing a specific algorithm or data structure
- Follows consistent structure with main method and interactive menu
- Includes comprehensive Java imports demonstration

**Test Implementation**
- Java class with 12 comprehensive test methods
- Covers functionality, edge cases, performance, and error handling
- Generates detailed test result files

**Documentation**
- Markdown files explaining algorithms, tests, and project structure
- Follows consistent template and format
- Includes performance analysis and examples

**Interactive Menu**
- User interface provided in algorithm implementations
- Allows users to test algorithms with custom input
- Demonstrates practical usage of algorithms

---

## 🔗 Related Resources

- **[Algorithm Documentation](algorithms/)** - Detailed algorithm explanations
- **[Testing Documentation](testing/)** - Test methodologies and coverage
- **[Examples](examples/)** - Practical usage examples
- **[Learning Path](LEARNING_PATH.md)** - Structured learning curriculum

---

*This glossary is continuously updated to include new terms and concepts. For questions about terminology, please refer to the [main documentation](README.md).*

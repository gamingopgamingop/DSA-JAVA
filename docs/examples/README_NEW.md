# Usage Examples

> 💡 **Practical examples and use cases for DSA Java algorithms**

---

## 📁 Directory Structure

This directory contains practical examples demonstrating how to use the algorithms and data structures implemented in this project.

### Example Categories
- **Basic Usage**: Simple algorithm usage examples
- **Real-World Applications**: Practical problem-solving examples
- **Performance Comparisons**: Side-by-side algorithm comparisons
- **Integration Examples**: Combining multiple algorithms
- **Best Practices**: Recommended usage patterns

---

## 🚀 Quick Start Examples

### Search Algorithms

#### Binary Search Example
```java
// Example: Find element in sorted array
public class BinarySearchExample {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        // Sorted array (required for binary search)
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        
        // Perform binary search
        int index = bs.binarySearch(sortedArray, target);
        
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in array");
        }
        
        // Output: Found 7 at index: 3
    }
}
```

#### Linear Search Example
```java
// Example: Find element in unsorted array
public class LinearSearchExample {
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        
        // Unsorted array (works with any order)
        int[] array = {5, 2, 8, 1, 9, 3};
        int target = 8;
        
        // Perform linear search
        int index = ls.linearSearch(array, target);
        
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in array");
        }
        
        // Output: Found 8 at index: 2
    }
}
```

### Sorting Algorithms

#### Quick Sort Example
```java
// Example: Sort array using quick sort
public class QuickSortExample {
    public static void main(String[] args) {
        QuickSortAlgorithm qs = new QuickSortAlgorithm();
        
        // Unsorted array
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        // Sort using quick sort
        qs.quickSort(array, 0, array.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
        
        // Output:
        // Original array: [64, 34, 25, 12, 22, 11, 90]
        // Sorted array: [11, 12, 22, 25, 34, 64, 90]
    }
}
```

#### Merge Sort Example
```java
// Example: Sort array using merge sort (stable sorting)
public class MergeSortExample {
    public static void main(String[] args) {
        MergeSortAlgorithm ms = new MergeSortAlgorithm();
        
        // Array with duplicate elements
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Original array: " + Arrays.toString(array));
        
        // Sort using merge sort
        ms.mergeSort(array, 0, array.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
        
        // Output:
        // Original array: [38, 27, 43, 3, 9, 82, 10]
        // Sorted array: [3, 9, 10, 27, 38, 43, 82]
    }
}
```

### Data Structures

#### Stack Operations Example
```java
// Example: Stack usage for expression evaluation
public class StackExample {
    public static void main(String[] args) {
        StackOperations stack = new StackOperations();
        
        // Push elements onto stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Stack size: " + stack.size()); // 3
        
        // Pop elements from stack
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
        
        // Output:
        // Top element: 30
        // Stack size: 3
        // Popped: 30
        // Popped: 20
        // Popped: 10
    }
}
```

#### Queue Operations Example
```java
// Example: Queue usage for task scheduling
public class QueueExample {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        
        // Enqueue tasks
        queue.enqueue("Task 1");
        queue.enqueue("Task 2");
        queue.enqueue("Task 3");
        
        System.out.println("Front element: " + queue.getFront()); // Task 1
        System.out.println("Queue size: " + queue.size()); // 3
        
        // Dequeue tasks (FIFO order)
        while (!queue.isEmpty()) {
            System.out.println("Processed: " + queue.dequeue());
        }
        
        // Output:
        // Front element: Task 1
        // Queue size: 3
        // Processed: Task 1
        // Processed: Task 2
        // Processed: Task 3
    }
}
```

---

## 🌟 Real-World Applications

### 1. Contact List Management

#### Problem: Manage a sorted contact list
```java
public class ContactManager {
    private String[] contacts;
    private BinarySearch search;
    
    public ContactManager() {
        this.search = new BinarySearch();
        this.contacts = new String[0];
    }
    
    public void addContact(String name) {
        // Add contact and maintain sorted order
        String[] newContacts = Arrays.copyOf(contacts, contacts.length + 1);
        newContacts[contacts.length] = name;
        Arrays.sort(newContacts);
        contacts = newContacts;
    }
    
    public boolean findContact(String name) {
        return search.binarySearch(contacts, name) != -1;
    }
    
    public void displayContacts() {
        System.out.println("Contacts:");
        for (String contact : contacts) {
            System.out.println("- " + contact);
        }
    }
}
```

### 2. Task Scheduler

#### Problem: Schedule tasks using priority queue
```java
public class TaskScheduler {
    private PriorityQueueOperations priorityQueue;
    
    public TaskScheduler() {
        this.priorityQueue = new PriorityQueueOperations(10);
    }
    
    public void addTask(String task, int priority) {
        priorityQueue.insert(task, priority);
        System.out.println("Added task: " + task + " (Priority: " + priority + ")");
    }
    
    public void processNextTask() {
        if (!priorityQueue.isEmpty()) {
            String task = priorityQueue.deleteHighestPriority();
            System.out.println("Processing: " + task);
        } else {
            System.out.println("No tasks to process");
        }
    }
}
```

### 3. Browser History

#### Problem: Implement browser back/forward functionality
```java
public class BrowserHistory {
    private StackOperations backStack;
    private StackOperations forwardStack;
    private String currentPage;
    
    public BrowserHistory() {
        this.backStack = new StackOperations();
        this.forwardStack = new StackOperations();
        this.currentPage = "home";
    }
    
    public void navigateTo(String page) {
        backStack.push(currentPage);
        currentPage = page;
        forwardStack.clear(); // Clear forward history
        System.out.println("Navigated to: " + page);
    }
    
    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Went back to: " + currentPage);
        } else {
            System.out.println("No back history available");
        }
    }
    
    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Went forward to: " + currentPage);
        } else {
            System.out.println("No forward history available");
        }
    }
}
```

---

## ⚡ Performance Comparisons

### Search Algorithm Comparison
```java
public class SearchComparison {
    public static void main(String[] args) {
        // Create test data
        int[] sortedArray = generateSortedArray(100000);
        int[] unsortedArray = generateUnsortedArray(100000);
        int target = 50000;
        
        // Binary Search (sorted data)
        long start = System.nanoTime();
        int binaryResult = new BinarySearch().binarySearch(sortedArray, target);
        long binaryTime = System.nanoTime() - start;
        
        // Linear Search (unsorted data)
        start = System.nanoTime();
        int linearResult = new LinearSearch().linearSearch(unsortedArray, target);
        long linearTime = System.nanoTime() - start;
        
        System.out.println("Binary Search Time: " + binaryTime + " ns");
        System.out.println("Linear Search Time: " + linearTime + " ns");
        System.out.println("Speedup: " + (linearTime / binaryTime) + "x faster");
        
        // Typical output:
        // Binary Search Time: 1200 ns
        // Linear Search Time: 2500000 ns
        // Speedup: 2083x faster
    }
}
```

### Sorting Algorithm Comparison
```java
public class SortComparison {
    public static void main(String[] args) {
        int[] data = generateRandomArray(10000);
        
        // Test Quick Sort
        int[] quickData = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        new QuickSortAlgorithm().quickSort(quickData, 0, quickData.length - 1);
        long quickTime = System.nanoTime() - start;
        
        // Test Merge Sort
        int[] mergeData = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        new MergeSortAlgorithm().mergeSort(mergeData, 0, mergeData.length - 1);
        long mergeTime = System.nanoTime() - start;
        
        // Test Bubble Sort (for comparison)
        int[] bubbleData = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        new BubbleSort().bubbleSort(bubbleData);
        long bubbleTime = System.nanoTime() - start;
        
        System.out.println("Quick Sort: " + (quickTime / 1000000) + " ms");
        System.out.println("Merge Sort: " + (mergeTime / 1000000) + " ms");
        System.out.println("Bubble Sort: " + (bubbleTime / 1000000) + " ms");
        
        // Typical output:
        // Quick Sort: 12 ms
        // Merge Sort: 18 ms
        // Bubble Sort: 892 ms
    }
}
```

---

## 🔧 Integration Examples

### Multi-Algorithm Pipeline
```java
public class DataProcessingPipeline {
    public static void main(String[] args) {
        // Step 1: Generate random data
        int[] data = generateRandomData(1000);
        System.out.println("Generated " + data.length + " random numbers");
        
        // Step 2: Sort the data
        QuickSortAlgorithm sorter = new QuickSortAlgorithm();
        sorter.quickSort(data, 0, data.length - 1);
        System.out.println("Data sorted using Quick Sort");
        
        // Step 3: Search for specific values
        BinarySearch searcher = new BinarySearch();
        int[] targets = {100, 500, 900};
        
        for (int target : targets) {
            int index = searcher.binarySearch(data, target);
            if (index != -1) {
                System.out.println("Found " + target + " at position " + index);
            } else {
                System.out.println(target + " not found");
            }
        }
        
        // Step 4: Calculate statistics
        int min = data[0];
        int max = data[data.length - 1];
        double median = data[data.length / 2];
        
        System.out.println("Statistics:");
        System.out.println("- Min: " + min);
        System.out.println("- Max: " + max);
        System.out.println("- Median: " + median);
    }
}
```

### Error Handling Integration
```java
public class RobustAlgorithmUsage {
    public static void main(String[] args) {
        try {
            // Validate input
            int[] data = getUserInput();
            if (data == null || data.length == 0) {
                throw new IllegalArgumentException("Invalid input data");
            }
            
            // Choose algorithm based on data characteristics
            Algorithm algorithm = selectAlgorithm(data);
            
            // Process data
            int[] result = algorithm.process(data);
            
            // Validate output
            if (!isValidResult(result)) {
                throw new RuntimeException("Invalid processing result");
            }
            
            System.out.println("Processing completed successfully");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Processing error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    private static Algorithm selectAlgorithm(int[] data) {
        if (isSorted(data)) {
            return new BinarySearch();
        } else if (data.length < 100) {
            return new LinearSearch();
        } else {
            return new QuickSortAlgorithm();
        }
    }
}
```

---

## 📚 Best Practices

### 1. Algorithm Selection Guidelines
```java
public class AlgorithmSelector {
    public static SearchAlgorithm chooseSearchAlgorithm(int[] data) {
        if (isSorted(data) && data.length > 100) {
            return new BinarySearch(); // O(log n) for sorted data
        } else {
            return new LinearSearch(); // O(n) for unsorted or small data
        }
    }
    
    public static SortAlgorithm chooseSortAlgorithm(int[] data) {
        if (data.length < 50) {
            return new InsertionSort(); // Good for nearly sorted data
        } else if (data.length < 1000) {
            return new QuickSort(); // Fast average case
        } else {
            return new MergeSort(); // Stable, guaranteed O(n log n)
        }
    }
}
```

### 2. Performance Optimization
```java
public class PerformanceOptimizer {
    public static void optimizeSearch(int[] data, int target) {
        // Check if data is sorted
        if (!isSorted(data)) {
            // Sort first if multiple searches expected
            Arrays.sort(data);
            System.out.println("Data sorted for optimized searching");
        }
        
        // Use binary search for sorted data
        int index = new BinarySearch().binarySearch(data, target);
        System.out.println("Search result: " + index);
    }
}
```

### 3. Memory Management
```java
public class MemoryManager {
    public static void processLargeDataset(int[] largeData) {
        // Process in chunks to avoid memory issues
        int chunkSize = 1000;
        
        for (int i = 0; i < largeData.length; i += chunkSize) {
            int[] chunk = Arrays.copyOfRange(largeData, i, Math.min(i + chunkSize, largeData.length));
            
            // Process chunk
            processChunk(chunk);
            
            // Clear references to help garbage collection
            chunk = null;
        }
    }
}
```

---

## 🔗 Related Resources

### Learning Resources
- **[Algorithm Documentation](../algorithms/)** - Detailed algorithm information
- **[Test Documentation](../testing/)** - Test coverage and validation
- **[Complexity Table](../COMPLEXITY_TABLE.md)** - Performance comparison
- **[Learning Path](../LEARNING_PATH.md)** - Structured learning

### Implementation Resources
- **[Source Code](../../)** - Algorithm implementations
- **[Templates](../templates/)** - Code templates
- **[Style Guide](../STYLE_GUIDE.md)** - Coding standards

---

## 📞 Contributing

### Adding Examples
1. Choose appropriate category
2. Follow naming conventions
3. Include comprehensive comments
4. Test examples thoroughly
5. Update this README.md

### Example Quality Standards
- **Working Code**: All examples must compile and run
- **Clear Comments**: Explain algorithm choices
- **Real-World Context**: Show practical applications
- **Performance Notes**: Include performance considerations

---

*📅 **Last Updated**: $(date '+%Y-%m-%d %H:%M:%S')*  
*🔧 **Auto-generated by*: Documentation Generator*

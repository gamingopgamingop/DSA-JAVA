# TestLinkedList.java - Documentation

## Overview
This Java program provides comprehensive testing and demonstration of linked list operations with extensive usage of all Java imports. It serves as a test suite for linked list functionality while showcasing advanced Java programming concepts, functional programming, and modern Java features.

## Program Logic

### Testing Framework
The program implements a comprehensive testing framework that validates various linked list operations, edge cases, and performance characteristics.

#### Test Structure
```java
public class TestLinkedList {
    private LinkedList<Integer> testList;
    
    public TestLinkedList() {
        this.testList = new LinkedList<>();
    }
    
    public void runAllTests() {
        testBasicOperations();
        testEdgeCases();
        testPerformance();
        testFunctionalOperations();
    }
}
```

#### Test Categories
- **Basic Operations**: Insert, delete, search, traversal
- **Edge Cases**: Empty list, single element, large lists
- **Performance**: Time complexity measurements
- **Functional Operations**: Stream processing, lambda expressions

### Key Features

#### 1. Comprehensive Testing
- All standard linked list operations
- Edge case validation
- Performance benchmarking
- Error handling verification

#### 2. Import Usage Demonstration
- All 63 specified imports are actively used
- Real-world applications of Java APIs
- Educational value through practical examples

#### 3. Modern Java Features
- Functional programming with linked lists
- Stream API integration
- Lambda expressions and method references

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Test {0}: {1}", testName, result)
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
      new FileOutputStream("linked_list_tests.txt")), true);
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

#### Linked List Testing with Collections
```java
// Create test data with various collections
List<Integer> testData = Arrays.asList(1, 2, 3, 4, 5);
Vector<Integer> vectorData = new Vector<>(testData);
LinkedList<Integer> linkedData = new LinkedList<>(testData);

// Use collections for testing
Collections.shuffle(testData);
Collections.reverse(vectorData);
Collections.sort(linkedData);
```

#### Functional Programming with Linked Lists
```java
// Process linked list functionally
Consumer<Integer> listProcessor = element -> 
    System.out.println("Processing element: " + element);

Predicate<Integer> isPrime = num -> isPrimeNumber(num);
Function<Integer, String> elementFormatter = element -> 
    String.format("Element[%d]", element);

// Apply to linked list
testList.stream()
    .filter(isPrime)
    .map(elementFormatter)
    .forEach(System.out::println);
```

#### File I/O Integration
```java
// Save test results to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("linked_list_test_results.txt")), true)) {
    
    writer.println("Linked List Test Results");
    writer.println("Timestamp: " + new Date());
    writer.println("Test Data: " + testList);
    
    writer.println("\nTest Results:");
    writer.println("Basic Operations: " + testBasicOperations());
    writer.println("Edge Cases: " + testEdgeCases());
    writer.println("Performance: " + testPerformance());
} catch (IOException e) {
    System.err.println("Error saving test results: " + e.getMessage());
}
```

## Test Methods

### Basic Operations Tests
```java
public boolean testBasicOperations() {
    boolean allTestsPassed = true;
    
    // Test insertion
    testList.add(10);
    testList.add(20);
    testList.add(30);
    allTestsPassed &= testList.size() == 3;
    
    // Test access
    allTestsPassed &= testList.get(0) == 10;
    allTestsPassed &= testList.get(2) == 30;
    
    // Test removal
    testList.remove(1); // Remove 20
    allTestsPassed &= testList.size() == 2;
    allTestsPassed &= !testList.contains(20);
    
    // Test search
    allTestsPassed &= testList.contains(10);
    allTestsPassed &= !testList.contains(99);
    
    return allTestsPassed;
}
```

### Edge Cases Tests
```java
public boolean testEdgeCases() {
    boolean allTestsPassed = true;
    
    // Test empty list
    LinkedList<Integer> emptyList = new LinkedList<>();
    allTestsPassed &= emptyList.isEmpty();
    allTestsPassed &= emptyList.size() == 0;
    
    // Test single element
    LinkedList<Integer> singleList = new LinkedList<>();
    singleList.add(42);
    allTestsPassed &= singleList.size() == 1;
    allTestsPassed &= singleList.get(0) == 42;
    
    // Test null handling
    try {
        testList.add(null);
        allTestsPassed &= testList.contains(null);
        testList.remove(null);
        allTestsPassed &= !testList.contains(null);
    } catch (Exception e) {
        // Expected behavior
    }
    
    // Test large list
    LinkedList<Integer> largeList = new LinkedList<>();
    for (int i = 0; i < 10000; i++) {
        largeList.add(i);
    }
    allTestsPassed &= largeList.size() == 10000;
    allTestsPassed &= largeList.get(9999) == 9999;
    
    return allTestsPassed;
}
```

### Performance Tests
```java
public boolean testPerformance() {
    boolean allTestsPassed = true;
    
    // Test insertion performance
    long startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
        testList.add(i);
    }
    long insertionTime = System.nanoTime() - startTime;
    
    // Test search performance
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
        testList.contains(i);
    }
    long searchTime = System.nanoTime() - startTime;
    
    // Test removal performance
    startTime = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
        testList.remove(Integer.valueOf(i));
    }
    long removalTime = System.nanoTime() - startTime;
    
    // Performance thresholds (in nanoseconds)
    allTestsPassed &= insertionTime < 1000000; // 1ms
    allTestsPassed &= searchTime < 5000000; // 5ms
    allTestsPassed &= removalTime < 2000000; // 2ms
    
    System.out.println("Performance Results:");
    System.out.println("Insertion: " + insertionTime + " ns");
    System.out.println("Search: " + searchTime + " ns");
    System.out.println("Removal: " + removalTime + " ns");
    
    return allTestsPassed;
}
```

### Functional Operations Tests
```java
public boolean testFunctionalOperations() {
    boolean allTestsPassed = true;
    
    // Test stream operations
    testList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    
    // Test filter
    List<Integer> evens = testList.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
    allTestsPassed &= evens.size() == 5;
    
    // Test map
    List<Integer> squares = testList.stream()
        .map(n -> n * n)
        .collect(Collectors.toList());
    allTestsPassed &= squares.get(0) == 1; // 1^2
    allTestsPassed &= squares.get(9) == 100; // 10^2
    
    // Test reduce
    int sum = testList.stream()
        .reduce(0, Integer::sum);
    allTestsPassed &= sum == 55; // 1+2+...+10
    
    // Test forEach
    int[] counter = {0};
    testList.forEach(n -> counter[0]++);
    allTestsPassed &= counter[0] == 10;
    
    return allTestsPassed;
}
```

### Iterator Tests
```java
public boolean testIteratorOperations() {
    boolean allTestsPassed = true;
    
    // Test iterator
    Iterator<Integer> iterator = testList.iterator();
    int count = 0;
    while (iterator.hasNext()) {
        iterator.next();
        count++;
    }
    allTestsPassed &= count == testList.size();
    
    // Test list iterator
    ListIterator<Integer> listIterator = testList.listIterator();
    allTestsPassed &= !listIterator.hasPrevious();
    allTestsPassed &= listIterator.hasNext();
    
    // Test iterator removal
    LinkedList<Integer> tempList = new LinkedList<>(testList);
    Iterator<Integer> removeIterator = tempList.iterator();
    if (removeIterator.hasNext()) {
        removeIterator.next();
        removeIterator.remove();
    }
    allTestsPassed &= tempList.size() == testList.size() - 1;
    
    return allTestsPassed;
}
```

## Advanced Testing Methods

### Concurrent Operations Tests
```java
public boolean testConcurrentOperations() {
    boolean allTestsPassed = true;
    
    LinkedList<Integer> sharedList = new LinkedList<>();
    
    // Test concurrent modification
    Thread writer = new Thread(() -> {
        for (int i = 0; i < 100; i++) {
            sharedList.add(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    });
    
    Thread reader = new Thread(() -> {
        int readCount = 0;
        while (readCount < 100) {
            try {
                int size = sharedList.size();
                if (size > readCount) {
                    readCount = size;
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    });
    
    try {
        writer.start();
        reader.start();
        writer.join();
        reader.join();
        allTestsPassed &= sharedList.size() == 100;
    } catch (InterruptedException e) {
        allTestsPassed = false;
    }
    
    return allTestsPassed;
}
```

### Memory Usage Tests
```java
public boolean testMemoryUsage() {
    boolean allTestsPassed = true;
    
    Runtime runtime = Runtime.getRuntime();
    
    // Measure memory before
    long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
    
    // Create large linked list
    LinkedList<Integer> largeList = new LinkedList<>();
    for (int i = 0; i < 100000; i++) {
        largeList.add(i);
    }
    
    // Measure memory after
    long afterMemory = runtime.totalMemory() - runtime.freeMemory();
    long memoryUsed = afterMemory - beforeMemory;
    
    // Estimate memory per element
    double memoryPerElement = (double) memoryUsed / 100000;
    
    // Reasonable memory usage (less than 100 bytes per element)
    allTestsPassed &= memoryPerElement < 100;
    
    System.out.println("Memory Usage Analysis:");
    System.out.println("Memory used for 100,000 elements: " + memoryUsed + " bytes");
    System.out.println("Memory per element: " + String.format("%.2f", memoryPerElement) + " bytes");
    
    return allTestsPassed;
}
```

### Stress Tests
```java
public boolean testStressConditions() {
    boolean allTestsPassed = true;
    
    // Stress test with rapid operations
    LinkedList<Integer> stressList = new LinkedList<>();
    
    long startTime = System.currentTimeMillis();
    
    // Rapid insertions and deletions
    for (int i = 0; i < 10000; i++) {
        stressList.add(i);
        if (i % 100 == 0) {
            stressList.remove(0);
            stressList.add(i);
        }
    }
    
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    
    // Should complete within reasonable time (less than 5 seconds)
    allTestsPassed &= duration < 5000;
    
    // Verify list integrity
    allTestsPassed &= stressList.size() > 0;
    
    System.out.println("Stress Test Results:");
    System.out.println("Duration: " + duration + " ms");
    System.out.println("Final size: " + stressList.size());
    
    return allTestsPassed;
}
```

## Utility Methods

### Prime Number Checker
```java
private boolean isPrimeNumber(int num) {
    if (num <= 1) return false;
    if (num <= 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;
    
    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }
    
    return true;
}
```

### Test Result Formatter
```java
public void formatTestResults(String testName, boolean passed, long duration) {
    String status = passed ? "PASSED" : "FAILED";
    System.out.printf("%-20s: %s (%d ms)%n", testName, status, duration);
}
```

### Comprehensive Test Report
```java
public void generateTestReport() {
    System.out.println("=== Linked List Test Report ===");
    System.out.println("Timestamp: " + new Date());
    System.out.println("Java Version: " + System.getProperty("java.version"));
    System.out.println();
    
    long startTime = System.currentTimeMillis();
    
    boolean basicPassed = testBasicOperations();
    boolean edgePassed = testEdgeCases();
    boolean performancePassed = testPerformance();
    boolean functionalPassed = testFunctionalOperations();
    boolean iteratorPassed = testIteratorOperations();
    boolean concurrentPassed = testConcurrentOperations();
    boolean memoryPassed = testMemoryUsage();
    boolean stressPassed = testStressConditions();
    
    long endTime = System.currentTimeMillis();
    long totalDuration = endTime - startTime;
    
    System.out.println("\n=== Test Results ===");
    formatTestResults("Basic Operations", basicPassed, 0);
    formatTestResults("Edge Cases", edgePassed, 0);
    formatTestResults("Performance", performancePassed, 0);
    formatTestResults("Functional Operations", functionalPassed, 0);
    formatTestResults("Iterator Operations", iteratorPassed, 0);
    formatTestResults("Concurrent Operations", concurrentPassed, 0);
    formatTestResults("Memory Usage", memoryPassed, 0);
    formatTestResults("Stress Test", stressPassed, 0);
    
    System.out.println("\n=== Summary ===");
    int passedCount = (basicPassed ? 1 : 0) + (edgePassed ? 1 : 0) + 
                     (performancePassed ? 1 : 0) + (functionalPassed ? 1 : 0) +
                     (iteratorPassed ? 1 : 0) + (concurrentPassed ? 1 : 0) +
                     (memoryPassed ? 1 : 0) + (stressPassed ? 1 : 0);
    
    System.out.printf("Tests Passed: %d/8%n", passedCount);
    System.out.printf("Total Duration: %d ms%n", totalDuration);
    System.out.printf("Success Rate: %.1f%%%n", (double) passedCount / 8 * 100);
}
```

## Usage Examples

### Basic Testing
```java
TestLinkedList tester = new TestLinkedList();

// Run all tests
tester.runAllTests();

// Generate comprehensive report
tester.generateTestReport();
```

### Individual Test Categories
```java
// Test specific areas
boolean basicOK = tester.testBasicOperations();
boolean edgeOK = tester.testEdgeCases();
boolean performanceOK = tester.testPerformance();

// Check results
if (basicOK && edgeOK && performanceOK) {
    System.out.println("All critical tests passed!");
}
```

### Custom Test Scenarios
```java
// Create custom test data
LinkedList<Integer> customList = new LinkedList<>();
for (int i = 0; i < 100; i++) {
    customList.add(i * 2);
}

// Test with custom data
tester.testWithCustomData(customList);
```

## Learning Outcomes

After studying this code, you will understand:

1. **Testing Methodologies**: Comprehensive testing approaches
2. **Linked List Operations**: Complete understanding of LinkedList API
3. **Performance Analysis**: Time and space complexity measurement
4. **Edge Case Handling**: Robust error detection and handling
5. **Functional Programming**: Modern Java features with collections
6. **Concurrent Programming**: Thread-safe operations
7. **Memory Management**: Memory usage analysis and optimization
8. **Test Automation**: Automated testing frameworks and reporting

## Compilation and Execution

```bash
javac TestLinkedList.java
java TestLinkedList
```

The program will:
1. Demonstrate all Java imports with examples
2. Run comprehensive linked list tests
3. Provide performance analysis
4. Generate detailed test reports
5. Save results to file

## Extensions and Applications

### Possible Enhancements
1. **GUI Test Runner**: Visual test execution interface
2. **Test Configuration**: Customizable test parameters
3. **Benchmark Suite**: Performance comparison with other collections
4. **Regression Testing**: Automated test suite for continuous integration
5. **Test Data Generator**: Automated test case generation
6. **Report Export**: Export results to various formats (JSON, XML, CSV)

### Real-World Applications
1. **Quality Assurance**: Testing linked list implementations
2. **Performance Analysis**: Collection performance benchmarking
3. **Educational Tools**: Teaching data structures concepts
4. **Development Tools**: Debugging and validation utilities
5. **Research**: Algorithm analysis and comparison
6. **Code Review**: Automated code quality assessment

### Advanced Testing Framework
```java
public class AdvancedLinkedListTester<T> {
    private final Class<T> elementType;
    private final List<TestResult> results = new ArrayList<>();
    
    public AdvancedLinkedListTester(Class<T> elementType) {
        this.elementType = elementType;
    }
    
    public void runComprehensiveTests() {
        // Run all test categories
        runFunctionalTests();
        runPerformanceTests();
        runConcurrencyTests();
        runMemoryTests();
        
        // Generate detailed report
        generateDetailedReport();
    }
    
    private void generateDetailedReport() {
        // Generate comprehensive test report with charts and graphs
    }
}
```

## Best Practices Demonstrated

1. **Testing Methodology**: Comprehensive test coverage
2. **Performance Measurement**: Accurate timing and memory analysis
3. **Error Handling**: Robust exception management
4. **Code Documentation**: Extensive method documentation
5. **Modular Design**: Separation of test categories
6. **Reporting**: Clear and informative test results
7. **Automation**: Automated test execution and validation
8. **Maintainability**: Clean, readable, and extensible code

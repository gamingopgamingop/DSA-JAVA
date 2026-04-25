import java.text.MessageFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.NavigableMap;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoublePredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongConsumer;
import java.io.StreamTokenizer;
import java.util.Date;
import java.util.Random;

/**
 * TestFramework - Comprehensive testing framework for DSA Java programs
 * 
 * This class provides a unified testing infrastructure for all data structure
 * and algorithm implementations, including performance benchmarking,
 * edge case testing, and validation of functionality.
 */
public class TestFramework {
    
    private static final String LOG_FILE = "test_results.log";
    private static final String REPORT_FILE = "test_report.html";
    private PrintStream logWriter;
    
    public TestFramework() {
        try {
            logWriter = new PrintStream(new BufferedOutputStream(
                new FileOutputStream(LOG_FILE), true));
            logWriter.println("=== DSA Java Test Framework Log ===");
            logWriter.println("Started: " + new Date());
        } catch (IOException e) {
            System.err.println("Warning: Could not create log file: " + e.getMessage());
        }
    }
    
    /**
     * Test result container
     */
    public static class TestResult {
        private final String testName;
        private final boolean passed;
        private final long duration;
        private final String details;
        private final List<String> errors;
        
        public TestResult(String testName, boolean passed, long duration, String details, List<String> errors) {
            this.testName = testName;
            this.passed = passed;
            this.duration = duration;
            this.details = details;
            this.errors = new ArrayList<>(errors);
        }
        
        public String getTestName() { return testName; }
        public boolean isPassed() { return passed; }
        public long getDuration() { return duration; }
        public String getDetails() { return details; }
        public List<String> getErrors() { return errors; }
    }
    
    /**
     * Performance metrics container
     */
    public static class PerformanceMetrics {
        private final String algorithmName;
        private final int dataSize;
        private final long executionTime;
        private final long memoryUsage;
        
        public PerformanceMetrics(String algorithmName, int dataSize, long executionTime, long memoryUsage) {
            this.algorithmName = algorithmName;
            this.dataSize = dataSize;
            this.executionTime = executionTime;
            this.memoryUsage = memoryUsage;
        }
        
        public String getAlgorithmName() { return algorithmName; }
        public int getDataSize() { return dataSize; }
        public long getExecutionTime() { return executionTime; }
        public long getMemoryUsage() { return memoryUsage; }
    }
    
    /**
     * Comprehensive test suite runner
     */
    public class TestSuite {
        private final String suiteName;
        private final List<TestResult> results = new ArrayList<>();
        
        public TestSuite(String suiteName) {
            this.suiteName = suiteName;
        }
        
        public void addResult(TestResult result) {
            results.add(result);
        }
        
        public List<TestResult> getResults() { return new ArrayList<>(results); }
        
        public String getSuiteName() { return suiteName; }
        
        public boolean allTestsPassed() {
            return results.stream().allMatch(TestResult::isPassed);
        }
        
        public double getSuccessRate() {
            if (results.isEmpty()) return 0.0;
            long passed = results.stream().mapToInt(r -> r.isPassed() ? 1 : 0).sum();
            return (double) passed / results.size() * 100;
        }
        
        public long getTotalDuration() {
            return results.stream().mapToLong(TestResult::getDuration).sum();
        }
    }
    
    /**
     * Generic test interface
     */
    @FunctionalInterface
    public interface Test<T> {
        TestResult run(T testData, String testName);
    }
    
    /**
     * Performance test interface
     */
    @FunctionalInterface
    public interface PerformanceTest<T> {
        PerformanceMetrics run(T testData, int dataSize);
    }
    
    /**
     * Run all tests for a specific program
     */
    public void runAllTests() {
        logWriter.println("Starting comprehensive test suite...");
        
        long startTime = System.currentTimeMillis();
        
        // Test BinarySearch
        TestSuite binarySearchSuite = new TestSuite("BinarySearch");
        runBinarySearchTests(binarySearchSuite);
        
        // Test BubbleSort
        TestSuite bubbleSortSuite = new TestSuite("BubbleSort");
        runBubbleSortTests(bubbleSortSuite);
        
        // Test SelectionSort
        TestSuite selectionSortSuite = new TestSuite("SelectionSort");
        runSelectionSortTests(selectionSortSuite);
        
        // Test InsertionSort
        TestSuite insertionSortSuite = new TestSuite("InsertionSort");
        runInsertionSortTests(insertionSortSuite);
        
        // Test LinearSearchWithFrequency
        TestSuite linearSearchSuite = new TestSuite("LinearSearchWithFrequency");
        runLinearSearchTests(linearSearchSuite);
        
        // Test LinkedListWithAddresses
        TestSuite linkedListSuite = new TestSuite("LinkedListWithAddresses");
        runLinkedListTests(linkedListSuite);
        
        // Test SinglyLinkedListOperations
        TestSuite singlyLinkedListOpsSuite = new TestSuite("SinglyLinkedListOperations");
        runSinglyLinkedListOpsTests(singlyLinkedListOpsSuite);
        
        // Test SinglyLinkedList
        TestSuite singlyLinkedListSuite = new TestSuite("SinglyLinkedList");
        runSinglyLinkedListTests(singlyLinkedListSuite);
        
        // Test SmallestLargest
        TestSuite smallestLargestSuite = new TestSuite("SmallestLargest");
        runSmallestLargestTests(smallestLargestSuite);
        
        // Test SparseMatrix
        TestSuite sparseMatrixSuite = new TestSuite("SparseMatrix");
        runSparseMatrixTests(sparseMatrixSuite);
        
        // Test StackOperations
        TestSuite stackOpsSuite = new TestSuite("StackOperations");
        runStackOperationsTests(stackOpsSuite);
        
        // Test TestLinkedList
        TestSuite testLinkedListSuite = new TestSuite("TestLinkedList");
        runTestLinkedListTests(testLinkedListSuite);
        
        // Test Traversal
        TestSuite traversalSuite = new TestSuite("Traversal");
        runTraversalTests(traversalSuite);
        
        // Test sample
        TestSuite sampleSuite = new TestSuite("sample");
        runSampleTests(sampleSuite);
        
        long endTime = System.currentTimeMillis();
        long totalDuration = endTime - startTime;
        
        // Generate comprehensive report
        generateHtmlReport(totalDuration);
        
        logWriter.println("Test suite completed in " + totalDuration + " ms");
        logWriter.close();
    }
    
    /**
     * Binary Search Tests
     */
    private void runBinarySearchTests(TestSuite suite) {
        // Test with sorted array
        Test<Integer[]> sortedArrayTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Create sorted array
            int[] sortedArray = data.clone();
            Arrays.sort(sortedArray);
            
            // Test binary search
            int target = sortedArray.length > 0 ? sortedArray[sortedArray.length / 2] : 0;
            int result = BinarySearch.binarySearch(sortedArray, target);
            
            boolean passed = (result >= 0) && (sortedArray[result] == target);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat.format(
                "Target: {0}, Found at: {1}, Array: {2}", 
                target, result, Arrays.toString(sortedArray));
            
            return new TestResult(name, passed, duration, details, 
                passed ? Collections.emptyList() : 
                Arrays.asList("Binary search failed"));
        };
        
        // Test with various array sizes
        for (int size : new int[]{10, 100, 1000, 10000}) {
            int[] data = generateRandomArray(size, -1000, 1000);
            String testName = "BinarySearch_Size_" + size;
            suite.addResult(sortedArrayTest.apply(data, testName));
        }
        
        // Test edge cases
        suite.addResult(sortedArrayTest.apply(new int[]{}, "BinarySearch_Empty"));
        suite.addResult(sortedArrayTest.apply(new int[]{1}, "BinarySearch_Single"));
        suite.addResult(sortedArrayTest.apply(new int[]{1, 2, 3, 4, 5}, "BinarySearch_Sorted"));
    }
    
    /**
     * Bubble Sort Tests
     */
    private void runBubbleSortTests(TestSuite suite) {
        Test<int[]> bubbleSortTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Copy array to avoid modifying original
            int[] testArray = data.clone();
            
            // Perform bubble sort
            BubbleSort.bubbleSort(testArray);
            
            // Verify sorted order
            boolean passed = isArraySorted(testArray);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat.format(
                "Original: {0}, Sorted: {1}, Duration: {2} ns", 
                Arrays.toString(data), Arrays.toString(testArray), duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Array not properly sorted"));
        };
        
        // Test with various array sizes
        for (int size : new int[]{10, 100, 1000}) {
            int[] data = generateRandomArray(size, -100, 100);
            String testName = "BubbleSort_Size_" + size;
            suite.addResult(bubbleSortTest.apply(data, testName));
        }
        
        // Test edge cases
        suite.addResult(bubbleSortTest.apply(new int[]{}, "BubbleSort_Empty"));
        suite.addResult(bubbleSortTest.apply(new int[]{1}, "BubbleSort_Single"));
        suite.addResult(bubbleSortTest.apply(new int[]{1, 2, 3, 4, 5}, "BubbleSort_Sorted"));
        suite.addResult(bubbleSortTest.apply(new int[]{5, 4, 3, 2, 1}, "BubbleSort_Reverse"));
    }
    
    /**
     * Selection Sort Tests
     */
    private void runSelectionSortTests(TestSuite suite) {
        Test<int[]> selectionSortTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Copy array to avoid modifying original
            int[] testArray = data.clone();
            
            // Perform selection sort
            SelectionSort.selectionSort(testArray);
            
            // Verify sorted order
            boolean passed = isArraySorted(testArray);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat.format(
                "Original: {0}, Sorted: {1}, Duration: {2} ns", 
                Arrays.toString(data), Arrays.toString(testArray), duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Array not properly sorted"));
        };
        
        // Test with various array sizes
        for (int size : new int[]{10, 100, 1000, 10000}) {
            int[] data = generateRandomArray(size, -1000, 1000);
            String testName = "SelectionSort_Size_" + size;
            suite.addResult(selectionSortTest.apply(data, testName));
        }
        
        // Test edge cases
        suite.addResult(selectionSortTest.apply(new int[]{}, "SelectionSort_Empty"));
        suite.addResult(selectionSortTest.apply(new int[]{1}, "SelectionSort_Single"));
        suite.addResult(selectionSortTest.apply(new int[]{1, 2, 3, 4, 5}, "SelectionSort_Sorted"));
    }
    
    /**
     * Insertion Sort Tests
     */
    private void runInsertionSortTests(TestSuite suite) {
        Test<int[]> insertionSortTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Copy array to avoid modifying original
            int[] testArray = data.clone();
            
            // Perform insertion sort
            InsertionSort.insertionSort(testArray);
            
            // Verify sorted order
            boolean passed = isArraySorted(testArray);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat.format(
                "Original: {0}, Sorted: {1}, Duration: {2} ns", 
                Arrays.toString(data), Arrays.toString(testArray), duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Array not properly sorted"));
        };
        
        // Test with various array sizes
        for (int size : new int[]{10, 100, 1000, 10000}) {
            int[] data = generateRandomArray(size, -1000, 1000);
            String testName = "InsertionSort_Size_" + size;
            suite.addResult(insertionSortTest.apply(data, testName));
        }
        
        // Test edge cases
        suite.addResult(insertionSortTest.apply(new int[]{}, "InsertionSort_Empty"));
        suite.addResult(insertionSortTest.apply(new int[]{1}, "InsertionSort_Single"));
        suite.addResult(insertionSortTest.apply(new int[]{1, 2, 3, 4, 5}, "InsertionSort_Sorted"));
        
        // Test nearly sorted array (best case)
        int[] nearlySorted = generateNearlySortedArray(1000);
        suite.addResult(insertionSortTest.apply(nearlySorted, "InsertionSort_NearlySorted"));
    }
    
    /**
     * Linear Search with Frequency Tests
     */
    private void runLinearSearchTests(TestSuite suite) {
        Test<int[]> linearSearchTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Test search for multiple targets
            int[] targets = {5, 10, 15};
            Map<Integer, Integer> expectedCounts = new HashMap<>();
            Map<Integer, Integer> actualCounts = new HashMap<>();
            
            // Calculate expected frequencies
            for (int target : targets) {
                expectedCounts.put(target, 0);
                for (int num : data) {
                    if (num == target) {
                        expectedCounts.merge(target, 1, Integer::sum);
                    }
                }
            }
            
            // Perform frequency search
            for (int target : targets) {
                int frequency = LinearSearchWithFrequency.linearSearchFrequency(data, target);
                actualCounts.put(target, frequency);
            }
            
            // Verify results
            boolean passed = expectedCounts.equals(actualCounts);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat.format(
                "Targets: {0}, Expected: {1}, Actual: {2}, Duration: {3} ns", 
                Arrays.toString(targets), expectedCounts, actualCounts, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Frequency counts don't match"));
        };
        
        // Test with various array sizes
        for (int size : new int[]{10, 100, 1000, 10000}) {
            int[] data = generateRandomArray(size, -100, 100);
            String testName = "LinearSearch_Size_" + size;
            suite.addResult(linearSearchTest.apply(data, testName));
        }
        
        // Test edge cases
        suite.addResult(linearSearchTest.apply(new int[]{}, "LinearSearch_Empty"));
        suite.addResult(linearSearchTest.apply(new int[]{5}, "LinearSearch_Single"));
        suite.addResult(linearSearchTest.apply(new int[]{1, 2, 3, 4, 5}, "LinearSearch_Found"));
        suite.addResult(linearSearchTest.apply(new int[]{5, 10, 5, 10, 5}, "LinearSearch_Duplicates"));
    }
    
    /**
     * LinkedList with Addresses Tests
     */
    private void runLinkedListTests(TestSuite suite) {
        Test<LinkedListWithAddresses> linkedListTest = (LinkedListWithAddresses list, String name) -> {
            long start = System.nanoTime();
            
            // Test basic operations
            list.insert(10);
            list.insert(20);
            list.insert(30);
            
            // Test display functionality
            int initialSize = list.getSize();
            list.displayWithAddresses();
            
            // Verify size
            boolean passed = list.getSize() == 3;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Initial size: {0}, Current size: {1}, Duration: {2} ns", 
                initialSize, list.getSize(), duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Size mismatch"));
        };
        
        // Test with multiple insertions
        LinkedListWithAddresses largeList = new LinkedListWithAddresses();
        for (int i = 1; i <= 100; i++) {
            largeList.insert(i);
        }
        
        suite.addResult(linkedListTest.apply(largeList, "LinkedList_LargeInsert"));
        
        // Test deletion operations
        largeList.deleteFromBeginning();
        largeList.deleteFromEnd();
        largeList.deleteAtPosition(50);
        
        suite.addResult(linkedListTest.apply(largeList, "LinkedList_Deletions"));
        
        // Test memory addresses
        suite.addResult(linkedListTest.apply(new LinkedListWithAddresses(), "LinkedList_Addresses"));
    }
    
    /**
     * Singly LinkedList Operations Tests
     */
    private void runSinglyLinkedListOpsTests(TestSuite suite) {
        Test<SinglyLinkedListOperations> opsTest = (SinglyLinkedListOperations list, String name) -> {
            long start = System.nanoTime();
            
            // Test all operations
            list.insertAtBeginning(10);
            list.insertAtEnd(20);
            list.insertAtPosition(15, 1);
            
            list.displayList();
            
            // Test deletion operations
            list.deleteFromBeginning();
            list.deleteFromEnd();
            list.deleteAtPosition(1);
            
            // Verify final state
            boolean passed = list.getSize() == 0;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "All operations completed, Final size: {0}, Duration: {1} ns", 
                list.getSize(), duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Operations failed"));
        };
        
        // Test with large dataset
        SinglyLinkedListOperations largeList = new SinglyLinkedListOperations();
        for (int i = 1; i <= 1000; i++) {
            largeList.insertAtEnd(i);
        }
        
        suite.addResult(opsTest.apply(largeList, "SinglyLinkedList_LargeDataset"));
        
        // Test position operations
        largeList.insertAtPosition(500, 500);
        suite.addResult(opsTest.apply(largeList, "SinglyLinkedList_PositionInsert"));
        largeList.deleteAtPosition(500);
        suite.addResult(opsTest.apply(largeList, "SinglyLinkedList_PositionDelete"));
    }
    
    /**
     * Singly LinkedList Tests
     */
    private void runSinglyLinkedListTests(TestSuite suite) {
        Test<SinglyLinkedList> listTest = (SinglyLinkedList list, String name) -> {
            long start = System.nanoTime();
            
            // Test basic functionality
            list.insert(10);
            list.insert(20);
            list.insert(30);
            
            // Test traversal
            List<Integer> elements = new ArrayList<>();
            list.traverse(elements::add);
            
            // Test search
            boolean found = list.search(20);
            boolean passed = elements.size() == 3 && found;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Elements: {0}, Found 20: {1}, Duration: {2} ns", 
                elements.size(), found, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Traversal or search failed"));
        };
        
        // Test with reverse
        SinglyLinkedList reverseList = new SinglyLinkedList();
        for (int i = 1; i <= 100; i++) {
            reverseList.insertAtBeginning(i);
        }
        
        reverseList.reverseList();
        List<Integer> reversedElements = new ArrayList<>();
        reverseList.traverse(reversedElements::add);
        
        boolean isReversed = reversedElements.equals(Arrays.asList(100, 99, 98, ..., 1));
        suite.addResult(listTest.apply(reverseList, "SinglyLinkedList_Reverse"));
        
        // Test with large dataset
        SinglyLinkedList largeList = new SinglyLinkedList();
        for (int i = 1; i <= 10000; i++) {
            largeList.insertAtEnd(i);
        }
        
        suite.addResult(listTest.apply(largeList, "SinglyLinkedList_LargeDataset"));
    }
    
    /**
     * Smallest and Largest Tests
     */
    private void runSmallestLargestTests(TestSuite suite) {
        Test<int[]> minMaxTest = (int[] data, String name) -> {
            long start = System.nanoTime();
            
            // Find smallest and largest
            int min = data.length > 0 ? data[0] : Integer.MAX_VALUE;
            int max = data.length > 0 ? data[0] : Integer.MIN_VALUE;
            
            for (int num : data) {
                if (num < min) min = num;
                if (num > max) max = num;
            }
            
            boolean passed = (min <= max) && (data.length > 0);
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Min: {0}, Max: {1}, Duration: {2} ns", min, max, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Min/max calculation failed"));
        };
        
        // Test with various data sets
        for (int size : new int[]{10, 100, 1000, 10000}) {
            int[] data = generateRandomArray(size, -1000, 1000);
            String testName = "SmallestLargest_Size_" + size;
            suite.addResult(minMaxTest.apply(data, testName));
        }
        
        // Test with sorted data
        int[] sortedData = generateSortedArray(1000);
        suite.addResult(minMaxTest.apply(sortedData, "SmallestLargest_Sorted"));
        
        // Test with reverse sorted data
        int[] reverseSortedData = generateReverseSortedArray(1000);
        suite.addResult(minMaxTest.apply(reverseSortedData, "SmallestLargest_ReverseSorted"));
        
        // Test with duplicate elements
        int[] duplicateData = {5, 3, 8, 1, 2, 3, 5, 7, 9, 2};
        suite.addResult(minMaxTest.apply(duplicateData, "SmallestLargest_Duplicates"));
    }
    
    /**
     * Sparse Matrix Tests
     */
    private void runSparseMatrixTests(TestSuite suite) {
        Test<SparseMatrix> matrixTest = (SparseMatrix matrix, String name) -> {
            long start = System.nanoTime();
            
            // Test basic operations
            matrix.insert(0, 0, 1);
            matrix.insert(1, 1, 2);
            matrix.insert(2, 2, 3);
            
            // Test matrix properties
            int rows = matrix.getRows();
            int cols = matrix.getCols();
            int nonZeroCount = matrix.getNonZeroCount();
            
            // Test transpose
            SparseMatrix transposed = matrix.transpose();
            
            boolean passed = rows == 3 && cols == 3 && nonZeroCount == 3;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Size: {0}x{1}, Non-zero: {2}, Duration: {3} ns", 
                rows, cols, nonZeroCount, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Matrix operations failed"));
        };
        
        // Test with different sparsity levels
        double[] sparsityLevels = {0.1, 0.5, 0.9, 0.99};
        
        for (double sparsity : sparsityLevels) {
            SparseMatrix sparseMatrix = createSparseMatrix(100, 100, sparsity);
            String testName = "SparseMatrix_Sparsity_" + sparsity;
            suite.addResult(matrixTest.apply(sparseMatrix, testName));
        }
        
        // Test matrix operations
        SparseMatrix matrix1 = createSparseMatrix(50, 50, 0.3);
        SparseMatrix matrix2 = createSparseMatrix(50, 50, 0.3);
        
        SparseMatrix sum = matrix1.add(matrix2);
        suite.addResult(matrixTest.apply(sum, "SparseMatrix_Addition"));
        
        SparseMatrix product = matrix1.multiply(matrix2);
        suite.addResult(matrixTest.apply(product, "SparseMatrix_Multiplication"));
    }
    
    /**
     * Stack Operations Tests
     */
    private void runStackOperationsTests(TestSuite suite) {
        Test<Stack<Integer>> stackTest = (Stack<Integer> stack, String name) -> {
            long start = System.nanoTime();
            
            // Test basic stack operations
            stack.push(10);
            stack.push(20);
            stack.push(30);
            
            // Test stack properties
            int top = stack.peek();
            int size = stack.size();
            boolean empty = stack.isEmpty();
            
            // Test pop operations
            int popped1 = stack.pop();
            int popped2 = stack.pop();
            int popped3 = stack.pop();
            
            boolean passed = top == 30 && size == 0 && empty && 
                         popped1 == 30 && popped2 == 20 && popped3 == 10;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Top: {0}, Size: {1}, Empty: {2}, Duration: {3} ns", 
                top, size, empty, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("Stack operations failed"));
        };
        
        // Test with large stack
        Stack<Integer> largeStack = new Stack<>();
        for (int i = 1; i <= 10000; i++) {
            largeStack.push(i);
        }
        
        suite.addResult(stackTest.apply(largeStack, "Stack_LargeDataset"));
        
        // Test stack underflow
        Stack<Integer> emptyStack = new Stack<>();
        try {
            emptyStack.pop();
            return new TestResult("Stack_Underflow", false, 0, "Stack underflow occurred");
        } catch (EmptyStackException e) {
            return new TestResult("Stack_Underflow", true, 0, "Exception properly caught");
        }
        
        // Test stack with different data types
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        suite.addResult(stackTest.apply(stringStack, "Stack_StringData"));
    }
    
    /**
     * TestLinkedList Tests
     */
    private void runTestLinkedListTests(TestSuite suite) {
        Test<TestLinkedList> listTest = (TestLinkedList list, String name) -> {
            long start = System.nanoTime();
            
            // Test basic operations
            list.add(10);
            list.add(20);
            list.add(30);
            
            // Test list properties
            int size = list.size();
            boolean contains = list.contains(20);
            int get = list.get(1);
            
            // Test removal operations
            boolean removed = list.remove(Integer.valueOf(20));
            int sizeAfterRemoval = list.size();
            
            boolean passed = size == 3 && contains && !removed && sizeAfterRemoval == 2;
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "Size: {0}, Contains 20: {1}, Get 1: {2}, After removal: {3}, Duration: {4} ns", 
                size, contains, get, sizeAfterRemoval, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("List operations failed"));
        };
        
        // Test with iterator
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = testList.iterator();
        
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        
        suite.addResult(new TestResult("LinkedList_Iterator", count == 5, 0, 
            "Iterator visited all elements"));
        
        // Test with different list implementations
        List<Integer> arrayList = new ArrayList<>(testList);
        Vector<Integer> vector = new Vector<>(testList);
        LinkedList<Integer> linkedList = new LinkedList<>(testList);
        
        suite.addResult(listTest.apply(arrayList, "LinkedList_ArrayList"));
        suite.addResult(listTest.apply(vector, "LinkedList_Vector"));
        suite.addResult(listTest.apply(linkedList, "LinkedList_LinkedList"));
        
        // Test with large dataset
        List<Integer> largeList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            largeList.add(i);
        }
        
        suite.addResult(listTest.apply(largeList, "LinkedList_LargeDataset"));
    }
    
    /**
     * Traversal Tests
     */
    private void runTraversalTests(TestSuite suite) {
        // Create a sample binary tree for testing
        TreeNode root = createSampleTree();
        
        Test<TreeNode> dfsTest = (TreeNode node, String name) -> {
            long start = System.nanoTime();
            
            List<Integer> dfsResult = new ArrayList<>();
            depthFirstTraversal(root, dfsResult::add);
            
            boolean passed = dfsResult.equals(Arrays.asList(1, 2, 4, 5, 7, 9));
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "DFS traversal: {0}, Duration: {1} ns", 
                dfsResult, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("DFS traversal failed"));
        };
        
        Test<TreeNode> bfsTest = (TreeNode node, String name) -> {
            long start = System.nanoTime();
            
            List<Integer> bfsResult = new ArrayList<>();
            breadthFirstTraversal(root, bfsResult::add);
            
            boolean passed = bfsResult.equals(Arrays.asList(1, 2, 4, 5, 7, 9));
            long duration = System.nanoTime() - start;
            
            String details = MessageFormat(
                "BFS traversal: {0}, Duration: {1} ns", 
                bfsResult, duration);
            
            return new TestResult(name, passed, duration, details,
                passed ? Collections.emptyList() : 
                Arrays.asList("BFS traversal failed"));
        };
        
        Test<TreeNode> inOrderTest = (TreeNode node, String name) -> {
            List<Integer> inOrderResult = new ArrayList<>();
            inOrderTraversal(root, inOrderResult::add);
            
            boolean passed = inOrderResult.equals(Arrays.asList(1, 2, 4, 5, 7, 9));
            return new TestResult(name, passed, 0, 
                "In-order traversal completed");
        };
        
        Test<TreeNode> preOrderTest = (TreeNode node, String name) -> {
            List<Integer> preOrderResult = new ArrayList<>();
            preOrderTraversal(root, preOrderResult::add);
            
            boolean passed = preOrderResult.equals(Arrays.asList(1, 2, 4, 5, 7, 9));
            return new TestResult(name, passed, 0, 
                "Pre-order traversal completed");
        };
        
        Test<TreeNode> postOrderTest = (TreeNode node, String name) -> {
            List<Integer> postOrderResult = new ArrayList<>();
            postOrderTraversal(root, postOrderResult::add);
            
            boolean passed = postOrderResult.equals(Arrays.asList(4, 5, 7, 9, 2, 1));
            return new TestResult(name, passed, 0, 
                "Post-order traversal completed");
        };
        
        suite.addResult(dfsTest);
        suite.addResult(bfsTest);
        suite.addResult(inOrderTest);
        suite.addResult(preOrderTest);
        suite.addResult(postOrderTest);
    }
    
    /**
     * Sample Program Tests
     */
    private void runSampleTests(TestSuite suite) {
        Test<sample> sampleTest = (sample, name) -> {
            long start = System.nanoTime();
            
            // Test all imports functionality
            sample.demonstrateAllImports();
            
            boolean passed = true; // Assume all imports work
            long duration = System.nanoTime() - start;
            
            return new TestResult(name, passed, duration, 
                "All imports demonstrated successfully");
        };
        
        suite.addResult(sampleTest);
    }
    
    /**
     * Helper Methods
     */
    private int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    
    private int[] generateNearlySortedArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        
        // Introduce some disorder
        for (int i = 0; i < size / 10; i++) {
            int j = random.nextInt(size);
            if (j != i) {
                int temp = array[i];
                array[i] = array[j];
            }
        }
        return array;
    }
    
    private int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i * 2;
        }
        return array;
    }
    
    private int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (size - i - 1);
        }
        return array;
    }
    
    private boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    private TreeNode createSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(9);
        return root;
    }
    
    private SparseMatrix createSparseMatrix(int rows, int cols, double sparsity) {
        SparseMatrix matrix = new SparseMatrix(rows, cols);
        Random random = new Random();
        
        int totalElements = (int) (rows * cols * sparsity);
        for (int i = 0; i < totalElements; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            int value = random.nextInt(1000);
            matrix.insert(row, col, value);
        }
        
        return matrix;
    }
    
    private void depthFirstTraversal(TreeNode root, Consumer<Integer> visitor) {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            visitor.accept(current.data);
            
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }
    
    private void breadthFirstTraversal(TreeNode root, Consumer<Integer> visitor) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            visitor.accept(current.data);
            
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }
    
    private void inOrderTraversal(TreeNode root, Consumer<Integer> visitor) {
        if (root != null) {
            inOrderTraversal(root.left, visitor);
            visitor.accept(root.data);
            inOrderTraversal(root.right, visitor);
        }
    }
    
    private void preOrderTraversal(TreeNode root, Consumer<Integer> visitor) {
        if (root != null) {
            visitor.accept(root.data);
            preOrderTraversal(root.left, visitor);
            preOrderTraversal(root.right, visitor);
        }
    }
    
    private void postOrderTraversal(TreeNode root, Consumer<Integer> visitor) {
        if (root != null) {
            postOrderTraversal(root.left, visitor);
            visitor.accept(root.data);
            postOrderTraversal(root.right, visitor);
        }
    }
    
    /**
     * Generate comprehensive HTML report
     */
    private void generateHtmlReport(long totalDuration) {
        try (PrintStream writer = new PrintStream(
                new BufferedOutputStream(
                new FileOutputStream(REPORT_FILE), true)) {
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>DSA Java Test Report</title>");
            writer.println("<style>");
            writer.println("body { font-family: Arial, sans-serif; margin: 40px; }");
            writer.println("table { border-collapse: collapse; width: 100%; margin-bottom: 20px; }");
            writer.println("th, td { padding: 8px; text-align: left; border: 1px solid #ddd; }");
            writer.println("th { background-color: #f8f9fa; }");
            writer.println("td { background-color: #ffffff; }");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>DSA Java Test Report</h1>");
            writer.println("<p>Generated on: " + new Date() + "</p>");
            writer.println("<p>Total test duration: " + totalDuration + " ms</p>");
            
            // Add summary table
            writer.println("<h2>Test Suite Summary</h2>");
            writer.println("<table>");
            writer.println("<tr><th>Test Suite</th><th>Tests Run</th><th>Passed</th><th>Failed</th><th>Success Rate</th><th>Total Duration</th></tr>");
            
            // Add suite summaries
            Map<String, TestSuite> allSuites = new HashMap<>();
            // Add all test suites here
            
        } catch (IOException e) {
            System.err.println("Error generating report: " + e.getMessage());
        }
    }
    
    /**
     * Main method to run all tests
     */
    public static void main(String[] args) {
        TestFramework framework = new TestFramework();
        framework.runAllTests();
    }
}

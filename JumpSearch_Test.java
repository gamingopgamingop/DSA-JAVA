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
 * JumpSearch_Test - Test class for Jump Search algorithm validation.
 */
public class JumpSearch_Test {

    private static final String TEST_RESULTS_FILE = "jump_search_test_results.txt";
    private static PrintStream writer;

    public static void main(String[] args) {
        try {
            writer = new PrintStream(new BufferedOutputStream(
                    new FileOutputStream(TEST_RESULTS_FILE), 1024), true);

            writer.println("=== JumpSearch Test Results ===");
            writer.println("Timestamp: " + new Date());
            writer.println();

            testBasicFunctionality();
            testEdgeCases();
            testLargeDataset();
            testElementNotFound();

            writer.close();
            System.out.println("JumpSearch tests completed. Results saved to " + TEST_RESULTS_FILE);

        } catch (IOException e) {
            System.err.println("Error writing test results: " + e.getMessage());
        }
    }

    private static void testBasicFunctionality() {
        writer.println("Test Case 1: Basic Functionality");
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 };
        int target = 55;
        int expected = 10;
        int actual = JumpSearch.jumpSearch(arr, target);
        
        writer.println("Array: " + Arrays.toString(arr));
        writer.println("Target: " + target);
        writer.println("Expected Index: " + expected);
        writer.println("Actual Index: " + actual);
        writer.println("Result: " + (expected == actual ? "PASSED" : "FAILED"));
        writer.println();
    }

    private static void testEdgeCases() {
        writer.println("Test Case 2: Edge Cases");
        
        // Empty array
        writer.println("Subtest: Empty Array");
        int[] emptyArr = {};
        int actualEmpty = JumpSearch.jumpSearch(emptyArr, 10);
        writer.println("Result: " + (actualEmpty == -1 ? "PASSED" : "FAILED"));

        // Single element (found)
        writer.println("Subtest: Single Element (Found)");
        int[] singleArr = { 42 };
        int actualSingle = JumpSearch.jumpSearch(singleArr, 42);
        writer.println("Result: " + (actualSingle == 0 ? "PASSED" : "FAILED"));

        // Single element (not found)
        writer.println("Subtest: Single Element (Not Found)");
        int actualSingleNotFound = JumpSearch.jumpSearch(singleArr, 10);
        writer.println("Result: " + (actualSingleNotFound == -1 ? "PASSED" : "FAILED"));
        
        writer.println();
    }

    private static void testLargeDataset() {
        writer.println("Test Case 3: Large Dataset");
        int size = 10000;
        int[] largeArr = new int[size];
        for (int i = 0; i < size; i++) {
            largeArr[i] = i * 2;
        }
        
        int target = 9998;
        int expected = 4999;
        long startTime = System.nanoTime();
        int actual = JumpSearch.jumpSearch(largeArr, target);
        long endTime = System.nanoTime();
        
        writer.println("Dataset size: " + size);
        writer.println("Target: " + target);
        writer.println("Time taken: " + (endTime - startTime) + " ns");
        writer.println("Result: " + (expected == actual ? "PASSED" : "FAILED"));
        writer.println();
    }

    private static void testElementNotFound() {
        writer.println("Test Case 4: Element Not Found");
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 25;
        int actual = JumpSearch.jumpSearch(arr, target);
        
        writer.println("Array: " + Arrays.toString(arr));
        writer.println("Target: " + target);
        writer.println("Actual Index: " + actual);
        writer.println("Result: " + (actual == -1 ? "PASSED" : "FAILED"));
        writer.println();
    }
}

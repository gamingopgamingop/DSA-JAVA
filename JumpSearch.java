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
 * JumpSearch - Implements the Jump Search algorithm.
 * 
 * Jump Search is an algorithm for searching an element in a sorted array.
 * It works by jumping ahead by fixed steps and then performing a linear search.
 */
public class JumpSearch {

    /**
     * Performs Jump Search on a sorted integer array.
     * 
     * @param arr    The sorted array of integers.
     * @param target The integer value to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) return -1;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is present (if it is present)
        int prev = 0;
        
        // Use functional interface for comparison to match existing style
        IntBinaryOperator comparator = (a, b) -> Integer.compare(a, b);
        
        while (comparator.applyAsInt(arr[Math.min(step, n) - 1], target) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        // Doing a linear search for target in block beginning with prev
        while (comparator.applyAsInt(arr[prev], target) < 0) {
            prev++;

            // If we reached next block or end of array, element is not present
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        // If element is found
        if (comparator.applyAsInt(arr[prev], target) == 0) {
            return prev;
        }

        return -1;
    }

    /**
     * Main method to demonstrate Jump Search.
     */
    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
        int target = 55;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Searching for: " + target);

        int result = jumpSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");
        }
        
        demonstrateAllImports();
    }

    /**
     * Demonstrates usage of various imports to match repository style.
     */
    private static void demonstrateAllImports() {
        System.out.println("\n--- Demonstration of Imports ---");
        
        // java.util
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("ArrayList: " + list);
        
        // java.text
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Date: " + sdf.format(new Date()));
        
        // java.util.function
        IntConsumer printer = x -> System.out.println("Functional Interface (IntConsumer): " + x);
        printer.accept(42);
        
        // java.util.Random
        Random rand = new Random();
        System.out.println("Random Number: " + rand.nextInt(100));
    }
}

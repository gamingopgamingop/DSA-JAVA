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
 * BinarySearch - Implements the binary search algorithm.
 * 
 * This class provides a method to perform binary search on a sorted array
 * to find the index of a specific target element.
 */
public class BinarySearch {
    /**
     * Performs binary search on a sorted integer array using functional interfaces.
     * 
     * @param arr The sorted array of integers.
     * @param target The integer value to search for.
     * @param predicate Custom predicate for comparison (optional, can be null).
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int binarySearch(int[] arr, int target, IntPredicate predicate) {
        int left = 0;
        int right = arr.length - 1;
        
        IntUnaryOperator midCalculator = l -> l + (right - l) / 2;
        IntBinaryOperator comparator = (a, b) -> Integer.compare(a, b);
        
        while (left <= right) {
            int mid = midCalculator.applyAsInt(left);
            int comparison = comparator.applyAsInt(arr[mid], target);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Performs binary search on a sorted List of integers using functional interfaces.
     * 
     * @param list The sorted list of integers.
     * @param target The integer value to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        
        Function<Integer, Integer> midCalculator = l -> l + (right - l) / 2;
        Comparator<Integer> comparator = Comparator.naturalOrder();
        
        while (left <= right) {
            int mid = midCalculator.apply(left);
            int comparison = comparator.compare(list.get(mid), target);
            
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Demonstrates various data structures and utilities.
     */
    public static void demonstrateDataStructures() {
        // Collections demonstration
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Vector<Integer> vector = new Vector<>(Arrays.asList(6, 7, 8, 9, 10));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(11, 12, 13, 14, 15));
        
        // Stack demonstration
        Stack<Integer> stack = new Stack<>();
        stack.push(1); stack.push(2); stack.push(3);
        
        // Queue demonstration
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(3, 1, 4, 1, 5));
        
        // Set demonstration
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(3, 1, 4, 1, 5));
        
        // Map demonstration
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1); hashMap.put("two", 2);
        
        // Functional interfaces demonstration
        Consumer<String> printer = str -> System.out.println("Consumer: " + str);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Function<String, Integer> stringLength = String::length;
        Supplier<Double> randomSupplier = () -> new Random().nextDouble();
        
        // Using the functional interfaces
        printer.accept("Hello from Consumer!");
        System.out.println("Predicate (isEven 4): " + isEven.test(4));
        System.out.println("Function (length of 'Hello'): " + stringLength.apply("Hello"));
        System.out.println("Supplier (random): " + randomSupplier.get());
        
        // Collections utilities
        Collections.sort(arrayList);
        Collections.reverse(linkedList);
        Collections.shuffle(vector);
        
        System.out.println("Demonstrated various data structures and utilities.");
    }
    
    /**
     * Demonstrates date formatting and decimal formatting.
     */
    public static void demonstrateFormatting() {
        // Date formatting
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(new Date());
        System.out.println("Current date: " + currentDate);
        
        // Decimal formatting
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        double pi = 3.14159265359;
        System.out.println("Formatted PI: " + decimalFormat.format(pi));
    }
    
    /**
     * Main method to test the binary search implementation with enhanced features.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        demonstrateDataStructures();
        demonstrateFormatting();
        
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Sort the array to ensure Binary Search works
            Arrays.sort(arr);
            
            // Create different types of collections from the array
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            Vector<Integer> vector = new Vector<>(list);
            LinkedList<Integer> linkedList = new LinkedList<>(list);
            
            // Display sorted array using Iterator
            System.out.print("Sorted array: [");
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            System.out.print("Enter the target value to search for: ");
            int target = scanner.nextInt();
            
            // Test binary search on different collections
            System.out.println("\n--- Binary Search Results ---");
            
            // Using array-based binarySearch with functional interfaces
            int arrayIndex = binarySearch(arr, target, null);
            
            // Using List-based binarySearch
            int listIndex = binarySearch(list, target);
            
            // Using Formatter for formatted output
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);
            
            if (arrayIndex != -1) {
                String result = MessageFormat.format("Element found at index {0} in array", arrayIndex);
                formatter.format("%s%n", result);
            } else {
                String result = MessageFormat.format("Element {0} not found in array", target);
                formatter.format("%s%n", result);
            }
            
            if (listIndex != -1) {
                String result = MessageFormat.format("Element found at index {0} in list", listIndex);
                formatter.format("%s%n", result);
            } else {
                String result = MessageFormat.format("Element {0} not found in list", target);
                formatter.format("%s%n", result);
            }
            
            System.out.print(sb.toString());
            formatter.close();
            
            // Demonstrate file operations
            try {
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                    new FileOutputStream("binary_search_results.txt", false)), true);
                writer.println("Binary Search Results - " + new Date());
                writer.println("Target: " + target);
                writer.println("Array index: " + arrayIndex);
                writer.println("List index: " + listIndex);
                writer.close();
                System.out.println("Results saved to binary_search_results.txt");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        } finally {
            scanner.close();
        }
    }

}

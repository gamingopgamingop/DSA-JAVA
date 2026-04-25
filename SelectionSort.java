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
/**
 * SelectionSort - A program to sort an array using Selection Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Selection Sort, and displays the array before and after sorting.
 */
public class SelectionSort {

    /**
     * Main method to execute selection sort logic.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // List implementations
        List<Integer> numberList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Vector<Integer> numberVector = new Vector<>();
        
        // Queue implementations
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        // Set implementations
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        
        // Map implementations
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> hashtable = new Hashtable<>();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        
        Stack<Integer> sortStack = new Stack<>();
        Formatter formatter = new Formatter();
        
        // Printing utilities
        PrintStream printStream = System.out;
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(System.out));
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // Read array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();

            int[] arr = new int[size];

            // Read array elements
            System.out.println(MessageFormat.format("Enter {0} array elements:", size));
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
                int value = arr[i];
                String label = "Num_" + value;
                
                // Add to Lists
                numberList.add(value);
                linkedList.add(value);
                numberVector.add(value);
                
                // Add to Queues
                queue.offer(value);
                arrayDeque.offer(value);
                priorityQueue.offer(value);
                
                // Add to Sets
                hashSet.add(value);
                linkedHashSet.add(value);
                treeSet.add(value);
                
                // Add to Maps
                hashMap.put(value, label);
                linkedHashMap.put(value, label);
                treeMap.put(value, label);
                hashtable.put(value, label);
                sortedMap.put(value, label);
                navigableMap.put(value, label);
            }

            // Print comprehensive collection demonstration with all printing packages
            System.out.println("\n" + "=".repeat(60));
            System.out.println("COLLECTIONS & PRINTING DEMONSTRATION");
            System.out.println("=".repeat(60));
            
            // Using PrintStream
            printStream.println("\n--- PRINTSTREAM OUTPUT ---");
            printStream.println("Total elements: " + size);
            printStream.println("Array length: " + arr.length);
            printStream.flush();
            
            // Using PrintWriter
            printWriter.println("\n--- PRINTWRITER OUTPUT ---");
            printWriter.println("Processing " + size + " elements");
            printWriter.println("Using buffered output for better performance");
            printWriter.flush();
            
            // Using DecimalFormat
            System.out.println("\n--- DECIMALFORMAT OUTPUT ---");
            if (size > 0) {
                double sum = 0;
                for (int num : arr) sum += num;
                double average = sum / size;
                System.out.println("Sum: " + decimalFormat.format(sum));
                System.out.println("Average: " + decimalFormat.format(average));
                System.out.println("Max value: " + decimalFormat.format(Arrays.stream(arr).max().orElse(0)));
                System.out.println("Min value: " + decimalFormat.format(Arrays.stream(arr).min().orElse(0)));
            }
            
            // Using SimpleDateFormat
            System.out.println("\n--- DATE/TIME FORMATTING ---");
            System.out.println("Current time: " + dateFormat.format(new java.util.Date()));
            System.out.println("Processing started at: " + dateFormat.format(new java.util.Date()));
            
            // Using MessageFormat
            System.out.println("\n--- MESSAGEFORMAT OUTPUT ---");
            String message = MessageFormat.format(
                "Sorting {0,number,integer} elements with values ranging from {1} to {2}",
                size,
                size > 0 ? Arrays.stream(arr).min().orElse(0) : 0,
                size > 0 ? Arrays.stream(arr).max().orElse(0) : 0
            );
            System.out.println(message);
            
            // Using Formatter for table
            System.out.println("\n--- FORMATTER TABLE OUTPUT ---");
            Formatter tableFormatter = new Formatter();
            tableFormatter.format("%-15s | %-10s | %-10s%n", "Collection", "Size", "Type");
            tableFormatter.format("%-15s | %-10s | %-10s%n", "---------------", "----------", "----------");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "ArrayList", numberList.size(), "List");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "LinkedList", linkedList.size(), "List");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "Vector", numberVector.size(), "List");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "HashSet", hashSet.size(), "Set");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "TreeSet", treeSet.size(), "Set");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "HashMap", hashMap.size(), "Map");
            tableFormatter.format("%-15s | %-10d | %-10s%n", "TreeMap", treeMap.size(), "Map");
            System.out.println(tableFormatter.toString());
            tableFormatter.close();
            
            // LIST IMPLEMENTATIONS
            System.out.println("\n--- LIST IMPLEMENTATIONS ---");
            System.out.println("ArrayList: " + numberList);
            System.out.println("LinkedList: " + linkedList);
            System.out.println("Vector: " + numberVector);
            System.out.println("Vector capacity: " + numberVector.capacity());
            System.out.print("Elements using Iterator: ");
            Iterator<Integer> iterator = numberList.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
            
            // QUEUE IMPLEMENTATIONS
            System.out.println("\n--- QUEUE IMPLEMENTATIONS ---");
            System.out.println("Queue (LinkedList): " + queue);
            System.out.println("ArrayDeque: " + arrayDeque);
            System.out.println("PriorityQueue (natural order): " + priorityQueue);
            System.out.println("Queue peek: " + queue.peek() + ", ArrayDeque peek: " + arrayDeque.peek());
            
            // SET IMPLEMENTATIONS
            System.out.println("\n--- SET IMPLEMENTATIONS ---");
            System.out.println("HashSet (unordered, no duplicates): " + hashSet);
            System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
            System.out.println("TreeSet (sorted): " + treeSet);
            
            // MAP IMPLEMENTATIONS
            System.out.println("\n--- MAP IMPLEMENTATIONS ---");
            System.out.println("HashMap: " + hashMap);
            System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
            System.out.println("TreeMap (sorted by key): " + treeMap);
            System.out.println("Hashtable (synchronized): " + hashtable);
            
            // Advanced Map operations
            if (size > 0) {
                System.out.println("\n--- ADVANCED MAP OPERATIONS ---");
                System.out.println("SortedMap first key: " + sortedMap.firstKey() + 
                                 ", last key: " + sortedMap.lastKey());
                System.out.println("NavigableMap first entry: " + navigableMap.firstEntry());
                System.out.println("NavigableMap last entry: " + navigableMap.lastEntry());
            }
            
            System.out.println("\nArray before sorting: " + Arrays.toString(arr));

            // Selection Sort logic
            for (int i = 0; i < size - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                // Swap smallest element with first unsorted position
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                
                // Push sorted elements to stack
                sortStack.push(arr[i]);
            }
            // Push the last element
            if (size > 0) {
                sortStack.push(arr[size - 1]);
            }

            // Print array after sorting
            System.out.println("\n" + "=".repeat(60));
            System.out.println("SORTING RESULTS");
            System.out.println("=".repeat(60));
            System.out.println("Array after sorting: " + Arrays.toString(arr));
            
            // Demonstrate Stack usage
            System.out.print("\nElements from stack (LIFO): ");
            while (!sortStack.isEmpty()) {
                try {
                    System.out.print(sortStack.pop() + " ");
                } catch (NoSuchElementException e) {
                    System.out.println("\nStack is empty!");
                }
            }
            System.out.println();
            
            // Final summary using all printing methods
            printStream.println("\n--- FINAL SUMMARY (PrintStream) ---");
            printStream.println("Sorting completed successfully!");
            
            printWriter.println("\n--- FINAL SUMMARY (PrintWriter) ---");
            printWriter.println("All " + size + " elements sorted using Selection Sort");
            printWriter.flush();
            
            // Use Formatter for final summary
            Formatter summaryFormatter = new Formatter();
            summaryFormatter.format("%n%n" + "=".repeat(60) + "%n");
            summaryFormatter.format("COMPREHENSIVE SORTING SUMMARY%n");
            summaryFormatter.format("=".repeat(60) + "%n");
            summaryFormatter.format("Algorithm: Selection Sort%n");
            summaryFormatter.format("Input Size: %d elements%n", size);
            summaryFormatter.format("Time Complexity: O(n²)%n");
            summaryFormatter.format("Space Complexity: O(1)%n");
            summaryFormatter.format("Collections Demonstrated: 18%n");
            summaryFormatter.format("Printing Methods Used: 7%n");
            summaryFormatter.format("  - System.out (PrintStream)%n");
            summaryFormatter.format("  - PrintWriter (Buffered)%n");
            summaryFormatter.format("  - Formatter (Table format)%n");
            summaryFormatter.format("  - MessageFormat (Template)%n");
            summaryFormatter.format("  - DecimalFormat (Numbers)%n");
            summaryFormatter.format("  - SimpleDateFormat (Date/Time)%n");
            summaryFormatter.format("  - String formatting (%, %s, %d)%n");
            summaryFormatter.format("=".repeat(60) + "%n");
            System.out.println(summaryFormatter.toString());
            summaryFormatter.close();
            
            formatter.close();
            printWriter.close();

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integer values only.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input found.");
        } finally {
            scanner.close();
        }
    }
}

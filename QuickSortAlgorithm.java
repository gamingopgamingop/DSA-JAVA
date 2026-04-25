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
 * QuickSortAlgorithm - Implements the Quick Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Quick Sort algorithm, and then prints the sorted array.
 */
public class QuickSortAlgorithm implements Runnable {

    /**
     * Reads an integer from the console with input validation.
     *
     * @param scanner The Scanner object to read input from.
     * @param prompt The message to display to the user.
     * @return The integer entered by the user.
     */ 
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            } catch (NoSuchElementException e) {
                System.err.println("Error: Required input was not found.");
                System.exit(1);
            }       
        }
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     * @param recursionStack A stack to track recursion depth (for demonstration).
     */
    // public static void quickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
    //     if (low < high) {
    //         recursionStack.push(low); // Track recursion for demonstration
    //         int pi = partition(arr, low, high);
    //         quickSort(arr, low, pi - 1, recursionStack);
    //         quickSort(arr, pi + 1, high, recursionStack);
    //         recursionStack.pop();
    //     }
    // }
    
    public void quickSort(int[] arr, int low, int high, Stack<Integer> recursionStack) {
        if (low < high) {
            recursionStack.push(low); // Track recursion for demonstration
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1, recursionStack);
            quickSort(arr, pi + 1, high, recursionStack);
            recursionStack.pop();
        }
    }


    /**
     * Partitions the array into two sub-arrays around a pivot element.
     * Elements smaller than the pivot are moved to its left, and larger elements to its right.
     *
     * @param arr The array to be partitioned.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     * @return The partitioning index.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(MessageFormat.format("Array size: {0}", n));
            
            // Input array elements
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, MessageFormat.format("Element {0}: ", i));
            }

            System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

            // Sort the array using Quick Sort
            Stack<Integer> recursionStack = new Stack<>();
            quickSort(array, 0, array.length - 1, recursionStack);
            
            // Using List and Iterator for demonstration of imports
            List<Integer> sortedList = new java.util.ArrayList<>();
            for (int val : array) sortedList.add(val);
            
            System.out.print("Sorted Array (via Iterator): ");
            Iterator<Integer> it = sortedList.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();

            // Using Formatter for final summary
            Formatter formatter = new Formatter();
            formatter.format("Summary: Quick Sort completed on %d elements. Sorted Array: %s", 
                            n, Arrays.toString(array));
            System.out.println(formatter.toString());
            formatter.close();
        }
    }

    public static void main(String[] args) {
        new QuickSortAlgorithm().run();
    }
}

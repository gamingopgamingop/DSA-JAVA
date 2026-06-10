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
 * InterpolationSearch - Implements the Interpolation Search algorithm.
 * 
 * Interpolation Search is an improvement over Binary Search for instances, 
 * where the values in a sorted array are uniformly distributed.
 */
public class InterpolationSearch {

    /**
     * Performs Interpolation Search on a sorted, uniformly distributed integer array.
     * 
     * @param arr    The sorted array of integers.
     * @param target The integer value to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        // Functional interface for position calculation (The 'Interpolation' part)
        // pos = low + [ (target-arr[low])*(high-low) / (arr[high]-arr[low]) ]
        java.util.function.ToLongFunction<int[]> posCalculator = (bounds) -> {
            long l = low;
            long h = high;
            long t = target;
            long al = arr[low];
            long ah = arr[high];
            if (ah == al) return l;
            return l + ((t - al) * (h - l) / (ah - al));
        };

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            int pos = (int) posCalculator.applyAsLong(arr);

            if (arr[pos] == target) {
                return pos;
            }

            if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };
        int target = 18;

        System.out.println("Interpolation Search Demonstration");
        System.out.println("Array: " + Arrays.toString(arr));
        
        int index = search(arr, target);
        
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }

        demonstrateAllImports();
    }

    private static void demonstrateAllImports() {
        // Matching repository style of demonstrating imports
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Execution Time: " + formatter.format(new Date()));
        
        IntConsumer logger = (val) -> System.out.println("Logged Value: " + val);
        logger.accept(100);
    }
}

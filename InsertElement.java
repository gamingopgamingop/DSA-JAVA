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
 * InsertElement - A program to insert an element into an array.
 * 
 * This class reads an array from the user, then asks for an index and an element
 * to insert. It shifts existing elements to make space and inserts the new element.
 */
public class InsertElement {
    /**
     * Main method to execute the insertion logic.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read array size
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        // Read array elements
        System.out.println(MessageFormat.format("Enter {0} array elements:", size));
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        // Print the array before insertion
        System.out.println(MessageFormat.format("Array before insertion: {0}", arr));
        System.out.println("Array before insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();
        // Print the array before insertion
        System.out.println("Array before insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();
            
        // Read index and element to insert
        System.out.print("Enter index to insert at: ");
        int index = scanner.nextInt();
        System.out.print("Enter element to insert: ");
        int element = scanner.nextInt();
        
        // Shift elements to the right to make space for the new element
        for(int i=arr.length-1;i>=index;i--){
            arr[i] = arr[i-1];
        }
                arr[index] = element;
                
        // Print the array after insertion
        System.out.println(MessageFormat.format("Array after insertion: {0}", arr));
        System.out.println("Array after insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        
        scanner.close();
    }
}

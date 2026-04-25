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

public class SmallestLargest {
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume the invalid token
        }
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // consume the invalid token
            }
            array[i] = scanner.nextInt();
        }

        // Find smallest and largest elements
        int smallest = array[0];
        int largest = array[0];
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {    
                largest = num;
            }
        }
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);
        scanner.close();

    }
}

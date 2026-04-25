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
 * LinearSearchWithFrequency - Performs linear search and counts occurrences.
 * 
 * This class allows the user to input an array and a target element.
 * It searches for the target in the array and reports how many times it appears.
 */
public class LinearSearchWithFrequency {
    /**
     * Performs linear search to count occurrences of a target element in an array.
     * 
     * @param arr   The array to search in.
     * @param target The element to search for.
     * @return The frequency of the target element in the array.
     */
    public static int linearSearchFrequency(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static int linearSearchFrequency(Set<Integer> set, int target) {
        return set.contains(target) ? 1 : 0;
    }

    public static int linearSearchFrequency(List<Integer> arr, int target) {
        int count = 0;
        for (Integer num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }


    /**
     * Demonstrates all imports with comprehensive examples.
     */
    public static void demonstrateAllImports() {
        try {
            // Date and Time formatting
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDate = dateFormat.format(new Date());
            System.out.println("Current date: " + currentDate);
            
            // Decimal formatting
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            double pi = 3.14159265359;
            System.out.println("Formatted PI: " + decimalFormat.format(pi));
            
            // Collections demonstration
            List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
            Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
            LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));
            
            // Stack operations
            Stack<Integer> stack = new Stack<>();
            stack.push(1); stack.push(2); stack.push(3);
            
            // Queue operations
            Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));
            
            // Set operations
            Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
            Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
            Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
            Set<java.lang.Thread.State> enumSet = EnumSet.noneOf(java.lang.Thread.State.class);
            
            // Map operations
            Map<String, Integer> hashMap = new HashMap<>();
            hashMap.put("one", 1); hashMap.put("two", 2);
            Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("first", 1); linkedHashMap.put("second", 2);
            Map<String, Integer> treeMap = new TreeMap<>();
            treeMap.put("z", 26); treeMap.put("a", 1);
            Hashtable<String, Integer> hashtable = new Hashtable<>();
            hashtable.put("hash", 42);
            SortedMap<String, Integer> sortedMap = new TreeMap<>();
            sortedMap.put("sorted", 100);
            NavigableMap<String, Integer> navigableMap = new TreeMap<>();
            navigableMap.put("nav", 200);
            
            // I/O Operations
            PrintStream printStream = new PrintStream(new BufferedOutputStream(
                new FileOutputStream("linear_search_freq_demo.txt")), true);
            printStream.println("Linear Search Frequency Demo Output");
            printStream.close();
            
            // Character encoding
            String encodedText = "Linear Search Frequency Demo";
            byte[] utf8Bytes = encodedText.getBytes(StandardCharsets.UTF_8);
            System.out.println("UTF-8 encoded: " + new String(utf8Bytes, StandardCharsets.UTF_8));
            
            // Desktop operations
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    System.out.println("Desktop operations supported: " + desktop.isSupported(Desktop.Action.BROWSE));
                }
            } catch (Exception e) {
                System.out.println("Desktop operations not available");
            }
            
            // Printing operations
            try {
                PrinterJob printerJob = PrinterJob.getPrinterJob();
                PageFormat pageFormat = printerJob.defaultPage();
                Book book = new Book();
                System.out.println("Printing system available: " + printerJob.printDialog());
                // This method actually throws PrinterException
                printerJob.print();
            } catch (PrinterException e) {
                System.out.println("Printing system error: " + e.getMessage());
            }
            
            // Collections utilities
            Collections.sort(arrayList);
            Collections.reverse(linkedList);
            Collections.shuffle(vector);
            
            // Functional interfaces
            Consumer<String> printer = str -> System.out.println("Consumer: " + str);
            Predicate<Integer> isEven = num -> num % 2 == 0;
            Function<String, Integer> stringLength = String::length;
            Supplier<Double> randomSupplier = () -> new Random().nextDouble();
            
            // Primitive functional interfaces
            IntUnaryOperator square = x -> x * x;
            IntBinaryOperator multiply = (a, b) -> a * b;
            IntPredicate isPositive = x -> x > 0;
            IntConsumer printInt = x -> System.out.println("Int: " + x);
            IntFunction<String> intToString = Integer::toString;
            
            DoubleUnaryOperator doubleSquare = x -> x * x;
            DoubleBinaryOperator doubleMultiply = (a, b) -> a * b;
            DoublePredicate isDoublePositive = x -> x > 0.0;
            DoubleConsumer printDouble = x -> System.out.println("Double: " + x);
            DoubleFunction<String> doubleToString = Double::toString;
            
            LongUnaryOperator longSquare = x -> x * x;
            LongPredicate isLongPositive = x -> x > 0L;
            LongConsumer printLong = x -> System.out.println("Long: " + x);
            
            // Stream Tokenizer
            String sampleText = "Linear 123 Search 456 Frequency Demo";
            StreamTokenizer tokenizer = new StreamTokenizer(new java.io.StringReader(sampleText));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                System.out.println("Token: " + tokenizer.sval + " (Type: " + tokenizer.ttype + ")");
            }
            
            // Random operations
            Random random = new Random();
            System.out.println("Random int: " + random.nextInt());
            System.out.println("Random double: " + random.nextDouble());
            
            // Demonstrate functional interfaces
            printer.accept("Hello from Linear Search Frequency!");
            System.out.println("Predicate (isEven 4): " + isEven.test(4));
            System.out.println("Function (length of 'Linear'): " + stringLength.apply("Linear"));
            System.out.println("Supplier (random): " + randomSupplier.get());
            
            int result = square.applyAsInt(5);
            System.out.println("Square of 5: " + result);
            
            int product = multiply.applyAsInt(3, 4);
            System.out.println("3 * 4 = " + product);
            
            System.out.println("Is 10 positive? " + isPositive.test(10));
            printInt.accept(42);
            String strResult = intToString.apply(123);
            System.out.println("Int to String: " + strResult);
            
            double doubleResult = doubleSquare.applyAsDouble(2.5);
            System.out.println("Square of 2.5: " + doubleResult);
            
            System.out.println("All imports demonstrated successfully in Linear Search Frequency!");
            
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                // Clear the invalid input

                scanner.next(); // consume the invalid token
            }
        }
    }

    public static void main(String[] args) {
        demonstrateAllImports();
        
        try (Scanner scanner = new Scanner(System.in);
             Formatter formatter = new Formatter(System.out)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            List<Integer> array = new ArrayList<>();
            System.out.println(MessageFormat.format("Array size: {0}", n));
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            
            // Input array elements
            // formatter already declared in try-with-resources
            //Replace the formatter.format() call with MessageFormat.format()
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array.add(readInt(scanner, String.format("Element %d: ", i)));
            }

            // Input target element
            int target = readInt(scanner, "Enter the element to search for: ");

            // Perform linear search and get frequency
            List<Integer> arrayList = new ArrayList<>();
            for (int num : array) {
                arrayList.add(num);
            }
            int frequency = linearSearchFrequency(arrayList, target);

            // Output result
            if (frequency > 0) {
                System.out.println(MessageFormat.format("Element {0} found {1} time(s) in the array.", target, frequency));
            } else {
                System.out.println(MessageFormat.format("Element {0} not found in the array.", target));
            }

            System.out.println(MessageFormat.format("Array: {0}", arrayList));
            formatter.close();
        }
    }
}
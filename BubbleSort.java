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
import java.util.stream.Collectors;
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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Book;
import java.awt.print.Printable;
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
 * BubbleSort - A program to sort an array using Bubble Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Bubble Sort, and displays the array before and after sorting.
 */
public class BubbleSort implements Printable {

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
            // Use the queue - demonstrate FIFO behavior
            while (!queue.isEmpty()) {
                Integer element = queue.poll();
                System.out.println("Queue element: " + element);
            }
            // Add more elements to queue
            queue.offer(4); queue.offer(5);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));
            // Use the priority queue - demonstrate priority-based behavior
            System.out.println("PriorityQueue elements (priority order):");
            while (!priorityQueue.isEmpty()) {
                Integer element = priorityQueue.poll();
                System.out.print(element + " ");
            }
            System.out.println();
            // Add more elements to priority queue
            priorityQueue.offer(6); priorityQueue.offer(0);
            
            // Set operations
            Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
            // Use the hash set - demonstrate uniqueness and unordered behavior
            System.out.println("HashSet elements (unique, unordered): " + hashSet);
            hashSet.add(4); hashSet.add(1); // Add new element and duplicate
            System.out.println("HashSet after additions: " + hashSet);
            Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
            // Use the linked hash set - demonstrate insertion order
            System.out.println("LinkedHashSet elements (insertion order): " + linkedHashSet);
            linkedHashSet.add(6); linkedHashSet.add(0); // Add new elements
            System.out.println("LinkedHashSet after additions: " + linkedHashSet);
            Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
            // Use the tree set - demonstrate sorted order
            System.out.println("TreeSet elements (sorted): " + treeSet);
            treeSet.add(6); treeSet.add(0); // Add new elements
            System.out.println("TreeSet after additions: " + treeSet);
            // Use the tree set - demonstrate sorted order and uniqueness
            System.out.println("TreeSet elements (sorted, unique): " + treeSet);
            treeSet.add(6); treeSet.add(0); // Add new elements
            System.out.println("TreeSet after additions: " + treeSet);
            Set<java.lang.Thread.State> enumSet = EnumSet.noneOf(java.lang.Thread.State.class);
            // Use the enum set - demonstrate enum values
            System.out.println("EnumSet elements: " + enumSet);
            enumSet.add(java.lang.Thread.State.NEW);
            enumSet.add(java.lang.Thread.State.RUNNABLE);
            System.out.println("EnumSet after additions: " + enumSet);
            
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
                new FileOutputStream("bubble_sort_demo.txt")), true);
            printStream.println("Bubble Sort Demo Output");
            printStream.close();
            
            // Character encoding
            String encodedText = "Bubble Sort Demo";
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
                // Use pageFormat - demonstrate page format properties
                System.out.println("Page orientation: " + pageFormat.getOrientation());
                System.out.println("Page width: " + pageFormat.getWidth());
                System.out.println("Page height: " + pageFormat.getHeight());
                Book book = new Book();
                // Use book - demonstrate Book properties
                System.out.println("Book created with " + book.getNumberOfPages() + " pages");
                book.append(new BubbleSort(), pageFormat);
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
            
            // Stream operations with Collectors
            List<Integer> streamList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
            System.out.println("Even numbers using stream: " + streamList);
            
            // Reduce operation
            int sum = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .reduce(0, Integer::sum);
            System.out.println("Sum of first 5 numbers: " + sum);
            
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
            String sampleText = "Bubble 123 Sort 456 Demo";
            StreamTokenizer tokenizer = new StreamTokenizer(new java.io.StringReader(sampleText));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                System.out.println("Token: " + tokenizer.sval + " (Type: " + tokenizer.ttype + ")");
            }
            
            // Random operations
            Random random = new Random();
            System.out.println("Random int: " + random.nextInt());
            System.out.println("Random double: " + random.nextDouble());
            
            // Demonstrate functional interfaces
            printer.accept("Hello from Bubble Sort!");
            System.out.println("Predicate (isEven 4): " + isEven.test(4));
            System.out.println("Function (length of 'Bubble'): " + stringLength.apply("Bubble"));
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
            
            // Double functional interfaces
            double doubleProduct = doubleMultiply.applyAsDouble(3.5, 2.0);
            System.out.println("3.5 * 2.0 = " + doubleProduct);
            
            System.out.println("Is 2.5 positive? " + isDoublePositive.test(2.5));
            printDouble.accept(3.14159);
            String doubleStr = doubleToString.apply(42.0);
            System.out.println("Double to String: " + doubleStr);
            
            // Long functional interfaces
            long longResult = longSquare.applyAsLong(100L);
            System.out.println("Square of 100L: " + longResult);
            
            System.out.println("Is 50L positive? " + isLongPositive.test(50L));
            printLong.accept(999999999L);
            
            System.out.println("All imports demonstrated successfully in Bubble Sort!");
            
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    /**
     * Main method to execute bubble sort logic.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        demonstrateAllImports();

        Scanner scanner = new Scanner(System.in);

        try {
            // Read array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[size];

            // Read array elements
            System.out.println(MessageFormat.format("Enter {0} array elements:", size));
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Confirm array sorting for user clarity
            System.out.println("Array sorting confirmation:");
            System.out.println(MessageFormat.format("Array elements: {0}", Arrays.toString(arr)));
            System.out.println("Sorting algorithm: Bubble Sort");
            System.out.println("Sorting direction: Ascending");
            System.out.print("Are you sure you want to sort the array? (yes/no): ");
            String confirmation = scanner.next();
            if (!confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Array sorting canceled.");
                return;
            }

            // Print array before sorting
            System.out.print("Array before sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(MessageFormat.format("{0} ", arr[i]));
            }
            System.out.println();

            // Convert array to List for demonstration
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            System.out.println("Array converted to List: " + list);

            // Bubble Sort logic
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            // Convert array to List after sorting
            list = Arrays.stream(arr).boxed().toList();
            System.out.println("Array converted to List after sorting: " + list);

            // Use Iterator to traverse and print the sorted List
            System.out.print("Sorted List traversal using Iterator: ");
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();

            // Print array after sorting
            System.out.print("Array after sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(MessageFormat.format("{0} ", arr[i]));
            }
            System.out.println();

            // Use PrintWriter for file output demonstration
            try (PrintWriter writer = new PrintWriter("bubble_sort_output.txt")) {
                writer.println("Bubble Sort Results:");
                writer.println("Sorted array: " + Arrays.toString(arr));
                writer.println("Array size: " + size);
                writer.println("First element: " + arr[0]);
                writer.println("Last element: " + arr[size-1]);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            
            // Use Comparator for custom sorting demonstration
            List<Integer> comparatorList = new ArrayList<>();
            for (int num : arr) {
                comparatorList.add(num);
            }
            // Sort in reverse order using Comparator
            comparatorList.sort(Comparator.reverseOrder());
            System.out.println("Array sorted in reverse order: " + comparatorList);
            
            // Sort using custom Comparator (by absolute value)
            comparatorList.sort(Comparator.comparingInt(Math::abs));
            System.out.println("Array sorted by absolute value: " + comparatorList);
            
            // Use Formatter to create a final summary
            Formatter formatter = new Formatter();
            formatter.format("Summary: Sorted array of size %d has first element %d and last element %d.", 
                            size, arr[0], arr[size-1]);
            System.out.println(formatter.toString());
            formatter.close();

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: Required input was not found.");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Implements the Printable interface for printing support
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        
        // Set up fonts
        Font titleFont = new Font("Arial", Font.BOLD, 16);
        Font contentFont = new Font("Arial", Font.PLAIN, 12);
        
        int y = 50;
        int lineHeight = 20;
        
        // Print title
        g2d.setFont(titleFont);
        g2d.drawString("Bubble Sort Algorithm Demonstration", 50, y);
        y += lineHeight * 2;
        
        // Print content
        g2d.setFont(contentFont);
        g2d.drawString("This demonstrates the Bubble Sort algorithm with various Java imports.", 50, y);
        y += lineHeight;
        g2d.drawString("Time Complexity: O(n²) - Best for small datasets", 50, y);
        y += lineHeight;
        g2d.drawString("Space Complexity: O(1) - In-place sorting", 50, y);
        y += lineHeight;
        g2d.drawString("Stable: Yes - Maintains relative order of equal elements", 50, y);
        y += lineHeight * 2;
        
        // Print imports used
        g2d.drawString("Key imports demonstrated:", 50, y);
        y += lineHeight;
        String[] imports = {
            "java.util.* (Collections Framework)",
            "java.text.* (Formatting)",
            "java.io.* (I/O Operations)",
            "java.awt.print.* (Printing)",
            "java.util.function.* (Lambda Expressions)"
        };
        
        for (String imp : imports) {
            g2d.drawString("• " + imp, 70, y);
            y += lineHeight;
        }
        
        return Printable.PAGE_EXISTS;
    }
}

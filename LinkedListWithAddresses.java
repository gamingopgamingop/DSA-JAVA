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
 * Node - Represents a node in a custom Singly Linked List.
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * LinkedListWithAddresses - A program to implement a linked list and display elements with their addresses.
 * 
 * This class uses all imports from QuickSortAlgorithm and provides a menu-driven 
 * interface to insert elements and display the list with memory addresses (hash codes).
 */
public class LinkedListWithAddresses {
    private Node head;

    /**
     * Inserts a new node at the end of the linked list.
     * 
     * @param data The integer value to be inserted.
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(MessageFormat.format("Inserted {0} into the linked list.", data));
    }

    /**
     * Displays all nodes in the linked list with their data and memory addresses.
     */
    public void displayWithAddresses() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        System.out.println("\n--- Linked List Elements with Addresses ---");
        Node temp = head;
        while (temp != null) {
            // Using System.identityHashCode to simulate memory address display
            String address = Integer.toHexString(System.identityHashCode(temp));
            System.out.println(MessageFormat.format("Data: {0} | Address: @{1}", temp.data, address));
            temp = temp.next;
        }
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
                new FileOutputStream("linked_list_demo.txt")), true);
            printStream.println("Linked List Demo Output");
            printStream.close();
            
            // Character encoding
            String encodedText = "Linked List Demo";
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
            String sampleText = "Linked 123 List 456 Demo";
            StreamTokenizer tokenizer = new StreamTokenizer(new java.io.StringReader(sampleText));
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                System.out.println("Token: " + tokenizer.sval + " (Type: " + tokenizer.ttype + ")");
            }
            
            // Random operations
            Random random = new Random();
            System.out.println("Random int: " + random.nextInt());
            System.out.println("Random double: " + random.nextDouble());
            
            // Demonstrate functional interfaces
            printer.accept("Hello from Linked List!");
            System.out.println("Predicate (isEven 4): " + isEven.test(4));
            System.out.println("Function (length of 'Linked'): " + stringLength.apply("Linked"));
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
            
            System.out.println("All imports demonstrated successfully in Linked List!");
            
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    /**
     * Main method to execute linked list operations through a menu-driven interface.
     */
    public static void main(String[] args) {
        demonstrateAllImports();
        
        Scanner scanner = new Scanner(System.in);
        LinkedListWithAddresses ll = new LinkedListWithAddresses();

        try {
            int choice;
            do {
                System.out.println("\n--- Linked List Menu ---");
                System.out.println("1. Insert Element");
                System.out.println("2. Display Elements with Addresses");
                System.out.println("3. Demonstrate All Import Utilities");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter data: ");
                        int data = scanner.nextInt();
                        ll.insert(data);
                        break;
                    case 2:
                        ll.displayWithAddresses();
                        break;
                    case 3:
                        demonstrateAllImports();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 4);

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        } finally {
            scanner.close();
        }
    }
}

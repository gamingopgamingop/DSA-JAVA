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
 * StackOperations - A program to implement a stack using java.util.Stack.
 * 
 * This class provides a menu-driven interface to perform core stack operations
 * such as Push, Pop, Peek, and status checks (Empty/Full).
 */
public class StackOperations {
    private Stack<Integer> stack;
    private int capacity;

    /**
     * Constructor to initialize the stack with a specified capacity.
     * 
     * @param size The maximum number of elements the stack can hold.
     */
    public StackOperations(int size) {
        stack = new Stack<>();
        capacity = size;
    }

    /**
     * Pushes an element onto the top of the stack.
     * 
     * @param x The integer to be pushed.
     */
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        stack.push(x);
        System.out.println("Pushed " + x + " to stack.");
    }

    /**
     * Removes and returns the element at the top of the stack.
     * 
     * @return The popped integer, or -1 if the stack is underflow.
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        return stack.pop();
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * 
     * @return The top integer, or -1 if the stack is empty.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack.peek();
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Checks if the stack has reached its maximum capacity.
     * 
     * @return true if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return stack.size() == capacity;
    }

    /**
     * Displays all elements currently in the stack using an Iterator.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        
        System.out.print("Stack elements (via Iterator): ");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    /**
     * Main method to execute stack operations through a menu-driven interface.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Initialize stack capacity
            System.out.print("Enter the capacity of the stack: ");
            int size = scanner.nextInt();
            StackOperations stackOp = new StackOperations(size);

            int choice;
            // Menu-driven loop for stack operations
            do {
                System.out.println("\n--- Stack Operations Menu ---");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Check if Empty");
                System.out.println("5. Check if Full");
                System.out.println("6. Display Stack");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Perform Push operation
                        System.out.print("Enter element to push: ");
                        int val = scanner.nextInt();
                        stackOp.push(val);
                        break;
                    case 2:
                        // Perform Pop operation
                        int popped = stackOp.pop();
                        if (popped != -1) {
                            System.out.println(MessageFormat.format("Popped element: {0}", popped));
                        }
                        break;
                    case 3:
                        // Perform Peek operation
                        int peeked = stackOp.peek();
                        if (peeked != -1) {
                            System.out.println(MessageFormat.format("Top element: {0}", peeked));
                        }
                        break;
                    case 4:
                        // Check if Empty
                        System.out.println(MessageFormat.format("Stack is empty: {0}", stackOp.isEmpty()));
                        break;
                    case 5: 
                        // Check if Full
                        System.out.println(MessageFormat.format("Stack is full: {0}", stackOp.isFull()));
                        break;
                    case 6:
                        // Display all elements
                        stackOp.display();
                        break;
                    case 7:
                        // Exit the program
                        Formatter formatter = new Formatter();
                        formatter.format("Exiting stack operations for stack of capacity %d.", size);
                        System.out.println(formatter.toString());
                        formatter.close();
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 7);

        } catch (InputMismatchException e) {
            // Handle non-integer inputs
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            // Handle missing input
            System.err.println("Error: No input provided.");
        } finally {
            // Ensure scanner is closed
            scanner.close();
        }
    }
}
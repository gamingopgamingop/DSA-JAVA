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
 * LinearQueue - A program to implement a linear queue using an array.
 * 
 * This class provides a menu-driven interface to perform core queue operations
 * such as Enqueue, Dequeue, Peek, and status checks (Empty/Full).
 */
public class LinearQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Constructor to initialize the linear queue with a specified capacity.
     * 
     * @param size The maximum number of elements the queue can hold.
     */
    public LinearQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = -1;
        rear = -1;
    }

    /**
     * Inserts an element into the rear of the queue.
     * 
     * @param item The integer to be inserted.
     */
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + item);
            return;
        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = item;
        System.out.println(MessageFormat.format("Inserted {0} into the queue.", item));
    }

    /**
     * Removes and returns the element from the front of the queue.
     * 
     * @return The dequeued integer, or -1 if the queue is empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot delete.");
            return -1;
        }
        int item = queue[front];
        if (front >= rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return item;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return The front integer, or -1 if the queue is empty.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the queue has reached its maximum capacity.
     * 
     * @return true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return rear == capacity - 1;
    }

    /**
     * Displays all elements currently in the linear queue.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main method to execute linear queue operations through a menu-driven interface.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the capacity of the linear queue: ");
            int size = sc.nextInt();
            LinearQueue lq = new LinearQueue(size);

            int choice;
            do {
                System.out.println("\n--- Linear Queue Operations ---");
                System.out.println("1. Enqueue (Insert)");
                System.out.println("2. Dequeue (Delete)");
                System.out.println("3. Peek (Front)");
                System.out.println("4. Check Empty");
                System.out.println("5. Check Full");
                System.out.println("6. Display Queue");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter element: ");
                        int item = sc.nextInt();
                        lq.enqueue(item);
                        break;
                    case 2:
                        int deleted = lq.dequeue();
                        if (deleted != -1) {
                            System.out.println("Deleted element: " + deleted);
                        }
                        break;
                    case 3:
                        int frontItem = lq.peek();
                        if (frontItem != -1) {
                            System.out.println("Front element: " + frontItem);
                        }
                        break;
                    case 4:
                        System.out.println("Is Empty: " + lq.isEmpty());
                        break;
                    case 5:
                        System.out.println("Is Full: " + lq.isFull());
                        break;
                    case 6:
                        lq.display();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 7);
        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        }
    }
}

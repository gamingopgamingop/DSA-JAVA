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
 * DequeOperations - A program to implement a Double Ended Queue (Deque) using an array.
 * 
 * This class provides a menu-driven interface to perform core deque operations
 * such as InsertFront, InsertRear, DeleteFront, DeleteRear, and Display.
 */
public class DequeOperations {
    private int[] deque;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Constructor to initialize the deque with a specified capacity.
     * 
     * @param size The maximum number of elements the deque can hold.
     */
    public DequeOperations(int size) {
        deque = new int[size];
        capacity = size;
        front = -1;
        rear = -1;
    }
    
    /**
     * Gets the capacity of the deque.
     * 
     * @return The maximum number of elements the deque can hold.
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Gets the capacity of the deque (alias for getCapacity()).
     * 
     * @return The maximum number of elements the deque can hold.
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Inserts an element at the front of the deque.
     * 
     * @param item The integer to be inserted.
     */
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Deque Overflow! Cannot insert at front.");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        deque[front] = item;
        System.out.println(MessageFormat.format("Inserted {0} at front.", item));
    }

    /**
     * Inserts an element at the rear of the deque.
     * 
     * @param item The integer to be inserted.
     */
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Deque Overflow! Cannot insert at rear.");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        deque[rear] = item;
        System.out.println(MessageFormat.format("Inserted {0} at rear.", item));
    }

    /**
     * Deletes an element from the front of the deque.
     * 
     * @return The deleted integer, or -1 if empty.
     */
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque Underflow! Cannot delete from front.");
            return -1;
        }
        int item = deque[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        return item;
    }

    /**
     * Deletes an element from the rear of the deque.
     * 
     * @return The deleted integer, or -1 if empty.
     */
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque Underflow! Cannot delete from rear.");
            return -1;
        }
        int item = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        return item;
    }

    /**
     * Checks if the deque is empty.
     * 
     * @return true if empty.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the deque is full.
     * 
     * @return true if full.
     */
    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || (front == rear + 1);
    }

    /**
     * Displays all elements in the deque.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque elements: ");
        int i = front;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    /**
     * Main method to execute deque operations.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter capacity: ");
            int size = sc.nextInt();
            DequeOperations dq = new DequeOperations(size);

            int choice;
            do {
                System.out.println("\n--- Deque Operations ---");
                System.out.println("1. Insert Front  2. Insert Rear");
                System.out.println("3. Delete Front  4. Delete Rear");
                System.out.println("5. Display       6. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Item: ");
                        dq.insertFront(sc.nextInt());
                        break;
                    case 2:
                        System.out.print("Item: ");
                        dq.insertRear(sc.nextInt());
                        break;
                    case 3:
                        int df = dq.deleteFront();
                        if (df != -1) System.out.println("Deleted: " + df);
                        break;
                    case 4:
                        int dr = dq.deleteRear();
                        if (dr != -1) System.out.println("Deleted: " + dr);
                        break;
                    case 5:
                        dq.display();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                }
            } while (choice != 6);
        } catch (Exception e) {
            System.err.println("Error occurred.");
        }
    }
}

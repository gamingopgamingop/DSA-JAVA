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
 * Node - Represents a node in the custom Singly Linked List.
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
 * SinglyLinkedListOperations - A program to implement insertion and deletion 
 * operations in a Singly Linked List via a menu-driven interface.
 */
public class SinglyLinkedListOperations {
    private Node head;

    /**
     * Inserts a new element at the beginning of the linked list.
     * 
     * @param data The integer value to be inserted.
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println(MessageFormat.format("Inserted {0} at the beginning.", data));
    }

    /**
     * Inserts a new element at a given position in the linked list.
     * 
     * @param data The integer value to be inserted.
     * @param position The position (1-based) where the element should be inserted.
     */
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println(MessageFormat.format("Inserted {0} at position {1}.", data, position));
        }
    }

    /**
     * Deletes the element from the beginning of the linked list.
     */
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        System.out.println(MessageFormat.format("Deleted {0} from the beginning.", head.data));
        head = head.next;
    }

    /**
     * Deletes the element from the end of the linked list.
     */
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.next == null) {
            System.out.println(MessageFormat.format("Deleted {0} from the end.", head.data));
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(MessageFormat.format("Deleted {0} from the end.", temp.next.data));
        temp.next = null;
    }

    /**
     * Deletes an element from a specific position in the linked list.
     * 
     * @param position The position (1-based) of the element to be deleted.
     */
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds!");
        } else {
            System.out.println(MessageFormat.format("Deleted {0} from position {1}.", temp.next.data, position));
            temp.next = temp.next.next;
        }
    }

    /**
     * Displays all elements in the linked list.
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /**
     * Main method to interact with the user via a menu-driven interface.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedListOperations list = new SinglyLinkedListOperations();

        try {
            int choice;
            do {
                System.out.println("\n--- Singly Linked List Operations ---");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at Position");
                System.out.println("3. Delete from Beginning");
                System.out.println("4. Delete from End");
                System.out.println("5. Delete at Position");
                System.out.println("6. Display List");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value: ");
                        list.insertAtBeginning(scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter value: ");
                        int val = scanner.nextInt();
                        System.out.print("Enter position: ");
                        int pos = scanner.nextInt();
                        list.insertAtPosition(val, pos);
                        break;
                    case 3:
                        list.deleteFromBeginning();
                        break;
                    case 4:
                        list.deleteFromEnd();
                        break;
                    case 5:
                        System.out.print("Enter position to delete: ");
                        list.deleteAtPosition(scanner.nextInt());
                        break;
                    case 6:
                        list.display();
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
        } finally {
            scanner.close();
        }   
    }
}

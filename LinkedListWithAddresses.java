import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

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
     * Demonstrates the usage of all required imports.
     */
    private void demonstrateImports() {
        // Formatter demonstration
        Formatter formatter = new Formatter();
        formatter.format("LinkedListWithAddresses utility is active.");
        System.out.println(formatter.toString());
        formatter.close();

        // Stack demonstration (tracking node data for reversal)
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        int count = 0;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
            count++;
        }
        
        // Arrays demonstration: Create an array from the stack data
        Integer[] dataArray = new Integer[count];
        for (int i = 0; i < count; i++) {
            dataArray[i] = stack.get(i);
        }
        System.out.println("Data array created via Arrays utility: " + Arrays.toString(dataArray));

        // List and Iterator demonstration
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        System.out.print("Elements in reverse order (via List/Iterator/Stack): ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    /**
     * Main method to execute linked list operations through a menu-driven interface.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListWithAddresses ll = new LinkedListWithAddresses();

        try {
            int choice;
            do {
                System.out.println("\n--- Linked List Menu ---");
                System.out.println("1. Insert Element");
                System.out.println("2. Display Elements with Addresses");
                System.out.println("3. Demonstrate Import Utilities (Stack/List/Iterator/Formatter)");
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
                        ll.demonstrateImports();
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

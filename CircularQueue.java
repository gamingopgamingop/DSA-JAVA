import java.util.*;
import java.text.MessageFormat;

/**
 * CircularQueue - A program to implement a circular queue using an array.
 * 
 * This class provides a menu-driven interface to perform core circular queue operations
 * such as Enqueue, Dequeue, Peek, and status checks (Empty/Full).
 */
public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    /**
     * Constructor to initialize the circular queue with a specified capacity.
     * 
     * @param size The maximum number of elements the queue can hold.
     */
    public CircularQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = -1;
        rear = -1;
    }

    /**
     * Inserts an element into the circular queue.
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
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        System.out.println(MessageFormat.format("Inserted {0} into the circular queue.", item));
    }

    /**
     * Removes and returns the element from the front of the circular queue.
     * 
     * @return The dequeued integer, or -1 if the queue is empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot delete.");
            return -1;
        }
        int item = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return item;
    }

    /**
     * Returns the element at the front of the circular queue without removing it.
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
     * Checks if the circular queue is empty.
     * 
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the circular queue has reached its maximum capacity.
     * 
     * @return true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    /**
     * Displays all elements currently in the circular queue.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    /**
     * Main method to execute circular queue operations through a menu-driven interface.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the capacity of the circular queue: ");
            int size = sc.nextInt();
            CircularQueue cq = new CircularQueue(size);

            int choice;
            do {
                System.out.println("\n--- Circular Queue Operations ---");
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
                        cq.enqueue(item);
                        break;
                    case 2:
                        int deleted = cq.dequeue();
                        if (deleted != -1) {
                            System.out.println("Deleted element: " + deleted);
                        }
                        break;
                    case 3:
                        int frontItem = cq.peek();
                        if (frontItem != -1) {
                            System.out.println("Front element: " + frontItem);
                        }
                        break;
                    case 4:
                        System.out.println("Is Empty: " + cq.isEmpty());
                        break;
                    case 5:
                        System.out.println("Is Full: " + cq.isFull());
                        break;
                    case 6:
                        cq.display();
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

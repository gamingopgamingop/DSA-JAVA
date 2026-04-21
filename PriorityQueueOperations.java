import java.util.*;
import java.text.MessageFormat;

/**
 * PriorityQueueOperations - A program to implement a Priority Queue using java.util.PriorityQueue.
 * 
 * This class provides a menu-driven interface to perform core priority queue operations
 * such as Insert (Offer), Delete (Poll), Peek, and Display.
 */
public class PriorityQueueOperations {
    private PriorityQueue<Integer> pq;

    /**
     * Constructor to initialize the priority queue.
     */
    public PriorityQueueOperations() {
        pq = new PriorityQueue<>();
    }

    /**
     * Inserts an element into the priority queue.
     * 
     * @param item The integer to be inserted.
     */
    public void insert(int item) {
        pq.offer(item);
        System.out.println(MessageFormat.format("Inserted {0} into the priority queue.", item));
    }

    /**
     * Removes and returns the highest priority element from the queue.
     * 
     * @return The dequeued integer, or -1 if the queue is empty.
     */
    public int delete() {
        if (isEmpty()) {
            System.out.println("Priority Queue Underflow! Cannot delete.");
            return -1;
        }
        return pq.poll();
    }

    /**
     * Returns the highest priority element without removing it.
     * 
     * @return The front integer, or -1 if the queue is empty.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        return pq.peek();
    }

    /**
     * Checks if the priority queue is empty.
     * 
     * @return true if empty.
     */
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    /**
     * Displays all elements in the priority queue.
     * Note: PriorityQueue does not guarantee insertion order traversal.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.print("Priority Queue elements (Internal Array Order): ");
        System.out.println(pq);
    }

    /**
     * Main method to execute priority queue operations through a menu-driven interface.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PriorityQueueOperations pqOps = new PriorityQueueOperations();

            int choice;
            do {
                System.out.println("\n--- Priority Queue Operations ---");
                System.out.println("1. Insert (Offer)");
                System.out.println("2. Delete (Poll)");
                System.out.println("3. Peek (Front)");
                System.out.println("4. Display Queue");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter element: ");
                        int item = sc.nextInt();
                        pqOps.insert(item);
                        break;
                    case 2:
                        int deleted = pqOps.delete();
                        if (deleted != -1) {
                            System.out.println("Deleted (Highest Priority): " + deleted);
                        }
                        break;
                    case 3:
                        int frontItem = pqOps.peek();
                        if (frontItem != -1) {
                            System.out.println("Front (Highest Priority): " + frontItem);
                        }
                        break;
                    case 4:
                        pqOps.display();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        }
    }
}

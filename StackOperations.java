import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;

public class StackOperations {
    private Stack<Integer> stack;
    private int capacity;

    public StackOperations(int size) {
        stack = new Stack<>();
        capacity = size;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        stack.push(x);
        System.out.println("Pushed " + x + " to stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        return stack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == capacity;
    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the capacity of the stack: ");
            int size = scanner.nextInt();
            StackOperations stackOp = new StackOperations(size);

            int choice;
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
                        System.out.print("Enter element to push: ");
                        int val = scanner.nextInt();
                        stackOp.push(val);
                        break;
                    case 2:
                        int popped = stackOp.pop();
                        if (popped != -1) {
                            System.out.println(MessageFormat.format("Popped element: {0}", popped));
                        }
                        break;
                    case 3:
                        int peeked = stackOp.peek();
                        if (peeked != -1) {
                            System.out.println(MessageFormat.format("Top element: {0}", peeked));
                        }
                        break;
                    case 4:
                        System.out.println(MessageFormat.format("Stack is empty: {0}", stackOp.isEmpty()));
                        break;
                    case 5: 
                        System.out.println(MessageFormat.format("Stack is full: {0}", stackOp.isFull()));
                        break;
                    case 6:
                        stackOp.display();
                        break;
                    case 7:
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
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        } finally {
            scanner.close();
        }
    }
}
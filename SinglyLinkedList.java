import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList implements Iterable<Integer> {

    Node start = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = start;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                if (current == null) {
                    throw new NoSuchElementException("End of list reached");
                }
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Convert list to array using java.util.Arrays (indirectly by returning a sorted copy or just creating it)
    public int[] toArray() {
        int size = 0;
        Node temp = start;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] result = new int[size];
        temp = start;
        for (int i = 0; i < size; i++) {
            result[i] = temp.data;
            temp = temp.next;
        }
        return result;
    }

    // Insert at start
    void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = start;
        start = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (start == null) {
            start = newNode;
            return;
        }

        Node temp = start;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Insert at position
    void insertAtPosition(int data, int pos) {

        if (pos == 1) {
            insertAtStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = start;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at start
    void deleteAtStart() {

        if (start == null) {
            System.out.println("List empty");
            return;
        }

        start = start.next;
    }

    // Delete at end
    void deleteAtEnd() {

        if (start == null) {
            System.out.println("List empty");
            return;
        }

        if (start.next == null) {
            start = null;
            return;
        }

        Node temp = start;

        while (temp.next.next != null)
            temp = temp.next;

        temp.next = null;
    }

    // Delete by item
    void deleteByItem(int item) {

        if (start == null) {
            System.out.println("List empty");
            return;
        }

        if (start.data == item) {
            start = start.next;
            return;
        }

        Node q = start;
        Node p = start.next;

        while (p != null) {
            if (p.data == item) {
                q.next = p.next;
                return;
            }
            q = p;
            p = p.next;
        }

        System.out.println("Item not found");
    }

    // Delete by position
    void deleteByPosition(int pos) {

        if (start == null) {
            System.out.println("List empty");
            return;
        }

        if (pos == 1) {
            start = start.next;
            return;
        }

        Node temp = start;

        for (int i = 1; i < pos - 1 && temp.next != null; i++)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    // Display list
    void display() {

        if (start == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = start;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Clear list
    void clear() {
        start = null;
        System.out.println("List cleared");
    }

    // Search element
    boolean search(int value) {

        Node temp = start;
        int pos = 1;

        while (temp != null) {

            if (temp.data == value) {
                System.out.println("Found at position " + pos);
                return true;
            }  

            temp = temp.next;
            pos++;
        }

        System.out.println("Value not found");
        return false;
    }

    // Traverse list using Iterator and Formatter
    void traverse() {
        if (start == null) {
            System.out.println("List empty");
            return;
        }
        
        System.out.print("Traversing: ");
        Iterator<Integer> it = this.iterator();
        Formatter fmt = new Formatter();
        while (it.hasNext()) {
            fmt.format("[%d] -> ", it.next());
        }
        System.out.println(fmt.toString() + "null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int choice, value, pos;

        while (true) {
            try {
                System.out.println("\n---- Linked List Menu ----");
                System.out.println("1 Insert at Start");
                System.out.println("2 Insert at End");
                System.out.println("3 Insert at Position");
                System.out.println("4 Delete at Start");
                System.out.println("5 Delete at End");
                System.out.println("6 Delete by Item");
                System.out.println("7 Delete by Position");
                System.out.println("8 Display");
                System.out.println("9 Search");
                System.out.println("10 Traverse (using Iterator)");
                System.out.println("11 Clear");
                System.out.println("12 Show as Array");
                System.out.println("13 Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter value: ");
                        value = sc.nextInt();
                        list.insertAtStart(value);
                        break;

                    case 2:
                        System.out.print("Enter value: ");
                        value = sc.nextInt();
                        list.insertAtEnd(value);
                        break;

                    case 3:
                        System.out.print("Enter position: ");
                        pos = sc.nextInt();
                        System.out.print("Enter value: ");
                        value = sc.nextInt();
                        list.insertAtPosition(value, pos);
                        break;

                    case 4:
                        list.deleteAtStart();
                        break;

                    case 5:
                        list.deleteAtEnd();
                        break;

                    case 6:
                        System.out.print("Enter item to delete: ");
                        value = sc.nextInt();
                        list.deleteByItem(value);
                        break;

                    case 7:
                        System.out.print("Enter position: ");
                        pos = sc.nextInt();
                        list.deleteByPosition(pos);
                        break;

                    case 8:
                        list.display();
                        break;

                    case 9:
                        System.out.print("Enter value to search: ");
                        value = sc.nextInt();
                        if (list.search(value)) {
                            // Using MessageFormat
                            System.out.println(MessageFormat.format("The value {0} is present in the list.", value));
                        } else {
                            System.out.println(MessageFormat.format("The value {0} is NOT present.", value));
                        }
                        break;

                    case 10:
                        list.traverse();
                        break;

                    case 11:
                        list.clear();
                        break;

                    case 12:
                        // Using Arrays
                        int[] arr = list.toArray();
                        System.out.println("List as Array: " + Arrays.toString(arr));
                        break;

                    case 13:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                sc.nextLine(); // Clear buffer
            } catch (NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

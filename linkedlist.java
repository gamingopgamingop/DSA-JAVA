import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node start = null;

    // Function to add a node at the end
    void insert(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Function to delete a node by its item (value)
    void deleteByItem(int item) {
        if (start == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: Item is at the start
        if (start.data == item) {
            start = start.next;
            return;
        }

        // Case 2: Search for the item
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
        System.out.println("Item " + item + " not found in the list.");
    }

    // Function to delete a node by its position (1-based index)
    void deleteByPosition(int position) {
        if (start == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: Position is 1
        if (position == 1) {
            start = start.next;
            return;
        }

        // Case 2: Traverse to the position
        Node q = start;
        Node p = start.next;
        int count = 2; // Since p is at position 2
        
        while (p != null) {
            if (count == position) {
                q.next = p.next;
                return;
            }
            q = p;
            p = p.next;
            count++;
        }
        System.out.println("Position " + position + " is out of bounds.");
    }

    // Function to display the list
    void display() {
        if (start == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = start;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // Function to clear the list
    void clear() {
        start = null;
        System.out.println("List cleared.");
    }
    // Function to search for a value in the list
    boolean search(int value) {
        if (start == null) {
            System.out.println("List is empty.");
            return false;
        }
        Node temp = start;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value " + value + " found in the list.");
                return true;
            }
            temp = temp.next;
        }
        System.out.println("Value " + value + " not found in the list.");
        return false;
       }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, value, pos;

        while (true) {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete by Item");
            System.out.println("3. Delete by Position");
            System.out.println("4. Display");
            System.out.println("6. Clear");
            System.out.println("7. Search");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    list.deleteByItem(value);
                    break;
                case 3:
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();
                    list.deleteByPosition(pos);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                case 6:
                    list.clear();
                    System.out.println("List cleared.");
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    if (list.search(value)) {
                        System.out.println("Value " + value + " found in the list.");
                    } else {
                        System.out.println("Value " + value + " not found in the list.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

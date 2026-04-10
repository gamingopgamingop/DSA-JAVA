public class TestLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("Inserting 10, 20, 30, 40...");
        list.insertAtStart(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.display(); // Expected: 10 -> 20 -> 30 -> 40 -> null

        System.out.println("Deleting by position 2 (value 20)...");
        list.deleteByPosition(2);
        list.display(); // Expected: 10 -> 30 -> 40 -> null

        System.out.println("Deleting by item 30...");
        list.deleteByItem(30);
        list.display(); // Expected: 10 -> 40 -> null

        System.out.println("Deleting by position 1 (value 10)...");
        list.deleteByPosition(1);
        list.display(); // Expected: 40 -> null

        System.out.println("Deleting by position 1 (value 40)...");
        list.deleteByPosition(1);
        list.display(); // Expected: List is empty.
    }
}

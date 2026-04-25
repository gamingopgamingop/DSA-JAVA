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
import java.util.Collections;
/**
 * SelectionSort - A program to sort an array using Selection Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Selection Sort, and displays the array before and after sorting.
 */
public class SelectionSort {

    /**
     * Main method to execute selection sort logic.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // List implementations
        List<Integer> numberList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Vector<Integer> numberVector = new Vector<>();
        
        // Queue implementations
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> arrayDeque = new ArrayDeque<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        // Set implementations
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        
        // Map implementations
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> hashtable = new Hashtable<>();
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        
        Stack<Integer> sortStack = new Stack<>();
        Formatter formatter = new Formatter();

        try {
            // Read array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();

            int[] arr = new int[size];

            // Read array elements
            System.out.println(MessageFormat.format("Enter {0} array elements:", size));
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
                int value = arr[i];
                String label = "Num_" + value;
                
                // Add to Lists
                numberList.add(value);
                linkedList.add(value);
                numberVector.add(value);
                
                // Add to Queues
                queue.offer(value);
                arrayDeque.offer(value);
                priorityQueue.offer(value);
                
                // Add to Sets
                hashSet.add(value);
                linkedHashSet.add(value);
                treeSet.add(value);
                
                // Add to Maps
                hashMap.put(value, label);
                linkedHashMap.put(value, label);
                treeMap.put(value, label);
                hashtable.put(value, label);
                sortedMap.put(value, label);
                navigableMap.put(value, label);
            }

            // Print array before sorting using Iterator
            System.out.println("Array before sorting: " + Arrays.toString(arr));
            System.out.print("Elements using Iterator: ");
            for (Integer num : numberList) {
                System.out.print(num + " ");
            }
            System.out.println();
            
            // Display Vector elements
            System.out.print("Elements in Vector: ");
            for (Integer num : numberVector) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("Vector size: " + numberVector.size() + ", Capacity: " + numberVector.capacity());
            
            // Display LinkedList elements
            System.out.print("Elements in LinkedList: ");
            for (Integer num : linkedList) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("LinkedList first: " + numberLinkedList.getFirst() + ", last: " + numberLinkedList.getLast());
            
            // Display HashSet elements (no duplicates, unordered)
            System.out.print("Elements in HashSet: ");
            for (Integer num : numberHashSet) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("HashSet size (unique elements): " + numberHashSet.size());
            
            // Display TreeSet elements (sorted, no duplicates)
            System.out.print("Elements in TreeSet (auto-sorted): ");
            for (Integer num : numberTreeSet) {
                System.out.print(num + " ");
            }
            System.out.println();
            
            // Display HashMap elements
            System.out.println("HashMap entries:");
            for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
                System.out.println("  Key: " + entry.getKey() + " -> Value: " + entry.getValue());
            }

            // Use Formatter for formatted output
            formatter.format("Total elements to sort: %d%n", size);
            System.out.println(formatter.toString());
            formatter.close();

            // Selection Sort logic
            for (int i = 0; i < size - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                // Swap smallest element with first unsorted position
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                
                // Push sorted elements to stack
                sortStack.push(arr[i]);
            }
            // Push the last element
            if (size > 0) {
                sortStack.push(arr[size - 1]);
            }

            // Print array after sorting
            System.out.println("Array after sorting: " + Arrays.toString(arr));
            
            // Demonstrate Stack usage
            System.out.print("Elements from stack (LIFO): ");
            while (!sortStack.isEmpty()) {
                try {
                    System.out.print(sortStack.pop() + " ");
                } catch (NoSuchElementException e) {
                    System.out.println("\nStack is empty!");
                }
            }
            System.out.println();

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integer values only.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input found.");
        } finally {
            scanner.close();
        }
    }
}

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
        List<Integer> numberList = new ArrayList<>();
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
                numberList.add(arr[i]);
            }

            // Print array before sorting using Iterator
            System.out.println("Array before sorting: " + Arrays.toString(arr));
            System.out.print("Elements using Iterator: ");
            Iterator<Integer> iterator = numberList.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();

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

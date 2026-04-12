import java.util.Scanner;
import java.text.MessageFormat; 
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Arrays;

/**
 * BubbleSort - A program to sort an array using Bubble Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Bubble Sort, and displays the array before and after sorting.
 */
public class BubbleSort {

    /**
     * Main method to execute bubble sort logic.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Read array size
            System.out.print("Enter the number of elements: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[size];

            // Read array elements
            System.out.println(MessageFormat.format("Enter {0} array elements:", size));
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            // Confirm array sorting for user clarity
            System.out.println("Array sorting confirmation:");
            System.out.println(MessageFormat.format("Array elements: {0}", Arrays.toString(arr)));
            System.out.println("Sorting algorithm: Bubble Sort");
            System.out.println("Sorting direction: Ascending");
            System.out.print("Are you sure you want to sort the array? (yes/no): ");
            String confirmation = scanner.next();
            if (!confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Array sorting canceled.");
                return;
            }

            // Print array before sorting
            System.out.print("Array before sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(MessageFormat.format("{0} ", arr[i]));
            }
            System.out.println();

            // Convert array to List for demonstration
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            System.out.println("Array converted to List: " + list);

            // Bubble Sort logic
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            // Convert array to List after sorting
            list = Arrays.stream(arr).boxed().toList();
            System.out.println("Array converted to List after sorting: " + list);

            // Use Iterator to traverse and print the sorted List
            System.out.print("Sorted List traversal using Iterator: ");
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();

            // Print array after sorting
            System.out.print("Array after sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(MessageFormat.format("{0} ", arr[i]));
            }
            System.out.println();

            // Use Formatter to create a final summary
            Formatter formatter = new Formatter();
            formatter.format("Summary: Sorted array of size %d has first element %d and last element %d.", 
                            size, arr[0], arr[size-1]);
            System.out.println(formatter.toString());
            formatter.close();

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: Required input was not found.");
        } finally {
            scanner.close();
        }
    }
}

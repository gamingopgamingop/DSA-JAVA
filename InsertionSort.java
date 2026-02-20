import java.util.Scanner;
import java.text.MessageFormat;

/**
 * InsertionSort - A program to sort an array using Insertion Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Insertion Sort, and displays the array before and after sorting.
 */
public class InsertionSort {

    /**
     * Main method to execute insertion sort logic.
     *
     * @param args Command line arguments (not used).
     */
    public static void insertionSort(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read array size
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Read array elements
        System.out.println(MessageFormat.format("Enter {0} array elements:", size));
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Print array before sorting
        System.out.print("Array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();

        // Insertion Sort logic
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        // Print array after sorting
        System.out.print("Array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }

        scanner.close();
    }
}

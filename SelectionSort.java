import java.util.Scanner;
import java.text.MessageFormat;

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
        }

        // Print array after sorting
        System.out.print("Array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }

        scanner.close();
    }
}

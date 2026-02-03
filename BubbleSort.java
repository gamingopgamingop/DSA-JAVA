import java.util.Scanner;
import java.text.MessageFormat;

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

        // Print array after sorting
        System.out.print("Array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;

/**
 * QuickSort - Implements the Quick Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Quick Sort algorithm, and then prints the sorted array.
 */
public class QuickSort {

    /**
     * Reads an integer from the console with input validation.
     *
     * @param scanner The Scanner object to read input from.
     * @param prompt The message to display to the user.
     * @return The integer entered by the user.
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            }
        }
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Partitions the array into two sub-arrays around a pivot element.
     * Elements smaller than the pivot are moved to its left, and larger elements to its right.
     *
     * @param arr The array to be partitioned.
     * @param low The starting index of the subarray.
     * @param high The ending index of the subarray.
     * @return The partitioning index.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(MessageFormat.format("Array size: {0}", n));
            
            // Input array elements
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, MessageFormat.format("Element {0}: ", i));
            }

            System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

            quickSort(array, 0, array.length - 1);

            System.out.println(MessageFormat.format("Sorted Array: {0}", Arrays.toString(array)));
        }
    }
}

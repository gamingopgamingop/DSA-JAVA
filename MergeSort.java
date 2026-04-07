import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;

/**
 * MergeSort - Implements the Merge Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Merge Sort algorithm, and then prints the sorted array.
 */
public class MergeSort {

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
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param left The starting index of the subarray.
     * @param right The ending index of the subarray.
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[left..mid]
     * Second subarray is arr[mid+1..right]
     *
     * @param arr The array containing the subarrays.
     * @param left The starting index of the first subarray.
     * @param mid The middle index.
     * @param right The ending index of the second subarray.
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
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

            mergeSort(array, 0, array.length - 1);

            System.out.println(MessageFormat.format("Sorted Array: {0}", Arrays.toString(array)));
        }
    }
}

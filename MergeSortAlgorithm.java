import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;

/**
 * MergeSortAlgorithm - Implements the Merge Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Merge Sort algorithm, and then prints the sorted array.
 */
public class MergeSortAlgorithm implements Runnable {

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
            } catch (NoSuchElementException e) {
                System.err.println("Error: Required input was not found.");
                System.exit(1);
            }
        }
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param arr The array to be sorted.
     * @param left The starting index of the subarray.
     * @param right The ending index of the subarray.
     * @param recursionStack A stack to track recursion depth (for demonstration).
     */
    public static void mergeSort(int[] arr, int left, int right, Stack<Integer> recursionStack) {
        if (left < right) {
            recursionStack.push(left); // Track recursion depth for demonstration
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, recursionStack);
            mergeSort(arr, mid + 1, right, recursionStack);
            merge(arr, left, mid, right);
            recursionStack.pop();
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
    @Override
    public void run() {
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

                Stack<Integer> recursionStack = new Stack<>();
            mergeSort(array, 0, array.length - 1, recursionStack);

            // Using List and Iterator for demonstration of imports
            List<Integer> sortedList = new java.util.ArrayList<>();
            for (int val : array) sortedList.add(val);
            
            System.out.print("Sorted Array (via Iterator): ");
            Iterator<Integer> it = sortedList.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();

            // Using Formatter for final summary
            Formatter formatter = new Formatter();
            formatter.format("Summary: Merge Sort completed on %d elements. Sorted Array: %s", 
                            n, Arrays.toString(array));
            System.out.println(formatter.toString());
            formatter.close();
        }
    }

    public static void main(String[] args) {
        new MergeSortAlgorithm().run();
    }
}

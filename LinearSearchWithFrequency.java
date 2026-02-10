import java.util.Scanner;
import java.text.MessageFormat;
// import java.util.InputMismatchException;

/**
 * LinearSearchWithFrequency - Performs linear search and counts occurrences.
 * 
 * This class allows the user to input an array and a target element.
 * It searches for the target in the array and reports how many times it appears.
 */
public class LinearSearchWithFrequency {
    /**
     * Performs linear search to count occurrences of a target element in an array.
     * 
     * @param arr   The array to search in.
     * @param target The element to search for.
     * @return The frequency of the target element in the array.
     */
    public static int linearSearchFrequency(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume the invalid token
        }
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input array elements
        System.out.println(MessageFormat.format("Enter {0} elements:", n));
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // consume the invalid token
            }
            array[i] = scanner.nextInt();
        }

        // Input target element
        System.out.print("Enter the element to search for: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume the invalid token
        }
        int target = scanner.nextInt();

        // Perform linear search and get frequency
        int frequency = linearSearchFrequency(array, target);

        // Output result
        if (frequency > 0) {
            System.out.println(MessageFormat.format("Element {0} found {1} time(s) in the array.", target, frequency));
        } else {
            System.out.println(MessageFormat.format("Element {0} not found in the array.", target));
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Formatter;
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
        try (Formatter formatter = new Formatter()) {

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
            System.out.print(MessageFormat.format("Element {0}: ", i));
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
            formatter.format("Element %d found %d time(s) in the array.%n", target, frequency);
        } else {
            formatter.format("Element %d not found in the array.%n", target);
        }

        scanner.close();
    }
}
}
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

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Formatter formatter = new Formatter(System.out)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(formatter.format("Array size: %d%n", n));

            // Input array elements
            // formatter already declared in try-with-resources
            formatter.format("Enter %d elements:%n", n)                                 ;
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, String.format("Element %d: ", i));
            }

            // Input target element
            int target = readInt(scanner, "Enter the element to search for: ");

            // Perform linear search and get frequency
            int frequency = linearSearchFrequency(array, target);

            // Output result
            if (frequency > 0) {
                System.out.println(formatter.format("Element %d found %d time(s) in the array.%n", target, frequency));
            } else {
                System.out.println(formatter.format("Element %d not found in the array.%n", target));
            }

            System.out.println(formatter.format("Array: %s%n", Arrays.toString(array)));
        }
    }
}
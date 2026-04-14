import java.util.*;
import java.text.*;

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

    public static int linearSearchFrequency(List<Integer> arr, int target) {
        int count = 0;
        for (Integer num : arr) {
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
                // Clear the invalid input

                scanner.next(); // consume the invalid token
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Formatter formatter = new Formatter(System.out)) {
            // Input array size
            int n = readInt(scanner, "Enter the number of elements: ");
            List<Integer> array = new ArrayList<>();
            System.out.println(MessageFormat.format("Array size: {0}", n));
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            
            // Input array elements
            // formatter already declared in try-with-resources
            //Replace the formatter.format() call with MessageFormat.format()
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array.add(readInt(scanner, String.format("Element %d: ", i)));
            }

            // Input target element
            int target = readInt(scanner, "Enter the element to search for: ");

            // Perform linear search and get frequency
            List<Integer> arrayList = new ArrayList<>();
            for (int num : array) {
                arrayList.add(num);
            }
            int frequency = linearSearchFrequency(arrayList, target);

            // Output result
            if (frequency > 0) {
                System.out.println(MessageFormat.format("Element {0} found {1} time(s) in the array.", target, frequency));
            } else {
                System.out.println(MessageFormat.format("Element {0} not found in the array.", target));
            }

            System.out.println(MessageFormat.format("Array: {0}", arrayList));
            formatter.close();
        }
    }
}
import java.util.Scanner;
import java.text.MessageFormat;

/**
 * LinearSearch - A simple program to perform linear search on an array of integers.
 * Reads user input for array elements and the key to search, then reports the index
 * of the first occurrence or indicates that the key was not found.
 */
public class LinearSearch {
    /**
     * Entry point of the application.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println(MessageFormat.format("Enter {0} integers:", n));
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the number to search for: ");
        int key = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println(MessageFormat.format("Number {0} found at index {1}.", key, index));
        } else {
            System.out.println(MessageFormat.format("Number {0} not found in the array.", key));
        }

        scanner.close();
    }
}

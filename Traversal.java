import java.util.Scanner;
import java.text.MessageFormat;

/**
 * Traversal - Demonstrates array traversal.
 * 
 * This class reads an array of integers from the user and then prints
 * each element of the array to the console.
 */
public class Traversal {
    /**
     * Main method to execute the traversal logic.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        // Input elements from user
        System.out.println("Enter " + size + " array elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + " element:  ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Array elements: " + numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(MessageFormat.format("Index {0}: {1}", i, numbers[i]));
        }
        scanner.close();
    }
}

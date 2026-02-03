import java.util.Scanner;
// import java.util.Arrays;

/**
 * SecondSmallestSecondLargest - Finds the second smallest and second largest elements.
 * 
 * This class reads an array of integers from the user and determines the
 * second smallest and second largest values in the array.
 */
public class SecondSmallestSecondLargest {
    /**
     * Main method to execute the logic.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);

        // Input array size
        System.out.println("Enter the number of elements:");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume the invalid token
        }
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // consume the invalid token
            }
            array[i] = scanner.nextInt();
        }

        // Find second smallest and second largest elements
        int secondSmallest = Integer.MAX_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : array) {
            if (num < secondSmallest) {
                secondSmallest = num;
            }
            if (num > secondLargest) {
                secondLargest = num;
            }
        }
       // Print results
        System.out.println("Second smallest element: " + secondSmallest);
        System.out.println("Second largest element: " + secondLargest);
        scanner.close();
    }
}

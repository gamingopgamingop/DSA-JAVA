import java.util.Scanner;
public class SmallestLargest {
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume the invalid token
        }
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // consume the invalid token
            }
            array[i] = scanner.nextInt();
        }

        // Find smallest and largest elements
        int smallest = array[0];
        int largest = array[0];
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {    
                largest = num;
            }
        }
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);
        scanner.close();

    }
}

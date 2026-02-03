import java.text.MessageFormat;
import java.util.Scanner;
/**
 * BinarySearch - Implements the binary search algorithm.
 * 
 * This class provides a method to perform binary search on a sorted array
 * to find the index of a specific target element.
 */
public class BinarySearch {
    /**
     * Performs binary search on a sorted integer array.
     * 
     * @param arr The sorted array of integers.
     * @param target The integer value to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    /**
     * Main method to test the binary search implementation.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the target value to search for: ");
        int target = scanner.nextInt();
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println(MessageFormat.format("Element found at index: {0}", index));
        } else {
            System.out.println(MessageFormat.format("Element {0} not found", target));
        }
        scanner.close();
    }

}

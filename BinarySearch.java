import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
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
        System.out.println("Left: " + left);
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
     * Performs binary search on a sorted List of integers.
     * 
     * @param list The sorted list of integers.
     * @param target The integer value to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
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
        try {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Sort the array to ensure Binary Search works
            Arrays.sort(arr);
            
            // Create a List from the array for demonstration
            List<Integer> list = Arrays.stream(arr).boxed().toList();
            
            System.out.print("Array has been sorted and converted to List: [");
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            System.out.print("Enter the target value to search for: ");
            int target = scanner.nextInt();
            
            // Using the List-based binarySearch
            int index = binarySearch(list, target);
            
            // Using Formatter for formatted output
            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);
            if (index != -1) {
                // Using MessageFormat for complex message construction
                String result = MessageFormat.format("Element found at index: {0}", index);
                formatter.format("%s", result);
                System.out.println(sb.toString());
            } else {
                // Using MessageFormat for complex message construction
                String result = MessageFormat.format("Element {0} not found", target);
                formatter.format("%s", result);
                System.out.println(sb.toString());
            }
            formatter.close();

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integers.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: No input provided.");
        } finally {
            scanner.close();
        }
    }

}

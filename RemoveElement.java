import java.util.Scanner;
import java.text.MessageFormat;

/**
 * RemoveElement - A program to remove an element from an array.
 * 
 * This class reads an array from the user, then asks for an index to remove.
 * It shifts subsequent elements to the left to fill the gap.
 */

public class RemoveElement {

    /**
     * Main method to execute the removal logic.
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read array size
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        // Read array elements
        System.out.println(MessageFormat.format("Enter {0} array elements:", size));
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Print the array before removal
        System.out.println(MessageFormat.format("Array before removal: {0}", arr));
        for(int i=0;i<arr.length;i++){
            System.out.println(MessageFormat.format("Index {0}: {1}", i, arr[i]));
        }
        System.out.println();
                
        // Read index and element to remove
        System.out.print("Enter index to remove: ");
        int index = scanner.nextInt();
        
        // Shift elements to the left to fill the gap
        for(int i=index;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0; // Optional: Set the last element to 0 or any default value
        
        // Print the array after removal
        System.out.println("Array after removal:");
        for(int i=0;i<arr.length;i++){
            System.out.println(MessageFormat.format("Index {0}: {1}", i, arr[i]));
        }
        
        scanner.close();
    }
}

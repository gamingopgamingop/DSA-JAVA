import java.util.Scanner;
import java.text.MessageFormat;

/**
 * InsertElement - A program to insert an element into an array.
 * 
 * This class reads an array from the user, then asks for an index and an element
 * to insert. It shifts existing elements to make space and inserts the new element.
 */
public class InsertElement {
    /**
     * Main method to execute the insertion logic.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read array size
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        // Read array elements
        System.out.println(MessageFormat.format("Enter {0} array elements:", size));
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        // Print the array before insertion
        System.out.println(MessageFormat.format("Array before insertion: {0}", arr));
        System.out.println("Array before insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();
        // Print the array before insertion
        System.out.println("Array before insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();
            
        // Read index and element to insert
        System.out.print("Enter index to insert at: ");
        int index = scanner.nextInt();
        System.out.print("Enter element to insert: ");
        int element = scanner.nextInt();
        
        // Shift elements to the right to make space for the new element
        for(int i=arr.length-1;i>=index;i--){
            arr[i] = arr[i-1];
        }
                arr[index] = element;
        
        // Print the array after insertion
        System.out.println(MessageFormat.format("Array after insertion: {0}", arr));
        System.out.println("Array after insertion:");
        for(int i=0;i<arr.length;i++){
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        
        scanner.close();
    }
}

import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Array Operations");
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Array");
            System.out.println("2. Find Sum");
            System.out.println("3. Find Average");
            System.out.println("4. Find Maximum");
            System.out.println("5. Find Minimum");
            System.out.println("6. Search Element");
            System.out.println("7. Reverse Array");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    displayArray(array);
                    break;
                case 2:
                    System.out.println("Sum: " + findSum(array));
                    break;
                case 3:
                    System.out.println("Average: " + findAverage(array));
                    break;
                case 4:
                    System.out.println("Maximum: " + findMaximum(array));
                    break;
                case 5:
                    System.out.println("Minimum: " + findMinimum(array));
                    break;
                case 6:
                    System.out.print("Enter element to search: ");
                    int element = scanner.nextInt();
                    int index = searchElement(array, element);
                    if (index != -1) {
                        System.out.println("Element found at index: " + index);
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 7:
                    reverseArray(array);
                    System.out.println("Array reversed!");
                    displayArray(array);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void displayArray(int[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    public static double findAverage(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }
    
    public static int findMaximum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public static int searchElement(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
    
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

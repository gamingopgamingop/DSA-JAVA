# Insertion Sort Analysis

## Objective
The objective of this program is to implement the **Insertion Sort** algorithm in Java. This algorithm sorts an array of integers in ascending order by building a sorted array one item at a time. It is efficient for small data sets and is stable.

## Algorithm
1.  Start from the second element (index 1) of the array (call it `key`).
2.  Compare `key` with the elements before it (predecessors).
3.  If the predecessor is greater than `key`, shift the predecessor one position to the right.
4.  Repeat step 3 until a smaller element is found or the beginning of the array is reached.
5.  Insert `key` at the correct position (after the smaller element or at the start).
6.  Repeat steps 1-5 for all elements in the array.

## Code
```java
import java.util.Scanner;
import java.text.MessageFormat;

/**
 * InsertionSort - A program to sort an array using Insertion Sort algorithm.
 * 
 * This class reads an array from the user, sorts it in ascending order
 * using Insertion Sort, and displays the array before and after sorting.
 */
public class InsertionSort {

    /**
     * Main method to execute insertion sort logic.
     *
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

        // Print array before sorting
        System.out.print("Array before sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }
        System.out.println();

        // Insertion Sort logic
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        // Print array after sorting
        System.out.print("Array after sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(MessageFormat.format("{0} ", arr[i]));
        }

        scanner.close();
    }
}
```

## Dry Run
**Input Array**: `[5, 2, 4, 6, 1, 3]`
**Size**: `6`

### Iteration 1 (i = 1)
*   **Key**: `arr[1] = 2`
*   **Predecessor**: `arr[0] = 5`
*   **Comparison**: `5 > 2` is True.
*   **Action**: Shift `5` to index 1. Array becomes `[5, 5, 4, 6, 1, 3]`.
*   `j` becomes `-1`. Loop ends.
*   **Insert**: Place `key` (2) at `arr[0]`.
*   **Result**: `[2, 5, 4, 6, 1, 3]`

### Iteration 2 (i = 2)
*   **Key**: `arr[2] = 4`
*   **Predecessors**: `arr[1] = 5`, `arr[0] = 2`
*   **Comparison**: `5 > 4` is True.
*   **Action**: Shift `5` to index 2. Array: `[2, 5, 5, 6, 1, 3]`.
*   **Comparison**: `2 > 4` is False. Loop ends.
*   **Insert**: Place `key` (4) at `arr[1]`.
*   **Result**: `[2, 4, 5, 6, 1, 3]`

### Iteration 3 (i = 3)
*   **Key**: `arr[3] = 6`
*   **Predecessors**: `arr[2] = 5`
*   **Comparison**: `5 > 6` is False. Loop doesn't start.
*   **Insert**: `key` (6) stays at `arr[3]`.
*   **Result**: `[2, 4, 5, 6, 1, 3]`

### Iteration 4 (i = 4)
*   **Key**: `arr[4] = 1`
*   **Predecessors**: `6, 5, 4, 2`
*   **Shift**:
    *   `6 > 1`: Shift 6. `[2, 4, 5, 6, 6, 3]`
    *   `5 > 1`: Shift 5. `[2, 4, 5, 5, 6, 3]`
    *   `4 > 1`: Shift 4. `[2, 4, 4, 5, 6, 3]`
    *   `2 > 1`: Shift 2. `[2, 2, 4, 5, 6, 3]`
*   **Insert**: Place `key` (1) at `arr[0]`.
*   **Result**: `[1, 2, 4, 5, 6, 3]`

### Iteration 5 (i = 5)
*   **Key**: `arr[5] = 3`
*   **Predecessors**: `6, 5, 4, 2, 1`
*   **Shift**:
    *   `6 > 3`: Shift 6. `[1, 2, 4, 5, 6, 6]`
    *   `5 > 3`: Shift 5. `[1, 2, 4, 5, 5, 6]`
    *   `4 > 3`: Shift 4. `[1, 2, 4, 4, 5, 6]`
    *   `2 > 3`: False.
*   **Insert**: Place `key` (3) at `arr[2]`.
*   **Result**: `[1, 2, 3, 4, 5, 6]`

**Final Sorted Array**: `[1, 2, 3, 4, 5, 6]`

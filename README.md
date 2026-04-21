# DSA Java Algorithms Analysis

This document contains the Objective, Algorithm, Code, and Dry Run analysis for various Data Structures and Algorithms implemented in Java.

## Table of Contents
1.  [Binary Search](#binary-search)
2.  [Bubble Sort](#bubble-sort)
3.  [Insert Element](#insert-element)
4.  [Insertion Sort](#insertion-sort)
5.  [Linear Search](#linear-search)
6.  [Linear Search With Frequency](#linear-search-with-frequency)
7.  [Remove Element](#remove-element)
8.  [Second Smallest & Second Largest](#second-smallest--second-largest)
9.  [Selection Sort](#selection-sort)
10. [Smallest & Largest](#smallest--largest)
11. [Traversal](#traversal)
12. [Merge Sort](#merge-sort)
13. [Quick Sort](#quick-sort)
14. [Sample (Hello World)](#sample-hello-world)
15. [Stack Operations](#stack-operations)
16. [Linear Queue](#linear-queue)
17. [Circular Queue](#circular-queue)
18. [Deque Operations](#deque-operations)
19. [Priority Queue](#priority-queue)
20. [Merge Sort Algorithm](#merge-sort-algorithm)
21. [Quick Sort Algorithm](#quick-sort-algorithm)
22. [Linked List with Addresses](#linked-list-with-addresses)
23. [Singly Linked List Operations](#singly-linked-list-operations)

---

## Binary Search

### Objective
To find the position of a specific target element within a **sorted** array using the Binary Search algorithm. It divides the search interval in half repeatedly.

### Algorithm
1.  Initialize `left = 0` and `right = length - 1`.
2.  While `left <= right`:
    a. Calculate `mid = left + (right - left) / 2`.
    b. If `arr[mid] == target`, return `mid`.
    c. If `arr[mid] < target`, ignore left half: `left = mid + 1`.
    d. If `arr[mid] > target`, ignore right half: `right = mid - 1`.
3.  If loop ends, target is not found (return -1).

### Code
```java
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Arrays;

/**
 * BinarySearch - Implements the binary search algorithm.
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        // ... binary search logic ...
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

    public static void main(String[] args) {
        // ... input reading ...
        // Sort the array to ensure Binary Search works
        Arrays.sort(arr);
        System.out.println("Array has been sorted: " + Arrays.toString(arr));
        
        // ... perform search ...
        int index = binarySearch(arr, target);
        // ... output ...
    }
}
```

### Dry Run
**Input**: `arr = [2, 5, 8, 12, 16]`, `target = 12`
1.  **Iter 1**: `left=0`, `right=4`. `mid = 0 + (4-0)/2 = 2`. `arr[2]=8`. `8 < 12`, so `left = 2 + 1 = 3`.
2.  **Iter 2**: `left=3`, `right=4`. `mid = 3 + (4-3)/2 = 3`. `arr[3]=12`. `12 == 12`.
3.  **Result**: Found at index `3`.

---

## Bubble Sort

### Objective
To sort an array of integers in ascending order by repeatedly stepping through the list, comparing adjacent elements and swapping them if they are in the wrong order.

### Algorithm
1.  Iterate `i` from `size - 1` down to `1`.
2.  Iterate `j` from `0` to `i - 1`.
3.  Compare `arr[j]` and `arr[j + 1]`.
4.  If `arr[j] > arr[j + 1]`, swap them.
5.  Repeat until the array is sorted.

### Code
```java
// ... imports ...
public class BubbleSort {
    public static void main(String[] args) {
        // ... input reading ...
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // ... output printing ...
    }
}
```

### Dry Run
**Input**: `[5, 1, 4, 2, 8]`
1.  **Pass 1 (i=4)**:
    *   `5 > 1` -> Swap -> `[1, 5, 4, 2, 8]`
    *   `5 > 4` -> Swap -> `[1, 4, 5, 2, 8]`
    *   `5 > 2` -> Swap -> `[1, 4, 2, 5, 8]`
    *   `5 < 8` -> No Swap.
2.  **Pass 2 (i=3)**:
    *   `1 < 4` -> No Swap.
    *   `4 > 2` -> Swap -> `[1, 2, 4, 5, 8]`
    *   `4 < 5` -> No Swap.
3.  **Result**: `[1, 2, 4, 5, 8]`.

---

## Insert Element

### Objective
To insert a new element at a specified index in an array, shifting subsequent elements to the right.

### Algorithm
1.  Read array size `n`, elements, `index` to insert, and `element` value.
2.  Iterate from the last element (`n-1`) down to `index`.
3.  Shift element: `arr[i] = arr[i-1]`.
4.  Place new `element` at `arr[index]`.

### Code
```java
// ... imports ...
public class InsertElement {
    public static void main(String[] args) {
        // ... input reading ...
        // Shift elements to the right
        for(int i=arr.length-1;i>=index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        // ... output ...
    }
}
```

### Dry Run
**Input**: `arr = [10, 20, 30, 0]`, `index = 1`, `element = 15` (assuming space exists)
1.  **i=3**: `arr[3] = arr[2]` (30). Array: `[10, 20, 30, 30]`
2.  **i=2**: `arr[2] = arr[1]` (20). Array: `[10, 20, 20, 30]`
3.  **i=1**: Loop ends.
4.  **Insert**: `arr[1] = 15`.
5.  **Result**: `[10, 15, 20, 30]`.

---

## Insertion Sort

### Objective
To sort an array by building a sorted portion one item at a time, inserting each new element into its correct position relative to the already sorted elements.

### Algorithm
1.  Loop `i` from `1` to `n-1`.
2.  Set `key = arr[i]`, `j = i - 1`.
3.  While `j >= 0` and `arr[j] > key`:
    a. `arr[j + 1] = arr[j]` (Shift right).
    b. `j--`.
4.  `arr[j + 1] = key` (Insert key).

### Code
```java
// ... imports ...
public class InsertionSort {
    public static void main(String[] args) {
        // ... input ...
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        // ... output ...
    }
}
```

### Dry Run
**Input**: `[5, 2, 4]`
1.  **i=1 (Key=2)**: `5 > 2`, shift 5 -> `[5, 5, 4]`. Insert 2 at 0 -> `[2, 5, 4]`.
2.  **i=2 (Key=4)**: `5 > 4`, shift 5 -> `[2, 5, 5]`. `2 < 4`, stop. Insert 4 at 1 -> `[2, 4, 5]`.
3.  **Result**: `[2, 4, 5]`.

---

## Linear Search

### Objective
To find the index of a specific element in an array by checking each element sequentially.

### Algorithm
1.  Read array `arr` and `key`.
2.  Initialize `index = -1`.
3.  Loop `i` from `0` to `n-1`:
    a. If `arr[i] == key`, set `index = i` and `break`.
4.  If `index != -1`, print found; else print not found.

### Code
```java
// ... imports ...
public class LinearSearch {
    public static void main(String[] args) {
        // ... input ...
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        // ... output ...
    }
}
```

### Dry Run
**Input**: `arr = [10, 50, 30]`, `key = 30`
1.  **i=0**: `10 != 30`.
2.  **i=1**: `50 != 30`.
3.  **i=2**: `30 == 30`. `index = 2`. Break.
4.  **Result**: Found at index 2.

---

## Linear Search With Frequency

### Objective
To find a target element in an array and count how many times it appears.

### Algorithm
1.  Initialize `count = 0`.
2.  Iterate through each element `num` in `arr`.
3.  If `num == target`, increment `count`.
4.  Return/Print `count`.

### Code
```java
// ... imports ...
public class LinearSearchWithFrequency {
    public static int linearSearchFrequency(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
    // ... main ...
}
```

### Dry Run
**Input**: `arr = [1, 2, 3, 2]`, `target = 2`
1.  `num=1`: `1 != 2`.
2.  `num=2`: `2 == 2`. `count = 1`.
3.  `num=3`: `3 != 2`.
4.  `num=2`: `2 == 2`. `count = 2`.
5.  **Result**: Frequency is 2.

---

## Remove Element

### Objective
To remove an element at a specific index from an array and shift remaining elements to fill the gap.

### Algorithm
1.  Read `index` to remove.
2.  Loop `i` from `index` to `n-2`.
3.  Set `arr[i] = arr[i+1]` (Shift left).
4.  Optionally set last element to 0/null.

### Code
```java
// ... imports ...
public class RemoveElement {
    public static void main(String[] args) {
        // ... input ...
        for(int i=index;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
        // ... output ...
    }
}
```

### Dry Run
**Input**: `arr = [10, 20, 30, 40]`, `index = 1` (Value 20)
1.  **i=1**: `arr[1] = arr[2]` (30). Array: `[10, 30, 30, 40]`
2.  **i=2**: `arr[2] = arr[3]` (40). Array: `[10, 30, 40, 40]`
3.  **Final Step**: `arr[3] = 0`.
4.  **Result**: `[10, 30, 40, 0]`.

---

## Second Smallest & Second Largest

### Objective
To find the second smallest and second largest numbers in an array without sorting.

### Algorithm
1.  Initialize `secondSmallest = MAX_VALUE`, `secondLargest = MIN_VALUE`.
2.  (Note: The provided code logic in file seems to rely on single pass but might be incomplete/buggy for finding strict second best without tracking first best. However, based on the file content logic):
3.  Iterate through array, updating variables if conditions met.

### Code
```java
// ... imports ...
public class SecondSmallestSecondLargest {
    public static void main(String[] args) {
        // ... input ...
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
        // ... output ...
    }
}
```
*Note: The implementation in the file `SecondSmallestSecondLargest.java` actually finds the **Smallest** and **Largest**, not the **Second** ones, despite the variable names. A proper algorithm would track `first` and `second`.*

### Dry Run (As per code logic)
**Input**: `[10, 5, 20]`
1.  `num=10`: `secSmall=10`, `secLarge=10`.
2.  `num=5`: `secSmall=5`.
3.  `num=20`: `secLarge=20`.
4.  **Result**: Smallest: 5, Largest: 20. (Code logic calculates min/max).

---

## Selection Sort

### Objective
To sort an array by repeatedly finding the minimum element from the unsorted part and putting it at the beginning.

### Algorithm
1.  Loop `i` from `0` to `n-2`.
2.  Find index of minimum element `minIndex` in sub-array `i+1` to `n`.
3.  Swap `arr[i]` with `arr[minIndex]`.

### Code
```java
// ... imports ...
public class SelectionSort {
    public static void main(String[] args) {
        // ... input ...
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        // ... output ...
    }
}
```

### Dry Run
**Input**: `[64, 25, 12]`
1.  **i=0**: Min in `[25, 12]` is `12` (at index 2). Swap `64` & `12`. Array: `[12, 25, 64]`.
2.  **i=1**: Min in `[64]` is `64` (at index 2). `25 < 64`, no change. `minIndex` remains 1. Swap `25` & `25` (no op).
3.  **Result**: `[12, 25, 64]`.

---

## Smallest & Largest

### Objective
To find the smallest and largest elements in an array.

### Algorithm
1.  Initialize `smallest = arr[0]`, `largest = arr[0]`.
2.  Iterate through the array.
3.  If `current < smallest`, update `smallest`.
4.  If `current > largest`, update `largest`.

### Code
```java
// ... imports ...
public class SmallestLargest {
    public static void main(String[] args) {
        // ... input ...
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
        // ... output ...
    }
}
```

### Dry Run
**Input**: `[10, 5, 20]`
1.  Start: `small=10`, `large=10`.
2.  `num=10`: No change.
3.  `num=5`: `5 < 10` -> `small=5`.
4.  `num=20`: `20 > 10` -> `large=20`.
5.  **Result**: Smallest: 5, Largest: 20.

---

## Traversal

### Objective
To iterate through an array and access/print each element.

### Algorithm
1.  Read array size and elements.
2.  Loop from `i = 0` to `n-1`.
3.  Print element at index `i`.

### Code
```java
// ... imports ...
public class Traversal {
    public static void main(String[] args) {
        // ... input ...
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(MessageFormat.format("Index {0}: {1}", i, numbers[i]));
        }
    }
}
```

### Dry Run
**Input**: `[1, 2]`
1.  **i=0**: Print "Index 0: 1".
2.  **i=1**: Print "Index 1: 2".

---

## Merge Sort

### Objective
To sort an array of integers in ascending order using the Divide and Conquer strategy of the Merge Sort algorithm.

### Algorithm
1.  **Divide**: If the array has more than one element, divide it into two halves.
2.  **Conquer**: Recursively sort each half.
3.  **Combine**: Merge the two sorted halves back into a single sorted array.
    a. Create temporary arrays `L` and `R`.
    b. Copy data to `L` and `R`.
    c. Merge `L` and `R` back into the original array, comparing elements and placing the smaller one first.
    d. Copy any remaining elements of `L` or `R` (if any).

### Code
```java
import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;

/**
 * MergeSort - Implements the Merge Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Merge Sort algorithm, and then prints the sorted array.
 */
public class MergeSort {

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(MessageFormat.format("Array size: {0}", n));
            
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, MessageFormat.format("Element {0}: ", i));
            }

            System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

            mergeSort(array, 0, array.length - 1);

            System.out.println(MessageFormat.format("Sorted Array: {0}", Arrays.toString(array)));
        }
    }
}
```

### Dry Run
**Input**: `arr = [38, 27, 43, 3, 9, 82, 10]`
1.  **Divide**: Array is split recursively until single-element arrays are formed.
    *   `[38, 27, 43, 3]` and `[9, 82, 10]`
    *   `[38, 27]`, `[43, 3]` and `[9, 82]`, `[10]`
    *   `[38]`, `[27]`, `[43]`, `[3]`, `[9]`, `[82]`, `[10]`
2.  **Merge**: Subarrays are merged in sorted order.
    *   `[27, 38]`, `[3, 43]` -> `[3, 27, 38, 43]`
    *   `[9, 82]`, `[10]` -> `[9, 10, 82]`
    *   `[3, 27, 38, 43]`, `[9, 10, 82]` -> `[3, 9, 10, 27, 38, 43, 82]`
3.  **Result**: `[3, 9, 10, 27, 38, 43, 82]`

---

## Quick Sort

### Objective
To sort an array of integers in ascending order using the Quick Sort algorithm, which is a divide-and-conquer algorithm that picks an element as a pivot and partitions the given array around the picked pivot.

### Algorithm
1.  **Choose Pivot**: Select an element from the array as the pivot (e.g., the last element).
2.  **Partition**: Rearrange the array such that all elements smaller than the pivot come before it, and all elements greater than the pivot come after it. Elements equal to the pivot can go on either side. This step places the pivot in its final sorted position.
3.  **Recurse**: Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.

### Code
```java
import java.util.Scanner;
import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Arrays;

/**
 * QuickSort - Implements the Quick Sort algorithm.
 * 
 * This class allows the user to input an array of integers,
 * sorts it using the Quick Sort algorithm, and then prints the sorted array.
 */
public class QuickSort {

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume the invalid token
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = readInt(scanner, "Enter the number of elements: ");
            int[] array = new int[n];
            System.out.println(MessageFormat.format("Array size: {0}", n));
            
            System.out.println(MessageFormat.format("Enter {0} elements:", n));
            for (int i = 0; i < n; i++) {
                array[i] = readInt(scanner, MessageFormat.format("Element {0}: ", i));
            }

            System.out.println(MessageFormat.format("Original Array: {0}", Arrays.toString(array)));

            quickSort(array, 0, array.length - 1);

            System.out.println(MessageFormat.format("Sorted Array: {0}", Arrays.toString(array)));
        }
    }
}
```

### Dry Run
**Input**: `arr = [10, 80, 30, 90, 40, 50, 70]`
1.  **Initial Call**: `quickSort(arr, 0, 6)`
2.  **Partition (pivot=70)**:
    *   Array becomes `[10, 40, 30, 50, 70, 90, 80]` (pivot 70 is at index 4)
    *   `pi = 4`
3.  **Recursive Calls**:
    *   `quickSort(arr, 0, 3)` (for `[10, 40, 30, 50]`)
    *   `quickSort(arr, 5, 6)` (for `[90, 80]`)
4.  ... (further recursive calls and partitions) ...
5.  **Result**: `[10, 30, 40, 50, 70, 80, 90]`

---

## Sample (Hello World)

### Objective
To verify the development environment and demonstrate basic Java program structure and output.

### Algorithm
1.  Define a class named `sample`.
2.  Implement the `main` method.
3.  Use `System.out.println` to display "Hello, World!".

### Code
```java
public class sample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Dry Run
1.  **Execution**: `main` method starts.
2.  **Statement**: `System.out.println("Hello, World!")` is called.
3.  **Result**: "Hello, World!" is printed to the console.

---

## Stack Operations

### Objective
To implement a Stack data structure using the java.util.Stack collection, supporting six key operations: Push, Pop, Peek, IsEmpty, IsFull, and Display, all controlled through a menu-driven interface.

### Algorithm
1.  **Initialize**: Set a fixed capacity for the stack and initialize a java.util.Stack instance.
2.  **Push(x)**: If stack.size() < capacity, use stack.push(x). Else, signal Overflow.
3.  **Pop()**: If !stack.isEmpty(), use stack.pop(). Else, signal Underflow.
4.  **Peek()**: If !stack.isEmpty(), return stack.peek(). Else, signal Empty.
5.  **IsEmpty()**: Check stack.isEmpty().
6.  **IsFull()**: Check if stack.size() == capacity.
7.  **Display()**: Obtain an Iterator from the stack and traverse all elements.

### Code
```java
import java.util.Stack;
import java.util.Iterator;
import java.util.Scanner;

public class StackOperations {
    private Stack<Integer> stack;
    private int capacity;

    public StackOperations(int size) {
        stack = new Stack<>();
        capacity = size;
    }

    public void push(int x) {
        if (stack.size() == capacity) {
            System.out.println("Stack Overflow!");
            return;
        }
        stack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        return stack.pop();
    }

    public void display() {
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
    }
}
```

### Dry Run
**Input**: Capacity = 3, Operations: Push(10), Push(20), Push(30), Push(40), Pop(), Display()
1.  **Push(10)**: Stack = `[10]`, size = 1.
2.  **Push(20)**: Stack = `[10, 20]`, size = 2.
3.  **Push(30)**: Stack = `[10, 20, 30]`, size = 3.
4.  **Push(40)**: size (3) == capacity (3). **Overflow** reported.
5.  **Pop()**: Returns 30. Stack = `[10, 20]`.
6.  **Display()**: Output: `10 20`.

---

## Linear Queue

### Objective
To implement a Linear Queue data structure using an array, supporting Enqueue, Dequeue, Peek, and Display operations through a menu-driven interface.

### Algorithm
1.  **Enqueue(item)**: If `rear == capacity - 1`, Overflow. Else, `rear++`, `arr[rear] = item`. If `front == -1`, `front = 0`.
2.  **Dequeue()**: If `front == -1`, Underflow. Else, `item = arr[front]`. If `front == rear`, reset `front = rear = -1`. Else, `front++`.

### Code
```java
public class LinearQueue {
    private int[] queue;
    private int front = -1, rear = -1;

    public void enqueue(int item) {
        if (rear == capacity - 1) return;
        if (front == -1) front = 0;
        queue[++rear] = item;
    }

    public int dequeue() {
        if (front == -1) return -1;
        int item = queue[front];
        if (front >= rear) front = rear = -1;
        else front++;
        return item;
    }
}
```

### Dry Run
**Input**: Capacity = 2, Operations: Enqueue(10), Enqueue(20), Enqueue(30), Dequeue()
1.  **Enqueue(10)**: `front=0, rear=0`. Queue: `[10]`.
2.  **Enqueue(20)**: `rear=1`. Queue: `[10, 20]`.
3.  **Enqueue(30)**: `rear=1 == capacity-1`. **Overflow**.
4.  **Dequeue()**: Returns 10. `front=1`. Queue: `[20]`.
5.  **Result**: `front=1, rear=1, elements=[20]`.

---

## Circular Queue

### Objective
To implement a Circular Queue to overcome the limitation of space wastage in Linear Queues.

### Algorithm
1.  **Enqueue(item)**: If `(rear + 1) % capacity == front`, Overflow. Else, `rear = (rear + 1) % capacity`, `arr[rear] = item`. If `front == -1`, `front = 0`.
2.  **Dequeue()**: If `front == -1`, Underflow. Else, `item = arr[front]`. If `front == rear`, reset `front = rear = -1`. Else, `front = (front + 1) % capacity`.

### Code
```java
public class CircularQueue {
    public void enqueue(int item) {
        if ((rear + 1) % capacity == front) return;
        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;
        queue[rear] = item;
    }

    public int dequeue() {
        if (front == -1) return -1;
        int item = queue[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % capacity;
        return item;
    }
}
```

### Dry Run
**Input**: Capacity = 3, Operations: Enqueue(1), Enqueue(2), Enqueue(3), Dequeue(), Enqueue(4)
1.  **Enqueue(1,2,3)**: `front=0, rear=2`. Queue: `[1, 2, 3]`.
2.  **Dequeue()**: Returns 1. `front=1`.
3.  **Enqueue(4)**: `rear = (2+1)%3 = 0`. Queue: `[4, 2, 3]` (circular).
4.  **Result**: `front=1, rear=0`.

---

## Deque Operations

### Objective
To implement a Double Ended Queue (Deque) allowing insertions and deletions from both ends.

### Algorithm
1.  **InsertFront(item)**: Decrement `front` circularly and insert.
2.  **InsertRear(item)**: Increment `rear` circularly and insert.
3.  **DeleteFront()**: Increment `front` circularly and remove.
4.  **DeleteRear()**: Decrement `rear` circularly and remove.

### Code
```java
public class DequeOperations {
    public void insertFront(int item) {
        if (isFull()) return;
        if (front == -1) { front = 0; rear = 0; }
        else if (front == 0) front = capacity - 1;
        else front--;
        deque[front] = item;
    }
}
```

### Dry Run
**Input**: Capacity = 5, InsertRear(10), InsertFront(20)
1.  **InsertRear(10)**: `front=0, rear=0`. `[10]`.
2.  **InsertFront(20)**: `front` becomes 4. `[10, _, _, _, 20]`.
3.  **Result**: `front=4, rear=0`.

---

## Priority Queue

### Objective
To implement a Priority Queue using the `java.util.PriorityQueue` collection, where elements are dequeued based on their natural ordering or a custom comparator.

### Algorithm
1.  **Insert(item)**: Uses `pq.offer(item)` to add element.
2.  **Delete()**: Uses `pq.poll()` to remove and return the element with the highest priority (lowest value by default).
3.  **Peek()**: Uses `pq.peek()` to view the highest priority element.

### Code
```java
import java.util.PriorityQueue;

public class PriorityQueueOperations {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public void insert(int item) { pq.offer(item); }
    public int delete() { return pq.poll(); }
}
```

### Dry Run
**Input**: Insert(30), Insert(10), Insert(20), Delete()
1.  **Insert(30, 10, 20)**: Internal heap stores elements.
2.  **Delete()**: Returns 10 (smallest value has highest priority).
3.  **Result**: 10 removed.

---

## Merge Sort Algorithm

### Objective
To implement the Merge Sort algorithm, a divide-and-conquer strategy that recursively splits the array into halves, sorts them, and merges them back together.

### Algorithm
1.  **Split**: Find the middle point `mid = (left + right) / 2`.
2.  **Recursively Sort**: Call `mergeSort` for the left half and right half.
3.  **Merge**: Combine the two sorted halves into a single sorted array.

### Code
```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
```

### Dry Run
**Input**: `[3, 1, 2]`
1.  Split to `[3]` and `[1, 2]`.
2.  Split `[1, 2]` to `[1]` and `[2]`.
3.  Merge `[1]` and `[2]` -> `[1, 2]`.
4.  Merge `[3]` and `[1, 2]` -> `[1, 2, 3]`.

---

## Quick Sort Algorithm

### Objective
To implement the Quick Sort algorithm, a divide-and-conquer strategy that picks an element as a 'pivot' and partitions the array around it.

### Algorithm
1.  **Pivot Selection**: Choose an element (e.g., the last element) as the pivot.
2.  **Partitioning**: Rearrange the array so elements smaller than the pivot are on the left and larger elements are on the right.
3.  **Recursively Sort**: Call `quickSort` for the left and right partitions.

### Code
```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### Dry Run
**Input**: `[10, 80, 30]`, Pivot=30
1.  Partition: `10 < 30`, `80 > 30`. Swap 80 and 30. Array: `[10, 30, 80]`.
2.  `pi = 1`.
3.  Recurse `[10]` and `[80]`.

---

## Linked List with Addresses

### Objective
To implement a custom Singly Linked List and display each node's data alongside its memory address (hash code) to visualize how nodes are stored in memory.

### Algorithm
1.  **Insert**: Create a new `Node` and traverse to the end of the list to link it.
2.  **Display**: Traverse the list from `head`, printing `node.data` and `System.identityHashCode(node)`.
3.  **Utilities**: Use `Stack` and `ArrayList` to demonstrate data conversion and reversal.

### Code
```java
public void displayWithAddresses() {
    Node temp = head;
    while (temp != null) {
        String addr = Integer.toHexString(System.identityHashCode(temp));
        System.out.println(temp.data + " at " + addr);
        temp = temp.next;
    }
}
```

### Dry Run
**Input**: List with nodes `10` and `20`.
1.  Node 10: data=10, addr=@1a2b3c.
2.  Node 20: data=20, addr=@4d5e6f.
3.  **Output**: `10 at @1a2b3c`, `20 at @4d5e6f`.


---

## Singly Linked List Operations

### Objective
To implement insertion and deletion operations in a Singly Linked List, including insertion at the beginning and at a specific position, and deletion from the beginning, end, and specific positions.

### Algorithm
1.  **Insert at Beginning**: Create a new node, point its `next` to the current `head`, and update `head`.
2.  **Insert at Position**: Traverse to `position - 1`, link the new node to the current node’s `next`, and update the current node’s `next`.
3.  **Delete from Beginning**: Point `head` to `head.next`.
4.  **Delete from End**: Traverse to the second-to-last node and set its `next` to `null`.
5.  **Delete at Position**: Traverse to `position - 1` and update its `next` to `temp.next.next`.

### Code
```java
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; this.next = null; }
}

public class SinglyLinkedListOperations {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position == 1) { insertAtBeginning(data); return; }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) temp = temp.next;
        if (temp != null) { newNode.next = temp.next; temp.next = newNode; }
    }

    public void deleteFromBeginning() {
        if (head != null) head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null || head.next == null) { head = null; return; }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    public void deleteAtPosition(int position) {
        if (position == 1) { deleteFromBeginning(); return; }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) temp = temp.next;
        if (temp != null && temp.next != null) temp.next = temp.next.next;
    }
}
```

### Dry Run
**Operations**: InsertBeginning(10), InsertBeginning(20), InsertAtPosition(15, 2), DeleteFromEnd()
1.  **InsertBeginning(10)**: `head` -> `[10|null]`.
2.  **InsertBeginning(20)**: `newNode(20).next` = `head(10)`. `head` -> `[20] -> [10|null]`.
3.  **InsertAtPosition(15, 2)**: `temp` stops at position 1 (`node 20`). `newNode(15).next` = `temp.next(10)`. `temp.next` = `newNode(15)`. List: `[20] -> [15] -> [10|null]`.
4.  **DeleteFromEnd()**: `temp` stops at `node 15`. `temp.next` = `null`. List: `[20] -> [15|null]`.
5.  **Result**: `20 -> 15 -> null`.






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
12. [Sample (Hello World)](#sample-hello-world)

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

## Sample (Hello World)

### Objective
To demonstrate a basic Java program structure.

### Algorithm
1.  Define a class `sample`.
2.  Define `main` method.
3.  Call `printHello()`.
4.  Print "Hello World!".

### Code
```java
public class sample {
    public static void main(String[] args) {
        printHello();
    }
    public static void printHello(){
        System.out.println("Hello World!");
    }
}
```

### Dry Run
1.  Program starts at `main`.
2.  Calls `printHello`.
3.  Console outputs "Hello World!".

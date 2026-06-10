# 🏗️ DSA Knowledge Module

This module covers the science of data organization and algorithmic efficiency.

## 📌 Core Taxonomy

### 1. Data Structures
- **Linear**: [Arrays](#arrays), [Strings](#strings), [Linked Lists](#linked-lists), [Stacks](#stacks), [Queues](#queues), [Deques](#deques). (100+ types cataloged).
- **Hashing**: [Hash Tables](#hash-tables), [Hash Maps](#hash-maps), [Bloom Filters](#bloom-filters). (25+ search/table algorithms).
- **Hierarchical**: [Trees](#trees), [Binary Search Trees](#binary-search-trees), [Heaps](#heaps). (35+ indexed search types).
- **Advanced Trees**: [AVL](#avl-trees), [Red-Black](#red-black-trees), [Segment Trees](#segment-trees), [Fenwick Trees](#fenwick-trees), [Tries](#tries).
- **Graphs**: [Directed](#directed-graphs), [Weighted](#weighted-graphs), [Sparse/Dense](#sparse-graphs). (100+ algorithms cataloged).

### 2. Algorithms
- **Searching**: [Linear](#linear-search), [Binary](#binary-search), [Jump](#jump-search), [A*](#a-search). (50+ well-known; 350 total procedural entries).
- **Sorting**: [Merge Sort](#merge-sort), [Quick Sort](#quick-sort), [Tim Sort](#tim-sort). (47+ implementations; 180+ elementary & distribution types).
- **Paradigms**: [DP](#dynamic-programming), [Greedy](#greedy-algorithms), [Backtracking](#backtracking). (100-200+ DP patterns cataloged).

---

## 🔍 Detailed Node: Binary Search (L2 - Intermediate)

1. **Definition**: An efficient algorithm for finding an item from a sorted list of items by repeatedly dividing the search interval in half.
2. **Intuition**: Think of finding a word in a dictionary. You open it in the middle, see if the word is before or after, and discard the other half.
3. **Theory**: Binary Search uses the **Divide and Conquer** paradigm. It reduces the search space by half in every step, leading to logarithmic time complexity.
4. **Mathematical Foundation**: Based on the recurrence relation $T(n) = T(n/2) + c$. By Master Theorem, this results in $O(\log_2 n)$.
5. **Complexity Analysis**:
   - **Time**: $O(\log n)$ (Worst/Average), $O(1)$ (Best).
   - **Space**: $O(1)$ (Iterative), $O(\log n)$ (Recursive due to call stack).
6. **Advantages**: Extremely fast for large sorted datasets; much more efficient than linear search.
7. **Disadvantages**: Array must be sorted; random access is required ($O(1)$ access to middle element).
8. **Real World Applications**: Database indexing, version control (git bisect), libraries like `java.util.Arrays.binarySearch()`.
9. **Industry Use Cases**: High-frequency trading (finding price points), Search Engines (inverted index lookup).
10. **Interview Relevance**: **High**. Foundational for "Search in Rotated Array", "Square Root using BS", etc.
11. **Competitive Programming Relevance**: **Critical**. Used in "Binary Search on Answer" techniques.
12. **Research Relevance**: Used as a primitive in more complex structures like B-Trees and Skip Lists.
13. **Visual Explanation**: 
    `[1, 2, 3, 4, 5, 6, 7] -> Target: 6`
    `Step 1: Mid=4, Target > 4 -> Search [5, 6, 7]`
    `Step 2: Mid=6, Target == 6 -> Found!`
14. **Pseudocode**:
    ```text
    while low <= high:
        mid = low + (high - low) / 2
        if arr[mid] == target: return mid
        if arr[mid] < target: low = mid + 1
        else: high = mid - 1
    ```
15. **Java Implementation**: See [BinarySearch.java](file:///d:/DSA%20JAVA/DSA-JAVA/BinarySearch.java)
16. **Python Implementation**:
    ```python
    def binary_search(arr, target):
        low, high = 0, len(arr) - 1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == target: return mid
            elif arr[mid] < target: low = mid + 1
            else: high = mid - 1
        return -1
    ```
17. **C++ Implementation**:
    ```cpp
    int binarySearch(int arr[], int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    ```
18. **Common Mistakes**: Overflow in `(low + high) / 2` (use `low + (high-low)/2`), off-by-one errors in boundaries.
19. **Best Practices**: Always use the overflow-safe mid calculation.
20. **Practice Problems**: [LeetCode 704](https://leetcode.com/problems/binary-search/), [Codeforces - Binary Search](https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A).
21. **Advanced Problems**: [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/), [K-th element of two sorted arrays](https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/).
22. **Research Papers**: *Jon Bentley, "Writing Correct Programs" (Communications of the ACM, 1983)*.
23. **Books**: *Introduction to Algorithms (CLRS)*, *Programming Pearls*.
24. **Learning Resources**: [Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search), [CP-Algorithms](https://cp-algorithms.com/general/binary-search.html).
25. **Related Topics**: [Interpolation Search](#interpolation-search), [Binary Search Tree](#binary-search-trees).
26. **Prerequisites**: [Arrays](#arrays), [Sorting](#sorting).
27. **Next Topics to Learn**: [Ternary Search](#ternary-search), [Exponential Search](#exponential-search).

---

## 🔍 Detailed Node: Interpolation Search (L3 - Advanced)

1. **Definition**: A searching algorithm for sorted arrays with uniformly distributed values, which estimates the position of the target.
2. **Intuition**: When looking for "Zebediah" in a phonebook, you don't start in the middle; you start near the end.
3. **Theory**: Uses a linear interpolation formula to predict the target's position based on its value relative to the boundaries.
4. **Mathematical Foundation**: $pos = low + \frac{(target - arr[low]) \times (high - low)}{arr[high] - arr[low]}$.
5. **Complexity Analysis**:
   - **Time**: $O(\log \log n)$ (Average for uniform distribution), $O(n)$ (Worst case for non-uniform).
   - **Space**: $O(1)$.
6. **Advantages**: Faster than Binary Search for large, uniformly distributed datasets.
7. **Disadvantages**: Poor performance on non-uniformly distributed data; more complex calculation than BS.
8. **Real World Applications**: Large sorted databases where values follow a known distribution (e.g., timestamps).
9. **Industry Use Cases**: Data retrieval in sensor networks where readings are linear.
10. **Interview Relevance**: **Medium**. Good for demonstrating knowledge of non-standard search optimizations.
11. **Competitive Programming Relevance**: **Low**. Rare, but useful if distribution is guaranteed.
12. **Research Relevance**: Basis for "Adaptive Search" algorithms.
13. **Visual Explanation**: 
    `[10, 20, 30, 40, 50] -> Target: 40`
    `Formula estimates pos=3 directly.`
14. **Pseudocode**:
    ```text
    pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]))
    ```
15. **Java Implementation**: See [InterpolationSearch.java](file:///d:/DSA%20JAVA/DSA-JAVA/InterpolationSearch.java)
16. **Python Implementation**:
    ```python
    def interpolation_search(arr, target):
        low, high = 0, len(arr) - 1
        while low <= high and target >= arr[low] and target <= arr[high]:
            pos = low + int(((float(high - low) / (arr[high] - arr[low])) * (target - arr[low])))
            if arr[pos] == target: return pos
            if arr[pos] < target: low = pos + 1
            else: high = pos - 1
        return -1
    ```
17. **C++ Implementation**:
    ```cpp
    int interpolationSearch(int arr[], int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high && target >= arr[low] && target <= arr[high]) {
            int pos = low + (((double)(high - low) / (arr[high] - arr[low])) * (target - arr[low]));
            if (arr[pos] == target) return pos;
            if (arr[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }
    ```
18. **Common Mistakes**: Not checking if `arr[high] == arr[low]` (division by zero).
19. **Best Practices**: Only use when distribution is known to be uniform.
20. **Practice Problems**: [GFG - Interpolation Search](https://www.geeksforgeeks.org/interpolation-search/).
21. **Advanced Problems**: Hybrid BS-Interpolation algorithms.
22. **Research Papers**: *W. W. Peterson, "Addressing for Random-Access Storage" (1957)*.
23. **Books**: *CLRS*, *The Art of Computer Programming (Knuth)*.
24. **Learning Resources**: [Wikipedia](https://en.wikipedia.org/wiki/Interpolation_search).
25. **Related Topics**: [Binary Search](#binary-search), [Extrapolation Search].
26. **Prerequisites**: [Binary Search](#binary-search), [Linear Interpolation (Math)](#math).
27. **Next Topics to Learn**: [Exponential Search](#exponential-search).

---

## 🔗 Interconnections
- **DSA ↔ Mathematics**: Complexity analysis relies on **Big-O Notation** and **Calculus**.
- **DSA ↔ OS**: Memory management and pointers are crucial for **Linked Lists** and **Trees**.
- **DSA ↔ AI**: **A* Search** and **Heaps** are foundational for pathfinding.

---

## 🚀 Learning Path
1. **Basics**: Arrays, Strings, Complexity.
2. **Intermediate**: Stacks, Queues, Recursion.
3. **Advanced**: DP, Graphs, Segment Trees.

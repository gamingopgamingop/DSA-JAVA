# Naming Conventions

This document establishes the naming standards for all files and classes in the DSA Java project to ensure consistency and maintainability.

## 📋 File Naming Conventions

### Algorithm Implementation Files

### Main Algorithm Files
- **Format**: `PascalCase` with descriptive names
- **Suffix**: Add `Algorithm` for sorting algorithms
- **Examples**:
  - `BinarySearch.java`
  - `BubbleSort.java`
  - `MergeSortAlgorithm.java`
  - `QuickSortAlgorithm.java`

### Test Files
- **Format**: `AlgorithmName_Test.java`
- **Examples**:
  - `BinarySearch_Test.java`
  - `BubbleSort_Test.java`
  - `MergeSortAlgorithm_Test.java`
  - `QuickSortAlgorithm_Test.java`

### Documentation Files
- **Algorithm Documentation**: `AlgorithmName_Documentation.md`
- **Test Documentation**: `AlgorithmName_Test_Documentation.md`
- **Examples**:
  - `BinarySearch_Documentation.md`
  - `BubbleSort_Documentation.md`
  - `MergeSortAlgorithm_Documentation.md`
  - `QuickSortAlgorithm_Documentation.md`

### Test Result Files
- **Format**: `algorithm_name_test_results.txt`
- **Examples**:
  - `binary_search_test_results.txt`
  - `bubble_sort_test_results.txt`
  - `merge_sort_algorithm_test_results.txt`
  - `quick_sort_algorithm_test_results.txt`

## 📝 Class Naming Conventions

### Main Algorithm Classes
- **Format**: `PascalCase` with descriptive names
- **Visibility**: `public` for main classes
- **Examples**:
  - `BinarySearch`
  - `BubbleSort`
  - `MergeSortAlgorithm`
  - `QuickSortAlgorithm`

### Test Classes
- **Format**: `AlgorithmName_Test`
- **Visibility**: `public`
- **Examples**:
  - `BinarySearch_Test`
  - `BubbleSort_Test`
  - `MergeSortAlgorithm_Test`
  - `QuickSortAlgorithm_Test`

### Documentation Classes
- **Format**: `AlgorithmName_Documentation`
- **Visibility**: `public`
- **Examples**:
  - `BinarySearch_Documentation`
  - `BubbleSort_Documentation`
  - `MergeSortAlgorithm_Documentation`
  - `QuickSortAlgorithm_Documentation`

### Data Structure Classes
- **Format**: `PascalCase` with descriptive names
- **Visibility**: `public`
- **Examples**:
  - `LinkedListWithAddresses`
  - `StackOperations`
  - `LinearQueue`
  - `CircularQueue`
  - `DequeOperations`
  - `PriorityQueueOperations`
  - `QueueUsingArray`

### Sample Classes
- **Format**: `PascalCase` with descriptive names
- **Visibility**: `public`
- **Examples**:
  - `Sample`

## 📝 Package Structure

### Current Structure
```
DSA-JAVA/
├── Algorithm Files (PascalCase)
├── Test Files (AlgorithmName_Test.java)
├── Documentation Files (AlgorithmName_Documentation.md)
├── Test Documentation Files (AlgorithmName_Test_Documentation.md)
├── Test Result Files (algorithm_name_test_results.txt)
├── Supporting Files (.gitignore, build.gradle, etc.)
├── docs/ (Documentation directory)
└── .github/ (GitHub workflows)
```

### Future Structure (If Organized by Category)
```
DSA-JAVA/
├── sorting/
│   ├── BinarySearch.java
│   ├── BinarySearch_Test.java
│   ├── BinarySearch_Documentation.md
│   └── BinarySearch_test_results.txt
├── searching/
│   ├── LinearSearch.java
│   ├── LinearSearch_Test.java
│   ├── LinearSearch_Documentation.md
│   └── linear_search_test_results.txt
├── data-structures/
│   ├── LinkedListWithAddresses.java
│   ├── StackOperations.java
│   ├── LinearQueue.java
│   ├── CircularQueue.java
│   ├── DequeOperations.java
│   ├── PriorityQueueOperations.java
│   └── QueueUsingArray.java
│   ├── *_Test.java files
│   └── *_Documentation.md files
│   └── *_test_results.txt files
└── array-operations/
│   ├── InsertElement.java
│   ├── RemoveElement.java
│   ├── Traversal.java
│   *_Test.java files
│   *_Documentation.md files
│   └── *_test_results.txt files
└── matrix-operations/
│   ├── MatrxMultiplication.java
│   ├── SparseMatrix.java
│   *_Test.java files
│   *_Documentation.md files
│   └── *_test_results.txt files
└── sample/
│   ├── Sample.java
│   ├── Sample_Test.java
│   ├── Sample_Documentation.md
│   └── sample_test_results.txt
└── test-framework/
│   ├── TestFramework.java
│   └── Test_Summary_Report.md
│   └── Quality_Assurance.md
└── docs/
│   ├── README.md
│   ├── INDEX.md
│   ├── ALGORITHM_TEMPLATE.md
│   ├── TEST_CASE_MATRIX.md
│   ├── COMPLEXITY_TABLE.md
│   ├── INPUT_OUTPUT_EXAMPLES.md
│   ├── ERROR_HANDLING_GUIDE.md
│   ├── NAMING_CONVENTIONS.md
│   ├── FAQ.md
│   └── LEARNING_PATH.md
│   └── ROADMAP.md
│   └── CONTRIBUTING.md
│   └── CODE_OF_CONDUCT.md
│   └── SECURITY.md
│   └── CHANGELOG.md
└── LICENSE
└── README.md
```

## 📝 File Naming Examples

### Algorithm Files
```
✅ BinarySearch.java
✅ BubbleSort.java
✅ InsertionSort.java
✅ SelectionSort.java
✅ MergeSort.java
✅ QuickSort.java
✅ MergeSortAlgorithm.java
✅ QuickSortAlgorithm.java
```

### Test Files
```
✅ BinarySearch_Test.java
✅ BubbleSort_Test.java
✅ InsertionSort_Test.java
✅ SelectionSort_Test.java
✅ MergeSortAlgorithm_Test.java
✅ QuickSort_Test.java
✅ MergeSortAlgorithm_Test.java
✅ QuickSortAlgorithm_Test.java
```

### Documentation Files
```
✅ BinarySearch_Documentation.md
✅ BubbleSort_Documentation.md
✅ InsertionSort_Documentation.md
✅ SelectionSort_Documentation.md
✅ MergeSort_Documentation.md
✅ QuickSort_Documentation.md
✅ MergeSortAlgorithm_Documentation.md
✅ QuickSortAlgorithm_Documentation.md
```

### Test Result Files
```
✅ binary_search_test_results.txt
✅ bubble_sort_test_results.txt
✅ insertion_sort_test_results.txt
✅ selection_sort_test_results.txt
✅ merge_sort_test_results.txt
✅ quick_sort_test_results.txt
✅ merge_sort_algorithm_test_results.txt
✅ quick_sort_algorithm_test_results.txt
```

## 🔗 Class Naming Examples

### Algorithm Classes
```java
public class BinarySearch {
    // Implementation
}

public class BubbleSort {
    // Implementation
}

public class MergeSortAlgorithm {
    // Implementation
}

public class QuickSortAlgorithm {
    // Implementation
}
```

### Test Classes
```java
public class BinarySearch_Test {
    // Test implementation
}

public class BubbleSort_Test {
    // Test implementation
}

public class MergeSortAlgorithm_Test {
    // Test implementation
}

public class QuickSortAlgorithm_Test {
    // Test implementation
}
```

### Documentation Classes
```java
public class BinarySearch_Documentation {
    // Documentation
}

public class BubbleSort_Documentation {
    // Documentation
}

public class MergeSortAlgorithm_Documentation {
    // Documentation
}

public class QuickSortAlgorithm_Documentation {
    // Documentation
}
```

### Data Structure Classes
```java
public class LinkedListWithAddresses {
    // Implementation
}

public class StackOperations {
    // Implementation
}

public class LinearQueue {
    // Implementation
}

public class CircularQueue {
    // Implementation
}

public class DequeOperations {
    // Implementation
}

public class PriorityQueueOperations {
    // Implementation
}

public class QueueUsingArray {
    // Implementation
}
```

## 📝 Special Cases

### Multiple Algorithm Variants
When multiple variants exist, use descriptive suffixes:
```java
✅ MergeSort.java (basic implementation)
✅ MergeSortAlgorithm.java (enhanced with tracking)
✅ QuickSort.java (basic implementation)
✅ QuickSortAlgorithm.java (enhanced with tracking)
```

### Test Variants
For multiple test files, use descriptive suffixes:
```java
✅ BinarySearch_Basic_Test.java
✅ BinarySearch_Advanced_Test.java
✅ BinarySearch_Performance_Test.java
```

### Documentation Variants
For multiple documentation files, use descriptive suffixes:
```java
✅ BinarySearch_Documentation.md (basic documentation)
✅ BinarySearch_Advanced_Documentation.md (advanced documentation)
✅ BinarySearch_Performance_Documentation.md (performance analysis)
```

## 🔗 Package Structure

### Current Package Structure
```java
// No packages - All classes in root directory
public class BinarySearch { ... }
```

### Future Package Organization
```java
package sorting.algorithms;
public class BinarySearch { ... }

package searching.algorithms;
public class LinearSearch { ... }

package datastructures.linear;
public class LinearQueue { ... }

package datastructures.circular;
public class CircularQueue { ... }
```

## 🔍 Integration with Build System

### Gradle Configuration
```gradle
sourceSets {
    main {
        java {
            src/main/java
        }
    }
}
```

### Maven Configuration
```xml
<build>
    <sourceDirectory>src/main/java</sourceDirectory>
    <testSourceDirectory>src/test/java</testSourceDirectory>
</build>
```

## 🔍 Code Quality Standards

### Class Documentation
```java
/**
 * Binary Search Algorithm Implementation
 * 
 * This class implements the binary search algorithm for searching
 * elements in a sorted array.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * @author DSA Java Project
 * @version 1.0
 */
public class BinarySearch {
    // Implementation
}
```

### Method Documentation
```java
/**
 * Searches for a target element in a sorted array.
 * 
 * @param arr The sorted array to search
 * @param target The target element to find
 * @return Index of target element, or -1 if not found
 * @throws IllegalArgumentException if array is null
 */
public static int binarySearch(int[] arr, int target) {
    // Implementation
}
```

## 🔍 Common Mistakes to Avoid

### File Naming
- ✅ `binarySearch.java` (correct)
- ❌ `binarysearch.java` (incorrect)
- ❌ `BinarySearch.java` (incorrect)
- ❌ `binary_search.java` (incorrect)

### Class Naming
- ✅ `public class BinarySearch` (correct)
- ❌ `public class binarySearch` (incorrect)
- ❌ `public class BinarySearchAlgorithm` (incorrect for search)

### Test Naming
- ✅ `BinarySearch_Test.java` (correct)
- ❌ `BinarySearchTest.java` (incorrect)
- ❌ `BinarySearch_Test.java` (incorrect)

### Documentation Naming
- ✅ `BinarySearch_Documentation.md` (correct)
- ❌ `BinarySearch_Documentation.md` (incorrect)
- ❌ `binary_search_documentation.md` (incorrect)

## 🔍 Validation Tools

### Automated Checks
```bash
# Check file naming conventions
find . -name "*.java" | grep -E "^[A-Z][a-z]*[A-Z]*$"

# Check for duplicate names
find . -name "*.java" | sort | uniq -d

# Check for proper test file naming
find . -name "*_Test.java" | wc -l
```

### IDE Configuration
```java
# IDE Naming Convention
# Settings > Style > Java > Code Style > Names
# Class Names: PascalCase
# Method Names: camelCase
# Variable Names: camelCase
```

## 🔗 Migration Guidelines

### When Renaming Files
1. **Backup**: Create backup before renaming
2. **Update References**: Update all import statements
3. **Update Documentation**: Update all documentation links
4. **Test**: Update test file names
5. **Commit**: Commit changes with descriptive message

### Batch Renaming
```bash
# Rename multiple files
for file in *_Test.java; do
    mv "$file" "${file%.java"
done
```

## 🔗 Version Control

### File Versioning
- Use descriptive names that reflect the algorithm
- Include version numbers for algorithm variants
- Maintain backward compatibility where possible

### Documentation Updates
- Update all cross-references when renaming
- Update table of contents in documentation
- Update examples in documentation files

---

## 🔗 Related Documents

### Core Documentation
- [README.md](../README.md)
- [Contributing Guide](../CONTRIBUTING.md)
- [Code of Conduct](../CODE_OF_CONDUCT.md)
- [Security Policy](../SECURITY.md)

### Reference Documents
- [Algorithm Template](ALGORITHM_CONVENTIONS.md)
- [Test Case Matrix](TEST_CASE_MATRIX.md)
- [Complexity Table](COMPLEXITY_TABLE.md)
- [Input Output Examples](INPUT_OUTPUT_EXAMPLES.md)
- [FAQ](FAQ.md)

---

*This naming conventions document is continuously updated to reflect the current state of the DSA Java project. Last updated: April 25, 2025*

---

*For questions about naming conventions or to suggest improvements, please refer to the [Contributing Guide](../CONTRIBUTING.md) or create an issue in the project repository.*

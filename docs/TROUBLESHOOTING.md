# Troubleshooting Guide

This guide addresses common issues, errors, and problems you might encounter while working with the DSA Java algorithms and their implementations.

## 🚨 Common Compilation Issues

### Java Compilation Errors

#### Issue: "javac: command not found"
**Symptoms**: Command not found error when trying to compile
**Causes**: Java not installed or not in PATH
**Solutions**:
```bash
# Check if Java is installed
java -version

# If not installed, install Java (Windows)
# Download from: https://www.oracle.com/java/technologies/downloads/

# Add Java to PATH (Windows)
set PATH=%PATH%;C:\Program Files\Java\jdk-XX\bin

# Verify installation
javac -version
```

#### Issue: "package javax.swing does not exist"
**Symptoms**: Compilation fails with package not found errors
**Causes**: Using JavaFX/Swing without proper imports
**Solutions**:
```java
// Remove or replace Swing imports
// Use console I/O instead of GUI components
import java.util.Scanner;  // Instead of javax.swing
```

#### Issue: "cannot find symbol: variable scanner"
**Symptoms**: Variable not found errors
**Causes**: Scanner not declared or imported
**Solutions**:
```java
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Declare scanner
        // Use scanner...
        scanner.close();  // Close scanner
    }
}
```

## 🔧 Runtime Issues

### Input/Output Problems

#### Issue: "InputMismatchException"
**Symptoms**: Program crashes when entering invalid input
**Causes**: Mismatch between expected and actual input type
**Solutions**:
```java
// Add input validation
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");

try {
    int number = scanner.nextInt();
    // Process number
} catch (InputMismatchException e) {
    System.out.println("Please enter a valid number!");
    // Handle error
}
```

#### Issue: "NoSuchElementException"
**Symptoms**: Program crashes when no input available
**Causes**: Trying to read from empty input stream
**Solutions**:
```java
// Check if input is available
Scanner scanner = new Scanner(System.in);
if (scanner.hasNextInt()) {
    int number = scanner.nextInt();
} else {
    System.out.println("No input available!");
}
```

#### Issue: "ArrayIndexOutOfBoundsException"
**Symptoms**: Program crashes with array index error
**Causes**: Accessing array outside bounds
**Solutions**:
```java
// Add bounds checking
int[] array = {1, 2, 3, 4, 5};
int index = 5;  // Out of bounds

if (index >= 0 && index < array.length) {
    System.out.println(array[index]);
} else {
    System.out.println("Index out of bounds!");
}
```

## 📊 Algorithm-Specific Issues

### Binary Search Problems

#### Issue: Binary Search Returns -1 for Existing Element
**Symptoms**: Search fails even when element exists
**Causes**: Array not sorted or incorrect implementation
**Solutions**:
```java
// Ensure array is sorted first
Arrays.sort(array);

// Verify binary search implementation
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

#### Issue: Infinite Loop in Binary Search
**Symptoms**: Program hangs during binary search
**Causes**: Incorrect loop condition or mid calculation
**Solutions**:
```java
// Correct loop condition
while (left <= right) {  // Not left < right
    
// Correct mid calculation
int mid = left + (right - left) / 2;  // Prevents overflow
```

### Sorting Algorithm Issues

#### Issue: Bubble Sort Doesn't Sort
**Symptoms**: Array remains unsorted after bubble sort
**Causes**: Incorrect loop bounds or comparison
**Solutions**:
```java
// Correct bubble sort implementation
for (int i = 0; i < n - 1; i++) {           // Outer loop
    for (int j = 0; j < n - i - 1; j++) {   // Inner loop
        if (arr[j] > arr[j + 1]) {           // Correct comparison
            // Swap elements
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```

#### Issue: Quick Sort Stack Overflow
**Symptoms**: StackOverflowError with large arrays
**Causes**: Worst-case partitioning (already sorted array)
**Solutions**:
```java
// Use random pivot selection
Random random = new Random();
int pivotIndex = left + random.nextInt(right - left + 1);
swap(arr, pivotIndex, right);

// Or use median-of-three
int mid = left + (right - left) / 2;
if (arr[left] > arr[mid]) swap(arr, left, mid);
if (arr[left] > arr[right]) swap(arr, left, right);
if (arr[mid] > arr[right]) swap(arr, mid, right);
swap(arr, mid, right);
```

### Data Structure Issues

#### Issue: Queue Shows "Full" When Not Actually Full
**Symptoms**: Linear queue reports full with empty space
**Causes**: Front pointer has moved forward
**Solutions**:
```java
// Use circular queue instead
class CircularQueue {
    int[] arr;
    int front, rear, size;
    
    boolean isFull() {
        return (rear + 1) % size == front;
    }
    
    boolean isEmpty() {
        return front == -1;
    }
}
```

#### Issue: Linked List NullPointerException
**Symptoms**: NPE when traversing linked list
**Causes**: Null pointer in next reference
**Solutions**:
```java
// Add null checks
void traverse(Node head) {
    Node current = head;
    while (current != null) {
        System.out.println(current.data);
        current = current.next;  // Will be null at end
        if (current == null) break;  // Safety check
    }
}
```

## 🔍 Performance Issues

### Slow Algorithm Performance

#### Issue: Algorithm Too Slow for Large Datasets
**Symptoms**: Program takes very long with large inputs
**Causes**: Using O(n²) algorithm for large data
**Solutions**:
```java
// Replace O(n²) with O(n log n) algorithm
// Instead of Bubble Sort for large arrays:
Arrays.sort(array);  // Uses optimized algorithms

// Instead of Linear Search for sorted data:
int index = Arrays.binarySearch(array, target);
```

#### Issue: Memory Usage Too High
**Symptoms**: OutOfMemoryError with large datasets
**Causes**: Inefficient memory usage
**Solutions**:
```java
// Use more memory-efficient algorithms
// Instead of creating many temporary arrays:
int[] result = new int[input.length];  // Single result array

// Process data in chunks
int chunkSize = 1000;
for (int i = 0; i < data.length; i += chunkSize) {
    processChunk(data, i, Math.min(i + chunkSize, data.length));
}
```

## 🛠️ Environment Setup Issues

### IDE Configuration Problems

#### Issue: IDE Doesn't Recognize Java Files
**Symptoms**: IDE shows errors for valid Java code
**Causes**: Incorrect project configuration
**Solutions**:
```bash
# For VS Code:
# Install Extension Pack for Java
# Set Java home correctly

# For IntelliJ:
# File → Project Structure → SDKs → Add JDK
# Ensure project SDK is set

# For Eclipse:
# Window → Preferences → Java → Installed JREs
# Add and select appropriate JRE
```

#### Issue: Classpath Issues
**Symptoms**: NoClassDefFoundError or ClassNotFoundException
**Causes**: Classpath not set correctly
**Solutions**:
```bash
# Set classpath (Windows)
set CLASSPATH=%CLASSPATH%;.

# Compile with classpath
javac -cp . MyProgram.java

# Run with classpath
java -cp . MyProgram

# For packages
javac -cp . com/example/MyProgram.java
java -cp . com.example.MyProgram
```

### Build System Issues

#### Issue: Gradle Build Fails
**Symptoms**: Build fails with dependency errors
**Causes**: Incorrect Gradle configuration
**Solutions**:
```gradle
// build.gradle
plugins {
    id 'java'
    id 'application'
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
}

application {
    mainClass = 'YourMainClass'
}
```

#### Issue: JUnit Tests Not Found
**Symptoms**: Test runner can't find tests
**Causes**: Incorrect test class naming or structure
**Solutions**:
```java
// Ensure test class follows naming convention
public class YourAlgorithm_Test {
    
    @Test
    public void testBasicFunctionality() {
        // Test implementation
    }
}

// Place test files in correct directory
// src/test/java/YourAlgorithm_Test.java
```

## 📋 Input Format Issues

### Common Input Format Problems

#### Issue: Scanner Reads Wrong Input Type
**Symptoms**: Program reads wrong values or crashes
**Causes**: Input format mismatch
**Solutions**:
```java
// Clear scanner buffer
Scanner scanner = new Scanner(System.in);
int number = scanner.nextInt();
scanner.nextLine();  // Clear newline
String text = scanner.nextLine();  // Now read text

// Or use robust input reading
public static int readInt(Scanner scanner) {
    while (true) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number:");
            scanner.next();  // Clear invalid input
        }
    }
}
```

#### Issue: Multiple Numbers on Same Line
**Symptoms**: Only first number read from line
**Causes**: Scanner reading only one token
**Solutions**:
```java
// Read entire line then split
String line = scanner.nextLine();
String[] numbers = line.split("\\s+");
int[] array = new int[numbers.length];

for (int i = 0; i < numbers.length; i++) {
    array[i] = Integer.parseInt(numbers[i]);
}
```

## 🐛 Debugging Tips

### General Debugging Strategies

#### 1. Add Debug Output
```java
// Add print statements to trace execution
System.out.println("Debug: Variable x = " + x);
System.out.println("Debug: Array length = " + arr.length);
System.out.println("Debug: Loop iteration i = " + i);
```

#### 2. Use Assertions
```java
// Add assertions to verify assumptions
assert arr != null : "Array should not be null";
assert index >= 0 && index < arr.length : "Index out of bounds";
```

#### 3. Step-by-Step Testing
```java
// Test with known inputs
int[] testArray = {5, 2, 8, 1, 9};
int target = 8;
int result = binarySearch(testArray, target);
System.out.println("Expected: 3, Got: " + result);
```

#### 4. Isolate Problem
```java
// Create minimal test case
public void testMinimalCase() {
    int[] array = {1, 2, 3};  // Simple case
    int result = algorithm(array);
    System.out.println("Result: " + result);
}
```

## 📞 Getting Help

### When to Ask for Help

#### ✅ Before Asking for Help:
1. **Search existing documentation**: Check [FAQ.md](FAQ.md) and algorithm docs
2. **Try the solutions above**: Apply relevant troubleshooting steps
3. **Create minimal example**: Isolate the problem
4. **Gather error messages**: Copy full error output
5. **Describe environment**: Java version, OS, IDE details

#### ❌ Don't Ask For Help When:
- You haven't tried the solutions above
- You haven't read the relevant documentation
- You don't provide enough context
- You don't show what you've already tried

### How to Report Issues Effectively

#### Good Issue Report:
```
Problem: Binary search returns -1 for existing element

Environment:
- Java 17
- Windows 11
- VS Code

Code:
int[] array = {1, 3, 5, 7, 9};
int result = binarySearch(array, 5);
System.out.println("Result: " + result);  // Prints -1, should print 2

Expected: 2
Actual: -1

What I tried:
- Verified array is sorted
- Checked implementation against documentation
- Tested with different arrays
```

#### Poor Issue Report:
```
My code doesn't work. Help!
```

## 🔧 Quick Fixes Summary

| Problem | Quick Fix |
|---------|-----------|
| **Compilation error** | Check Java installation and imports |
| **Input error** | Add input validation and error handling |
| **Array bounds error** | Add bounds checking |
| **Performance issue** | Use more efficient algorithm |
| **Memory error** | Process data in chunks |
| **Logic error** | Add debug output and test cases |
| **Environment issue** | Check IDE configuration and classpath |

---

## 🔗 Related Resources

- **[FAQ](FAQ.md)** - Common questions and answers
- **[Error Handling Guide](ERROR_HANDLING_GUIDE.md)** - Comprehensive error strategies
- **[Algorithm Documentation](algorithms/)** - Algorithm-specific troubleshooting
- **[Test Documentation](testing/)** - Test-related issues
- **[Style Guide](STYLE_GUIDE.md)** - Code style and formatting

---

*This troubleshooting guide covers the most common issues. For specific algorithm problems, refer to individual algorithm documentation.*

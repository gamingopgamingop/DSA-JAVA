# StackOperations Test Documentation

## Overview

The `StackOperations_Test.java` file provides comprehensive testing and validation for stack operations and algorithms. This test suite ensures correctness, performance, and robustness of stack implementations across various scenarios and data patterns.

## Algorithm Summary

**Stack Operations**: A collection of operations for stack data structure (LIFO - Last In First Out), including push, pop, peek, and various stack-based algorithms.
- **Time Complexity**: O(1) for basic operations, O(n) for search
- **Space Complexity**: O(n) where n is the number of elements
- **Structure**: LIFO (Last In First Out)
- **Applications**: Function calls, undo/redo, expression evaluation

## Test Coverage

### 1. Basic Functionality Tests
**Purpose**: Validate core stack behavior
- **Test Methods**: `testBasicFunctionality()`
- **Coverage**:
  - Push operations
  - Pop operations
  - Peek operations
  - Size and empty checks
  - Stack integrity verification

### 2. CRUD Operations Tests
**Purpose**: Test Create, Read, Update, Delete operations
- **Test Methods**: `testCRUDOperations()`
- **Coverage**:
  - Create operations (push elements)
  - Read operations (peek, size, isEmpty)
  - Update operations (pop and push combinations)
  - Delete operations (pop elements)

### 3. Edge Case Tests
**Purpose**: Handle boundary conditions and exceptional scenarios
- **Test Methods**: `testEdgeCases()`
- **Coverage**:
  - Empty stack operations
  - Single element stack
  - Stack overflow scenarios
  - Stack underflow scenarios
  - Null value handling
  - Maximum capacity testing

### 4. Performance Tests
**Purpose**: Measure and analyze algorithm performance
- **Test Methods**: `testPerformance()`
- **Coverage**:
  - Different data sizes (1000, 10000, 100000, 1000000)
  - Execution time measurement
  - Operation counting
  - Scalability assessment
  - Memory efficiency analysis

### 5. Stack Algorithms Tests
**Purpose**: Test stack-based algorithms
- **Test Methods**: `testStackAlgorithms()`
- **Coverage**:
  - Palindrome checking
  - Balanced parentheses validation
  - Postfix expression evaluation
  - Infix to postfix conversion
  - Expression evaluation

### 6. Large Dataset Tests
**Purpose**: Validate with substantial data volumes
- **Test Methods**: `testLargeDataset()`
- **Coverage**:
  - 1,000,000 element stacks
  - Performance measurement
  - Memory efficiency analysis
  - Operation scalability
  - Stress testing

### 7. Memory Efficiency Tests
**Purpose**: Analyze memory usage patterns
- **Test Methods**: `testMemoryEfficiency()`
- **Coverage**:
  - Memory usage per element
  - Total memory consumption
  - Memory leak detection
  - Garbage collection impact
  - Space complexity validation

### 8. Advanced Operations Tests
**Purpose**: Test complex stack operations
- **Test Methods**: `testAdvancedOperations()`
- **Coverage**:
  - Stack reversal
  - Stack sorting
  - Stack copying
  - Stack merging
  - Recursive operations

### 9. Thread Safety Tests
**Purpose**: Test concurrent operation safety
- **Test Methods**: `testThreadSafety()`
- **Coverage**:
  - Concurrent push operations
  - Concurrent pop operations
  - Synchronization requirements
  - Race condition detection
  - Thread safety validation

### 10. Different Data Types Tests
**Purpose**: Validate compatibility with various data types
- **Test Methods**: `testDifferentDataTypes()`
- **Coverage**:
  - Integer stacks
  - String stacks
  - Double stacks
  - Custom object stacks
  - Mixed data types

### 11. Stack Implementations Tests
**Purpose**: Compare different stack implementations
- **Test Methods**: `testStackImplementations()`
- **Coverage**:
  - Java Stack class
  - Deque as Stack
  - LinkedList as Stack
  - Vector as Stack
  - Performance comparison

### 12. Stack Applications Tests
**Purpose**: Test real-world stack applications
- **Test Methods**: `testStackApplications()`
- **Coverage**:
  - Function call simulation
  - Undo/redo operations
  - Browser history
  - Expression evaluation
  - Algorithm applications

## Test Implementation Details

### Test Structure
```java
public class StackOperations_Test {
    private static final String TEST_RESULTS_FILE = "stack_operations_test_results.txt";
    private static PrintStream writer;
    
    public static void main(String[] args) {
        // Test execution framework
        // Result generation and reporting
    }
}
```

### Key Features

#### Operation Testing
- **Push Operations**: Element insertion
- **Pop Operations**: Element removal
- **Peek Operations**: Top element access
- **Size Operations**: Stack size management
- **Empty Operations**: Empty state checking

#### Performance Measurement
- **Nanosecond precision timing**
- **Operation counting**
- **Memory usage monitoring**
- **Scalability analysis**
- **Implementation comparison**

#### Algorithm Testing
- **Palindrome Detection**: String reversal
- **Balanced Parentheses**: Expression validation
- **Expression Evaluation**: Postfix/infix processing
- **Stack Applications**: Real-world scenarios

## Performance Analysis

### Time Complexity Validation
- **Push**: O(1) amortized (may occasionally resize)
- **Pop**: O(1) - Constant time
- **Peek**: O(1) - Constant time
- **Search**: O(n) - Linear search through stack
- **Size**: O(1) - Constant time

### Space Complexity
- **Per Element**: O(1) - Element storage
- **Total**: O(n) - Linear with number of elements
- **Auxiliary**: O(1) for most operations

### Performance Metrics
| Data Size | Push (ms) | Pop (ms) | Peek (ms) | Search (ms) | Memory (KB) |
|-----------|-----------|----------|-----------|-------------|-------------|
| 1,000 | ~0.001 | ~0.001 | ~0.0001 | ~0.01 | ~8 |
| 10,000 | ~0.01 | ~0.01 | ~0.001 | ~0.1 | ~80 |
| 100,000 | ~0.1 | ~0.1 | ~0.01 | ~1.0 | ~800 |
| 1,000,000 | ~1.0 | ~1.0 | ~0.1 | ~10.0 | ~8000 |

## Core Operations

### Basic Stack Operations
```java
// Push operation
public void push(E element) {
    elements.add(element);
}

// Pop operation
public E pop() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    return elements.remove(elements.size() - 1);
}

// Peek operation
public E peek() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    return elements.get(elements.size() - 1);
}

// Size operation
public int size() {
    return elements.size();
}

// Empty check
public boolean isEmpty() {
    return elements.isEmpty();
}
```

### Stack Algorithms
```java
// Palindrome checking
public static boolean isPalindrome(String str) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : str.toCharArray()) {
        stack.push(c);
    }
    
    for (char c : str.toCharArray()) {
        if (stack.pop() != c) {
            return false;
        }
    }
    
    return true;
}

// Balanced parentheses
public static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : expression.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (stack.isEmpty()) {
                return false;
            }
            
            char top = stack.pop();
            if (!isMatchingPair(top, c)) {
                return false;
            }
        }
    }
    
    return stack.isEmpty();
}

// Postfix evaluation
public static int evaluatePostfix(String expression) {
    Stack<Integer> stack = new Stack<>();
    String[] tokens = expression.split("\\s+");
    
    for (String token : tokens) {
        if (isNumeric(token)) {
            stack.push(Integer.parseInt(token));
        } else {
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            int result = performOperation(token.charAt(0), operand1, operand2);
            stack.push(result);
        }
    }
    
    return stack.pop();
}
```

## Edge Case Handling

### Empty Stack
```java
Stack<Integer> stack = new Stack<>();
stack.peek();
// Expected: EmptyStackException
```

### Single Element
```java
Stack<Integer> stack = new Stack<>();
stack.push(42);
int value = stack.pop();
// Expected: value = 42, stack becomes empty
```

### Stack Overflow
```java
Stack<Integer> stack = new Stack<>();
for (int i = 0; i < Integer.MAX_VALUE; i++) {
    stack.push(i);
}
// Expected: OutOfMemoryError
```

## Error Handling

### Empty Stack Operations
- **Exception**: EmptyStackException
- **Behavior**: Graceful error reporting
- **Validation**: Empty state checking

### Null Value Handling
- **Behavior**: Allow null values (depends on implementation)
- **Validation**: Null checking
- **Recovery**: Safe default behavior

### Memory Overflow
- **Detection**: OutOfMemoryError
- **Behavior**: Graceful degradation
- **Reporting**: Memory usage analysis

## Usage Examples

### Basic Operations
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);
int top = stack.peek(); // Returns 30
int value = stack.pop(); // Returns 30
int size = stack.size(); // Returns 2
```

### Algorithm Applications
```java
// Palindrome check
boolean isPalindrome = isPalindrome("racecar");

// Balanced parentheses
boolean isBalanced = isBalanced("{[()]}");

// Postfix evaluation
int result = evaluatePostfix("3 4 + 2 * 7 /");
```

### Advanced Operations
```java
Stack<Integer> stack = new Stack<>();
// Build stack
Stack<Integer> reversed = reverseStack(stack);
Stack<Integer> sorted = sortStack(stack);
```

## Integration with Main Algorithm

### Test Dependencies
- **StackOperations.java**: Main algorithm implementation
- **Test Framework**: Unified testing infrastructure
- **Performance Utilities**: Benchmarking tools

### Validation Points
- **Operation Correctness**: Proper stack operations
- **Performance Metrics**: Time and space complexity validation
- **Algorithm Accuracy**: Stack-based algorithm correctness
- **Edge Case Handling**: Boundary condition validation

## Best Practices Demonstrated

### Testing Methodology
- **Comprehensive Coverage**: All operations tested
- **Performance Focus**: Efficiency measurement
- **Algorithm Testing**: Stack-based algorithms
- **Edge Case Emphasis**: Boundary condition testing

### Code Quality
- **Clear Documentation**: Well-commented test methods
- **Modular Design**: Separate test concerns
- **Reusable Components**: Utility methods for common tasks
- **Maintainable Structure**: Easy to extend and modify

## Educational Value

### Learning Objectives
- **Stack Understanding**: LIFO data structure
- **Algorithm Implementation**: Stack-based algorithms
- **Performance Analysis**: Time and space complexity
- **Real-world Applications**: Practical stack usage

### Key Concepts Covered
- **LIFO Principle**: Last In First Out
- **Stack Applications**: Function calls, expression evaluation
- **Algorithm Design**: Stack-based problem solving
- **Data Structure Selection**: When to use stacks

## Troubleshooting Guide

### Common Issues
1. **Stack Underflow**: Pop from empty stack
2. **Stack Overflow**: Exceed memory limits
3. **Performance Issues**: O(n) search operations
4. **Thread Safety**: Concurrent access issues

### Solutions
- **Empty Checking**: Validate before operations
- **Memory Management**: Monitor stack size
- **Performance Optimization**: Use appropriate data structures
- **Synchronization**: Thread-safe implementations

## Algorithm Comparison

### Stack Implementations
| Implementation | Thread Safe | Performance | Memory | Best Use Case |
|---------------|-------------|-------------|--------|---------------|
| Stack | Yes | Moderate | O(n) | Legacy code |
| ArrayDeque | No | Fast | O(n) | General purpose |
| LinkedList | No | Moderate | O(n) | Frequent insertions |
| Vector | Yes | Moderate | O(n) | Synchronized needed |

## Advanced Features

### Stack Reversal
```java
public static <T> Stack<T> reverseStack(Stack<T> original) {
    Stack<T> reversed = new Stack<>();
    
    while (!original.isEmpty()) {
        reversed.push(original.pop());
    }
    
    return reversed;
}
```

### Stack Sorting
```java
public static Stack<Integer> sortStack(Stack<Integer> unsorted) {
    Stack<Integer> sorted = new Stack<>();
    
    while (!unsorted.isEmpty()) {
        int temp = unsorted.pop();
        
        while (!sorted.isEmpty() && sorted.peek() > temp) {
            unsorted.push(sorted.pop());
        }
        
        sorted.push(temp);
    }
    
    return sorted;
}
```

### Stack Copy
```java
public static <T> Stack<T> copyStack(Stack<T> original) {
    Stack<T> copy = new Stack<>();
    
    // Create a temporary stack to preserve order
    Stack<T> temp = new Stack<>();
    while (!original.isEmpty()) {
        temp.push(original.pop());
    }
    
    // Copy to new stack
    while (!temp.isEmpty()) {
        T element = temp.pop();
        copy.push(element);
        original.push(element);
    }
    
    return copy;
}
```

### Expression Evaluation
```java
public static int evaluateInfix(String expression) {
    Stack<Integer> stack = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    for (int i = 0; i < expression.length(); i++) {
        char c = expression.charAt(i);
        
        if (Character.isDigit(c)) {
            int num = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            i--;
            stack.push(num);
        } else if (c == '(') {
            operators.push(c);
        } else if (c == ')') {
            while (!operators.isEmpty() && operators.peek() != '(') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                char op = operators.pop();
                stack.push(performOperation(op, operand1, operand2));
            }
            operators.pop(); // Remove '('
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                char op = operators.pop();
                stack.push(performOperation(op, operand1, operand2));
            }
            operators.push(c);
        }
    }
    
    while (!operators.isEmpty()) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        char op = operators.pop();
        stack.push(performOperation(op, operand1, operand2));
    }
    
    return stack.pop();
}
```

## Visualization Features

### Stack Display
```java
public void display() {
    System.out.println("Stack (top to bottom):");
    for (int i = elements.size() - 1; i >= 0; i--) {
        System.out.println(elements.get(i));
    }
}
```

### Debug Information
```java
public void debug() {
    System.out.println("Stack Debug Information:");
    System.out.println("Size: " + size());
    System.out.println("Is Empty: " + isEmpty());
    if (!isEmpty()) {
        System.out.println("Top Element: " + peek());
    }
    System.out.println("Elements: " + elements);
}
```

## Conclusion

The `StackOperations_Test.java` file provides a comprehensive testing framework that validates stack operations and algorithms. The test suite covers all critical aspects of the stack data structure, from basic operations to advanced algorithms, ensuring reliable and efficient stack implementation validation with extensive real-world applications.

## Related Files

- **StackOperations.java**: Main algorithm implementation
- **TestFramework.java**: Master testing infrastructure
- **StackOperations_Documentation.md**: Algorithm documentation
- **stack_operations_test_results.txt**: Generated test results

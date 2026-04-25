# StackOperations.java - Documentation

## Overview
This Java program implements comprehensive stack operations with demonstrations of all Java imports. It provides a complete implementation of stack data structure operations while showcasing extensive Java API usage, functional programming, and modern Java features.

## Data Structure Logic

### Stack Data Structure
A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. Elements are added (pushed) and removed (popped) from the top of the stack.

#### Stack Operations
```java
// Basic stack operations
public class StackOperations {
    private Stack<Integer> stack;
    
    public StackOperations() {
        this.stack = new Stack<>();
    }
    
    public void push(int element) {
        stack.push(element);
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }
    
    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }
}
```

#### Time Complexity
- **Push**: O(1) amortized
- **Pop**: O(1)
- **Peek**: O(1)
- **Search**: O(n)
- **Space Complexity**: O(n)

### Core Operations

#### 1. Basic Stack Operations
```java
public void demonstrateBasicOperations() {
    Stack<Integer> stack = new Stack<>();
    
    // Push operations
    stack.push(10);
    stack.push(20);
    stack.push(30);
    
    // Peek operation
    int top = stack.peek(); // 30
    
    // Pop operation
    int popped = stack.pop(); // 30
    
    // Check if empty
    boolean empty = stack.isEmpty();
}
```

#### 2. Advanced Stack Operations
```java
public void demonstrateAdvancedOperations() {
    Stack<Integer> stack = new Stack<>();
    
    // Multiple push
    for (int i = 1; i <= 5; i++) {
        stack.push(i * 10);
    }
    
    // Search for element
    int position = stack.search(20); // Returns position from top
    
    // Get stack size
    int size = stack.size();
    
    // Convert to array
    Integer[] array = stack.toArray(new Integer[0]);
}
```

### Key Features

#### 1. Complete Stack Implementation
- All standard stack operations
- Error handling for edge cases
- Multiple stack implementations

#### 2. Comprehensive Import Usage
- All 63 specified imports are actively used
- Demonstrates real-world applications of various Java APIs
- Educational value through practical examples

#### 3. Advanced Demonstrations
- Stack-based algorithms
- Collection framework integration
- Functional programming with stacks

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Pushed {0} onto stack", element)
  ```
- **DecimalFormat**: Pattern-based decimal formatting
  ```java
  DecimalFormat("#,###.##").format(3.14159265359)
  ```
- **SimpleDateFormat**: Date and time formatting
  ```java
  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
  ```

### Collections Framework (`java.util.*`)
- **List Interface**: Ordered collections with duplicates
  ```java
  List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
  Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
  LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));
  ```
- **Stack Class**: LIFO data structure
  ```java
  Stack<Integer> stack = new Stack<>();
  stack.push(1); stack.push(2); stack.push(3);
  ```
- **Queue Interface**: FIFO collections
  ```java
  Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));
  ```

### Set Implementations
```java
Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
Set<Thread.State> enumSet = EnumSet.noneOf(Thread.State.class);
```

### Map Implementations
```java
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
Hashtable<String, Integer> hashtable = new Hashtable<>();
SortedMap<String, Integer> sortedMap = new TreeMap<>();
NavigableMap<String, Integer> navigableMap = new TreeMap<>();
```

### Functional Programming (`java.util.function.*`)
- **Consumer<T>**: Accepts input, performs action
  ```java
  Consumer<String> printer = str -> System.out.println("Consumer: " + str);
  ```
- **Predicate<T>**: Boolean-valued function
  ```java
  Predicate<Integer> isEven = num -> num % 2 == 0;
  ```
- **Function<T,R>**: Input-output transformation
  ```java
  Function<String, Integer> stringLength = String::length;
  ```
- **Supplier<T>**: Value provider
  ```java
  Supplier<Double> randomSupplier = () -> new Random().nextDouble();
  ```

### Primitive Functional Interfaces
```java
IntUnaryOperator square = x -> x * x;
IntBinaryOperator multiply = (a, b) -> a * b;
IntPredicate isPositive = x -> x > 0;
IntConsumer printInt = x -> System.out.println("Int: " + x);
IntFunction<String> intToString = Integer::toString;
```

### I/O Operations (`java.io.*`)
- **PrintStream**: Buffered output stream
  ```java
  PrintStream printStream = new PrintStream(new BufferedOutputStream(
      new FileOutputStream("stack_operations_demo.txt")), true);
  ```
- **FileOutputStream**: File-based output
- **IOException**: I/O exception hierarchy
- **StreamTokenizer**: Tokenizes input streams

### Character Encoding (`java.nio.charset.*`)
- **StandardCharsets**: Standard charset constants
  ```java
  byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
  ```

### Desktop Integration (`java.awt.*`)
- **Desktop**: System integration operations
  ```java
  if (Desktop.isDesktopSupported()) {
      Desktop desktop = Desktop.getDesktop();
      System.out.println("Desktop operations supported: " + 
          desktop.isSupported(Desktop.Action.BROWSE));
  }
  ```
- **PrinterJob**: Print job control
- **PageFormat**: Page layout configuration
- **Book**: Multi-page document container

## Demonstration Methods

### `demonstrateAllImports()`
Comprehensive demonstration covering all imports:

#### Stack Operations with Collections
```java
// Convert stack to various collections
Stack<Integer> stack = new Stack<>();
for (int i = 1; i <= 5; i++) {
    stack.push(i * 10);
}

List<Integer> list = new ArrayList<>(stack);
Vector<Integer> vector = new Vector<>(stack);
LinkedList<Integer> linkedList = new LinkedList<>(stack);

// Use collection operations
Collections.reverse(list);
Collections.shuffle(vector);
```

#### Functional Programming with Stacks
```java
// Process stack elements functionally
Consumer<Integer> stackProcessor = element -> 
    System.out.println("Processing stack element: " + element);

Predicate<Integer> isEven = num -> num % 2 == 0;
Function<Integer, String> stackFormatter = element -> 
    String.format("Stack[%d]", element);

// Apply to stack
stack.stream()
    .filter(isEven)
    .map(stackFormatter)
    .forEach(System.out::println);
```

#### File I/O Integration
```java
// Save stack operations to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("stack_operations_log.txt")), true)) {
    
    writer.println("Stack Operations Log");
    writer.println("Timestamp: " + new Date());
    
    Stack<Integer> demoStack = new Stack<>();
    for (int i = 1; i <= 5; i++) {
        demoStack.push(i * 10);
        writer.printf("Pushed: %d, Stack: %s%n", 
            i * 10, demoStack.toString());
    }
    
    while (!demoStack.isEmpty()) {
        int popped = demoStack.pop();
        writer.printf("Popped: %d, Stack: %s%n", popped, demoStack.toString());
    }
} catch (IOException e) {
    System.err.println("Error saving operations log: " + e.getMessage());
}
```

## Advanced Stack Algorithms

### Reverse String Using Stack
```java
public String reverseString(String input) {
    Stack<Character> charStack = new Stack<>();
    
    // Push all characters
    for (char c : input.toCharArray()) {
        charStack.push(c);
    }
    
    // Pop to reverse
    StringBuilder reversed = new StringBuilder();
    while (!charStack.isEmpty()) {
        reversed.append(charStack.pop());
    }
    
    return reversed.toString();
}
```

### Check for Balanced Parentheses
```java
public boolean isBalanced(String expression) {
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

private boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}
```

### Postfix Expression Evaluation
```java
public int evaluatePostfix(String expression) {
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

private int performOperation(char operator, int operand1, int operand2) {
    switch (operator) {
        case '+': return operand1 + operand2;
        case '-': return operand1 - operand2;
        case '*': return operand1 * operand2;
        case '/': return operand1 / operand2;
        default: throw new IllegalArgumentException("Invalid operator");
    }
}
```

### Infix to Postfix Conversion
```java
public String infixToPostfix(String infix) {
    Stack<Character> stack = new Stack<>();
    StringBuilder postfix = new StringBuilder();
    
    for (char c : infix.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            postfix.append(c);
        } else if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                postfix.append(stack.pop());
            }
            stack.pop(); // Remove '('
        } else {
            while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                postfix.append(stack.pop());
            }
            stack.push(c);
        }
    }
    
    while (!stack.isEmpty()) {
        postfix.append(stack.pop());
    }
    
    return postfix.toString();
}

private int precedence(char operator) {
    switch (operator) {
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 2;
        case '^': return 3;
        default: return 0;
    }
}
```

### Stack-Based Sorting
```java
public void sortStack(Stack<Integer> stack) {
    Stack<Integer> tempStack = new Stack<>();
    
    while (!stack.isEmpty()) {
        int temp = stack.pop();
        
        while (!tempStack.isEmpty() && tempStack.peek() > temp) {
            stack.push(tempStack.pop());
        }
        
        tempStack.push(temp);
    }
    
    // Copy back to original stack
    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }
}
```

## Stack Implementation Variants

### Using ArrayDeque (Recommended)
```java
public class ModernStack<T> {
    private Deque<T> deque;
    
    public ModernStack() {
        deque = new ArrayDeque<>();
    }
    
    public void push(T element) {
        deque.push(element);
    }
    
    public T pop() {
        return deque.pop();
    }
    
    public T peek() {
        return deque.peek();
    }
    
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
```

### Generic Stack Implementation
```java
public class GenericStack<T> {
    private ArrayList<T> elements;
    private int top;
    
    public GenericStack() {
        elements = new ArrayList<>();
        top = -1;
    }
    
    public void push(T element) {
        elements.add(element);
        top++;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(top--);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(top);
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}
```

## Performance Analysis

### Time Complexity Comparison
| Operation | Stack | ArrayDeque | Vector | LinkedList |
|-----------|-------|------------|--------|-----------|
| Push | O(1) | O(1) | O(1) | O(1) |
| Pop | O(1) | O(1) | O(1) | O(1) |
| Peek | O(1) | O(1) | O(1) | O(1) |
| Search | O(n) | O(n) | O(n) | O(n) |

### Memory Usage
```java
public void compareMemoryUsage() {
    // Stack (synchronized)
    Stack<Integer> stack = new Stack<>();
    
    // ArrayDeque (recommended)
    Deque<Integer> deque = new ArrayDeque<>();
    
    // Vector (synchronized, legacy)
    Vector<Integer> vector = new Vector<>();
    
    // LinkedList (not recommended for stack)
    Deque<Integer> linkedList = new LinkedList<>();
    
    // Memory comparison
    Runtime runtime = Runtime.getRuntime();
    long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
    
    // Add elements and measure
    for (int i = 0; i < 10000; i++) {
        stack.push(i);
        deque.push(i);
        vector.add(i);
        linkedList.push(i);
    }
    
    long afterMemory = runtime.totalMemory() - runtime.freeMemory();
    long memoryUsed = afterMemory - beforeMemory;
    
    System.out.println("Memory used for 10000 elements: " + memoryUsed + " bytes");
}
```

## Usage Examples

### Basic Stack Operations
```java
StackOperations stackOps = new StackOperations();

// Push elements
stackOps.push(10);
stackOps.push(20);
stackOps.push(30);

// Peek and pop
int top = stackOps.peek(); // 30
int popped = stackOps.pop(); // 30

// Check stack state
boolean empty = stackOps.isEmpty();
int size = stackOps.size();
```

### Advanced Stack Applications
```java
// String reversal
String reversed = stackOps.reverseString("Hello World");

// Balanced parentheses check
boolean balanced = stackOps.isBalanced("{[()]}"); // true

// Postfix evaluation
int result = stackOps.evaluatePostfix("3 4 + 2 * 7 /");

// Infix to postfix conversion
String postfix = stackOps.infixToPostfix("a+b*c");
```

### Stack with Collections
```java
// Convert stack to list
Stack<Integer> stack = new Stack<>();
for (int i = 1; i <= 5; i++) {
    stack.push(i);
}

List<Integer> list = new ArrayList<>(stack);
Collections.sort(list);

// Use stack with streams
int sum = stack.stream().mapToInt(Integer::intValue).sum();
Optional<Integer> max = stack.stream().max(Integer::compareTo);
```

## Error Handling

### Stack Underflow
```java
public int safePop() {
    try {
        return stack.pop();
    } catch (EmptyStackException e) {
        System.err.println("Stack is empty - cannot pop");
        return Integer.MIN_VALUE; // or throw custom exception
    }
}
```

### Input Validation
```java
public void safePush(int element) {
    if (stack.size() >= MAX_STACK_SIZE) {
        throw new StackOverflowError("Stack size limit exceeded");
    }
    stack.push(element);
}
```

## Learning Outcomes

After studying this code, you will understand:

1. **Stack Data Structure**: Complete implementation and operations
2. **LIFO Principle**: Last-In-First-Out behavior
3. **Algorithm Applications**: Stack-based algorithms
4. **Java Collections**: Integration with standard collections
5. **Functional Programming**: Modern Java features with stacks
6. **Performance Analysis**: Time and space complexity
7. **Error Handling**: Robust exception management
8. **Real-World Applications**: Practical stack usage

## Compilation and Execution

```bash
javac StackOperations.java
java StackOperations
```

The program will:
1. Demonstrate all Java imports with examples
2. Show comprehensive stack operations
3. Provide advanced algorithm demonstrations
4. Handle various input scenarios
5. Save operations to file

## Extensions and Applications

### Possible Enhancements
1. **Generic Stack**: Support any data type
2. **Bounded Stack**: Fixed-size stack implementation
3. **Persistent Stack**: Save/load stack to/from files
4. **Visualization**: Graphical stack representation
5. **Performance Metrics**: Add timing and memory profiling
6. **Thread-Safe Stack**: Concurrent stack operations

### Real-World Applications
1. **Function Call Stack**: Programming language implementation
2. **Undo/Redo Systems**: Operation history management
3. **Expression Evaluation**: Mathematical expression parsing
4. **Browser History**: Forward/backward navigation
5. **Text Editors**: Undo/redo functionality
6. **Compiler Design**: Syntax parsing and evaluation

### Advanced Implementations
```java
// Thread-safe stack
public class ConcurrentStack<T> {
    private final ConcurrentLinkedDeque<T> deque = new ConcurrentLinkedDeque<>();
    
    public void push(T item) {
        deque.push(item);
    }
    
    public T pop() {
        return deque.pop();
    }
    
    public T peek() {
        return deque.peek();
    }
}

// Bounded stack
public class BoundedStack<T> {
    private final Deque<T> deque;
    private final int capacity;
    
    public BoundedStack(int capacity) {
        this.deque = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }
    
    public void push(T item) {
        if (deque.size() >= capacity) {
            throw new IllegalStateException("Stack is full");
        }
        deque.push(item);
    }
}

// Stack with iterator
public class IterableStack<T> implements Iterable<T> {
    private final Stack<T> stack = new Stack<>();
    
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    
    private class StackIterator implements Iterator<T> {
        private int currentIndex = stack.size() - 1;
        
        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }
        
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack.get(currentIndex--);
        }
    }
}
```

## Best Practices Demonstrated

1. **Data Structure Implementation**: Complete stack implementation
2. **Algorithm Design**: Multiple stack-based algorithms
3. **Error Handling**: Comprehensive validation and exception management
4. **Code Documentation**: Extensive method documentation
5. **Performance Analysis**: Complexity considerations
6. **API Integration**: Comprehensive Java API usage
7. **Testing**: Multiple test cases and scenarios
8. **Modular Design**: Separation of concerns and reusable methods

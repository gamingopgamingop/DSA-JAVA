# sample.java - Documentation

## Overview
This Java program serves as a comprehensive demonstration of all 63 Java imports while providing a sample implementation of various programming concepts. It showcases modern Java features, functional programming, and extensive API usage in a single cohesive program.

## Program Logic

### Sample Demonstration Framework
The program implements a comprehensive demonstration framework that showcases all imported Java classes and interfaces through practical examples.

#### Core Structure
```java
public class sample {
    public static void main(String[] args) {
        demonstrateAllImports();
    }
}
```

#### Demonstration Categories
- **Text Formatting**: MessageFormat, DecimalFormat, SimpleDateFormat
- **Collections Framework**: Lists, Sets, Queues, Maps, Stacks
- **Functional Programming**: Consumer, Predicate, Function, Supplier
- **I/O Operations**: File handling, stream processing
- **Desktop Integration**: System operations and printing
- **Utilities**: Arrays, Collections, Random, Date

### Key Features

#### 1. Comprehensive Import Usage
- All 63 specified imports are actively used
- Real-world applications of various Java APIs
- Educational value through practical examples

#### 2. Modern Java Features
- Lambda expressions and method references
- Stream API for data processing
- Functional interfaces
- Type-safe generic usage

#### 3. Practical Examples
- File I/O operations
- Data structure manipulations
- Algorithm demonstrations
- System integration

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Sample {0}: {1}", "Test", "Value")
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
      new FileOutputStream("sample_output.txt")), true);
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

#### Collections Framework Demonstration
```java
// List operations
List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
Vector<Integer> vector = new Vector<>(Arrays.asList(10, 20, 30));
LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(7, 4, 6));

// Stack operations
Stack<Integer> stack = new Stack<>();
stack.push(1); stack.push(2); stack.push(3);

// Queue operations
Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(5, 1, 4, 2, 3));

// Use collection operations
Collections.sort(arrayList);
Collections.reverse(linkedList);
Collections.shuffle(vector);
```

#### Set Operations Demonstration
```java
// Set operations
Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 2, 1));
Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(3, 1, 4, 1, 5));
Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9));
Set<Thread.State> enumSet = EnumSet.noneOf(Thread.State.class);

// Set operations
hashSet.add(10);
linkedHashSet.add(20);
treeSet.add(30);
enumSet.add(Thread.State.NEW);
```

#### Map Operations Demonstration
```java
// Map operations
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
Hashtable<String, Integer> hashtable = new Hashtable<>();

// Populate maps
hashMap.put("one", 1);
hashMap.put("two", 2);
linkedHashMap.put("first", 1);
linkedHashMap.put("second", 2);
treeMap.put("z", 26);
treeMap.put("a", 1);
hashtable.put("hash", 42);
```

#### Functional Programming Demonstration
```java
// Functional interfaces
Consumer<String> printer = str -> System.out.println("Consumer: " + str);
Predicate<Integer> isEven = num -> num % 2 == 0;
Function<String, Integer> stringLength = String::length;
Supplier<Double> randomSupplier = () -> new Random().nextDouble();

// Apply functional interfaces
printer.accept("Hello World!");
boolean even = isEven.test(4);
int length = stringLength.apply("Hello");
double random = randomSupplier.get();
```

#### Primitive Functional Interfaces
```java
// Primitive functional interfaces
IntUnaryOperator square = x -> x * x;
IntBinaryOperator multiply = (a, b) -> a * b;
IntPredicate isPositive = x -> x > 0;
IntConsumer printInt = x -> System.out.println("Int: " + x);
IntFunction<String> intToString = Integer::toString;

// Apply primitive functional interfaces
int squared = square.applyAsInt(5);
int product = multiply.applyAsInt(3, 4);
boolean positive = isPositive.test(10);
printInt.accept(42);
String text = intToString.apply(123);
```

## Advanced Demonstrations

### File I/O Operations
```java
// File writing with different approaches
try (PrintStream printStream = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("sample_demo.txt")), true)) {
    
    printStream.println("Sample Program Output");
    printStream.println("Timestamp: " + new Date());
    
    // Write collection data
    printStream.println("Array List: " + arrayList);
    printStream.println("Hash Map: " + hashMap);
    
} catch (IOException e) {
    System.err.println("I/O Error: " + e.getMessage());
}
```

### Desktop Integration
```java
// Desktop operations demonstration
try {
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        
        System.out.println("Desktop operations supported:");
        System.out.println("  Browse: " + desktop.isSupported(Desktop.Action.BROWSE));
        System.out.println("  Edit: " + desktop.isSupported(Desktop.Action.EDIT));
        System.out.println("  Print: " + desktop.isSupported(Desktop.Action.PRINT));
        System.out.println("  Mail: " + desktop.isSupported(Desktop.Action.MAIL));
        
        // Try to open browser if supported
        if (desktop.isSupported(Desktop.Action.BROWSE)) {
            System.out.println("Opening browser...");
            // desktop.browse(new URI("https://www.example.com"));
        }
    } else {
        System.out.println("Desktop operations not supported on this platform");
    }
} catch (Exception e) {
    System.out.println("Desktop operations error: " + e.getMessage());
}
```

### Printing Operations
```java
// Printing system demonstration
try {
    PrinterJob printerJob = PrinterJob.getPrinterJob();
    PageFormat pageFormat = printerJob.defaultPage();
    Book book = new Book();
    
    System.out.println("Printing system available: " + printerJob.printDialog());
    
    // Create a simple printable job
    if (printerJob.printDialog()) {
        System.out.println("Print job created successfully");
    }
    
} catch (PrinterException e) {
    System.out.println("Printing system error: " + e.getMessage());
}
```

### Stream Processing
```java
// Stream tokenizer demonstration
String sampleText = "Java 8 Stream 123 Processing 456 Example";
StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(sampleText));

System.out.println("Tokenized text:");
while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
    System.out.println("Token: " + tokenizer.sval + " (Type: " + tokenizer.ttype + ")");
}
```

### Date and Time Operations
```java
// Date and time formatting
Date currentDate = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

System.out.println("Current date and time: " + dateFormat.format(currentDate));
System.out.println("Just time: " + timeFormat.format(currentDate));
System.out.println("Full date-time: " + dateTimeFormat.format(currentDate));
```

### Random Number Generation
```java
// Random operations
Random random = new Random();

System.out.println("Random examples:");
System.out.println("Random int: " + random.nextInt());
System.out.println("Random double: " + random.nextDouble());
System.out.println("Random boolean: " + random.nextBoolean());
System.out.println("Random gaussian: " + random.nextGaussian());

// Random within range
int min = 1, max = 100;
int randomInRange = random.nextInt(max - min + 1) + min;
System.out.println("Random in range [1,100]: " + randomInRange);
```

## Utility Demonstrations

### Array Operations
```java
// Array operations
int[] numbers = {5, 3, 8, 1, 2, 9, 4, 7, 6};

System.out.println("Original array: " + Arrays.toString(numbers));
Arrays.sort(numbers);
System.out.println("Sorted array: " + Arrays.toString(numbers));

// Binary search
int index = Arrays.binarySearch(numbers, 5);
System.out.println("Binary search for 5: " + index);

// Array fill
int[] filledArray = new int[10];
Arrays.fill(filledArray, 42);
System.out.println("Filled array: " + Arrays.toString(filledArray));
```

### Exception Handling
```java
// Exception handling demonstration
try {
    // Simulate some operation that might fail
    String nullString = null;
    int length = nullString.length(); // This will throw NullPointerException
    
} catch (NullPointerException e) {
    System.err.println("NullPointerException caught: " + e.getMessage());
} catch (Exception e) {
    System.err.println("General exception caught: " + e.getMessage());
} finally {
    System.out.println("Finally block executed");
}
```

### Input/Output Operations
```java
// Scanner demonstration
Scanner scanner = new Scanner(System.in);

try {
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    
    System.out.print("Enter your age: ");
    int age = scanner.nextInt();
    
    System.out.println("Hello " + name + "! You are " + age + " years old.");
    
} catch (InputMismatchException e) {
    System.err.println("Invalid input! Please enter a valid integer.");
} catch (NoSuchElementException e) {
    System.err.println("No input provided!");
} finally {
    scanner.close();
}
```

## Performance Considerations

### Collection Performance
```java
// Performance comparison
List<Integer> arrayList = new ArrayList<>();
Vector<Integer> vector = new Vector<>();
LinkedList<Integer> linkedList = new LinkedList<>();

long startTime = System.nanoTime();

// Add 100,000 elements to each collection
for (int i = 0; i < 100000; i++) {
    arrayList.add(i);
    vector.add(i);
    linkedList.add(i);
}

long endTime = System.nanoTime();
long duration = endTime - startTime;

System.out.println("Adding 100,000 elements:");
System.out.println("Duration: " + duration + " nanoseconds");
```

### Memory Usage
```java
// Memory usage analysis
Runtime runtime = Runtime.getRuntime();
long totalMemory = runtime.totalMemory();
long freeMemory = runtime.freeMemory();
long usedMemory = totalMemory - freeMemory;

System.out.println("Memory Analysis:");
System.out.println("Total memory: " + (totalMemory / 1024 / 1024) + " MB");
System.out.println("Free memory: " + (freeMemory / 1024 / 1024) + " MB");
System.out.println("Used memory: " + (usedMemory / 1024 / 1024) + " MB");
```

## Usage Examples

### Basic Usage
```java
// Run the sample demonstration
sample.main(new String[]{});
```

### Custom Demonstrations
```java
// Create custom demonstration
public class CustomSample {
    public static void demonstrateCustomFeatures() {
        // Custom logic using demonstrated imports
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        
        // Functional processing
        names.stream()
             .filter(name -> name.length() > 4)
             .map(String::toUpperCase)
             .forEach(System.out::println);
        
        // Statistical analysis
        IntSummaryStatistics stats = IntStream.range(1, 101)
            .summaryStatistics();
        
        System.out.println("Statistics for 1-100:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
    }
}
```

### Integration Examples
```java
// Integration with other Java features
public class IntegrationExample {
    public void demonstrateIntegration() {
        // Combine collections with functional programming
        Map<String, List<Integer>> dataMap = new HashMap<>();
        
        // Populate map
        dataMap.put("numbers", Arrays.asList(1, 2, 3, 4, 5));
        dataMap.put("letters", Arrays.asList(6, 7, 8, 9, 10));
        
        // Process with streams
        dataMap.entrySet().stream()
            .flatMap(entry -> entry.getValue().stream())
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .sorted()
            .forEach(System.out::println);
        
        // Use functional interfaces
        Consumer<String> keyPrinter = key -> System.out.println("Key: " + key);
        Consumer<List<Integer>> valuePrinter = values -> 
            System.out.println("Values: " + values);
        
        dataMap.forEach((key, value) -> {
            keyPrinter.accept(key);
            valuePrinter.accept(value);
        });
    }
}
```

## Learning Outcomes

After studying this code, you will understand:

1. **Java Collections Framework**: Complete understanding of collections
2. **Functional Programming**: Modern Java features and lambda expressions
3. **I/O Operations**: File handling and stream processing
4. **Exception Handling**: Robust error management
5. **Date/Time Processing**: Date and time formatting
6. **System Integration**: Desktop and printing operations
7. **Performance Analysis**: Memory and timing considerations
8. **API Usage**: Comprehensive Java API demonstration

## Compilation and Execution

```bash
javac sample.java
java sample
```

The program will:
1. Demonstrate all 63 Java imports
2. Show various Java features and APIs
3. Provide practical examples
4. Handle different scenarios
5. Save results to file

## Extensions and Applications

### Possible Enhancements
1. **GUI Interface**: Add graphical user interface
2. **Database Integration**: JDBC examples
3. **Network Programming**: Socket and HTTP examples
4. **Multithreading**: Concurrent programming examples
5. **Testing Framework**: Unit testing with JUnit
6. **Logging**: Advanced logging with Log4j

### Real-World Applications
1. **Educational Tool**: Teaching Java programming concepts
2. **API Reference**: Quick reference for Java APIs
3. **Code Templates**: Starting point for new projects
4. **Interview Preparation**: Common Java interview patterns
5. **Development Helper**: Utility functions for development
6. **Learning Resource**: Self-contained Java examples

### Advanced Implementations
```java
// Generic sample framework
public class GenericSample<T> {
    private List<T> collection;
    
    public GenericSample() {
        this.collection = new ArrayList<>();
    }
    
    public void demonstrateGenericFeatures() {
        // Generic collection operations
        collection.add((T) "Generic Item");
        collection.forEach(System.out::println);
        
        // Generic functional interfaces
        Predicate<T> filter = item -> item != null;
        Consumer<T> processor = item -> System.out.println("Processing: " + item);
        
        collection.stream()
            .filter(filter)
            .forEach(processor);
    }
}

// Configuration-driven sample
public class ConfigurableSample {
    private Properties config;
    
    public ConfigurableSample() {
        this.config = new Properties();
        loadConfiguration();
    }
    
    private void loadConfiguration() {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            // Use default configuration
            config.setProperty("sample.name", "Default Sample");
            config.setProperty("sample.version", "1.0");
        }
    }
    
    public void runConfiguredDemo() {
        String name = config.getProperty("sample.name");
        String version = config.getProperty("sample.version");
        
        System.out.println("Sample: " + name + " v" + version);
    }
}
```

## Best Practices Demonstrated

1. **Import Management**: Comprehensive import usage
2. **Code Organization**: Clear structure and separation of concerns
3. **Error Handling**: Robust exception management
4. **Documentation**: Extensive comments and explanations
5. **Performance**: Efficient use of collections and algorithms
6. **Modern Java**: Latest Java features and best practices
7. **Maintainability**: Clean, readable, and extensible code
8. **Educational Value**: Learning-oriented examples and explanations

## Summary

The `sample.java` program serves as a comprehensive demonstration of Java programming capabilities. It showcases:

- **All 63 specified imports** with practical usage
- **Modern Java features** including functional programming
- **Comprehensive examples** of various Java APIs
- **Best practices** for Java development
- **Educational value** for learning Java programming

This program serves as an excellent reference and starting point for Java developers, providing practical examples of how to use various Java APIs and features effectively.

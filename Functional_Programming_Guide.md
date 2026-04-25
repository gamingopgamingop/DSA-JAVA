# Functional Programming in Java - Comprehensive Guide

## Overview
This document provides a comprehensive guide to functional programming concepts in Java, as demonstrated in our DSA Java programs. It covers functional interfaces, lambda expressions, stream processing, and best practices.

## Functional Interfaces

### Core Functional Interfaces (`java.util.function.*`)

#### Consumer<T>
**Purpose**: Accepts an input, performs an action, returns no result
**Method**: `void accept(T t)`

```java
// Basic usage
Consumer<String> printer = str -> System.out.println(str);
printer.accept("Hello World");

// Method reference
Consumer<String> systemPrinter = System.out::println;
systemPrinter.accept("Method Reference");

// Chaining consumers
Consumer<String> upperCase = str -> System.out.println(str.toUpperCase());
Consumer<String> lowerCase = str -> System.out.println(str.toLowerCase());
Consumer<String> combined = upperCase.andThen(lowerCase);
combined.accept("Hello");
```

#### Predicate<T>
**Purpose**: Accepts an input, returns boolean result
**Method**: `boolean test(T t)`

```java
// Basic usage
Predicate<Integer> isEven = num -> num % 2 == 0;
boolean result = isEven.test(4); // true

// Method reference
Predicate<String> isEmpty = String::isEmpty;
boolean empty = isEmpty.test(""); // true

// Combining predicates
Predicate<Integer> isPositive = num -> num > 0;
Predicate<Integer> isGreaterThan10 = num -> num > 10;
Predicate<Integer> isPositiveAndGreaterThan10 = isPositive.and(isGreaterThan10);
Predicate<Integer> isPositiveOrGreaterThan10 = isPositive.or(isGreaterThan10);
Predicate<Integer> notPositive = isPositive.negate();
```

#### Function<T,R>
**Purpose**: Accepts an input, returns an output
**Method**: `R apply(T t)`

```java
// Basic usage
Function<String, Integer> stringLength = str -> str.length();
int length = stringLength.apply("Hello"); // 5

// Method reference
Function<String, Integer> lengthMethod = String::length;
int length2 = lengthMethod.apply("World"); // 5

// Chaining functions
Function<String, String> toUpperCase = String::toUpperCase;
Function<String, Integer> lengthOfUpperCase = toUpperCase.andThen(String::length);
int upperLength = lengthOfUpperCase.apply("Hello"); // 5

// Compose functions
Function<Integer, String> intToString = Object::toString;
Function<String, Integer> stringToInt = Integer::parseInt;
Function<Integer, Integer> composed = stringToInt.compose(intToString);
int result2 = composed.apply(123); // 123
```

#### Supplier<T>
**Purpose**: No input, returns an output
**Method**: `T get()`

```java
// Basic usage
Supplier<Double> randomSupplier = () -> Math.random();
double random = randomSupplier.get();

// Method reference
Supplier<String> stringSupplier = String::new;
String newString = stringSupplier.get();

// Cached supplier
Supplier<Integer> counter = new Supplier<Integer>() {
    private int count = 0;
    @Override
    public Integer get() {
        return ++count;
    }
};
```

### Primitive Functional Interfaces

#### IntUnaryOperator
**Purpose**: int → int transformation
**Method**: `int applyAsInt(int operand)`

```java
IntUnaryOperator square = x -> x * x;
int result = square.applyAsInt(5); // 25

IntUnaryOperator increment = x -> x + 1;
IntUnaryOperator triple = increment.andThen(increment).andThen(increment);
int tripled = triple.applyAsInt(5); // 8
```

#### IntBinaryOperator
**Purpose**: (int, int) → int operation
**Method**: `int applyAsInt(int left, int right)`

```java
IntBinaryOperator add = (a, b) -> a + b;
int sum = add.applyAsInt(3, 4); // 7

IntBinaryOperator multiply = (a, b) -> a * b;
int product = multiply.applyAsInt(3, 4); // 12

IntBinaryOperator max = Integer::max;
int maximum = max.applyAsInt(5, 8); // 8
```

#### IntPredicate
**Purpose**: int → boolean test
**Method**: `boolean test(int value)`

```java
IntPredicate isPositive = x -> x > 0;
boolean positive = isPositive.test(5); // true

IntPredicate isEven = x -> x % 2 == 0;
boolean even = isEven.test(4); // true

IntPredicate isPositiveAndEven = isPositive.and(isEven);
boolean result = isPositiveAndEven.test(6); // true
```

#### IntConsumer
**Purpose**: int → void action
**Method**: `void accept(int value)`

```java
IntConsumer printer = x -> System.out.println("Value: " + x);
printer.accept(42); // Value: 42

IntConsumer accumulator = new IntConsumer() {
    private int sum = 0;
    @Override
    public void accept(int value) {
        sum += value;
        System.out.println("Running sum: " + sum);
    }
};
```

#### IntFunction<R>
**Purpose**: int → R transformation
**Method**: `R apply(int value)`

```java
IntFunction<String> intToString = Integer::toString;
String text = intToString.apply(123); // "123"

IntFunction<Double> toDouble = x -> (double) x;
double decimal = toDouble.apply(5); // 5.0
```

### Double and Long Variants
Similar interfaces exist for double and long primitive types:
- **DoubleUnaryOperator, DoubleBinaryOperator, DoublePredicate, DoubleConsumer, DoubleFunction**
- **LongUnaryOperator, LongBinaryOperator, LongPredicate, LongConsumer, LongFunction**

```java
// Double examples
DoubleUnaryOperator doubleSquare = x -> x * x;
DoublePredicate isDoublePositive = x -> x > 0.0;
DoubleConsumer printDouble = x -> System.out.println("Double: " + x);

// Long examples
LongUnaryOperator longSquare = x -> x * x;
LongPredicate isLongPositive = x -> x > 0L;
LongConsumer printLong = x -> System.out.println("Long: " + x);
```

## Lambda Expressions

### Syntax
```java
// Basic syntax
(parameters) -> expression
(parameters) -> { statements; }

// Examples
() -> System.out.println("Hello");
x -> x * x;
(x, y) -> x + y;
(String s) -> s.length();
(int x, int y) -> {
    int sum = x + y;
    return sum * 2;
};
```

### Lambda Examples

#### Sorting with Lambdas
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Before Java 8
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

// With lambda
Collections.sort(names, (a, b) -> a.compareTo(b));

// With method reference
Collections.sort(names, String::compareTo);
```

#### Event Handling
```java
// Traditional anonymous class
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked");
    }
});

// With lambda
button.addActionListener(e -> System.out.println("Button clicked"));
```

#### Collection Operations
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Iterate with lambda
numbers.forEach(n -> System.out.println(n));

// Remove with lambda
numbers.removeIf(n -> n % 2 == 0);

// Replace with lambda
numbers.replaceAll(n -> n * 2);
```

### Method References

#### Types of Method References
1. **Static method reference**: `ClassName::staticMethod`
2. **Instance method reference**: `instance::instanceMethod`
3. **Object method reference**: `ClassName::instanceMethod`
4. **Constructor reference**: `ClassName::new`

```java
// Static method reference
Function<String, Integer> parser = Integer::parseInt;

// Instance method reference
String text = "Hello";
Predicate<String> isEmpty = text::isEmpty;

// Object method reference
Function<String, Integer> length = String::length;
BiFunction<String, String, Boolean> equals = String::equals;

// Constructor reference
Supplier<String> stringSupplier = String::new;
Function<Integer, int[]> arrayFactory = int[]::new;
```

## Stream API

### Stream Creation
```java
// From collection
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream1 = list.stream();

// From array
String[] array = {"a", "b", "c"};
Stream<String> stream2 = Arrays.stream(array);

// From values
Stream<String> stream3 = Stream.of("a", "b", "c");

// Infinite stream
Stream<Integer> infinite = Stream.generate(() -> 1);
Stream<Integer> iterate = Stream.iterate(0, n -> n + 1);

// Empty stream
Stream<String> empty = Stream.empty();
```

### Intermediate Operations

#### Filter
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Filter even numbers
List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());

// Multiple filters
List<Integer> result = numbers.stream()
    .filter(n -> n > 3)
    .filter(n -> n < 8)
    .filter(n -> n % 2 == 1)
    .collect(Collectors.toList()); // [5, 7]
```

#### Map
```java
List<String> words = Arrays.asList("hello", "world", "java");

// Transform to uppercase
List<String> upper = words.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// Transform to lengths
List<Integer> lengths = words.stream()
    .map(String::length)
    .collect(Collectors.toList());

// Flat map
List<List<Integer>> nested = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4),
    Arrays.asList(5, 6)
);
List<Integer> flattened = nested.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList()); // [1, 2, 3, 4, 5, 6]
```

#### Sorted
```java
List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);

// Natural sorting
List<Integer> sorted = numbers.stream()
    .sorted()
    .collect(Collectors.toList());

// Custom sorting
List<Integer> reverseSorted = numbers.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());

// Custom comparator
List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> sortedByLength = words.stream()
    .sorted(Comparator.comparingInt(String::length))
    .collect(Collectors.toList());
```

#### Distinct and Limit
```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

// Remove duplicates
List<Integer> distinct = numbers.stream()
    .distinct()
    .collect(Collectors.toList()); // [1, 2, 3, 4]

// Limit elements
List<Integer> limited = numbers.stream()
    .limit(5)
    .collect(Collectors.toList()); // [1, 2, 2, 3, 3]

// Skip elements
List<Integer> skipped = numbers.stream()
    .skip(5)
    .collect(Collectors.toList()); // [3, 3, 4, 4, 4, 4]
```

### Terminal Operations

#### Collect
```java
List<String> words = Arrays.asList("hello", "world", "java", "stream");

// To list
List<String> list = words.stream()
    .filter(w -> w.length() > 4)
    .collect(Collectors.toList());

// To set
Set<String> set = words.stream()
    .collect(Collectors.toSet());

// To specific collection
ArrayList<String> arrayList = words.stream()
    .collect(Collectors.toCollection(ArrayList::new));

// To map
Map<String, Integer> wordToLength = words.stream()
    .collect(Collectors.toMap(
        Function.identity(),
        String::length
    ));

// Grouping
Map<Integer, List<String>> byLength = words.stream()
    .collect(Collectors.groupingBy(String::length));

// Partitioning
Map<Boolean, List<String>> byEvenLength = words.stream()
    .collect(Collectors.partitioningBy(w -> w.length() % 2 == 0));
```

#### Reduce
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sum
int sum = numbers.stream()
    .reduce(0, Integer::sum);

// Product
Optional<Integer> product = numbers.stream()
    .reduce((a, b) -> a * b);

// Concatenation
String concatenated = words.stream()
    .reduce("", (a, b) -> a + b);

// Find max
Optional<Integer> max = numbers.stream()
    .reduce(Integer::max);
```

#### Match Operations
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// All match
boolean allEven = numbers.stream()
    .allMatch(n -> n % 2 == 0); // false

// Any match
boolean anyEven = numbers.stream()
    .anyMatch(n -> n % 2 == 0); // true

// None match
boolean noneNegative = numbers.stream()
    .noneMatch(n -> n < 0); // true
```

#### Find Operations
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");

// Find first
Optional<String> first = words.stream()
    .filter(w -> w.startsWith("b"))
    .findFirst();

// Find any
Optional<String> any = words.stream()
    .filter(w -> w.length() > 5)
    .findAny();
```

#### ForEach
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Print each number
numbers.stream()
    .forEach(System.out::println);

// Perform action
numbers.stream()
    .forEach(n -> {
        int squared = n * n;
        System.out.println(n + " squared is " + squared);
    });
```

## Advanced Functional Programming

### Custom Functional Interfaces
```java
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

// Usage
TriFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
int result = sum.apply(1, 2, 3); // 6
```

### Higher-Order Functions
```java
// Function that returns a function
Function<Integer, IntUnaryOperator> createMultiplier = factor -> x -> x * factor;
IntUnaryOperator triple = createMultiplier.apply(3);
int result = triple.applyAsInt(5); // 15

// Function that takes a function
Function<IntUnaryOperator, IntUnaryOperator> composeWithSquare = 
    func -> func.andThen(x -> x * x);
IntUnaryOperator squareThenTriple = composeWithSquare.apply(x -> x * 3);
int result2 = squareThenTriple.applyAsInt(4); // 144 (4*3=12, 12*12=144)
```

### Currying
```java
// Curried function
Function<Integer, Function<Integer, IntBinaryOperator>> curriedAdd = 
    a -> b -> (x, y) -> a + b + x + y;

IntBinaryOperator add5And10 = curriedAdd.apply(5).apply(10);
int sum = add5And10.applyAsInt(3, 7); // 25 (5+10+3+7)
```

### Memoization
```java
// Memoization utility
public class Memoizer {
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}

// Usage
Function<Integer, Integer> fibonacci = Memoizer.memoize(n -> {
    if (n <= 1) return n;
    return fibonacci.apply(n - 1) + fibonacci.apply(n - 2);
});
```

## Functional Design Patterns

### Strategy Pattern
```java
// Traditional approach
interface SortingStrategy {
    void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Bubble sort implementation
    }
}

// Functional approach
Function<int[], int[]> bubbleSort = array -> {
    // Bubble sort implementation
    return array;
};

Function<int[], int[]> quickSort = array -> {
    // Quick sort implementation
    return array;
};

// Usage
int[] data = {5, 3, 8, 1, 2};
int[] sorted = bubbleSort.apply(data);
```

### Builder Pattern with Functions
```java
public class FunctionalBuilder<T> {
    private final T instance;
    private final List<Consumer<T>> operations = new ArrayList<>();

    public FunctionalBuilder(Supplier<T> supplier) {
        this.instance = supplier.get();
    }

    public FunctionalBuilder<T> with(Consumer<T> operation) {
        operations.add(operation);
        return this;
    }

    public T build() {
        operations.forEach(op -> op.accept(instance));
        return instance;
    }
}

// Usage
Person person = new FunctionalBuilder<>(Person::new)
    .with(p -> p.setName("Alice"))
    .with(p -> p.setAge(30))
    .with(p -> p.setEmail("alice@example.com"))
    .build();
```

### Optional Pattern
```java
// Traditional null checking
public String getDisplayName(User user) {
    if (user != null) {
        Profile profile = user.getProfile();
        if (profile != null) {
            return profile.getDisplayName();
        }
    }
    return "Unknown";
}

// Functional approach with Optional
public String getDisplayNameFunctional(User user) {
    return Optional.ofNullable(user)
        .map(User::getProfile)
        .map(Profile::getDisplayName)
        .orElse("Unknown");
}
```

## Performance Considerations

### Stream vs. Traditional Loops
```java
// Traditional loop
List<Integer> result = new ArrayList<>();
for (Integer item : collection) {
    if (item % 2 == 0) {
        result.add(item * 2);
    }
}

// Stream approach
List<Integer> result = collection.stream()
    .filter(item -> item % 2 == 0)
    .map(item -> item * 2)
    .collect(Collectors.toList());
```

### Parallel Streams
```java
// Sequential stream
List<Integer> result = list.stream()
    .map(this::expensiveOperation)
    .collect(Collectors.toList());

// Parallel stream
List<Integer> parallelResult = list.parallelStream()
    .map(this::expensiveOperation)
    .collect(Collectors.toList());

// When to use parallel streams:
// 1. Large datasets (thousands+ elements)
// 2. Expensive operations
// 3. Stateless operations
// 4. Order doesn't matter
```

### Primitive Streams
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Boxed stream (less efficient)
int sum = numbers.stream()
    .mapToInt(Integer::intValue)
    .sum();

// Primitive stream (more efficient)
IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
int sum2 = intStream.sum();

// Range operations
IntStream range = IntStream.range(0, 10); // 0-9
IntStream rangeClosed = IntStream.rangeClosed(0, 10); // 0-10
```

## Best Practices

### 1. Use Method References When Possible
```java
// Good
list.forEach(System.out::println);

// Avoid when lambda is clearer
list.forEach(item -> {
    if (item.length() > 5) {
        System.out.println(item.toUpperCase());
    }
});
```

### 2. Keep Lambda Expressions Short
```java
// Good
Predicate<String> isLong = s -> s.length() > 10;

// Avoid complex logic in lambda
Predicate<String> isComplex = s -> {
    // Complex logic here - consider extracting to method
    return s.length() > 10 && s.startsWith("A") && s.contains("test");
};

// Better
Predicate<String> isComplex = this::isComplexString;
```

### 3. Use Optional for Null Safety
```java
// Good
Optional<String> optional = Optional.ofNullable(getString());
String result = optional.orElse("default");

// Avoid Optional for fields
// Bad
private Optional<String> name; // Don't do this

// Good
private String name;
public Optional<String> getName() {
    return Optional.ofNullable(name);
}
```

### 4. Prefer Functional Interfaces for APIs
```java
// Good API design
public void processItems(List<Item> items, Consumer<Item> processor) {
    items.forEach(processor);
}

// Usage
processItems(items, item -> System.out.println(item));

// Avoid over-functionalization
// Don't make everything functional if it doesn't add value
```

### 5. Handle Exceptions in Functional Code
```java
// Custom functional interface for checked exceptions
@FunctionalInterface
interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}

// Utility to convert to regular Consumer
public static <T> Consumer<T> throwingConsumerWrapper(
    ThrowingConsumer<T, ?> throwingConsumer) {
    
    return item -> {
        try {
            throwingConsumer.accept(item);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    };
}

// Usage
list.forEach(throwingConsumerWrapper(item -> {
    // Code that throws checked exception
    item.process();
}));
```

## Common Pitfalls

### 1. Side Effects in Streams
```java
// Bad - modifying external state
List<Integer> result = new ArrayList<>();
list.stream()
    .filter(item -> item % 2 == 0)
    .forEach(item -> result.add(item)); // Side effect

// Good - use collect
List<Integer> result = list.stream()
    .filter(item -> item % 2 == 0)
    .collect(Collectors.toList());
```

### 2. Reusing Streams
```java
// Bad - streams can't be reused
Stream<String> stream = list.stream();
stream.forEach(System.out::println);
stream.forEach(System.out::println); // IllegalStateException!

// Good - create new streams or collect results
list.stream().forEach(System.out::println);
list.stream().forEach(System.out::println);
```

### 3. Infinite Streams Without Terminal Operation
```java
// Bad - will run forever
Stream.generate(() -> 1)
    .filter(n -> n > 0)
    .forEach(System.out::println);

// Good - limit the stream
Stream.generate(() -> 1)
    .limit(10)
    .forEach(System.out::println);
```

## Summary

Functional programming in Java provides powerful tools for writing concise, expressive, and maintainable code. Key concepts include:

1. **Functional Interfaces**: Define contracts for lambda expressions
2. **Lambda Expressions**: Provide anonymous function syntax
3. **Stream API**: Enables functional data processing
4. **Method References**: Provide shorthand for lambda expressions
5. **Optional**: Provides null-safe programming patterns

Best practices emphasize using functional programming judiciously, keeping lambdas simple, and understanding performance implications. When used appropriately, functional programming can significantly improve code quality and readability.

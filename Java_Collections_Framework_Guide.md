# Java Collections Framework - Comprehensive Guide

## Overview
This document provides a comprehensive guide to the Java Collections Framework as demonstrated in our DSA Java programs. It covers all major collection types, their characteristics, use cases, and best practices.

## Collections Framework Hierarchy

### Core Interfaces
```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── Vector
│   └── LinkedList
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   ├── TreeSet
│   └── EnumSet
├── Queue (Interface)
│   ├── ArrayDeque
│   ├── LinkedList
│   └── PriorityQueue
└── Map (Interface)
    ├── HashMap
    ├── LinkedHashMap
    ├── TreeMap
    ├── Hashtable
    ├── SortedMap (Interface)
    │   └── TreeMap
    └── NavigableMap (Interface)
        └── TreeMap
```

## List Implementations

### ArrayList
**Characteristics:**
- Resizable array implementation
- Fast random access (O(1))
- Slower insertion/deletion in middle (O(n))
- Not synchronized

**Use Cases:**
```java
// General-purpose list
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(30);

// Initial capacity optimization
List<String> names = new ArrayList<>(100);

// From array
String[] array = {"A", "B", "C"};
List<String> listFromArray = new ArrayList<>(Arrays.asList(array));
```

**Performance:**
- Access: O(1)
- Add (end): O(1) amortized
- Add (middle): O(n)
- Remove: O(n)
- Space: O(n)

### Vector
**Characteristics:**
- Legacy synchronized collection
- Thread-safe
- Similar to ArrayList but synchronized
- Generally replaced by ArrayList + Collections.synchronizedList()

**Use Cases:**
```java
// Thread-safe operations
Vector<Integer> vector = new Vector<>();
vector.addElement(10);
vector.addElement(20);

// Synchronized list (preferred approach)
List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
```

### LinkedList
**Characteristics:**
- Doubly-linked list implementation
- Fast insertion/deletion (O(1))
- Slower random access (O(n))
- Implements both List and Queue interfaces

**Use Cases:**
```java
// Queue operations
LinkedList<Integer> queue = new LinkedList<>();
queue.offer(10);  // Add to end
queue.poll();     // Remove from front

// Stack operations
LinkedList<Integer> stack = new LinkedList<>();
stack.push(10);   // Add to front
stack.pop();      // Remove from front

// List operations
LinkedList<Integer> list = new LinkedList<>();
list.add(10);     // Add to end
list.add(0, 5);   // Add to beginning
```

## Set Implementations

### HashSet
**Characteristics:**
- Hash-based implementation
- Fast operations (O(1) average)
- Unordered
- Allows one null element
- Not synchronized

**Use Cases:**
```java
// Unique elements
Set<Integer> uniqueNumbers = new HashSet<>();
uniqueNumbers.add(10);
uniqueNumbers.add(20);
uniqueNumbers.add(10); // Duplicate ignored

// Remove duplicates from list
List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3);
Set<Integer> uniqueSet = new HashSet<>(listWithDuplicates);
```

### LinkedHashSet
**Characteristics:**
- Hash-based with linked list
- Maintains insertion order
- Fast operations (O(1))
- Allows one null element

**Use Cases:**
```java
// Ordered unique elements
Set<String> orderedUnique = new LinkedHashSet<>();
orderedUnique.add("First");
orderedUnique.add("Second");
orderedUnique.add("Third");

// Preserve order while removing duplicates
Set<String> uniqueOrdered = new LinkedHashSet<>(listWithDuplicates);
```

### TreeSet
**Characteristics:**
- Red-black tree implementation
- Sorted order (natural or comparator)
- O(log n) operations
- No null elements (with natural ordering)

**Use Cases:**
```java
// Sorted elements
Set<Integer> sortedSet = new TreeSet<>();
sortedSet.add(30);
sortedSet.add(10);
sortedSet.add(20); // Automatically sorted: [10, 20, 30]

// Custom ordering
Set<String> reverseOrder = new TreeSet<>(Collections.reverseOrder());
```

### EnumSet
**Characteristics:**
- Optimized for enum types
- Extremely fast and memory efficient
- Bit vector representation
- Type-safe

**Use Cases:**
```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

// Enum operations
Set<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
Set<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
Set<Day> allDays = EnumSet.allOf(Day.class);
```

## Queue Implementations

### ArrayDeque
**Characteristics:**
- Array-based double-ended queue
- Fast operations at both ends (O(1))
- No capacity restrictions
- Not synchronized

**Use Cases:**
```java
// Stack operations
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);   // Add to front
stack.pop();      // Remove from front

// Queue operations
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(10);  // Add to end
queue.poll();     // Remove from front

// Double-ended operations
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(10);  // Add to front
deque.addLast(20);   // Add to end
deque.removeFirst(); // Remove from front
deque.removeLast();  // Remove from end
```

### PriorityQueue
**Characteristics:**
- Heap-based implementation
- Priority ordering (natural or comparator)
- O(log n) insertion/removal
- Head is smallest element

**Use Cases:**
```java
// Min-heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(30);
minHeap.offer(10);
minHeap.offer(20);
Integer smallest = minHeap.peek(); // 10

// Max-heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.offer(30);
maxHeap.offer(10);
maxHeap.offer(20);
Integer largest = maxHeap.peek(); // 30

// Custom priority
PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparing(Task::getPriority));
```

## Map Implementations

### HashMap
**Characteristics:**
- Hash-based implementation
- Fast operations (O(1) average)
- Unordered
- Allows one null key and multiple null values
- Not synchronized

**Use Cases:**
```java
// Basic operations
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 87);
scores.put("Charlie", 92);

// Get with default
int score = scores.getOrDefault("Dave", 0);

// Compute if absent
scores.computeIfAbsent("Eve", k -> 85);

// Merge operation
scores.merge("Alice", 5, Integer::sum); // Add 5 to Alice's score
```

### LinkedHashMap
**Characteristics:**
- Hash-based with linked list
- Maintains insertion order
- Fast operations (O(1))
- Access-order mode available

**Use Cases:**
```java
// Insertion order
Map<String, Integer> orderedMap = new LinkedHashMap<>();
orderedMap.put("First", 1);
orderedMap.put("Second", 2);
orderedMap.put("Third", 3);

// Access order (LRU cache simulation)
Map<String, Integer> lruCache = new LinkedHashMap<>(16, 0.75f, true);
```

### TreeMap
**Characteristics:**
- Red-black tree implementation
- Sorted order (natural or comparator)
- O(log n) operations
- No null key
- Implements SortedMap and NavigableMap

**Use Cases:**
```java
// Sorted map
Map<String, Integer> sortedMap = new TreeMap<>();
sortedMap.put("Charlie", 92);
sortedMap.put("Alice", 95);
sortedMap.put("Bob", 87); // Automatically sorted by key

// Navigable operations
NavigableMap<String, Integer> navMap = new TreeMap<>();
Map<String, Integer> headMap = navMap.headMap("M");
Map<String, Integer> tailMap = navMap.tailMap("M");
String firstKey = navMap.firstKey();
String lastKey = navMap.lastKey();
```

### Hashtable
**Characteristics:**
- Legacy synchronized collection
- Thread-safe
- Similar to HashMap but synchronized
- No null keys or values
- Generally replaced by HashMap + Collections.synchronizedMap()

**Use Cases:**
```java
// Thread-safe operations
Hashtable<String, Integer> table = new Hashtable<>();
table.put("Key", 100);

// Synchronized map (preferred approach)
Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
```

## Collections Utility Class

### Sorting Operations
```java
// Sort lists
List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
Collections.sort(numbers); // Natural order

// Custom sorting
Collections.sort(numbers, Collections.reverseOrder());
Collections.sort(numbers, (a, b) -> Integer.compare(b, a));

// Sort with comparator
List<Person> people = Arrays.asList(/* people objects */);
Collections.sort(people, Comparator.comparing(Person::getName));
```

### Searching Operations
```java
// Binary search (requires sorted list)
List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
int index = Collections.binarySearch(sortedList, 3);

// Search with custom comparator
int index = Collections.binarySearch(sortedList, 3, Collections.reverseOrder());
```

### Manipulation Operations
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

// Reverse
Collections.reverse(list);

// Shuffle
Collections.shuffle(list);
Collections.shuffle(list, new Random(42)); // With seed

// Rotate
Collections.rotate(list, 2); // Right rotation

// Swap
Collections.swap(list, 0, 4);

// Fill
Collections.fill(list, 0);

// Copy
List<Integer> dest = Arrays.asList(new Integer[5]);
Collections.copy(dest, list);
```

### Frequency and Disjoint Operations
```java
List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);

// Frequency
int frequency = Collections.frequency(list, 2); // 2

// Disjoint (no common elements)
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(4, 5, 6);
boolean disjoint = Collections.disjoint(list1, list2); // true
```

## Functional Programming with Collections

### Stream Operations
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Filter and map
List<Integer> evenSquares = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .collect(Collectors.toList());

// Reduce
int sum = numbers.stream().reduce(0, Integer::sum);

// Grouping
Map<String, List<Integer>> grouped = numbers.stream()
    .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

// Frequency counting
Map<Integer, Long> frequency = numbers.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

### Functional Interfaces
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Consumer
Consumer<String> printer = name -> System.out.println("Hello, " + name);
names.forEach(printer);

// Predicate
Predicate<String> longName = name -> name.length() > 4;
List<String> longNames = names.stream()
    .filter(longName)
    .collect(Collectors.toList());

// Function
Function<String, Integer> lengthFunction = String::length;
List<Integer> lengths = names.stream()
    .map(lengthFunction)
    .collect(Collectors.toList());

// Supplier
Supplier<List<String>> listSupplier = ArrayList::new;
List<String> newList = listSupplier.get();
```

## Best Practices

### Choosing the Right Collection

| Use Case | Recommended Collection | Reason |
|----------|----------------------|--------|
| General-purpose list | ArrayList | Fast random access |
| Thread-safe list | Collections.synchronizedList(new ArrayList<>()) | Synchronized when needed |
| Stack operations | ArrayDeque | Faster than Stack class |
| Queue operations | ArrayDeque | More efficient than LinkedList |
| Priority queue | PriorityQueue | Heap-based ordering |
| Unique elements | HashSet | Fast O(1) operations |
| Ordered unique elements | LinkedHashSet | Maintains insertion order |
| Sorted unique elements | TreeSet | Natural ordering |
| Key-value pairs | HashMap | Fast O(1) operations |
| Ordered key-value pairs | LinkedHashMap | Maintains insertion order |
| Sorted key-value pairs | TreeMap | Natural ordering |

### Performance Considerations

1. **Initial Capacity**: Set appropriate initial capacity to avoid resizing
   ```java
   List<String> list = new ArrayList<>(1000); // If expecting ~1000 elements
   Map<String, Integer> map = new HashMap<>(16); // Default is 16
   ```

2. **Synchronization**: Use only when necessary
   ```java
   // Bad: Always use Vector
   Vector<Integer> vector = new Vector<>(); // Unnecessary synchronization
   
   // Good: Use ArrayList when not needed
   List<Integer> list = new ArrayList<>();
   
   // Good: Synchronize only when needed
   List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
   ```

3. **Immutable Collections**: Use for thread-safe immutable data
   ```java
   List<String> immutable = Collections.unmodifiableList(new ArrayList<>(list));
   Set<String> immutableSet = Set.of("A", "B", "C"); // Java 9+
   ```

### Common Pitfalls

1. **ConcurrentModificationException**: Don't modify while iterating
   ```java
   // Bad
   for (String item : list) {
       if (item.equals("remove")) {
           list.remove(item); // Exception!
       }
   }
   
   // Good
   Iterator<String> iterator = list.iterator();
   while (iterator.hasNext()) {
       String item = iterator.next();
       if (item.equals("remove")) {
           iterator.remove();
       }
   }
   
   // Better (Java 8+)
   list.removeIf(item -> item.equals("remove"));
   ```

2. **NullPointerException**: Handle null values properly
   ```java
   // Bad
   map.get(key).toString(); // NPE if key not found
   
   // Good
   String value = map.get(key);
   if (value != null) {
       System.out.println(value);
   }
   
   // Better
   System.out.println(map.getOrDefault(key, "default"));
   ```

3. **Memory Leaks**: Remove references when done
   ```java
   // Cache with size limit
   Map<String, Object> cache = new LinkedHashMap<String, Object>(16, 0.75f, true) {
       @Override
       protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
           return size() > 100; // Limit to 100 entries
       }
   };
   ```

## Advanced Topics

### Custom Collections
```java
// Custom collection implementation
public class MyCollection<E> implements Collection<E> {
    private final List<E> backingList = new ArrayList<>();
    
    // Implement all required methods...
    @Override
    public boolean add(E e) {
        return backingList.add(e);
    }
    
    @Override
    public Iterator<E> iterator() {
        return backingList.iterator();
    }
    
    // ... other methods
}
```

### Collection Design Patterns
```java
// Builder pattern for collections
public class CollectionBuilder<T> {
    private final Collection<T> collection;
    
    public CollectionBuilder(Supplier<Collection<T>> supplier) {
        this.collection = supplier.get();
    }
    
    public CollectionBuilder<T> add(T item) {
        collection.add(item);
        return this;
    }
    
    public Collection<T> build() {
        return Collections.unmodifiableCollection(collection);
    }
}

// Usage
List<String> list = new CollectionBuilder<String>(ArrayList::new)
    .add("A")
    .add("B")
    .add("C")
    .build();
```

### Performance Testing
```java
// Performance comparison
public void comparePerformance() {
    int size = 1000000;
    
    // ArrayList performance
    long start = System.nanoTime();
    List<Integer> arrayList = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
        arrayList.add(i);
    }
    long arrayListTime = System.nanoTime() - start;
    
    // LinkedList performance
    start = System.nanoTime();
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < size; i++) {
        linkedList.add(i);
    }
    long linkedListTime = System.nanoTime() - start;
    
    System.out.println("ArrayList: " + arrayListTime + " ns");
    System.out.println("LinkedList: " + linkedListTime + " ns");
}
```

## Summary

The Java Collections Framework provides a comprehensive set of data structures and algorithms for working with collections of objects. Understanding the characteristics and appropriate use cases for each collection type is essential for writing efficient and maintainable Java code.

Key takeaways:
1. Choose the right collection for your specific use case
2. Consider performance implications of your choice
3. Use functional programming features for cleaner code
4. Handle synchronization and thread safety appropriately
5. Follow best practices to avoid common pitfalls

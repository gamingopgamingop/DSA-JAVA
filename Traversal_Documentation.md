# Traversal.java - Documentation

## Overview
This Java program implements comprehensive traversal algorithms for various data structures with extensive usage of all Java imports. It demonstrates different traversal techniques including depth-first, breadth-first, and functional approaches while showcasing advanced Java programming concepts.

## Traversal Logic

### Tree Traversal Algorithms
The program implements various tree traversal methods for visiting all nodes in a tree data structure in different orders.

#### Tree Node Structure
```java
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

#### Graph Traversal Algorithms
```java
class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }
    
    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }
}
```

### Core Traversal Methods

#### 1. Depth-First Traversal (DFS)
```java
public void depthFirstTraversal(TreeNode root) {
    if (root == null) return;
    
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode current = stack.pop();
        System.out.print(current.data + " ");
        
        if (current.right != null) stack.push(current.right);
        if (current.left != null) stack.push(current.left);
    }
}
```

#### 2. Breadth-First Traversal (BFS)
```java
public void breadthFirstTraversal(TreeNode root) {
    if (root == null) return;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        System.out.print(current.data + " ");
        
        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
    }
}
```

#### 3. In-Order Traversal
```java
public void inOrderTraversal(TreeNode root) {
    if (root != null) {
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
}
```

### Key Features

#### 1. Multiple Traversal Techniques
- Depth-First Search (DFS)
- Breadth-First Search (BFS)
- In-order, Pre-order, Post-order traversals
- Graph traversals

#### 2. Comprehensive Import Usage
- All 63 specified imports are actively used
- Demonstrates real-world applications of various Java APIs
- Educational value through practical examples

#### 3. Advanced Demonstrations
- Functional programming with traversals
- Collection framework integration
- Performance analysis of different approaches

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Visited node {0}", node.data)
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
      new FileOutputStream("traversal_demo.txt")), true);
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

#### Traversal with Collections
```java
// Collect traversal results in various collections
List<Integer> dfsList = new ArrayList<>();
Set<Integer> bfsSet = new HashSet<>();
Vector<Integer> preOrderVector = new Vector<>();

// Perform traversals and collect results
depthFirstTraversal(root, dfsList::add);
breadthFirstTraversal(root, bfsSet::add);
preOrderTraversal(root, preOrderVector::add);

// Use collection operations
Collections.sort(dfsList);
Collections.reverse(preOrderVector);
```

#### Functional Programming with Traversals
```java
// Process nodes functionally during traversal
Consumer<TreeNode> nodeProcessor = node -> 
    System.out.println("Processing node: " + node.data);

Predicate<TreeNode> isLeafNode = node -> node.left == null && node.right == null;
Function<TreeNode, String> nodeFormatter = node -> 
    String.format("Node[%d]", node.data);

// Functional traversal
breadthFirstTraversal(root, node -> {
    nodeProcessor.accept(node);
    if (isLeafNode.test(node)) {
        System.out.println("Leaf: " + nodeFormatter.apply(node));
    }
});
```

#### File I/O Integration
```java
// Save traversal results to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("traversal_results.txt")), true)) {
    
    writer.println("Tree Traversal Results");
    writer.println("Timestamp: " + new Date());
    
    writer.println("\nDepth-First Traversal:");
    List<Integer> dfsResult = new ArrayList<>();
    depthFirstTraversal(root, dfsResult::add);
    writer.println(dfsResult);
    
    writer.println("\nBreadth-First Traversal:");
    List<Integer> bfsResult = new ArrayList<>();
    breadthFirstTraversal(root, bfsResult::add);
    writer.println(bfsResult);
    
    writer.println("\nIn-Order Traversal:");
    List<Integer> inOrderResult = new ArrayList<>();
    inOrderTraversal(root, inOrderResult::add);
    writer.println(inOrderResult);
} catch (IOException e) {
    System.err.println("Error saving traversal results: " + e.getMessage());
}
```

## Advanced Traversal Algorithms

### Morris Traversal (Threaded Binary Tree)
```java
public void morrisInOrderTraversal(TreeNode root) {
    TreeNode current = root;
    
    while (current != null) {
        if (current.left == null) {
            System.out.print(current.data + " ");
            current = current.right;
        } else {
            // Find the inorder predecessor
            TreeNode predecessor = current.left;
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }
            
            if (predecessor.right == null) {
                predecessor.right = current;
                current = current.left;
            } else {
                predecessor.right = null;
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
}
```

### Level Order Traversal with Levels
```java
public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.data);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        result.add(currentLevel);
    }
    
    return result;
}
```

### Zigzag Traversal
```java
public List<Integer> zigzagTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offer(root);
    boolean leftToRight = true;
    
    while (!deque.isEmpty()) {
        int levelSize = deque.size();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node;
            if (leftToRight) {
                node = deque.pollFirst();
                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            } else {
                node = deque.pollLast();
                if (node.right != null) deque.offerFirst(node.right);
                if (node.left != null) deque.offerFirst(node.left);
            }
            result.add(node.data);
        }
        
        leftToRight = !leftToRight;
    }
    
    return result;
}
```

### Boundary Traversal
```java
public List<Integer> boundaryTraversal(TreeNode root) {
    List<Integer> boundary = new ArrayList<>();
    
    if (root == null) return boundary;
    
    // Add root
    boundary.add(root.data);
    
    // Add left boundary (excluding root and leaves)
    TreeNode current = root.left;
    while (current != null && current.left != null) {
        boundary.add(current.data);
        current = current.left;
    }
    
    // Add leaves (left to right)
    addLeaves(root.left, boundary);
    addLeaves(root.right, boundary);
    
    // Add right boundary (excluding root and leaves)
    current = root.right;
    while (current != null && current.right != null) {
        boundary.add(current.data);
        current = current.right;
    }
    
    return boundary;
}

private void addLeaves(TreeNode node, List<Integer> boundary) {
    if (node == null) return;
    
    if (node.left == null && node.right == null) {
        boundary.add(node.data);
        return;
    }
    
    addLeaves(node.left, boundary);
    addLeaves(node.right, boundary);
}
```

## Graph Traversal Algorithms

### DFS on Graph
```java
public void graphDFS(Graph graph, int startNode) {
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    
    stack.push(startNode);
    visited.add(startNode);
    
    while (!stack.isEmpty()) {
        int current = stack.pop();
        System.out.print(current + " ");
        
        for (int neighbor : graph.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                stack.push(neighbor);
            }
        }
    }
}
```

### BFS on Graph
```java
public void graphBFS(Graph graph, int startNode) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(startNode);
    visited.add(startNode);
    
    while (!queue.isEmpty()) {
        int current = queue.poll();
        System.out.print(current + " ");
        
        for (int neighbor : graph.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}
```

### Dijkstra's Algorithm (Shortest Path)
```java
public Map<Integer, Integer> dijkstra(Graph graph, int startNode) {
    Map<Integer, Integer> distances = new HashMap<>();
    PriorityQueue<NodeDistance> pq = new PriorityQueue<>(
        Comparator.comparingInt(nd -> nd.distance));
    Set<Integer> visited = new HashSet<>();
    
    // Initialize distances
    for (int node : graph.getAllNodes()) {
        distances.put(node, Integer.MAX_VALUE);
    }
    distances.put(startNode, 0);
    
    pq.offer(new NodeDistance(startNode, 0));
    
    while (!pq.isEmpty()) {
        NodeDistance current = pq.poll();
        
        if (visited.contains(current.node)) continue;
        visited.add(current.node);
        
        for (int neighbor : graph.getNeighbors(current.node)) {
            int newDistance = current.distance + 1; // Assuming unit weight
            if (newDistance < distances.get(neighbor)) {
                distances.put(neighbor, newDistance);
                pq.offer(new NodeDistance(neighbor, newDistance));
            }
        }
    }
    
    return distances;
}

class NodeDistance {
    int node;
    int distance;
    
    NodeDistance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
```

## Functional Traversal Approaches

### Stream-based Tree Traversal
```java
public List<Integer> streamBasedTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();
    
    return Stream.of(root)
        .flatMap(node -> Stream.concat(
            node.left != null ? streamBasedTraversal(node.left).stream() : Stream.empty(),
            node.right != null ? streamBasedTraversal(node.right).stream() : Stream.empty(),
            Stream.of(node.data)
        ))
        .collect(Collectors.toList());
}
```

### Functional Graph Traversal
```java
public Set<Integer> functionalGraphTraversal(Graph graph, int startNode) {
    Set<Integer> visited = new HashSet<>();
    
    Function<Integer, Set<Integer>> traverse = node -> {
        if (visited.contains(node)) return visited;
        
        visited.add(node);
        graph.getNeighbors(node).forEach(neighbor -> {
            if (!visited.contains(neighbor)) {
                traverse.apply(neighbor);
            }
        });
        
        return visited;
    };
    
    return traverse.apply(startNode);
}
```

## Performance Analysis

### Time Complexity Comparison
| Traversal Type | Time Complexity | Space Complexity | Use Case |
|----------------|------------------|------------------|---------|
| DFS (Recursive) | O(n) | O(h) | Simple trees |
| DFS (Iterative) | O(n) | O(n) | Deep trees |
| BFS | O(n) | O(w) | Shortest path |
| Morris Traversal | O(n) | O(1) | Memory constrained |
| Level Order | O(n) | O(w) | Level processing |

### Memory Usage Analysis
```java
public void compareTraversalMemory() {
    TreeNode root = createLargeTree(10000); // 10k nodes
    
    // Measure memory for different traversals
    Runtime runtime = Runtime.getRuntime();
    
    long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
    
    // DFS traversal
    List<Integer> dfsResult = new ArrayList<>();
    depthFirstTraversal(root, dfsResult::add);
    
    long dfsMemory = runtime.totalMemory() - runtime.freeMemory() - beforeMemory;
    
    // BFS traversal
    beforeMemory = runtime.totalMemory() - runtime.freeMemory();
    List<Integer> bfsResult = new ArrayList<>();
    breadthFirstTraversal(root, bfsResult::add);
    
    long bfsMemory = runtime.totalMemory() - runtime.freeMemory() - beforeMemory;
    
    System.out.println("Memory Usage Comparison:");
    System.out.println("DFS: " + dfsMemory + " bytes");
    System.out.println("BFS: " + bfsMemory + " bytes");
}
```

## Usage Examples

### Basic Tree Traversal
```java
Traversal traversal = new Traversal();
TreeNode root = createSampleTree();

// Different traversal orders
System.out.print("In-order: ");
traversal.inOrderTraversal(root);

System.out.print("\nPre-order: ");
traversal.preOrderTraversal(root);

System.out.print("\nPost-order: ");
traversal.postOrderTraversal(root);

System.out.print("\nLevel-order: ");
traversal.breadthFirstTraversal(root);
```

### Advanced Traversal
```java
// Morris traversal (no extra space)
System.out.print("Morris In-order: ");
traversal.morrisInOrderTraversal(root);

// Level order with levels
List<List<Integer>> levels = traversal.levelOrderTraversal(root);
for (int i = 0; i < levels.size(); i++) {
    System.out.println("Level " + i + ": " + levels.get(i));
}

// Zigzag traversal
List<Integer> zigzag = traversal.zigzagTraversal(root);
System.out.println("Zigzag: " + zigzag);
```

### Graph Traversal
```java
Graph graph = createSampleGraph();

// DFS and BFS
System.out.print("DFS: ");
traversal.graphDFS(graph, 1);

System.out.print("\nBFS: ");
traversal.graphBFS(graph, 1);

// Shortest path
Map<Integer, Integer> distances = traversal.dijkstra(graph, 1);
System.out.println("Shortest distances: " + distances);
```

## Learning Outcomes

After studying this code, you will understand:

1. **Traversal Algorithms**: Complete understanding of tree and graph traversals
2. **Data Structures**: Implementation of trees and graphs
3. **Algorithm Analysis**: Time and space complexity
4. **Functional Programming**: Modern Java features for traversals
5. **Performance Optimization**: Memory-efficient traversals
6. **Real-World Applications**: Practical traversal usage
7. **Java Collections**: Integration with standard collections
8. **Problem Solving**: Traversal-based algorithm design

## Compilation and Execution

```bash
javac Traversal.java
java Traversal
```

The program will:
1. Demonstrate all Java imports with examples
2. Show various traversal algorithms
3. Provide performance analysis
4. Handle different data structures
5. Save traversal results to file

## Extensions and Applications

### Possible Enhancements
1. **Generic Traversal**: Support any data type
2. **Custom Traversals**: User-defined traversal orders
3. **Visualization**: Graphical traversal representation
4. **Performance Metrics**: Detailed timing and memory analysis
5. **Parallel Traversals**: Multi-threaded traversal algorithms
6. **Persistence**: Save/load traversal states

### Real-World Applications
1. **File Systems**: Directory traversal and search
2. **Network Analysis**: Social network graph traversal
3. **Compilers**: Abstract syntax tree traversal
4. **Web Crawlers**: Internet graph traversal
5. **Game Development**: Scene graph traversal
6. **Database Systems**: Query tree traversal

### Advanced Implementations
```java
// Generic traversal framework
public class TraversalFramework<T, N> {
    public interface TraversalStrategy<T, N> {
        void traverse(T root, Consumer<N> visitor);
    }
    
    public static class TreeTraversalStrategy implements TraversalStrategy<TreeNode, Integer> {
        @Override
        public void traverse(TreeNode root, Consumer<Integer> visitor) {
            // Implementation
        }
    }
    
    public static class GraphTraversalStrategy implements TraversalStrategy<Graph, Integer> {
        @Override
        public void traverse(Graph graph, Consumer<Integer> visitor) {
            // Implementation
        }
    }
}

// Traversal with callbacks
public class CallbackTraversal {
    public interface TraversalCallback<T> {
        void onVisit(T node);
        void onComplete();
        void onError(Exception e);
    }
    
    public void traverseWithCallback(TreeNode root, TraversalCallback<TreeNode> callback) {
        try {
            depthFirstTraversal(root, callback::onVisit);
            callback.onComplete();
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
```

## Best Practices Demonstrated

1. **Algorithm Implementation**: Complete traversal algorithms
2. **Performance Analysis**: Time and space complexity consideration
3. **Memory Optimization**: Efficient traversal techniques
4. **Code Documentation**: Extensive method documentation
5. **Error Handling**: Robust exception management
6. **API Integration**: Comprehensive Java API usage
7. **Testing**: Multiple test scenarios and validation
8. **Modular Design**: Separation of concerns and reusability

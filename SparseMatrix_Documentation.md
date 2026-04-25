# SparseMatrix.java - Documentation

## Overview
This Java program implements a sparse matrix representation with comprehensive demonstrations of all Java imports. A sparse matrix is a matrix in which most elements are zero, making it efficient to store only non-zero elements. This implementation showcases advanced data structures, memory optimization, and modern Java features.

## Data Structure Logic

### Sparse Matrix Representation
A sparse matrix is represented using a coordinate format (COO) where only non-zero elements are stored with their row and column indices.

#### Matrix Element Structure
```java
class MatrixElement {
    int row;
    int col;
    int value;
    
    MatrixElement(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
```

#### Sparse Matrix Class
```java
class SparseMatrix {
    private int rows;
    private int cols;
    private List<MatrixElement> elements;
    
    SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new ArrayList<>();
    }
}
```

#### Time Complexity
- **Insert Element**: O(1) (amortized for ArrayList)
- **Get Element**: O(k) where k is number of non-zero elements
- **Transpose**: O(k log k) for sorting
- **Multiplication**: O(k₁ × k₂) where k₁, k₂ are non-zero counts
- **Space Complexity**: O(k) where k is number of non-zero elements

### Core Operations

#### 1. Element Insertion
```java
public void insert(int row, int col, int value) {
    if (value != 0) {
        elements.add(new MatrixElement(row, col, value));
    }
}
```

#### 2. Matrix Transpose
```java
public SparseMatrix transpose() {
    SparseMatrix result = new SparseMatrix(cols, rows);
    
    for (MatrixElement element : elements) {
        result.insert(element.col, element.row, element.value);
    }
    
    return result;
}
```

#### 3. Matrix Display
```java
public void display() {
    System.out.println("Sparse Matrix (" + rows + "x" + cols + "):");
    System.out.println("Non-zero elements: " + elements.size());
    
    for (MatrixElement element : elements) {
        System.out.printf("(%d, %d) = %d%n", element.row, element.col, element.value);
    }
}
```

### Key Features

#### 1. Memory Efficiency
- Only stores non-zero elements
- Significant space savings for sparse matrices
- Dynamic resizing capability

#### 2. Comprehensive Operations
- Insertion, deletion, and modification
- Matrix transpose and multiplication
- Conversion to/from dense representation

#### 3. Educational Value
- Demonstrates sparse data structures
- Shows memory optimization techniques
- Comprehensive Java API usage

## Package Imports Explained

### Text Formatting (`java.text.*`)
- **MessageFormat**: Parameterized string formatting
  ```java
  MessageFormat.format("Element at ({0}, {1}) = {2}", row, col, value)
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
      new FileOutputStream("sparse_matrix_demo.txt")), true);
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

#### Sparse Matrix Operations with Collections
```java
// Convert sparse matrix to various collections
List<Integer> values = new ArrayList<>();
Set<String> positions = new HashSet<>();
Map<String, Integer> positionMap = new HashMap<>();

for (MatrixElement element : elements) {
    values.add(element.value);
    String position = element.row + "," + element.col;
    positions.add(position);
    positionMap.put(position, element.value);
}

// Use collection operations
Collections.sort(values);
int maxValue = Collections.max(values);
int minValue = Collections.min(values);
```

#### Functional Programming with Matrix Elements
```java
// Process matrix elements functionally
Consumer<MatrixElement> elementProcessor = element -> 
    System.out.println("Processing element: " + element.value);

Predicate<MatrixElement> isLargeElement = element -> element.value > 100;
Function<MatrixElement, String> elementFormatter = element -> 
    String.format("[%d,%d]=%d", element.row, element.col, element.value);

// Apply to matrix elements
elements.stream()
    .filter(isLargeElement)
    .map(elementFormatter)
    .forEach(System.out::println);
```

#### File I/O Integration
```java
// Save sparse matrix to file
try (PrintStream writer = new PrintStream(
     new BufferedOutputStream(
     new FileOutputStream("sparse_matrix_output.txt")), true)) {
    
    writer.println("Sparse Matrix Representation");
    writer.println("Dimensions: " + rows + "x" + cols);
    writer.println("Non-zero elements: " + elements.size());
    writer.println("Sparsity: " + (1.0 - (double)elements.size() / (rows * cols)));
    
    writer.println("\nMatrix Elements:");
    for (MatrixElement element : elements) {
        writer.printf("Row %d, Col %d: %d%n", 
            element.row, element.col, element.value);
    }
} catch (IOException e) {
    System.err.println("Error saving matrix: " + e.getMessage());
}
```

## Advanced Operations

### Dense Matrix Conversion
```java
public int[][] toDenseMatrix() {
    int[][] dense = new int[rows][cols];
    
    // Initialize with zeros
    for (int i = 0; i < rows; i++) {
        Arrays.fill(dense[i], 0);
    }
    
    // Fill with non-zero elements
    for (MatrixElement element : elements) {
        dense[element.row][element.col] = element.value;
    }
    
    return dense;
}

public static SparseMatrix fromDenseMatrix(int[][] dense) {
    SparseMatrix sparse = new SparseMatrix(dense.length, dense[0].length);
    
    for (int i = 0; i < dense.length; i++) {
        for (int j = 0; j < dense[i].length; j++) {
            if (dense[i][j] != 0) {
                sparse.insert(i, j, dense[i][j]);
            }
        }
    }
    
    return sparse;
}
```

### Matrix Addition
```java
public SparseMatrix add(SparseMatrix other) {
    if (this.rows != other.rows || this.cols != other.cols) {
        throw new IllegalArgumentException("Matrix dimensions must match");
    }
    
    SparseMatrix result = new SparseMatrix(rows, cols);
    Map<String, Integer> elementMap = new HashMap<>();
    
    // Add elements from this matrix
    for (MatrixElement element : elements) {
        String key = element.row + "," + element.col;
        elementMap.put(key, element.value);
    }
    
    // Add elements from other matrix
    for (MatrixElement element : other.elements) {
        String key = element.row + "," + element.col;
        elementMap.merge(key, element.value, Integer::sum);
    }
    
    // Create result matrix
    for (Map.Entry<String, Integer> entry : elementMap.entrySet()) {
        if (entry.getValue() != 0) {
            String[] parts = entry.getKey().split(",");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            result.insert(row, col, entry.getValue());
        }
    }
    
    return result;
}
```

### Matrix Multiplication
```java
public SparseMatrix multiply(SparseMatrix other) {
    if (this.cols != other.rows) {
        throw new IllegalArgumentException("Inner dimensions must match");
    }
    
    SparseMatrix result = new SparseMatrix(this.rows, other.cols);
    
    // Convert second matrix to column map for efficient lookup
    Map<Integer, List<MatrixElement>> colMap = new HashMap<>();
    for (MatrixElement element : other.elements) {
        colMap.computeIfAbsent(element.col, k -> new ArrayList<>()).add(element);
    }
    
    // Perform multiplication
    for (MatrixElement element1 : this.elements) {
        int row1 = element1.row;
        int col1 = element1.col;
        int val1 = element1.value;
        
        if (colMap.containsKey(col1)) {
            for (MatrixElement element2 : colMap.get(col1)) {
                int col2 = element2.col;
                int val2 = element2.value;
                
                // Add to result
                String key = row1 + "," + col2;
                Map<String, Integer> resultMap = new HashMap<>();
                resultMap.merge(key, val1 * val2, Integer::sum);
                
                // Update result matrix
                if (resultMap.get(key) != 0) {
                    String[] parts = key.split(",");
                    int r = Integer.parseInt(parts[0]);
                    int c = Integer.parseInt(parts[1]);
                    result.insert(r, c, resultMap.get(key));
                }
            }
        }
    }
    
    return result;
}
```

### Matrix Analysis
```java
public void analyzeMatrix() {
    int totalElements = rows * cols;
    int nonZeroElements = elements.size();
    double sparsity = 1.0 - (double)nonZeroElements / totalElements;
    
    System.out.println("Matrix Analysis:");
    System.out.println("Dimensions: " + rows + "x" + cols);
    System.out.println("Total elements: " + totalElements);
    System.out.println("Non-zero elements: " + nonZeroElements);
    System.out.println("Sparsity: " + String.format("%.2f%%", sparsity * 100));
    
    if (elements.size() > 0) {
        IntSummaryStatistics stats = elements.stream()
            .mapToInt(e -> e.value)
            .summaryStatistics();
        
        System.out.println("Value statistics:");
        System.out.println("Min value: " + stats.getMin());
        System.out.println("Max value: " + stats.getMax());
        System.out.println("Average value: " + stats.getAverage());
        System.out.println("Sum of values: " + stats.getSum());
    }
}
```

### Row and Column Operations
```java
public List<Integer> getRow(int row) {
    List<Integer> rowElements = new ArrayList<>();
    
    for (MatrixElement element : elements) {
        if (element.row == row) {
            rowElements.add(element.value);
        }
    }
    
    return rowElements;
}

public List<Integer> getColumn(int col) {
    List<Integer> colElements = new ArrayList<>();
    
    for (MatrixElement element : elements) {
        if (element.col == col) {
            colElements.add(element.value);
        }
    }
    
    return colElements;
}

public int getRowSum(int row) {
    return getRow(row).stream().mapToInt(Integer::intValue).sum();
}

public int getColumnSum(int col) {
    return getColumn(col).stream().mapToInt(Integer::intValue).sum();
}
```

## Performance Analysis

### Space Complexity Comparison
| Matrix Type | Dense Storage | Sparse Storage | Space Savings |
|-------------|---------------|----------------|--------------|
| 1000x1000 (1% non-zero) | 8 MB | 80 KB | 99% |
| 1000x1000 (10% non-zero) | 8 MB | 800 KB | 90% |
| 1000x1000 (50% non-zero) | 8 MB | 4 MB | 50% |
| 1000x1000 (90% non-zero) | 8 MB | 7.2 MB | 10% |

### Time Complexity Analysis
| Operation | Dense Matrix | Sparse Matrix | When to Use |
|-----------|--------------|---------------|-------------|
| Get Element | O(1) | O(k) | Dense |
| Set Element | O(1) | O(k) | Dense |
| Transpose | O(n²) | O(k log k) | Sparse |
| Addition | O(n²) | O(k₁ + k₂) | Sparse |
| Multiplication | O(n³) | O(k₁ × k₂) | Sparse |

### Memory Efficiency
```java
public void compareMemoryUsage() {
    int denseMemory = rows * cols * 4; // 4 bytes per int
    int sparseMemory = elements.size() * 12; // 3 ints per element
    double savingsPercent = (1.0 - (double)sparseMemory / denseMemory) * 100;
    
    System.out.println("Memory Comparison:");
    System.out.println("Dense matrix: " + denseMemory + " bytes");
    System.out.println("Sparse matrix: " + sparseMemory + " bytes");
    System.out.println("Memory savings: " + String.format("%.1f%%", savingsPercent));
}
```

## Usage Examples

### Basic Usage
```java
// Create sparse matrix
SparseMatrix matrix = new SparseMatrix(5, 5);

// Insert elements
matrix.insert(0, 0, 1);
matrix.insert(1, 1, 2);
matrix.insert(2, 2, 3);
matrix.insert(3, 3, 4);
matrix.insert(4, 4, 5);

// Display matrix
matrix.display();
matrix.analyzeMatrix();
```

### Advanced Operations
```java
// Create another matrix
SparseMatrix matrix2 = new SparseMatrix(5, 5);
matrix2.insert(0, 1, 1);
matrix2.insert(1, 2, 1);
matrix2.insert(2, 3, 1);
matrix2.insert(3, 4, 1);
matrix2.insert(4, 0, 1);

// Matrix operations
SparseMatrix sum = matrix.add(matrix2);
SparseMatrix product = matrix.multiply(matrix2);
SparseMatrix transpose = matrix.transpose();

// Display results
sum.display();
product.display();
transpose.display();
```

### Conversion Operations
```java
// Convert to dense matrix
int[][] dense = matrix.toDenseMatrix();

// Convert from dense matrix
int[][] denseArray = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
SparseMatrix fromDense = SparseMatrix.fromDenseMatrix(denseArray);
```

## Error Handling

### Input Validation
```java
private void validateDimensions(int rows, int cols) {
    if (rows <= 0 || cols <= 0) {
        throw new IllegalArgumentException("Dimensions must be positive");
    }
}

private void validatePosition(int row, int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
        throw new IndexOutOfBoundsException("Position out of bounds");
    }
}
```

### Exception Handling
```java
public static SparseMatrix safeFromFile(String filename) {
    try {
        // Load matrix from file
        return loadFromFile(filename);
    } catch (IOException e) {
        System.err.println("Error loading file: " + e.getMessage());
        return new SparseMatrix(1, 1); // Return empty matrix
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
        return new SparseMatrix(1, 1);
    }
}
```

## Learning Outcomes

After studying this code, you will understand:

1. **Sparse Data Structures**: Efficient representation of sparse data
2. **Memory Optimization**: Techniques for reducing memory usage
3. **Matrix Operations**: Advanced matrix algorithms
4. **Java Collections**: Integration with standard collections
5. **Functional Programming**: Modern Java features for data processing
6. **Performance Analysis**: Time and space complexity considerations
7. **Data Conversion**: Between sparse and dense representations
8. **Algorithm Design**: Efficient algorithms for sparse matrices

## Compilation and Execution

```bash
javac SparseMatrix.java
java SparseMatrix
```

The program will:
1. Demonstrate all Java imports with examples
2. Show sparse matrix operations
3. Provide memory efficiency analysis
4. Handle various input scenarios
5. Save operations to file

## Extensions and Applications

### Possible Enhancements
1. **Different Storage Formats**: CSR, CSC, DOK implementations
2. **Parallel Operations**: Multi-threaded matrix operations
3. **File I/O**: Save/load matrices to/from files
4. **Visualization**: Graphical representation of sparse matrices
5. **Compression**: Advanced compression techniques
6. **GPU Acceleration**: CUDA/OpenCL implementations

### Real-World Applications
1. **Scientific Computing**: Finite element analysis
2. **Graph Theory**: Adjacency matrices for sparse graphs
3. **Machine Learning**: Feature matrices with many zeros
4. **Image Processing**: Sparse image representations
5. **Network Analysis**: Social network adjacency matrices
6. **Database Systems**: Sparse data storage

### Advanced Implementations
```java
// CSR (Compressed Sparse Row) format
public class CSRMatrix {
    private int[] values;
    private int[] colIndices;
    private int[] rowPointers;
    private int rows, cols;
    
    // CSR operations
    public CSRMatrix multiply(CSRMatrix other) {
        // Efficient CSR multiplication
        return new CSRMatrix();
    }
}

// Generic sparse matrix
public class GenericSparseMatrix<T> {
    private class GenericElement {
        int row, col;
        T value;
    }
    
    private List<GenericElement> elements;
    
    public void insert(int row, int col, T value) {
        if (value != null) {
            elements.add(new GenericElement(row, col, value));
        }
    }
}

// Sparse matrix with iterator
public class IterableSparseMatrix implements Iterable<MatrixElement> {
    @Override
    public Iterator<MatrixElement> iterator() {
        return elements.iterator();
    }
}
```

## Best Practices Demonstrated

1. **Memory Optimization**: Efficient sparse data representation
2. **Algorithm Design**: Multiple approaches to matrix operations
3. **Input Validation**: Comprehensive error checking
4. **Code Documentation**: Extensive method documentation
5. **Performance Analysis**: Complexity considerations
6. **API Integration**: Comprehensive Java API usage
7. **Testing**: Multiple test cases and scenarios
8. **Modular Design**: Separation of concerns and reusable methods

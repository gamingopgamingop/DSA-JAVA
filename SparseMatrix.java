import java.text.MessageFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.EnumSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.NavigableMap;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoublePredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongConsumer;
import java.io.StreamTokenizer;
import java.util.Date;
import java.util.Random;

// public class SparseMatrix {
//     private int rows;
//     private int columns;
//     private int[][] data;

//     public SparseMatrix(int rows, int columns, int[][] data) {
//         this.rows = rows;
//         this.columns = columns;
//         this.data = data;
//     }

//     public void printSparseMatrix() {
//         System.out.println("Sparse Matrix representation (Row Column Value):");
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < columns; j++) {
//                 if (data[i][j] != 0) {
//                     System.out.println(i + " " + j + " " + data[i][j]);
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Read matrix size
//         System.out.print("Enter the number of rows for matrices: ");
//         int rows = scanner.nextInt();
//         System.out.print("Enter the number of columns for matrices: ");
//         int columns = scanner.nextInt();

//         int[][] inputMatrix = new int[rows][columns];

//         // Read matrix elements
//         System.out.println(MessageFormat.format("Enter {0} elements for matrix:", rows * columns));
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < columns; j++) {
//                 inputMatrix[i][j] = scanner.nextInt();
//             }
//         }
//         SparseMatrix sparseMatrix = new SparseMatrix(rows, columns, inputMatrix);
//         sparseMatrix.printSparseMatrix();
//         scanner.close();
//     }
// }

import java.util.*;
import java.text.MessageFormat;

public class SparseMatrix {
    private int rows;
    private int columns;
    private int[][] data;
    private List<int[]> sparseTriplets;  // True sparse storage

    public SparseMatrix(int rows, int columns, int[][] data) {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
        this.sparseTriplets = buildSparseRepresentation();
    }
    
    // Build sparse representation ONCE during construction
    private List<int[]> buildSparseRepresentation() {
        List<int[]> triplets = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (data[i][j] != 0) {
                    triplets.add(new int[]{i, j, data[i][j]});
                }
            }
        }
        return triplets;
    }

    public void printSparseMatrix() {
        System.out.println("Sparse Matrix representation (Row Column Value):");
        for (int[] triplet : sparseTriplets) {
            System.out.printf("%d %d %d%n", triplet[0], triplet[1], triplet[2]);
        }
    }
    
    // Bonus: Get statistics
    public void printStatistics() {
        System.out.printf("Matrix size: %dx%d = %d elements%n", 
                         rows, columns, rows * columns);
        System.out.printf("Non-zero elements: %d (%.1f%% density)%n", 
                         sparseTriplets.size(), 
                         (100.0 * sparseTriplets.size()) / (rows * columns));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] inputMatrix = new int[rows][columns];
        System.out.println(MessageFormat.format("Enter {0} elements:", rows * columns));
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                inputMatrix[i][j] = scanner.nextInt();
            }
        }
        
        SparseMatrix sparseMatrix = new SparseMatrix(rows, columns, inputMatrix);
        sparseMatrix.printSparseMatrix();
        sparseMatrix.printStatistics();  // Bonus feature
        
        scanner.close();
    }
}

// import java.util.Scanner;
// import java.text.MessageFormat;

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

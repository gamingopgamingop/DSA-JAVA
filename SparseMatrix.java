import java.util.Scanner;
import java.text.MessageFormat;

public class SparseMatrix {
    private int rows;
    private int columns;
    private int[][] data;

    public SparseMatrix(int rows, int columns, int[][] data) {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
    }

    public void printSparseMatrix() {
        System.out.println("Sparse Matrix representation (Row Column Value):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (data[i][j] != 0) {
                    System.out.println(i + " " + j + " " + data[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix size
        System.out.print("Enter the number of rows for matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrices: ");
        int columns = scanner.nextInt();

        int[][] inputMatrix = new int[rows][columns];

        // Read matrix elements
        System.out.println(MessageFormat.format("Enter {0} elements for matrix:", rows * columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                inputMatrix[i][j] = scanner.nextInt();
            }
        }
        SparseMatrix sparseMatrix = new SparseMatrix(rows, columns, inputMatrix);
        sparseMatrix.printSparseMatrix();
        scanner.close();
    }
}

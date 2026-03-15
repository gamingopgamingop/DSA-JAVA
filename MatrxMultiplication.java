import java.util.Scanner;
import java.text.MessageFormat;

public class MatrxMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix size
        System.out.print("Enter the number of rows for matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrices: ");
        int columns = scanner.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] resultMatrix = new int[rows][columns];

        // Read matrix1 elements
        System.out.println(MessageFormat.format("Enter {0} elements for matrix 1:", rows * columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Read matrix2 elements
        System.out.println(MessageFormat.format("Enter {0} elements for matrix 2:", rows * columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
         // Matrix multiplication
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < columns; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        // Print result matrix
        System.out.println("Result Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
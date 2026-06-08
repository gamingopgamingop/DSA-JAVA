import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Factorial Calculator");
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers!");
        } else {
            long result = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
        }
        
        scanner.close();
    }
    
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
}

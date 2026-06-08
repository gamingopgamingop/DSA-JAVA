import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Fibonacci Sequence Generator");
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive number!");
        } else {
            System.out.println("Fibonacci sequence up to " + n + " terms:");
            generateFibonacci(n);
        }
        
        scanner.close();
    }
    
    public static void generateFibonacci(int n) {
        int first = 0, second = 1;
        
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    public static int getNthFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }
}

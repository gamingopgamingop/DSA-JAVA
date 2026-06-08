import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Palindrome Checker");
        System.out.println("1. Check String");
        System.out.println("2. Check Number");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch(choice) {
            case 1:
                checkStringPalindrome(scanner);
                break;
            case 2:
                checkNumberPalindrome(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
    
    public static void checkStringPalindrome(Scanner scanner) {
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (isStringPalindrome(cleanedStr)) {
            System.out.println("'" + str + "' is a palindrome!");
        } else {
            System.out.println("'" + str + "' is not a palindrome!");
        }
    }
    
    public static void checkNumberPalindrome(Scanner scanner) {
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (isNumberPalindrome(number)) {
            System.out.println(number + " is a palindrome!");
        } else {
            System.out.println(number + " is not a palindrome!");
        }
    }
    
    public static boolean isStringPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    public static boolean isNumberPalindrome(int number) {
        int original = number;
        int reversed = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        
        return original == reversed;
    }
}

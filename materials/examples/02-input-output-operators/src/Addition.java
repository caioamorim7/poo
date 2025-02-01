import java.util.Scanner;

public class Addition {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first integer: ");
            int a = scanner.nextInt();

            System.out.println("Enter second integer: ");
            int b = scanner.nextInt();
            
            int sum = a + b;
            System.out.println("The sum is: " + sum);
        }
    }

}

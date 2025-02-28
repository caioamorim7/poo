import java.util.Scanner;

public class Fibonacci {
    public static long calcularFibonacci (int n) {
        return 10;
    }

    public static String formatarSaida (long f) {
        return "";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inteiro;
        inteiro = scanner.nextInt();
        if (inteiro < 0) {
            scanner.close();
            throw new java.lang.Error("this is very bad");
        }
        scanner.close();
    }
}

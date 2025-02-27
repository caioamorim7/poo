import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long fibonacci = calcularFibonacci(n);
        String resultado = formatarSaida(n, fibonacci);

        System.out.println(resultado);
        scanner.close();
    }
    public static long calcularFibonacci(int n ) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static String formatarSaida(int n, long fibonacci) {
        return String.format("O %dº do número de Fibonacci é %d", n, fibonacci);
    }
}

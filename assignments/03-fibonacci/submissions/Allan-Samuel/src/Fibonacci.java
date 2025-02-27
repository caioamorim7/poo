/* Nome: Allan Samuel Alves do Monte
   Matrícula: 24101279     */
   
import java.util.Scanner;

public class Fibonacci {
    
    public static long calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long a = 0; 
        long b = 1; 
        long fib = 0;
        
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }
    
    public static String formatarSaida(int n, long fib) {
        return "O " + n + "º número de Fibonacci é: " + fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Por favor, insira um número não negativo.");
            return;
        }

        long resultado = calcularFibonacci(n);
        System.out.println(formatarSaida(n, resultado));
        scanner.close();
    }
}


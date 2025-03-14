import java.util.Scanner;

public class MedianCalculator {

    // Método para calcular a mediana de três números inteiros
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        } else {
            return c;
        }
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário três números inteiros
        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        // Calcula e exibe a mediana
        int mediana = findMedian(num1, num2, num3);
        System.out.println("A mediana dos números é: " + mediana);

        scanner.close();
    }
}


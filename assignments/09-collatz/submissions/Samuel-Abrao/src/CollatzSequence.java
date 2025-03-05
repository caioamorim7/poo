import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        return (n % 2 == 0) ? n / 2 : (n * 3) + 1;
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
        }
        sum += 1; // Adiciona o último termo da sequência (1)
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                }
            } else {
                scanner.next(); // Limpa entrada inválida
            }
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        }

        System.out.print("Sequência de Collatz: ");
        int temp = n;
        System.out.print(temp);
        while (temp != 1) {
            temp = nextCollatz(temp);
            System.out.print(" → " + temp);
        }

        System.out.println("\nSoma dos termos: " + calculateCollatzSum(n));

        scanner.close();
    }
}

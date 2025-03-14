import java.util.Scanner;

public class CollatzSequence {

    // Método para calcular o próximo número da sequência de Collatz
    public static int nextCollatz(int n) {
        return (n % 2 == 0) ? n / 2 : (n * 3) + 1;
    }

    // Método para calcular a sequência de Collatz e retornar a soma dos termos
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        System.out.print("Sequência de Collatz: " + n);

        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
            System.out.print(" → " + n);
        }

        sum += 1; // Adicionando o último termo (1)
        System.out.println();
        return sum;
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                break; // Entrada válida, sai do loop
            }
        }

        int sum = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }
}


import java.util.Scanner;

public class PsalindromeChecker {

    // Método para verificar se a entrada é válida (não vazia e sem espaços excessivos)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Método para verificar se a sequência é um palíndromo
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase(); // Ignora diferenças entre maiúsculas e minúsculas
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue; // Solicita nova entrada
            }

            if (isPalindrome(input)) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }
            break; // Encerra após uma entrada válida
        }
        scanner.close();
    }
}

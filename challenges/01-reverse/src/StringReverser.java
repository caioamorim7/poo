import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite uma string: ");
            String input = scanner.nextLine();

            // Verifica se a string é nula ou composta apenas por espaços
            if (input == null || input.trim().isEmpty()) {
                System.out.println("A string não pode ser vazia ou composta apenas por espaços.");
            } else {
                System.out.printf("String invertida: %s%n", reverseString(input));
            }
        }
    }

    public static String reverseString(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }

        int length = inputString.length();
        char[] reversedArray = new char[length];

        // Percorre a string de trás para frente e armazena no array
        for (int i = 0; i < length; i++) {
            reversedArray[i] = inputString.charAt(length - 1 - i);
        }

        // Retorna a string invertida
        return new String(reversedArray);
    }
}

import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {
<<<<<<< HEAD
        
        try (Scanner scanner = new Scanner(System.in)) {
=======
        try(Scanner scanner = new Scanner(System.in)){
>>>>>>> upstream/2025.1
            System.out.print("Digite uma string: ");
            String input = scanner.nextLine();
            System.out.printf("String invertida: %s\n", reverse(input));
<<<<<<< HEAD
        }
    }

    public static String reverse(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("A string não pode ser nula ou vazia.");
=======

       }
    }

    public static String reverse(String inputString) {

        if (inputString == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
>>>>>>> upstream/2025.1
        }

        StringBuilder reversedString = new StringBuilder();
  
<<<<<<< HEAD
        for (int i = inputString.length() - 1; i >= 0; i--) {
=======
        for (int i = inputString.length()-1; i >= 0; i--) {
>>>>>>> upstream/2025.1
            reversedString.append(inputString.charAt(i));
        }
        
        return reversedString.toString();
<<<<<<< HEAD
=======
 
>>>>>>> upstream/2025.1
    }
}
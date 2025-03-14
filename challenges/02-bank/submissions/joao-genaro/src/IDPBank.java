import java.util.Scanner;

public class IDPBank {


    private static Customer customer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {

            System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Digite o número correspondente à opção desejada: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine(); 
                continue;
            }
        }
    }

}
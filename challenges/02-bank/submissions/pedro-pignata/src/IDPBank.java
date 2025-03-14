import java.util.Scanner;

public class IDPBank {
    public static void main(String[] args){
        System.out.println(""
        +"Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:\n\n"
        +"1. Abrir conta \n"
        +"2. Consultar cliente \n"
        +"3. Depositar \n"
        +"4. Sacar \n"
        +"5. Sair \n\n"
        +"Digite o número correspondente à opção desejada: ");
        Scanner scanner = new Scanner(System.in);

        int escolha = scanner.nextInt();
        scanner.nextLine();

    }



}
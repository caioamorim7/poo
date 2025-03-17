import java.util.Scanner;
import java.util.random.RandomGenerator.StreamableGenerator;

public class IDPBank {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:");
        System.out.println(" ");
        System.out.println("1. Abrir conta");
        System.out.println("2. Consultar cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Sair");
        System.out.println(" ");
        System.out.println("Digite o número correspondente à opção desejada:");
        int resposta = scanner.nextInt();

        switch (resposta) {
            case 1:
                System.out.println("Digite os dados para a abertura da conta.");
                System.out.println(" ");
                System.out.println("Digite o seu primeiro nome: ");
                String firstName = scanner.nextLine();
                System.out.println("Digite seu sobrenome: ");
                String lastName = scanner.nextLine();
                System.out.println("Digite o seu CPF: ");
                String CPF = scanner.nextLine();
                break;
            case 2:    

        }

    }

    public static Customer createCustomer(String firstName, String lastName, String CPF) {
        return new Customer(firstName, lastName, CPF);
    }
    

    public static Account openAccount(){

        return Account();
    }

    public static void deposit(double amount){
        if(amount > 0){
            currentAccount.deposit(amount);
        }else{
            System.out.println("O depósito deve ser positivo");
        }
        
        
        return amount + balance;

    }
public static void withdraw(double amount){
    if(amount>0){
        boolean success = currentAccount.withdraw(amount);
        if(!success){
            System.out.println("Saldo induficiente");
        }else{
System.out.println("O valor do saque deve ser positivo");
        }
    }
}


}

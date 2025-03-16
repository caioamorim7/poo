import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o saldo inicial: ");
            double initialBalance = scanner.nextDouble();
            
            SavingsAccount account = new SavingsAccount(initialBalance);
            
            System.out.print("Informe a taxa de juros anual (%): ");
            double initialRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(initialRate);
            
            System.out.println("\nSaldos com taxa de juros de " + initialRate + "%:");
            for (int month = 1; month <= 12; month++) {
                account.calculateMonthlyInterest();
                System.out.println("Mês " + month + ": " + account.getFormattedBalance());
            }
            
            System.out.print("\nInforme a nova taxa de juros anual: ");
            double newRate = scanner.nextDouble();
            SavingsAccount.setAnnualInterestRate(newRate);
            
            System.out.println("\nAlterando taxa de juros anual para " + newRate + "%...");
            account.calculateMonthlyInterest();
            System.out.println("Mês 13: " + account.getFormattedBalance());
        }
    }
}

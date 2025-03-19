import java.util.Scanner;

public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterestRate = annualInterestRate / 12; // Taxa mensal em decimal
        double monthlyInterest = savingsBalance * monthlyInterestRate;
        savingsBalance += monthlyInterest;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("A taxa de juro não pode ser negativa.");
        }
        annualInterestRate = rate / 100.0; // Convertendo a taxa de porcentagem para decimal
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o saldo inicial
        System.out.print("Informe o saldo inicial: ");
        double initialBalance = scanner.nextDouble();

        // Criar a conta poupança
        SavingsAccount account = new SavingsAccount(initialBalance);

        // Solicitar a taxa de juros anual
        System.out.print("Informe a taxa de juros anual (%): ");
        double annualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(annualInterestRate);

        // Calcular e exibir os saldos atualizados para cada mês ao longo de 12 meses
        System.out.printf("Saldos com taxa de juros de %.1f%%:\n", annualInterestRate);
        for (int month = 1; month <= 12; month++) {
            account.calculateMonthlyInterest();
            System.out.printf("Mês %d: R$%.2f\n", month, account.getSavingsBalance());
        }

        // Solicitar a nova taxa de juros anual
        System.out.print("Informe a nova taxa de juros anual (%): ");
        double newAnnualInterestRate = scanner.nextDouble();
        SavingsAccount.setAnnualInterestRate(newAnnualInterestRate);

        // Calcular e exibir o saldo após mais um mês com a nova taxa de juros
        System.out.printf("Alterando taxa de juros anual para %.1f%%...\n", newAnnualInterestRate);
        account.calculateMonthlyInterest();
        System.out.printf("Mês 13: R$%.2f\n", account.getSavingsBalance());

        scanner.close();
    }
}
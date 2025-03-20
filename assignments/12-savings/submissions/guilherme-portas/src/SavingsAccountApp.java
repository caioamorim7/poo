import java.util.Scanner;

public class SavingsAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa de juros anual (%): ");
        double taxaJuros = scanner.nextDouble();

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setSavingsBalance(saldoInicial);
        savingsAccount.setTaxaJuros(taxaJuros);

        System.out.printf("Saldos com taxa de juros de %.1f%%\n", taxaJuros);
        int mes;
        double saldo = saldoInicial;
        for(mes = 1; mes <= 12; mes++) {
            saldo += saldo * savingsAccount.calculateMonthlyInterest();
            savingsAccount.setSavingsBalance(saldo);
            System.out.printf("Mês %d: R$ %.2f \n", mes, savingsAccount.getSavingsBalance());
        }

        System.out.print("Informe a nova taxa de juros: ");
        taxaJuros = scanner.nextDouble();

        savingsAccount.setTaxaJuros(taxaJuros);
        System.out.printf("Alterando taxa de juros anual para %f %% \n", savingsAccount.getTaxaJuros());

        saldo += saldo * savingsAccount.calculateMonthlyInterest();
        savingsAccount.setSavingsBalance(saldo);
        System.out.printf("Mês %d: R$ %.2f \n", mes, savingsAccount.getSavingsBalance());

        scanner.close();
    }
}
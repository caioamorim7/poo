public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.savingsBalance = initialBalance;
    }

    public void calculateMonthlyInterest() {

        double monthlyInterestRate = (Math.pow(1D+(annualInterestRate/100D),(1D/12D))) - 1;

        double monthlyInterest = (savingsBalance) * monthlyInterestRate;

        savingsBalance += monthlyInterest;
    }

    public static void setAnnualInterestRate(double newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException("A taxa de juros não pode ser negativa.");
        }
        annualInterestRate = newRate;
    }

    public String getFormattedBalance() {
        return String.format("R$%.2f", savingsBalance);
    }

    public double getBalance() {
        return savingsBalance;
    }
}

import java.lang.Math;

public class SavingsAccount {
    private double savingsBalance;
    private double taxaAnual;

    public static double annualInterestRate() {
        return 10;
    }

    public void setSavingsBalance(double savingsBalance) {
        if(savingsBalance < 0) throw new java.lang.IllegalArgumentException("O saldo inicial não pode ser negativo.");
        else this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    
    public double calculateMonthlyInterest() {
        return Math.pow(1 + this.taxaAnual / 100d, 1d/12) - 1;
    }

    public void setTaxaJuros(double taxaAnual) {
        this.taxaAnual = taxaAnual;
    }

    public double getTaxaJuros() {
        return this.taxaAnual;
    }


}
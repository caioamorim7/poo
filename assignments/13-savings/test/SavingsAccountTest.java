import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private SavingsAccount saver1;
    private SavingsAccount saver2;

    @BeforeEach
    void setUp() {
        // Criando contas com saldos iniciais
        saver1 = new SavingsAccount(2000.00);
        saver2 = new SavingsAccount(3000.00);
    }

    @Test
    void testCalculateMonthlyInterest() {
        SavingsAccount.setAnnualInterestRate(4.0); // Definindo taxa de juros como 4%

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        assertEquals(2006.67, saver1.getSavingsBalance(), 0.01);
        assertEquals(3010.00, saver2.getSavingsBalance(), 0.01);
    }

    @Test
    void testModifyInterestRateWithSetter() {
        SavingsAccount.setAnnualInterestRate(5.0); // Alterando taxa de juros para 5%
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        assertEquals(2008.33, saver1.getSavingsBalance(), 0.01);
        assertEquals(3012.50, saver2.getSavingsBalance(), 0.01);
    }

    @Test
    void testGetAnnualInterestRate() {
        SavingsAccount.setAnnualInterestRate(3.5);
        assertEquals(0.035, SavingsAccount.getAnnualInterestRate());
    }

    @Test
    void testNegativeInterestRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SavingsAccount.setAnnualInterestRate(-1.0);
        });
        assertEquals("A taxa de juros não pode ser negativa.", exception.getMessage());
    }

    @Test
    void testNegativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SavingsAccount(-500.00);
        });
        assertEquals("O saldo inicial não pode ser negativo.", exception.getMessage());
    }
}

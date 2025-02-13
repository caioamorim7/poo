import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElefantePassosTest {

    @Test
    public void testPosicaoMinima() {
        int resultado = ElefantePassos.calcularPassosMinimos(1);
        assertEquals(1, resultado, "O número mínimo de passos para x=1 deve ser 1.");
    }

    @Test
    public void testPosicaoMaxima() {
        int resultado = ElefantePassos.calcularPassosMinimos(1_000_000);
        assertEquals(200_000, resultado, "O número mínimo de passos para x=1.000.000 deve ser 200.000.");
    }

    @Test
    public void testPosicaoMultiploDeCinco() {
        int resultado = ElefantePassos.calcularPassosMinimos(10);
        assertEquals(2, resultado, "O número mínimo de passos para x=10 deve ser 2.");
    }

    @Test
    public void testPosicaoNaoMultiploDeCinco() {
        int resultado = ElefantePassos.calcularPassosMinimos(12);
        assertEquals(3, resultado, "O número mínimo de passos para x=12 deve ser 3.");
    }

    @Test
    public void testPosicaoGrandeNaoMultiploDeCinco() {
        int resultado = ElefantePassos.calcularPassosMinimos(999_999);
        assertEquals(200_000, resultado, "O número mínimo de passos para x=999.999 deve ser 200.000.");
    }

    @Test
    public void testPosicaoInvalidaZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ElefantePassos.calcularPassosMinimos(0);
        });
        assertEquals("A posição deve estar entre 1 e 1.000.000.", exception.getMessage());
    }

    @Test
    public void testPosicaoInvalidaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ElefantePassos.calcularPassosMinimos(-5);
        });
        assertEquals("A posição deve estar entre 1 e 1.000.000.", exception.getMessage());
    }

    @Test
    public void testPosicaoAcimaDoLimite() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ElefantePassos.calcularPassosMinimos(1_000_001);
        });
        assertEquals("A posição deve estar entre 1 e 1.000.000.", exception.getMessage());
    }

    @Test
    public void testCondicaoFalsaParaMultiploDeCinco() {
        int resultado = ElefantePassos.calcularPassosMinimos(25);
        assertEquals(5, resultado, "A condição deve avaliar corretamente múltiplos de 5.");
    }

    @Test
    public void testCondicaoFalsaParaNaoMultiploDeCinco() {
        int resultado = ElefantePassos.calcularPassosMinimos(27);
        assertEquals(6, resultado, "A condição deve avaliar corretamente números que não são múltiplos de 5.");
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FortalecerSenhaTest {

    @Test
    public void testSenhaMinima() {
        String resultado = FortalecerSenha.fortalecerSenha("a");
        assertEquals("wa", resultado, "A melhor senha para 'a' deveria ser 'wa'.");
    }

    @Test
    public void testSenhaMaxima() {
        String resultado = FortalecerSenha.fortalecerSenha("abcdefghij");
        assertEquals("abcdefghijz", resultado, "A melhor senha para 'abcdefghij' deveria incluir 'z' para maximizar o tempo.");
    }

    @Test
    public void testSenhaTamanhoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FortalecerSenha.fortalecerSenha("");
        });
        assertEquals("O tamanho da senha deve estar entre 1 e 10 caracteres.", exception.getMessage());
    }

    @Test
    public void testSenhaComCaracteresIguais()

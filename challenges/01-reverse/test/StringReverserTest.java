import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringReverserTest {

    @Test
    public void testEmptyString() {
        assertEquals("", StringReverser.reverse(""), "A string vazia deve permanecer vazia");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("a", StringReverser.reverse("a"), "Uma string de um caractere deve retornar o mesmo caractere");
    }

    @ParameterizedTest
    @CsvSource({
        "Java, avaJ",
        "OpenAI, IAnepO",
        "12345, 54321",
        "racecar, racecar",   // Palíndromo, saída deve ser igual à entrada
        "Hello World, dlroW olleH"
    })
    public void testRegularStrings(String input, String expected) {
        assertEquals(expected, StringReverser.reverse(input),
                "A string deve ser corretamente invertida");
    }

    @ParameterizedTest
    @NullSource
    public void testNullString(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> StringReverser.reverse(input),
                "Uma string nula deve lançar uma IllegalArgumentException");
        assertEquals("A string não pode ser nula.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        " ' ', ' ' ",          // Um único espaço deve permanecer o mesmo
        " '   ', '   ' ",      // Vários espaços devem permanecer os mesmos
        " 'abc def', 'fed cba' ",  // Espaços entre palavras
        " ' leading', 'gnidael ' ",  // Espaço no início
        " 'trailing ', ' gniliart' " // Espaço no final
    })
    public void testStringWithSpaces(String input, String expected) {
        assertEquals(expected, StringReverser.reverse(input),
                "A string com espaços deve ser invertida corretamente");
    }

    @ParameterizedTest
    @CsvSource({
        " 'hello!', '!olleh' ",
        " 'Café', 'éfaC' ",
        " '@123$', '$321@' ",
        " '日本語', '語本日' "  // Teste com caracteres Unicode
    })
    public void testStringWithSpecialCharacters(String input, String expected) {
        assertEquals(expected, StringReverser.reverse(input),
                "A string com caracteres especiais deve ser invertida corretamente");
    }

    @Test
    public void testPerformance() {
        String longString = "a".repeat(100000); // String de 100 mil caracteres 'a'
        assertTimeoutPreemptively(java.time.Duration.ofSeconds(1), () -> {
            StringReverser.reverse(longString);
        }, "A reversão de uma string longa deve ser concluída em menos de 1 segundo");
    }

    @ParameterizedTest
    @CsvSource({
        " 'AbCdEfG', 'GfEdCbA' ",
        " 'JaVa', 'aVaJ' "
    })
    public void testCaseSensitivity(String input, String expected) {
        assertEquals(expected, StringReverser.reverse(input),
                "A inversão deve manter as letras maiúsculas e minúsculas corretamente");
    }
}

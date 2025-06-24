import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

public class RelatorioComprasPorClienteTest {

    @Test
    public void testFluxoBasico() {
        List<String> input = List.of(
            "João,ProdutoA,100.0",
            "Maria,ProdutoB,200.0",
            "João,ProdutoC,50.0"
        );
        Map<String, Double> resultado = RelatorioComprasPorCliente.acumulaCompras(input);

        assertEquals(2, resultado.size());
        assertEquals(150.0, resultado.get("João"), 0.001);
        assertEquals(200.0, resultado.get("Maria"), 0.001);
    }

    @Test
    public void testIgnoraMalformadasENaN() {
        List<String> input = List.of(
            "Ana,ItemX,10.5",
            "Linha inválida",
            "Bob,ItemY,nãoÉNúmero",
            "Ana,ItemZ,20"
        );
        Map<String, Double> resultado = RelatorioComprasPorCliente.acumulaCompras(input);

        assertEquals(1, resultado.size());
        assertEquals(30.5, resultado.get("Ana"), 0.001);
    }
}
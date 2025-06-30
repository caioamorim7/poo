import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class RelatorioComprasPorCliente {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java RelatorioComprasPorCliente <caminho_entrada> <caminho_saida>");
            System.exit(1);
        }

        Path inputPath  = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        try {
            List<String> linhas = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
            Map<String, Double> totaisPorCliente = acumulaCompras(linhas);

            
            List<String> linhasSaida = totaisPorCliente.entrySet().stream()
                .map(e -> String.format("%s: %.2f", e.getKey(), e.getValue()))
                .toList();

            Files.write(outputPath, linhasSaida, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
            System.exit(1);
        }
    }

    
    public static Map<String, Double> acumulaCompras(List<String> linhas) {
        Map<String, Double> mapa = new LinkedHashMap<>();
        for (String linha : linhas) {
            if (linha == null || linha.isBlank()) continue;
            String[] parts = linha.split(",");
            if (parts.length < 3) continue;

            String cliente = parts[0].trim();
            String valorStr = parts[2].trim();
            try {
                double valor = Double.parseDouble(valorStr);
                mapa.put(cliente, mapa.getOrDefault(cliente, 0.0) + valor);
            } catch (NumberFormatException ex) {
                
                System.err.println("Valor inválido para o cliente " + cliente + ": " + valorStr);
                continue;
            }
        }
        return mapa;
    }
}
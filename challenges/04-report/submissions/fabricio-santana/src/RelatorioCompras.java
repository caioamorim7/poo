import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class RelatorioCompras {
    public static void main(String[] args) {
        Path arquivoEntrada = Path.of(args[0]);
        Path arquivoSaida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            ArrayList<String> linhas = new ArrayList<>(Files.readAllLines(arquivoEntrada));

            for (String linha : linhas) {
                String[] partes = linha.split(",");
                if (partes.length != 3) continue;

                String cliente = partes[0].trim();
                double valor = Double.parseDouble(partes[2].trim());

                int indice = clientes.indexOf(cliente);
                if (indice >= 0) {
                    double totalAtual = totais.get(indice);
                    totais.set(indice, totalAtual + valor);
                } else {
                    clientes.add(cliente);
                    totais.add(valor);
                }
            }

            ArrayList<String> relatorio = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(arquivoSaida, relatorio);
            System.out.println("Relatório gerado com sucesso!");

        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

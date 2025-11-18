import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ArquivoUtils {
    public static List<String> lerArquivo(String caminho) throws IOException {
        Path path = Paths.get(caminho);
        return Files.readAllLines(path);
    }

    public static void escreverArquivo(String caminho, List<String> linhas) throws IOException {
        Path path = Paths.get(caminho);
        Files.write(path, linhas);
    }
}

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <arquivoEntrada> <arquivoSaida>");
            return;
        }

        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = ArquivoUtils.lerArquivo(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) continue;

                String nome = partes[0].trim();
                String valorStr = partes[2].trim();

                double valor;
                try {
                    valor = Double.parseDouble(valorStr);
                } catch (NumberFormatException e) {
                    continue;
                }

                int index = clientes.indexOf(nome);
                if (index >= 0) {
                    totais.set(index, totais.get(index) + valor);
                } else {
                    clientes.add(nome);
                    totais.add(valor);
                }
            }

            List<String> relatorio = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            ArquivoUtils.escreverArquivo(caminhoSaida, relatorio);
            System.out.println("Relatório gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao acessar arquivos: " + e.getMessage());
        }
    }
}

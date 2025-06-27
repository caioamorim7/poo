import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilmsFromFile(String caminhoArquivo) {
        List<Film> listaDeFilmes = new ArrayList<>();

        try {
            List<String> linhasDoArquivo = Files.readAllLines(Paths.get(caminhoArquivo));
            if (!linhasDoArquivo.isEmpty()) {
                linhasDoArquivo.remove(0); 
            }

            for (String linha : linhasDoArquivo) {
                String[] campos = linha.split(";");
                if (campos.length == 5) {
                    String titulo = campos[0];
                    int idIdioma = Integer.parseInt(campos[1]);
                    int duracaoLocacao = Integer.parseInt(campos[2]);
                    double precoLocacao = Double.parseDouble(campos[3]);
                    double custoReposicao = Double.parseDouble(campos[4]);

                    listaDeFilmes.add(new Film(titulo, idIdioma, duracaoLocacao, precoLocacao, custoReposicao));
                }
            }

        } catch (IOException excecao) {
            System.out.println("Erro ao ler o arquivo: " + excecao.getMessage());
        }

        return listaDeFilmes;
    }
}

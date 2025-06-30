import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public static List<Film> readFilmsFromFile(String caminho) {
        List<Film> filmes = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Path.of(caminho));
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes.length != 5) continue;

                String title = partes[0];
                int languageId = Integer.parseInt(partes[1]);
                int rentalDuration = Integer.parseInt(partes[2]);
                double rentalRate = Double.parseDouble(partes[3]);
                double replacementCost = Double.parseDouble(partes[4]);

                filmes.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return filmes;
    }
}

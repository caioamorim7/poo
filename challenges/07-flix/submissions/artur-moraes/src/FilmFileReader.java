// FilmFileReader.java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath)); // lê todas as linhas de uma vez
            for (String line : lines) {
                
                if (line.trim().isEmpty() || line.startsWith("#")) continue; //ignorar linhas vazias e comentarios

                String[] parts = line.split(";"); // separa em partes usando ; como separador
                String title              = parts[0];
                int languageId            = Integer.parseInt(parts[1]);
                int rentalDuration        = Integer.parseInt(parts[2]);
                double rentalRate         = Double.parseDouble(parts[3]);
                double replacementCost    = Double.parseDouble(parts[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo de filmes: " + e.getMessage());
            e.printStackTrace();
        }
        return films;
    }
}

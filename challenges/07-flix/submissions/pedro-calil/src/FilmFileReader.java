import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    
    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length != 5) {
                    System.err.println("Linha inválida, pulando: " + line);
                    continue;
                }

                String title           = parts[0];
                int languageId         = Integer.parseInt(parts[1]);
                int rentalDuration     = Integer.parseInt(parts[2]);
                double rentalRate      = Double.parseDouble(parts[3]);
                double replacementCost = Double.parseDouble(parts[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler '" + filePath + "': " + e.getMessage());
        }

        return films;
    }
}

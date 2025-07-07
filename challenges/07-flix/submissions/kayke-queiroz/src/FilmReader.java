import java.util.*;
import java.nio.file.*;

public class FilmReader {
    public static List<Film> readFromFile(String path) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String title = parts[0];
                    int languageId = Integer.parseInt(parts[1]);
                    int rentDuration = Integer.parseInt(parts[2]);
                    double rentalRate = Double.parseDouble(parts[3]);
                    double replacementCost = Double.parseDouble(parts[4]);

                    films.add(new Film(title, languageId, rentDuration, rentalRate, replacementCost));
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return films;
    }
}

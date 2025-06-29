// Nome: Allan Samuel Alves do Monte

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String title = parts[0];
                    int languageId = Integer.parseInt(parts[1]);
                    int rentalDuration = Integer.parseInt(parts[2]);
                    double rentalRate = Double.parseDouble(parts[3]);
                    double replacementCost = Double.parseDouble(parts[4]);

                    Film film = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                    films.add(film);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return films;
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {
    public static List<Film> readFilmsFromFile(String filePath) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (line.trim().isEmpty() || line.startsWith("title")) continue;
                String[] parts = line.split(";");
                String title = parts[0];
                int languageId = Integer.parseInt(parts[1]);
                int rentDuration = Integer.parseInt(parts[2]);
                double rentalRate = Double.parseDouble(parts[3]);
                double replacementCost = Double.parseDouble(parts[4]);
                films.add(new Film(title, languageId, rentDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return films;
    }
}

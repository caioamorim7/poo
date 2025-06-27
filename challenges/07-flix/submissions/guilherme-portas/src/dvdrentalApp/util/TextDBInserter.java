package dvdrentalApp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.nio.file.Path;
import java.util.List;

import dvdrentalApp.model.Film;
import dvdrentalApp.dao.FilmDAO;

public class TextDBInserter {
    private static final Path newFilms = Paths.get("new_films.txt");

    public static void importNewFilms() throws IOException, SQLException{
        List<String> f = Files.readAllLines(newFilms);
        for(String lines : f) {
            String atributos[] = lines.split(";");
            FilmDAO.insert(new Film(atributos[0], Integer.parseInt(atributos[1]), Integer.parseInt(atributos[2]), Double.parseDouble(atributos[3]), Double.parseDouble(atributos[4])));
        }
    }
}

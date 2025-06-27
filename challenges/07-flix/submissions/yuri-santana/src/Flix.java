
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Flix {
  public static void main(String[] args) {
    System.out.println("Iniciando tarefa da IDP Flix...");

    try {
      List<Film> newFilms = readFilmsFromFile("new_films.txt");

      try (Connection connection = ConexaoBanco.conectar()) {
        FilmDao filmDAO = new FilmDao(connection);

        System.out.println("\n[OPERAÇÃO 1] Inserindo " + newFilms.size() + " novos filmes no banco de dados...");
        filmDAO.insertFilms(newFilms);
        System.out.println("Filmes inseridos com sucesso!");

        System.out.println("\n[OPERAÇÃO 2] Atualizando a taxa de aluguel de todos os filmes em 10%...");
        int updatedRows = filmDAO.updateAllRentalRates();
        System.out.println(updatedRows + " filmes tiveram sua taxa de aluguel atualizada.");

        System.out.println("\n[OPERAÇÃO 3] Buscando filmes com longa duração...");
        filmDAO.listFilmsWithLongDuration();

      } catch (SQLException e) {
        System.err.println("ERRO DE BANCO DE DADOS: " + e.getMessage());
        e.printStackTrace();
      }

    } catch (IOException | URISyntaxException e) {
      System.err.println("ERRO AO LER O ARQUIVO: " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("\nTarefa finalizada.");
  }


  private static List<Film> readFilmsFromFile(String fileName) throws IOException, URISyntaxException {
    List<Film> films = new ArrayList<>();


    Path path = Path.of("../../data/new_films.txt");
    if (path == null) {
      throw new IOException("Arquivo não encontrado: " + fileName);
    }

    List<String> lines = Files.readAllLines(path);

    for (String line : lines) {
      if (line.trim().isEmpty()) {
        continue;
      }
      String[] fields = line.split(";");
      if (fields.length == 5) {
        Film film = new Film(
            fields[0].trim(),
            Integer.parseInt(fields[1].trim()),
            Integer.parseInt(fields[2].trim()),
            Double.parseDouble(fields[3].trim()),
            Double.parseDouble(fields[4].trim())
        );
        films.add(film);
      }
    }
    return films;
  }

}

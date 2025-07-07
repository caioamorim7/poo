import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../../data/new_films.txt"; 
        List<Film> films = FilmFileReader.readFilmsFromFile(filePath); //classe que le o arquivo, usando java.nio.file.Files.readAllLines()

        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
        String user = "postgres.snghnxpdoffuasscqmms";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            //insere os filmes presentes no arquivo csv
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    stmt.setString(1, film.getTitle());
                    stmt.setInt(2, film.getLanguageId());
                    stmt.setInt(3, film.getRentalDuration());
                    stmt.setDouble(4, film.getRentalRate());
                    stmt.setDouble(5, film.getReplacementCost());
                    stmt.executeUpdate();
                }
                System.out.println("Filmes importados com sucesso!");
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1"; // atualiza o rental rate
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                int updatedRows = stmt.executeUpdate();
                System.out.println("Locação atualizada em 10% para " + updatedRows + " filmes.");
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99"; // seleeciona os filmes com rental duration = 99
            try (PreparedStatement stmt = conn.prepareStatement(selectSql);
                 ResultSet rs = stmt.executeQuery()) {
                System.out.println("Filmes com rent_duration = 99:");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("- %s | R$ %.2f\n", title, rentalRate);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}

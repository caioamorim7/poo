import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class FilmMain {
    public static void main(String[] args) {
        String url="jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
        String user="postgres.snghnxpdoffuasscqmms";
        String password= "";

        String filePath = "../../data/new_films.txt";

        List<Film> films = FilmReader.readFromFile(filePath);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Inserir filmes
            String insertSQL = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                for (Film f : films) {
                    stmt.setString(1, f.getTitle());
                    stmt.setInt(2, f.getLanguageId());
                    stmt.setInt(3, f.getRentalDuration());
                    stmt.setDouble(4, f.getRentalRate());
                    stmt.setDouble(5, f.getReplacementCost());
                    stmt.executeUpdate();
                }
                System.out.println("Os filmes importados com sucesso.");
            }

            // Atualizar rental_rate
            String updateSQL = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement stmt = conn.prepareStatement(updateSQL)) {
                int rows = stmt.executeUpdate();
                System.out.println("Valores de locação atualizados para " + rows + " filmes.");
            }

            // Listar filmes com rent_duration = 99
            String selectSQL = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement stmt = conn.prepareStatement(selectSQL);
                 ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nOS Filmes com rent_duration = 99:");
                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - R$ " + rs.getDouble("rental_rate"));
                }
            }

        } catch (Exception e) {
            System.err.println("Falha no banco de dados: " + e.getMessage());
        }
    }
}

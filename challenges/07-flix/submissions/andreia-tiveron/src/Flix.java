import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Flix {
    private static final String DB_URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
    private static final String DB_USER = "postgres.snghnxpdoffuasscqmms";
    private static final String DB_PASSWORD = "idpccpoo";

    public static void main(String[] args) {
        String filePath = "C:/Users/andre/Downloads/Estrutura de Dados/POO/poo/challenges/07-flix/data/new_films.txt";
        List<Film> films = LeitorArquivo.readFilmsFromFile(filePath);


        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false); 

            
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    stmt.setString(1, film.getTitle());
                    stmt.setInt(2, film.getLanguageId());
                    stmt.setInt(3, film.getRentalDuration());
                    stmt.setDouble(4, film.getRentalRate());
                    stmt.setDouble(5, film.getReplacementCost());
                    stmt.addBatch();
                }
                stmt.executeBatch();
            }

            // update o rental_rate em 10%
            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                stmt.executeUpdate();
            }

            //rent_duration = 99
            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement stmt = conn.prepareStatement(selectSql);
                 ResultSet rs = stmt.executeQuery()) {
                System.out.println("\nFilmes com rent_duration = 99:");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.println("Título: " + title + " | Preço locação: R$ " + rentalRate);
                }
            }

            conn.commit();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e);
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlixApp {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:5432/postgres";
        String user = "postgres";
        String password = "";
        String filePath = "../../data/new_films.txt";

        List<Film> films = FilmFileReader.readFilmsFromFile(filePath);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    pstmt.setString(1, film.getTitle());
                    pstmt.setInt(2, film.getLanguageId());
                    pstmt.setInt(3, film.getRentalDuration());
                    pstmt.setDouble(4, film.getRentalRate());
                    pstmt.setDouble(5, film.getReplacementCost());
                    pstmt.executeUpdate();
                }
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.executeUpdate();
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.println("Título: " + title + " | Rental Rate: " + rentalRate);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro de banco de dados: " + e.getMessage());
        }
    }
}

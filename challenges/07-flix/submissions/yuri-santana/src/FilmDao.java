
import java.sql.*;
import java.util.List;

public class FilmDao {

    private Connection connection;

    public FilmDao(Connection connection) {
        this.connection = connection;
    }

    public void insertFilms(List<Film> films) throws SQLException {
        String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Film film : films) {
                ps.setString(1, film.getTitle());
                ps.setInt(2, film.getLanguageId());
                ps.setInt(3, film.getRentalDuration());
                ps.setDouble(4, film.getRentalRate());
                ps.setDouble(5, film.getReplacementCost());
                ps.addBatch(); 
            }
            ps.executeBatch();
        }
    }

    public int updateAllRentalRates() throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            return ps.executeUpdate();
        }
    }

    public void listFilmsWithLongDuration() throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration >= 99";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            boolean found = false;
            System.out.println("\n--- Filmes com Duração de Locação >= 99 ---");
            while (rs.next()) {
                found = true;
                String title = rs.getString("title");
                double rentalRate = rs.getDouble("rental_rate");
                System.out.printf("Título: %s, Nova Taxa de Aluguel: %.2f%n", title, rentalRate);
            }
            if(!found){
                System.out.println("Nenhum filme encontrado com os critérios especificados.");
            }
            System.out.println("------------------------------------------");
        }
    }
}
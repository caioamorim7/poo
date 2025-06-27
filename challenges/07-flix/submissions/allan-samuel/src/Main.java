// Nome: Allan Samuel Alves do Monte

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "******"; 
        String filePath = "C:\Users\Nitro five\poo\challenges\07-flix\submissions\allan-samuel\new_films.txt"; 

        List<Film> films = FilmFileReader.readFilmsFromFile(filePath);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                for (Film film : films) {
                    ps.setString(1, film.getTitle());
                    ps.setInt(2, film.getLanguageId());
                    ps.setInt(3, film.getRentalDuration());
                    ps.setDouble(4, film.getRentalRate());
                    ps.setDouble(5, film.getReplacementCost());
                    ps.addBatch();
                }
                ps.executeBatch();
                System.out.println("Filmes importados com sucesso.");
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                int updated = ps.executeUpdate();
                System.out.println("Taxa de locação atualizada para " + updated + " filmes.");
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement ps = conn.prepareStatement(selectSql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("\nFilmes com rent_duration = 99:");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate = rs.getDouble("rental_rate");
                    System.out.printf("Título: %s | Preço: %.2f%n", title, rate);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
}

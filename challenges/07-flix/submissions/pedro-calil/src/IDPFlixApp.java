import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class IDPFlixApp {

    
    private static final String PROPS_FILE     = "data/db.properties";
    private static final String NEW_FILMS_FILE = "data/new_films.txt";

    public static void main(String[] args) {
        
        Properties props = new Properties();
        try (var in = Files.newInputStream(Paths.get(PROPS_FILE))) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Não consegui carregar " + PROPS_FILE + ": " + e.getMessage());
            return;
        }
        String url = props.getProperty("url");
        String usr = props.getProperty("user");
        String pwd = props.getProperty("password");

        
        List<Film> newFilms = FilmFileReader.readFilms(NEW_FILMS_FILE);
        if (newFilms.isEmpty()) {
            System.out.println("Nenhum filme para importar.");
            return;
        }

        
        try (Connection conn = DriverManager.getConnection(url, usr, pwd)) {
            conn.setAutoCommit(false);

            insertFilms(conn, newFilms);
            updateRentalRates(conn);
            conn.commit();

            listFilmsWithDuration(conn, 99);

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertFilms(Connection conn, List<Film> films) throws SQLException {
        String sql = """
            INSERT INTO film
             (title, language_id, rental_duration, rental_rate, replacement_cost)
            VALUES (?, ?, ?, ?, ?)
            """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Film f : films) {
                stmt.setString(1, f.getTitle());
                stmt.setInt   (2, f.getLanguageId());
                stmt.setInt   (3, f.getRentalDuration());
                stmt.setDouble(4, f.getRentalRate());
                stmt.setDouble(5, f.getReplacementCost());
                stmt.addBatch();
            }
            int[] res = stmt.executeBatch();
            System.out.println("Inseridos " + res.length + " novos filmes.");
        }
    }

    private static void updateRentalRates(Connection conn) throws SQLException {
        String sql = "UPDATE film SET rental_rate = rental_rate * 1.1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            int count = stmt.executeUpdate();
            System.out.println("Atualizados rental_rate de " + count + " filmes (+10%).");
        }
    }

    private static void listFilmsWithDuration(Connection conn, int duration) throws SQLException {
        String sql = "SELECT title, rental_rate FROM film WHERE rental_duration = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, duration);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n--- Filmes com rental_duration = " + duration + " ---");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate  = rs.getDouble("rental_rate");
                    System.out.printf("%-30s  R$ %.2f%n", title, rate);
                }
            }
        }
    }
}

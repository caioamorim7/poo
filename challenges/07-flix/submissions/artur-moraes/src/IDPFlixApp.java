// IDPFlixApp.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IDPFlixApp {

    // configuração do DB
    private static final String JDBC_URL      = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
    // usuario
    private static final String JDBC_USER     = "postgres.snghnxpdoffuasscqmms"; 
    // senha
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        String filePath = "../../data/new_films.txt";  // tem que estar na pasta onde vai ser executado o programa
        List<Film> films = FilmFileReader.readFilms(filePath); // Lê todas as linhas do arquivo de uma vez

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            conn.setAutoCommit(false);

            // Insere os novos filmes
            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) " 
                             + "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
                for (Film f : films) {
                    ps.setString(1, f.getTitle());
                    ps.setInt   (2, f.getLanguageId());
                    ps.setInt   (3, f.getRentalDuration());
                    ps.setDouble(4, f.getRentalRate());
                    ps.setDouble(5, f.getReplacementCost());

                    ps.addBatch(); // Adiciona ao lote em vez de executar imediatamente
                }
                ps.executeBatch(); // Executa todas as inserções de uma vez
            }

            // Atualiza 10% no rental_rate de todos os filmes
            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(sqlUpdate)) {
                int updated = ps.executeUpdate();
                System.out.println("Filmes atualizados: " + updated);
            }

            // Lista os filmes com rental_duration = 99
            String sqlSelect = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement ps = conn.prepareStatement(sqlSelect);
                 ResultSet rs = ps.executeQuery()) {
                System.out.println("=== Filmes com rental_duration = 99 ===");
                while (rs.next()) {
                    String title = rs.getString("title");
                    double rate  = rs.getDouble("rental_rate");
                    System.out.printf("%-50s | %.2f%n", title, rate);
                }
            }

            conn.commit();
        } catch (Exception e) {
            System.err.println("Erro na operação com o banco: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

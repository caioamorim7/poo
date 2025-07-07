import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       String caminhoArquivo = "../../data/new_films.txt";
        List<Film> filmes = FilmReader.readFilmsFromFile(caminhoArquivo);

        try (Connection conexao = ConexaoSupabase.conectar()) {
            // INSERIR FILMES
            String sqlInserir = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir)) {
                for (Film f : filmes) {
                    stmt.setString(1, f.getTitle());
                    stmt.setInt(2, f.getLanguageId());
                    stmt.setInt(3, f.getRentalDuration());
                    stmt.setDouble(4, f.getRentalRate());
                    stmt.setDouble(5, f.getReplacementCost());
                    stmt.executeUpdate();
                }
                System.out.println("✅ Inserção concluída.");
            }

            // ATUALIZAR VALOR DE LOCAÇÃO
            String sqlAtualizar = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
                stmt.executeUpdate();
                System.out.println("✅ Atualização de rental_rate concluída.");
            }

            // LISTAR FILMES COM DURAÇÃO 99
            String sqlListar = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlListar);
                 ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n📋 Filmes com rental_duration = 99:");
                while (rs.next()) {
                    String titulo = rs.getString("title");
                    double preco = rs.getDouble("rental_rate");
                    System.out.println("- " + titulo + " | R$ " + preco);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IDPFlixApp {

    public static void main(String[] args) {
        String caminhoDoArquivo = "../../data/new_films.txt";
        List<Film> listaDeFilmes = FilmFileReader.readFilmsFromFile(caminhoDoArquivo);

        try (Connection conexao = ConexaoSupabase.getConnection()) {

            String sqlInsercao = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement declaracao = conexao.prepareStatement(sqlInsercao)) {
                for (Film filme : listaDeFilmes) {
                    declaracao.setString(1, filme.getTitle());
                    declaracao.setInt(2, filme.getLanguageId());
                    declaracao.setInt(3, filme.getRentalDuration());
                    declaracao.setDouble(4, filme.getRentalRate());
                    declaracao.setDouble(5, filme.getReplacementCost());
                    declaracao.executeUpdate();
                }
            }

            String sqlAtualizacao = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement declaracao = conexao.prepareStatement(sqlAtualizacao)) {
                int linhasAtualizadas = declaracao.executeUpdate();
                System.out.println("Atualizados " + linhasAtualizadas + " filmes com 10% de aumento no rental_rate.");
            }

            String sqlConsulta = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement declaracao = conexao.prepareStatement(sqlConsulta);
                 ResultSet resultado = declaracao.executeQuery()) {
                System.out.println("Filmes com rental_duration = 99:");
                while (resultado.next()) {
                    System.out.println("Título: " + resultado.getString("title") +
                                       ", Preço: R$" + resultado.getDouble("rental_rate"));
                }
            }

        } catch (SQLException excecao) {
            System.out.println("Erro ao acessar o banco de dados: " + excecao.getMessage());
        }
    }
}

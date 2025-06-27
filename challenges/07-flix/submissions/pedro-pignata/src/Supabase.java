import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Supabase {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:5432/postgres";
        String usuario = "postgres";
        String senha = "postgres";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
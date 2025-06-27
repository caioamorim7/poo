import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSupabase {

    private static final String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres";
    private static final String USUARIO = "postgres.azrwlyjtlxykpbuimxmh";
    private static final String SENHA = "Tereza01";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

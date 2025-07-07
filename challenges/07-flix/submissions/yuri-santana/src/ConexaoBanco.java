
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexaoBanco {

    public static Connection conectar() {
        Connection conexao = null;

        try (InputStream input = ConexaoBanco.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo db.properties não encontrado.");
            }

            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.user");
            String senha = props.getProperty("db.password");
            System.out.println(url);
            System.out.println(usuario);
            System.out.println(senha);

            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexao;
    }

    public static void main(String[] args) {
        conectar();
    }
}


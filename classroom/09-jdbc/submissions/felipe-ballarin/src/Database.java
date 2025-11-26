import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
            // Opcional em versões novas do Java, mas bom para garantir em JDBC puro raiz:
            Class.forName("org.postgresql.Driver"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}
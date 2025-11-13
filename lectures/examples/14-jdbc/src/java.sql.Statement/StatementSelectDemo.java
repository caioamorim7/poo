import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StatementSelectDemo {

    private static String DATABASE_URL;
    private static String USER;
    private static String PASSWORD;

    public static void main(String[] args) {

        try {

            loadDatabaseProperties();
        
            try(
                Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ACTOR LIMIT 10")
            ){

                readResultSet(resultSet);
                
            } catch(SQLException sqlex) {
                System.out.printf("Erro: %s%n", sqlex);
            }
        } catch (IOException ex) {
            System.out.printf("Erro: %s%n", ex);
        } 
    }

    private static void loadDatabaseProperties() throws IOException {

        Properties props = new Properties();

        var inputStream = Files.newInputStream(Paths.get("db.properties"));

        props.load(inputStream);
        
        DATABASE_URL = props.getProperty("url");
        USER =    props.getProperty("user");
        PASSWORD =props.getProperty("password");
       
    }

    private static void readResultSet(ResultSet resultSet) throws SQLException {

            ResultSetMetaData metaData = resultSet.getMetaData();

            System.out.printf("Tabela ACTOR do banco dvdrental:%n%n");

            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-20s\t", metaData.getColumnName(i));
            }

            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-20s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

            System.out.println();
    }
}

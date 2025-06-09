package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo db.properties não encontrado no resources");
            }
            properties.load(input);
            String driver = properties.getProperty("jdbc.driver");
            Class.forName(driver);  // Carrega o driver uma vez só
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro ao carregar configuração do banco ou driver JDBC", ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }
}

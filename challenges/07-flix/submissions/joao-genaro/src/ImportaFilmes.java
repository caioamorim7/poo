import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ImportaFilmes {
    private static final String URL =
        "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.snghnxpdoffuasscqmms";
    private static final String PASS = "idpccpoo";

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Uso: java ImportaFilmes <caminho_para_new_films.txt>");
            System.exit(1);
        }
        Class.forName("org.postgresql.Driver");
        List<String> linhas = Files.readAllLines(Paths.get(args[0]));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ins = conn.prepareStatement(
                 "INSERT INTO film(title,language_id,rental_duration,rental_rate,replacement_cost) VALUES(?,?,?,?,?)");
             PreparedStatement upd = conn.prepareStatement(
                 "UPDATE film SET rental_rate = rental_rate * 1.1");
             PreparedStatement sel = conn.prepareStatement(
                 "SELECT title, rental_rate FROM film WHERE rental_duration = 99")) {

            for (String linha : linhas) {
                if (linha.trim().isEmpty() || linha.startsWith("title;")) continue;
                String[] p = linha.split(";");
                ins.setString(1, p[0]);
                ins.setInt(2, Integer.parseInt(p[1]));
                ins.setInt(3, Integer.parseInt(p[2]));
                ins.setDouble(4, Double.parseDouble(p[3]));
                ins.setDouble(5, Double.parseDouble(p[4]));
                ins.executeUpdate();
            }

            upd.executeUpdate();

            try (ResultSet rs = sel.executeQuery()) {
                while (rs.next()) {
                    System.out.printf("%s – %.2f%n",
                        rs.getString(1), rs.getDouble(2));
                }
            }
        }
    }
}
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmeReader {
    public static List<Film> ler(String caminho) {
        List<Film> lista = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminho));
            for (int i = 1; i < linhas.size(); i++) {
                String[] p = linhas.get(i).split(";");
                lista.add(new Film(
                    p[0],
                    Integer.parseInt(p[1]),
                    Integer.parseInt(p[2]),
                    Double.parseDouble(p[3]),
                    Double.parseDouble(p[4])
                ));
            }
        } catch (Exception e) {
            System.err.println("Erro na leitura: " + e.getMessage());
        }
        return lista;
    }
}

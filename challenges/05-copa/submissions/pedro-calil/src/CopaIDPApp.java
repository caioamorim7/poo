import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CopaIDPApp {
    public static void main(String[] args) {
        
        Time time1 = new Time("Time1");
        time1.adicionarAtleta("Atleta1");
        time1.adicionarAtleta("Atleta2");

        Time time2 = new Time("Time2");
        time2.adicionarAtleta("Atleta3");
        time2.adicionarAtleta("Atleta4");

        Time time3 = new Time("Time3");
        time3.adicionarAtleta("Atleta5");
        time3.adicionarAtleta("Atleta6");

        
        new Partida(time1, time2, time1);
        new Partida(time2, time3, time3);
        new Partida(time1, time3, time3);
        new Partida(time2, time1, time2);

        
        List<String> relatorio = new ArrayList<>();
        relatorio.add("Relatório da Copa IDP");
        relatorio.add("");

        for (Time t : List.of(time1, time2, time3)) {
            relatorio.add(t.getNome() + " - " + t.getPontuacao() + " pontos");
            relatorio.add("- Atletas:");
            for (String atleta : t.getAtletas()) {
                relatorio.add("  " + atleta);
            }
            relatorio.add("- Partidas:");
            for (String res : Partida.getResultadosDoTime(t)) {
                relatorio.add("  - " + res);
            }
            relatorio.add("");
        }

        relatorio.add("Todas as Partidas:");
        for (Partida p : Partida.getHistorico()) {
            relatorio.add(p.getTime1().getNome() + " vs " + p.getTime2().getNome()
                + " - Vencedor: " + p.getVencedor().getNome());
        }

        
        Path output = Paths.get("relatorio_copa_idp.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            for (String linha : relatorio) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
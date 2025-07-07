
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {
    private Time time1;
    private Time time2;
    private Time vencedor;

    private static List<Partida> historico = new ArrayList<>();
    private static Map<Time, List<String>> resultadosPorTime = new HashMap<>();

    public Partida(Time time1, Time time2, Time vencedor) {
        this.time1 = time1;
        this.time2 = time2;
        this.vencedor = vencedor;
        registrarResultado();
    }

    private void registrarResultado() {
       
        if (vencedor.equals(time1)) {
            time1.adicionarPontuacao(3);
        } else if (vencedor.equals(time2)) {
            time2.adicionarPontuacao(3);
        }
        
        historico.add(this);

        
        resultadosPorTime
            .computeIfAbsent(time1, t -> new ArrayList<>())
            .add(time2.getNome() + " - " + (vencedor.equals(time1) ? "Venceu" : "Perdeu"));
        resultadosPorTime
            .computeIfAbsent(time2, t -> new ArrayList<>())
            .add(time1.getNome() + " - " + (vencedor.equals(time2) ? "Venceu" : "Perdeu"));
    }

    public static List<Partida> getHistorico() {
        return historico;
    }

    public static List<String> getResultadosDoTime(Time time) {
        return resultadosPorTime.getOrDefault(time, List.of());
    }

    public Time getTime1() {
        return time1;
    }

    public Time getTime2() {
        return time2;
    }

    public Time getVencedor() {
        return vencedor;
    }
}
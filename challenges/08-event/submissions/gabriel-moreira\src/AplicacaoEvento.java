import java.util.ArrayList;
import java.util.List;

public class AplicacaoEvento {
    public static void main(String[] args) {
        List<Participante> listaDeParticipantes = new ArrayList<>();


        listaDeParticipantes.add(new Estudante("E01", "Pedro Silva", "pedro.silva@uni.com", "Ciência da Computação", 3));
        listaDeParticipantes.add(new Estudante("E02", "Maria Souza", "maria.souza@uni.com", "Engenharia de Software", 6));

        
        listaDeParticipantes.add(new Profissional("P01", "Joana Costa", "joana.costa@corp.com", "Tech Inova"));
        listaDeParticipantes.add(new Profissional("P02", "Ricardo Lima", "ricardo.lima@empresa.com", "CodeFactory"));

        
        for (Participante p : listaDeParticipantes) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.descreverPapel());
            System.out.println("-----------------------------");
        }
    }
}

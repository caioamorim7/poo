import java.util.ArrayList;
import java.util.List;

public class EventApp {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();

        participants.add(new StudentParticipant("S001", "Ana Silva", "ana.silva@email.com", "Engenharia de Software", 5));
        participants.add(new StudentParticipant("S002", "Bruno Costa", "bruno.costa@email.com", "Ciência da Computação", 3));

        participants.add(new ProfessionalParticipant("P001", "Carlos Mendes", "carlos.mendes@empresa.com", "Tech Solutions Inc."));
        participants.add(new ProfessionalParticipant("P002", "Diana Lima", "diana.lima@empresa.com", "Global Innovations Ltd."));

        System.out.println("--- Lista de Participantes da IDP Tech Week ---");
        for (Participant p : participants) {
            System.out.println(p.toString());
            System.out.println("Papel: " + p.describeRole());
            System.out.println("------------------------------------------");
        }
    }
}

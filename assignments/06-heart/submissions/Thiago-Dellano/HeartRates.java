import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Métodos Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }

    // Método para calcular a idade
    public int calculateAge() {
        return LocalDate.now().getYear() - this.yearOfBirth;
    }

    // Método para calcular a frequência cardíaca máxima
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    // Método para calcular a faixa de frequência cardíaca alvo (50% a 85% da máxima)
    public int[] calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        return new int[]{(int) (maxHeartRate * 0.50), (int) (maxHeartRate * 0.85)};
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações ao usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        // Criando objeto HeartRates
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        // Obtendo idade, frequência máxima e faixa de frequência alvo
        int age = person.calculateAge();
        int maxHeartRate = person.calculateMaxHeartRate();
        int[] targetHeartRate = person.calculateTargetHeartRate();

        // Exibindo os resultados
        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate[0] + " bpm - " + targetHeartRate[1] + " bpm");

        scanner.close();
    }
}


import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {
    // Atributos privados
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

    // Métodos get e set
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    // Método para calcular idade
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    // Método para calcular frequência cardíaca máxima
    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    // Método para calcular faixa de frequência cardíaca alvo
    public String calculateTargetHeartRate(int currentYear) {
        int maxRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int)(maxRate * 0.50);
        int maxTarget = (int)(maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    // Método principal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\n--- Informações do Usuário ---");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                           person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate(currentYear));
    }
}

// Classe HeartRates
import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor para inicializar os dados
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Métodos getters e setters
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

    // Método para calcular a idade
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    // Método para calcular a frequência cardíaca máxima
    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2024);  // Usando o ano atual de exemplo (2024)
    }

    // Método para calcular a faixa de frequência cardíaca alvo
    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int targetMin = (int) (maxHeartRate * 0.50);
        int targetMax = (int) (maxHeartRate * 0.85);
        return targetMin + " bpm - " + targetMax + " bpm";
    }

    // Método principal (main)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();
        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dayOfBirth = input.nextInt();
        int monthOfBirth = input.nextInt();
        int yearOfBirth = input.nextInt();

        // Criando o objeto HeartRates
        HeartRates person = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        // Exibindo as informações
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
        System.out.println("Idade: " + person.calculateAge(2024) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());
    }
}

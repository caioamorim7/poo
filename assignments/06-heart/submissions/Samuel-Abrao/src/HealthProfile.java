import java.util.Scanner;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private int weight;
    private int height;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, int weight, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate(int currentYear) {
        int maxRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) (maxRate * 0.50);
        int maxTarget = (int) (maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return weight / Math.pow(height / 100.0, 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite seu peso (kg): ");
        int weight = scanner.nextInt();

        System.out.print("Digite sua altura (cm): ");
        int height = scanner.nextInt();

        scanner.close();

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, weight, height);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Idade: " + person.calculateAge(2025) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(2025) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate(2025));
        System.out.printf("IMC: %.1f%n", person.calculateBMI());
    }
}

import java.util.Scanner;

public class HealthProfile {
    private final String firstName;
    private final String lastName;
    private final char gender;
    private final int dayOfBirth;
    private final int monthOfBirth;
    private final int yearOfBirth;
    private final double heightInInches;
    private final double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear) {
        int age = currentYear - yearOfBirth;
        if (monthOfBirth > 3 || (monthOfBirth == 3 && dayOfBirth > 5)) {
            age--;
        }
        return age;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate(int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) Math.round(maxHeartRate * 0.50);
        int maxTarget = (int) Math.round(maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public void displayHealthInfo(int currentYear) {
        System.out.printf("\nNome: %s %s%n", firstName, lastName);
        System.out.printf("Gênero: %s%n", (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.printf("Idade: %d anos%n", calculateAge(currentYear));
        System.out.printf("Altura: %.2f polegadas%n", heightInInches);
        System.out.printf("Peso: %.2f libras%n", weightInPounds);
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", calculateMaxHeartRate(currentYear));
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", calculateTargetHeartRate(currentYear));
    }

    public static void displayBMITable() {
        System.out.println("\nTabela de Classificação do BMI:");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, heightInInches, weightInPounds);

        int currentYear = 2025;
        person.displayHealthInfo(currentYear);

        displayBMITable();

        scanner.close();
    }
}
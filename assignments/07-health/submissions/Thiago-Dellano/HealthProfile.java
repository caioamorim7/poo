import java.util.Scanner;
import java.time.LocalDate;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // Construtor
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

    // Métodos Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public char getGender() { return gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }

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

    // Método para calcular o Índice de Massa Corporal (BMI)
    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações ao usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        // Criando objeto HealthProfile
        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        // Obtendo cálculos
        int age = person.calculateAge();
        int maxHeartRate = person.calculateMaxHeartRate();
        int[] targetHeartRate = person.calculateTargetHeartRate();
        double bmi = person.calculateBMI();

        // Exibindo os resultados
        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Gênero: " + (person.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate[0] + " bpm - " + targetHeartRate[1] + " bpm");

        // Exibindo tabela de referência do BMI
        System.out.println("\nTabela de referência do BMI:");
        System.out.println("Menos de 18.5  - Abaixo do peso");
        System.out.println("18.5 - 24.9    - Peso normal");
        System.out.println("25.0 - 29.9    - Sobrepeso");
        System.out.println("30.0 ou mais   - Obesidade");

        scanner.close();
    }
}

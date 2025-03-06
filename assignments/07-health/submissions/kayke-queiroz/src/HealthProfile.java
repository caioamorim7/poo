import java.util.Scanner;

// Classe para armazenar e processar as informações de saúde do paciente
public class HealthProfile {
    // Atributos privados
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // Construtor para inicializar os atributos
    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Métodos de acesso (getters)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public char getGender() { return gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }

    // Método para calcular a idade do paciente
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    // Método para calcular a frequência cardíaca máxima
    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    // Método para calcular a faixa de frequência cardíaca alvo
    public String calculateTargetHeartRate(int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) (maxHeartRate * 0.5);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    // Método para calcular o Índice de Massa Corporal (BMI)
    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    // Método para exibir o perfil de saúde do paciente
    public void displayHealthProfile(int currentYear) {
        System.out.println("Nome: " + firstName + " " + lastName);
        System.out.println("Gênero: " + (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.println("Idade: " + calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + heightInInches + " polegadas");
        System.out.println("Peso: " + weightInPounds + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + calculateTargetHeartRate(currentYear));
    }

    // Método para exibir a tabela de referência do BMI
    public static void displayBMITable() {
        System.out.println("\nTabela de valores do BMI:");
        System.out.println("BMI\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitação dos dados ao usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        // Criação do objeto HealthProfile com os dados fornecidos
        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        // Exibição das informações do paciente
        System.out.println("\nInformações do Paciente:");
        profile.displayHealthProfile(2024);

        // Exibição da tabela de referência do BMI
        HealthProfile.displayBMITable();

        scanner.close();
    }
}

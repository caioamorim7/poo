import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class HealthProfile {
    private String firstName = "";
    private String lastName = "";
    private char gender;
    private int dayOfBirth = 0;
    private int monthOfBirth = 0;
    private int yearOfBirth = 0;
    private double heightInInches = 0;
    private double weightInPounds = 0;

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        String genderInput;
        char gender;
        while (true) {
            System.out.print("Digite seu gênero (M/F): ");
            genderInput = scanner.nextLine().trim();
            if (!genderInput.isEmpty()) { //se tiver vazia retorna true, mas nega pelo ! entao false --- se tiver algo, volta verdadeiro mas vira false pelo !
                gender = Character.toUpperCase(genderInput.charAt(0));
                if (gender == 'M' || gender == 'F') break;
            }
            System.out.println("Entrada inválida. Digite 'M' ou 'F'.");
        }

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        try {
            java.time.LocalDate.of(year, month, day);
        } catch (java.time.DateTimeException e) {
            System.out.println("Data de nascimento inválida.");
            scanner.close();
            return;
        }

         HealthProfile patient = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("\nNome: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Gênero: " + (patient.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n", patient.getDayOfBirth(), patient.getMonthOfBirth(), patient.getYearOfBirth());
        System.out.println("Idade: " + patient.calculateAge() + " anos");
        System.out.println("Altura: " + patient.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + patient.getWeightInPounds() + " libras");

        System.out.printf("Índice de Massa Corporal: %.1f%n", patient.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + patient.calculateMaxHeartRate() + " bpm");

        double[] targetRate = patient.calculateTargetHeartRate();
        System.out.printf("Faixa de frequência cardíaca alvo: %.0f bpm - %.0f bpm%n\n", targetRate[0], targetRate[1]);

        System.out.println("BMI - Classificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 - 24.9\tPeso normal");
        System.out.println("25.0 - 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        scanner.close();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }


    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public double[] calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        double minTargetRate = maxHeartRate * 0.50;
        double maxTargetRate = maxHeartRate * 0.85;
        return new double[]{minTargetRate, maxTargetRate};
    }

    public double calculateBMI() {
        if (heightInInches <= 0){
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }
}
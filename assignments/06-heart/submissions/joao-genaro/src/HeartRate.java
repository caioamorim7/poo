import java.util.Scanner;

public class HeartRates {
    private final String firstName;
    private final String lastName;
    private final int dayOfBirth;
    private final int monthOfBirth;
    private final int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        if (yearOfBirth > 2025) {
            throw new IllegalArgumentException("Ano de nascimento não pode estar no futuro.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public int calculateAge(int currentYear) {
        if (yearOfBirth > currentYear) {
            throw new IllegalArgumentException("Ano de nascimento não pode estar no futuro.");
        }
        int age = currentYear - yearOfBirth;
        if (monthOfBirth > 3 || (monthOfBirth == 3 && dayOfBirth > 5)) {
            age--;
        }
        return age;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public int[] calculateTargetHeartRate(int currentYear) {
        int maxRate = calculateMaxHeartRate(currentYear);
        return new int[]{(int) Math.round(maxRate * 0.50), (int) Math.round(maxRate * 0.85)};
    }

    public void displayHeartRates(int currentYear) {
        System.out.printf("\nNome: %s %s\n", firstName, lastName);
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.printf("Idade: %d anos\n", calculateAge(currentYear));
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", calculateMaxHeartRate(currentYear));
        int[] targetRange = calculateTargetHeartRate(currentYear);
        System.out.printf("Faixa de frequência cardíaca alvo: %d bpm - %d bpm\n", targetRange[0], targetRange[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        try {
            HeartRates person = new HeartRates(firstName, lastName, day, month, year);
            person.displayHeartRates(2025);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}

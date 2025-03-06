import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

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
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) Math.round(maxHeartRate * 0.50);
        int maxTarget = (int) Math.round(maxHeartRate * 0.85);
        return new int[]{minTarget, maxTarget};
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

        HeartRates person;
        try {
            person = new HeartRates(firstName, lastName, day, month, year);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            scanner.close();
            return;
        }

        int currentYear = 2025;
        System.out.println("\nNome: " + person.firstName + " " + person.lastName);
        System.out.println("Data de nascimento: " + person.dayOfBirth + "/" + person.monthOfBirth + "/" + person.yearOfBirth);
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(currentYear) + " bpm");

        int[] targetHeartRate = person.calculateTargetHeartRate(currentYear);
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate[0] + " bpm - " + targetHeartRate[1] + " bpm");

        scanner.close();
    }
}

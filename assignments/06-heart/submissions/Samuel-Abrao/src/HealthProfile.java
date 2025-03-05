import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
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

    public int calculateAge(int currentDay, int currentMonth, int currentYear) {
        int age = currentYear - yearOfBirth;
        if (currentMonth < monthOfBirth || (currentMonth == monthOfBirth && currentDay < dayOfBirth)) {
            age--;
        }
        return age;
    }

    public int calculateMaxHeartRate(int currentDay, int currentMonth, int currentYear) {
        return 220 - calculateAge(currentDay, currentMonth, currentYear);
    }

    public String calculateTargetHeartRate(int currentDay, int currentMonth, int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentDay, currentMonth, currentYear);
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
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

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.print("Digite a data atual (dia mês ano): ");
        int currentDay = scanner.nextInt();
        int currentMonth = scanner.nextInt();
        int currentYear = scanner.nextInt();

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(currentDay, currentMonth, currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(currentDay, currentMonth, currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate(currentDay, currentMonth, currentYear));

        scanner.close();
    }
}

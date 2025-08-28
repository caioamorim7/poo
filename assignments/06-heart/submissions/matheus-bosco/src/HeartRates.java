import java.time.LocalDate;

public class HeartRates {
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

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // Calcular idade (considerando mês/dia do aniversário)
    public int calculateAge(int currentYear) {
        LocalDate today = LocalDate.now();
        int age = currentYear - yearOfBirth;
        if (today.getMonthValue() < monthOfBirth ||
           (today.getMonthValue() == monthOfBirth && today.getDayOfMonth() < dayOfBirth)) {
            age--;
        }
        return age;
    }

    // Frequência máxima (sem parâmetro)
    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        return 220 - calculateAge(currentYear);
    }

    // Faixa alvo (sem parâmetro, sem "bpm")
    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int)(maxHR * 0.50);
        int maxTarget = (int)(maxHR * 0.85);
        return minTarget + " - " + maxTarget;
    }
}

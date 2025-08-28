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

    // Getters e Setters
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

    // Idade: recebe o ano e calcula corretamente
    public int calculateAge(int currentYear) {
        LocalDate today = LocalDate.now();
        int age = currentYear - yearOfBirth;

        // Corrige o “+1 ano” se ainda não fez aniversário no ano
        if (today.getMonthValue() < monthOfBirth ||
           (today.getMonthValue() == monthOfBirth && today.getDayOfMonth() < dayOfBirth)) {
            age--;
        }
        return age;
    }

    // Frequência máxima: 220 - idade (sem parâmetro)
    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        return 220 - calculateAge(currentYear);
    }

    // Faixa alvo: 50% a 85% da máxima, com “bpm”
    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int) Math.round(maxHR * 0.50);
        int maxTarget = (int) Math.round(maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }
}

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

    // Calcular idade
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    // Frequência máxima
    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    // Faixa alvo
    public String calculateTargetHeartRate(int currentYear) {
        int maxHR = calculateMaxHeartRate(currentYear);
        int minTarget = (int)(maxHR * 0.50);
        int maxTarget = (int)(maxHR * 0.85);
        return minTarget + " - " + maxTarget;
    }
}


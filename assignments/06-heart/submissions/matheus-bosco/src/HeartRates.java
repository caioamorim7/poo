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

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int getMaximumHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String getTargetHeartRateRange(int currentYear) {
        int maxHR = getMaximumHeartRate(currentYear);
        int lower = (int)(maxHR * 0.50);
        int upper = (int)(maxHR * 0.85);
        return lower + " - " + upper;
    }
}

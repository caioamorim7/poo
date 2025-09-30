class Thermometer {
    private double celsius;

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double value) {
        if (value < -273.15) {
            return;
        }
        celsius = value;
    }

    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }
}

public class Q09 {
    public static void main(String[] args) {
        Thermometer t = new Thermometer();
        t.setCelsius(-300);
        t.setCelsius(25);
        System.out.println(t.getCelsius() + ":" + t.toFahrenheit());
    }
}

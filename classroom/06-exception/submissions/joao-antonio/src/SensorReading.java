public class SensorReading {
    private String Id;
    private double temperatura;

    public SensorReading(String Id, double temperature) {
        this.Id = Id;
        this.temperatura = temperature;
    }
    public String getId() {
        return Id;
    }
    public double getTemperature() {
        return temperatura;
    }
}
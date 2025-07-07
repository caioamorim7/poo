package dvdrentalApp.model;

public class Film {
    private int languageId, rentDuration;
    private double rentalRate, replacementCost;
    private String title;

    public Film(String title, int languageId, int rentDuration, double rentalRate, double replacementCost) {
        this.languageId = languageId;
        this.rentDuration = rentDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.title = title;
    }

    public int getLanguageId() {return this.languageId;}
    public int getRentalDuration() {return this.rentDuration;}
    public double getRentalRate() {return this.rentalRate;}
    public double getReplacementCost() {return this.replacementCost;}
    public String getTitle() {return this.title;}
}

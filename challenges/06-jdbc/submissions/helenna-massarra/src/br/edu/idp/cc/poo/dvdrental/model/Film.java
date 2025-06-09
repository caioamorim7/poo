package br.edu.idp.cc.poo.dvdrental.model;

public class Film {
    private int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private String specialFeatures;

    // Construtores, getters e setters

    public Film() {}

    public Film(int filmId, String title, String description, int releaseYear, int languageId,
                int rentalDuration, double rentalRate, int length, double replacementCost,
                String rating, String specialFeatures) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
    }

    // Getters e setters (omito aqui para não alongar)
}

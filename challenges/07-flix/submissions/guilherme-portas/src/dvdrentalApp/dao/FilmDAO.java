package dvdrentalApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;

import dvdrentalApp.util.*;
import dvdrentalApp.model.Film;;


public class FilmDAO {
    public static void insert(Film film) throws IOException, SQLException {
        Connection conn = ConnectionFactory.connectToDatabase();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO film(title, language_id, rental_duration, rental_rate, replacement_cost) VALUES(?, ?, ?, ?, ?)");
        ps.setString(1, film.getTitle());
        ps.setInt(2, film.getLanguageId());
        ps.setInt(3, film.getRentalDuration());
        ps.setDouble(4, film.getRentalDuration());
        ps.setDouble(5, film.getRentalRate());
        ps.executeUpdate();
        System.out.println("Filme inserido com sucesso!");
        AuditLogger.log("INSERT", "Film inserido: " + film);
    }   

    public static void updateValorLocacao() throws IOException, SQLException {
        Connection conn = ConnectionFactory.connectToDatabase();
        PreparedStatement ps = conn.prepareStatement("UPDATE film SET rental_rate = rental_rate * 1.1");
        int qntAtualizado = ps.executeUpdate();
        System.out.println(qntAtualizado + " Filmes atualizados com sucesso!");
        AuditLogger.log("UPDATE", "Filmes atualizados: " + qntAtualizado);
    }

    public static void ListAllLocacao() throws IOException, SQLException {
        Connection conn = ConnectionFactory.connectToDatabase();
        PreparedStatement ps = conn.prepareStatement("SELECT title, rental_rate FROM film WHERE rental_duration = 99");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println();   
            System.out.println("title: " + rs.getString(1));   
            System.out.println("rental_rate: " + rs.getDouble(2));   
            AuditLogger.log("SELECT", "Film procurado");
        }
    }
}
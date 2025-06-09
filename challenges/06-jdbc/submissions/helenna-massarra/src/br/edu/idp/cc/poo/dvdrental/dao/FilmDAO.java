package br.edu.idp.cc.poo.dvdrental.dao;

import br.edu.idp.cc.poo.dvdrental.model.Film;
import br.edu.idp.cc.poo.dvdrental.util.ConnectionFactory;
import br.edu.idp.cc.poo.dvdrental.util.AuditLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void insert(Film film) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());
            stmt.setInt(4, film.getLanguageId());
            stmt.setInt(5, film.getRentalDuration());
            stmt.setDouble(6, film.getRentalRate());
            stmt.setInt(7, film.getLength());
            stmt.setDouble(8, film.getReplacementCost());
            stmt.setString(9, film.getRating());
            stmt.setString(10, film.getSpecialFeatures());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        film.setFilmId(generatedKeys.getInt(1));
                    }
                }
                AuditLogger.log("INSERT", "Filme inserido: " + film.getTitle());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir filme: " + e.getMessage());
        }
    }

    public Film findById(int filmId) {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToFilm(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme por ID: " + e.getMessage());
        }
        return null;
    }

    public List<Film> findByTitle(String title) {
        String sql = "SELECT * FROM film WHERE title ILIKE ?";
        List<Film> films = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    films.add(mapResultSetToFilm(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme por título: " + e.getMessage());
        }
        return films;
    }

    public List<Film> findAll() {
        String sql = "SELECT * FROM film ORDER BY film_id";
        List<Film> films = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                films.add(mapResultSetToFilm(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar filmes: " + e.getMessage());
        }
        return films;
    }

    public void update(Film film) {
        String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? " +
                     "WHERE film_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getReleaseYear());
            stmt.setInt(4, film.getLanguageId());
            stmt.setInt(5, film.getRentalDuration());
            stmt.setDouble(6, film.getRentalRate());
            stmt.setInt(7, film.getLength());
            stmt.setDouble(8, film.getReplacementCost());
            stmt.setString(9, film.getRating());
            stmt.setString(10, film.getSpecialFeatures());
            stmt.setInt(11, film.getFilmId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                AuditLogger.log("UPDATE", "Filme atualizado: " + film.getFilmId());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar filme: " + e.getMessage());
        }
    }

    public void delete(int filmId) {
        String sql = "DELETE FROM film WHERE film_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                AuditLogger.log("DELETE", "Filme removido: " + filmId);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover filme: " + e.getMessage());
        }
    }

    private Film mapResultSetToFilm(ResultSet rs) throws SQLException {
        Film film = new Film();
        film.setFilmId(rs.getInt("film_id"));
        film.setTitle(rs.getString("title"));
        film.setDescription(rs.getString("description"));
        film.setReleaseYear(rs.getInt("release_year"));
        film.setLanguageId(rs.getInt("language_id"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getDouble("rental_rate"));
        film.setLength(rs.getInt("length"));
        film.setReplacementCost(rs.getDouble("replacement_cost"));
        film.setRating(rs.getString("rating"));
        film.setSpecialFeatures(rs.getString("special_features"));
        return film;
    }
}

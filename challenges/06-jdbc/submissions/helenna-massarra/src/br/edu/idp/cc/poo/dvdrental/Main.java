package br.edu.idp.cc.poo.dvdrental;

import br.edu.idp.cc.poo.dvdrental.dao.FilmDAO;
import br.edu.idp.cc.poo.dvdrental.model.Film;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static FilmDAO filmDAO = new FilmDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Inserir novo filme");
            System.out.println("2. Listar todos os filmes");
            System.out.println("3. Buscar filme por ID");
            System.out.println("4. Buscar filme por nome");
            System.out.println("5. Atualizar filme");
            System.out.println("6. Remover filme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    inserirFilme();
                    break;
                case 2:
                    listarFilmes();
                    break;
                case 3:
                    buscarFilmePorId();
                    break;
                case 4:
                    buscarFilmePorNome();
                    break;
                case 5:
                    atualizarFilme();
                    break;
                case 6:
                    removerFilme();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void inserirFilme() {
        Film film = new Film();
        System.out.print("Título: ");
        film.setTitle(scanner.nextLine());
        System.out.print("Descrição: ");
        film.setDescription(scanner.nextLine());
        System.out.print("Ano de lançamento: ");
        film.setReleaseYear(scanner.nextInt());
        System.out.print("ID do idioma: ");
        film.setLanguageId(scanner.nextInt());
        System.out.print("Duração do aluguel: ");
        film.setRentalDuration(scanner.nextInt());
        System.out.print("Taxa de aluguel: ");
        film.setRentalRate(scanner.nextDouble());
        System.out.print("Duração do filme (minutos): ");
        film.setLength(scanner.nextInt());
        System.out.print("Custo de reposição: ");
        film.setReplacementCost(scanner.nextDouble());
        scanner.nextLine(); // limpar buffer
        System.out.print("Classificação: ");
        film.setRating(scanner.nextLine());
        System.out.print("Características especiais: ");
        film.setSpecialFeatures(scanner.nextLine());

        filmDAO.insert(film);
        System.out.println("Filme inserido com ID: " + film.getFilmId());
    }

    private static void listarFilmes() {
        List<Film> filmes = filmDAO.findAll();
        for (Film f : filmes) {
            System.out.println(f.getFilmId() + " - " + f.getTitle());
        }
    }

    private static void buscarFilmePorId() {
        System.out.print("Digite o ID do filme: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Film film = filmDAO.findById(id);
        if (film != null) {
            System.out.println("Título: " + film.getTitle());
            System.out.println("Descrição: " + film.getDescription());
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private static void buscarFilmePorNome() {
        System.out.print("Digite parte do nome do filme: ");
        String nome = scanner.nextLine();
        List<Film> filmes = filmDAO.findByTitle(nome);
        if (!filmes.isEmpty()) {
            filmes.forEach(f -> System.out.println(f.getFilmId() + " - " + f.getTitle()));
        } else {
            System.out.println("Nenhum filme encontrado.");
        }
    }

    private static void atualizarFilme() {
        System.out.print("Digite o ID do filme para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Film film = filmDAO.findById(id);
        if (film == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Novo título (atual: " + film.getTitle() + "): ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.trim().isEmpty()) {
            film.setTitle(novoTitulo);
        }

        System.out.println("Nova descrição (atual: " + film.getDescription() + "): ");
        String novaDesc = scanner.nextLine();
        if (!novaDesc.trim().isEmpty()) {
            film.setDescription(novaDesc);
        }

        // Você pode adicionar outras atualizações de campos se quiser

        filmDAO.update(film);
        System.out.println("Filme atualizado.");
    }

    private static void removerFilme() {
        System.out.print("Digite o ID do filme para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        filmDAO.delete(id);
        System.out.println("Filme removido (se existia).");
    }
}

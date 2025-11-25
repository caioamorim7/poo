import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();

        // 1) Inserir um novo filme
        int newFilmId = filmDAO.insertFilm(
            "Novo Filme",
            "Descrição teste",
            2025,
            1
        );
        System.out.println("Filme inserido com ID: " + newFilmId);

        // 2) Buscar filme por ID
        FilmDAO.FilmRecord film = filmDAO.getFilmById(newFilmId);
        if (film != null) {
            System.out.println("Encontrado: " + film);
        } else {
            System.out.println("Filme não encontrado (ID " + newFilmId + ")");
        }

        // 3) Atualizar título por ID
        boolean updated = filmDAO.updateFilmTitle(newFilmId, "Título Atualizado");
        System.out.println("Título atualizado? " + updated);

        // 4) Listar todos os filmes
        List<FilmDAO.FilmRecord> allFilms = filmDAO.listAllFilms();
        System.out.println("Lista de filmes:");
        for (FilmDAO.FilmRecord fr : allFilms) {
            System.out.println(fr);
        }

        // 5) Listar atores vinculados ao filme inserido (se houver relacionamentos)
        actorDAO.listActorsByFilmId(newFilmId);

        // 6) Excluir o filme por ID
        boolean deleted = filmDAO.deleteFilm(newFilmId);
        System.out.println("Filme excluído? " + deleted);

        // 7) Exemplo: excluir um ator (cuidado ao usar em base real)
        // actorDAO.deleteActorById(1);
    }
}

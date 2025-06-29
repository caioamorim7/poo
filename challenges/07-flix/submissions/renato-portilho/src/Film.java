public class Film {
    private String titulo;
    private int idIdioma;
    private int duracaoLocacao;
    private double precoLocacao;
    private double custoReposicao;

    public Film(String titulo, int idIdioma, int duracaoLocacao, double precoLocacao, double custoReposicao) {
        this.titulo = titulo;
        this.idIdioma = idIdioma;
        this.duracaoLocacao = duracaoLocacao;
        this.precoLocacao = precoLocacao;
        this.custoReposicao = custoReposicao;
    }

    public String getTitle() {
        return titulo;
    }

    public int getLanguageId() {
        return idIdioma;
    }

    public int getRentalDuration() {
        return duracaoLocacao;
    }

    public double getRentalRate() {
        return precoLocacao;
    }

    public double getReplacementCost() {
        return custoReposicao;
    }
}

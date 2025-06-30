
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;

public class Time {
    private String nome;
    private int pontuacao;
    private SortedSet<String> atletas;

    public Time(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.atletas = new TreeSet<>();
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarAtleta(String nomeAtleta) {
        if (nomeAtleta != null && !nomeAtleta.isBlank()) {
            atletas.add(nomeAtleta);
        }
    }

    public Set<String> getAtletas() {
        return atletas;
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time other = (Time) o;
        return nome.equals(other.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
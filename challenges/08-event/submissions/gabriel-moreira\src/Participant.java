public abstract class Participante {
    private String matricula;
    private String nomeCompleto;
    private String email;

    public Participante(String matricula, String nomeCompleto, String email) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public abstract String descreverPapel();
}

public class Profissional extends Participante {
    private String empresa;

    public Profissional(String matricula, String nomeCompleto, String email, String empresa) {
        super(matricula, nomeCompleto, email);
        this.empresa = empresa;
    }

    
    public String descreverPapel() {
        return "Atuo profissionalmente na empresa " + empresa + ".";
    }

    
    public String toString() {
        return "[Profissional] " + getNomeCompleto() + " | Matrícula: " + getMatricula() +
               " | Email: " + getEmail() +
               " | Empresa: " + empresa;
    }
}

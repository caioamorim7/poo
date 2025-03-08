import java.util.Calendar;
import java.util.Scanner;

public class HealthProfile {
    // Atributos privados
    private String nome;
    private String sobrenome;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    private char sexo;
    private double altura;
    private double peso;

    // Construtor
    public HealthProfile(String nome, String sobrenome, char sexo, int diaNascimento, int mesNascimento, int anoNascimento, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int calcularIdade() {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - anoNascimento;
        if (mesNascimento > mesAtual || (mesNascimento == mesAtual && diaNascimento > diaAtual)) {
            idade--;
        }
        return idade;
    }

    public int calcularFrequenciaMaxima() {
        return 220 - calcularIdade();
    }

    public String calcularFrequenciaAlvo() {
        int maxFrequencia = calcularFrequenciaMaxima();
        int minAlvo = (int) (maxFrequencia * 0.50);
        int maxAlvo = (int) (maxFrequencia * 0.85);
        return minAlvo + " bpm - " + maxAlvo + " bpm";
    }

    public double calcularIMC() {
        return (peso * 703) / (altura * altura);
    }

    public static void exibirTabelaIMC() {
        System.out.println("\nÍndice de Massa Corporal (IMC) - Classificação:");
        System.out.println("Abaixo de 18.5: Abaixo do peso");
        System.out.println("18.5 - 24.9: Peso normal");
        System.out.println("25.0 - 29.9: Sobrepeso");
        System.out.println("30.0 ou mais: Obesidade");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        char sexo;
        do {
            System.out.print("Sexo (M/F): ");
            sexo = scanner.next().toUpperCase().charAt(0);
        } while (sexo != 'M' && sexo != 'F');

        System.out.print("Data de nascimento (dia mês ano): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        System.out.print("Altura (em polegadas): ");
        double altura = scanner.nextDouble();

        System.out.print("Peso (em libras): ");
        double peso = scanner.nextDouble();

        HealthProfile perfil = new HealthProfile(nome, sobrenome, sexo, dia, mes, ano, altura, peso);

        System.out.println("\nPerfil de Saúde:");
        System.out.println("Nome: " + perfil.getNome() + " " + perfil.getSobrenome());
        System.out.println("Sexo: " + (perfil.getSexo() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Idade: " + perfil.calcularIdade() + " anos");
        System.out.printf("IMC: %.1f\n", perfil.calcularIMC());
        System.out.println("Frequência cardíaca máxima: " + perfil.calcularFrequenciaMaxima() + " bpm");
        System.out.println("Frequência cardíaca alvo: " + perfil.calcularFrequenciaAlvo());

        exibirTabelaIMC();
        scanner.close();
    }
}

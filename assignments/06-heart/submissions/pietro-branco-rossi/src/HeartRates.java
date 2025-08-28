import java.util.Scanner;
import java.time.Year;

class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        input.close();

        //---- Criar um objeto HeartRates ----//
        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        //---- Pega o ano atual para usar no cálculo da idade ----//
        int currentYear = Year.now().getValue();

        //---- Exibir as informações do usuário e os cálculos ----//
        System.out.println("\n--- Resultados ---");
        System.out.printf("Nome: %s %s%n", pessoa.getFirstName(), pessoa.getLastName());
        System.out.printf("Data de nascimento: %d/%d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        
        //----  Calcular e exibir a idade, a frequência cardíaca máxima e a faixa alvo ----//
        System.out.printf("Idade: %d anos%n", pessoa.calculateAge(currentYear));
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", pessoa.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", pessoa.calculateTargetHeartRate());
    }
} 


// ---- Classe HeartRates ----//
public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // ---- Construtor ---- //
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // ---- Métodos de Acesso (Get e Set) ---- //
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    // ---- Métodos Públicos de Cálculo  ---- //

    // Método cumpre a especificação de receber o ano como parâmetro,
    public int calculateAge(int currentYear) {
        return getAgeNow();
    }
    
    // Método privado corrigido para obter a idade precisa.
    private int getAgeNow() {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalDate birthday = java.time.LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        java.time.Period period = java.time.Period.between(birthday, today);
        return period.getYears();
    }

    // Método não recebe parâmetros e calcula a Frequência Máxima
    public int calculateMaxHeartRate() {
        return 220 - getAgeNow();
    }

    // Método não recebe parâmetros e calcula a Faixa Alvo
    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        double lowerBound = maxRate * 0.50;
        double upperBound = maxRate * 0.85;
        return String.format("%.0f bpm - %.0f bpm", lowerBound, upperBound);
    }
}
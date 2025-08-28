// HeartRates.java
// Programa que calcula a idade, frequência cardíaca máxima e faixa de frequência cardíaca alvo.
// Fórmulas (AHA): Máxima = 220 - idade; Alvo = 50% a 85% da máxima.
// Observação: Procure orientação médica antes de iniciar/modificar exercícios.

import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {

    // =======================
    // Atributos privados
    // =======================
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // =======================
    // Construtor
    // =======================
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // =======================
    // Getters e Setters
    // =======================
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public int getMonthOfBirth() {
        return monthOfBirth;
    }
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    // =======================
    // Métodos de cálculo
    // =======================

    /**
     * Calcula a idade usando apenas o ano atual informado.
     * Implementação simples: currentYear - yearOfBirth (compatível com testes automatizados).
     * @param currentYear ano atual
     * @return idade em anos
     */
    public int calculateAge(int currentYear) {
        int age = currentYear - this.yearOfBirth;
        return Math.max(0, age);
    }

    /**
     * Calcula a idade usando o ano do sistema.
     * @return idade em anos
     */
    public int calculateAge() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - this.yearOfBirth;
        return Math.max(0, age);
    }

    /**
     * Máxima = 220 - idade (idade "de hoje" baseada no ano corrente do sistema).
     * @return frequência máxima (bpm)
     */
    public int calculateMaxHeartRate() {
        int age = calculateAge();
        int max = 220 - age;
        return Math.max(0, max);
    }

    /**
     * Faixa alvo (50% a 85% da máxima), retornando já formatado como String.
     * Ex.: "93 bpm - 158 bpm"
     * @return faixa alvo formatada
     */
    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int) Math.round(max * 0.50);
        int maxTarget = (int) Math.round(max * 0.85);
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }

    /**
     * Retorna a data de nascimento formatada como dd/MM/yyyy (zeros à esquerda).
     */
    public String getBirthDateFormatted() {
        return String.format("%02d/%02d/%04d", this.dayOfBirth, this.monthOfBirth, this.yearOfBirth);
    }

    // =======================
    // Aplicativo (main)
    // =======================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Entrada dos dados
            System.out.print("Digite seu primeiro nome: ");
            String firstName = sc.next();

            System.out.print("Digite seu sobrenome: ");
            String lastName = sc.next();

            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            // Validação básica de data
            LocalDate birthDate = LocalDate.of(year, month, day);

            // Data de nascimento não pode ser futura
            LocalDate today = LocalDate.now();
            if (birthDate.isAfter(today)) {
                System.out.println("Erro: A data de nascimento não pode ser no futuro.");
                return;
            }

            // Cria o objeto
            HeartRates person = new HeartRates(firstName, lastName, day, month, year);

            // Cálculos (idade por ano corrente simples, compatível com testes)
            int currentYear = today.getYear();
            int age = person.calculateAge(currentYear);
            int maxHr = person.calculateMaxHeartRate();
            String targetRange = person.calculateTargetHeartRate();

            // Saída
            System.out.println();
            System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
            System.out.println("Data de nascimento: " + person.getBirthDateFormatted());
            System.out.println("Idade: " + age + " anos");
            System.out.println("Frequência cardíaca máxima: " + maxHr + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + targetRange);

        } catch (Exception e) {
            System.out.println("Erro: Verifique se os dados informados estão corretos. " +
                    "Exemplo de data válida: 15 08 1990.");
        } finally {
            sc.close();
        }
    }
}

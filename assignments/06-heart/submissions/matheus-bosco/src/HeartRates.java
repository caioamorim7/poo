
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

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
     * Calcula a idade com base no ano corrente informado.
     * Ajusta considerando se o aniversário já ocorreu no ano atual, usando a data de hoje.
     * @param currentYear ano atual (ex.: LocalDate.now().getYear()).
     * @return idade em anos completos.
     */
    public int calculateAge(int currentYear) {
        // Usa a data atual do sistema para determinar se o aniversário já ocorreu
        LocalDate today = LocalDate.now();
        // Garante que o cálculo utiliza o currentYear passado, mantendo o mês/dia de "hoje"
        LocalDate referenceToday = LocalDate.of(currentYear, today.getMonthValue(), today.getDayOfMonth());

        LocalDate birthDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        if (birthDate.isAfter(referenceToday)) {
            // Se a data de nascimento for futura em relação ao referenceToday, a idade seria negativa.
            // Para segurança, retorna 0 (ou poderia lançar exceção).
            return 0;
        }
        return Period.between(birthDate, referenceToday).getYears();
    }

    /**
     * Calcula a idade usando a data de hoje do sistema (atalho conveniente).
     * @return idade em anos completos.
     */
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        if (birthDate.isAfter(today)) {
            return 0;
        }
        return Period.between(birthDate, today).getYears();
    }

    /**
     * Calcula a frequência cardíaca máxima usando a fórmula AHA: 220 - idade.
     * A idade considerada é a idade "de hoje".
     * @return frequência máxima (bpm), mínima 0.
     */
    public int calculateMaxHeartRate() {
        int age = calculateAge();
        int max = 220 - age;
        return Math.max(0, max);
    }

    /**
     * Calcula a faixa de frequência cardíaca alvo (50% a 85% da máxima), arredondando para o inteiro mais próximo.
     * @return vetor de dois inteiros: [minAlvo, maxAlvo] em bpm.
     */
    public int[] calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int) Math.round(max * 0.50);
        int maxTarget = (int) Math.round(max * 0.85);
        return new int[]{minTarget, maxTarget};
    }

    /**
     * Retorna a data de nascimento formatada como dd/MM/yyyy (com zeros à esquerda).
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

            // Validação básica de data (lança exceção se a data for inválida)
            LocalDate birthDate = LocalDate.of(year, month, day);

            // Validação adicional: data de nascimento não pode ser futura
            LocalDate today = LocalDate.now();
            if (birthDate.isAfter(today)) {
                System.out.println("Erro: A data de nascimento não pode ser no futuro.");
                return;
            }

            // Cria o objeto HeartRates
            HeartRates hr = new HeartRates(firstName, lastName, day, month, year);

            // Cálculos
            int currentYear = today.getYear();
            int age = hr.calculateAge(currentYear);
            int maxHr = hr.calculateMaxHeartRate();
            int[] targetRange = hr.calculateTargetHeartRate();

            // Saída formatada
            System.out.println();
            System.out.println("Nome: " + hr.getFirstName() + " " + hr.getLastName());
            System.out.println("Data de nascimento: " + hr.getBirthDateFormatted());
            System.out.println("Idade: " + age + " anos");
            System.out.println("Frequência cardíaca máxima: " + maxHr + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + targetRange[0] + " bpm - " + targetRange[1] + " bpm");

        } catch (Exception e) {
            System.out.println("Erro: Verifique se os dados informados estão corretos. " +
                    "Exemplo de data válida: 15 08 1990.");
        } finally {
            sc.close();
        }
    }
}

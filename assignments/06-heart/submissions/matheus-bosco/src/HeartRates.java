import java.util.Scanner;
import java.time.LocalDate;

public class HeartRatesTest {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia mes ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();


        //ANO ATUAL AUTOMATICO
        int currentYear = LocalDate.now().getYear();    

        //CRIAR OBJETO DE CLASSE HeartRates
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);


        //SAIDAS
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                           person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate(currentYear));

        scanner.close();
    }
    
}


//--------------------
//CLASSE MODELO
//--------------------


class HeartRates{

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;


    //CONSTRUTOR
    public HeartRates(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }

    // Getters e Setters
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



    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

     // FAIXA DE FREQUENCIA CARDIACA
    public String calculateTargetHeartRate(int currentYear) {
        int maxHR = calculateMaxHeartRate(currentYear);
        int minTarget = (int)(maxHR * 0.50);
        int maxTarget = (int)(maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }
}

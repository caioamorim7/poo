import java.util.Scanner;

public class ParkingGarage{


    public static double calculateCharges(double hours){
        double charge =2.0;

        if (hours > 3) {
            charge += (hours - 3) * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        double totalarrrecadado = 0;
        int customerCount = 0;

    while (true) {
        
    
        System.out.println("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
        double hours = scanner.nextDouble();

        if (hours == -1){
            break;
            }

        if (hours <=0 || hours > 24) {
            System.out.println("Número inválido de horas! Digite um valor entre 0 e 24.");
                continue;
            }

            customerCount++;

            double charge = calculateCharges(hours);

            totalarrecadado += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customerCount, charge);
        }    

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalRevenue);
        scanner.close();
        
    }
}
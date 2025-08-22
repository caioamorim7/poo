import java.util.Scanner;

public class CalculadoraIMC {
    public static void Main(String[] args) {
        double weight, height, IMC;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu peso: ");  
        weight = input.nextDouble();

        System.out.print("Digite sua altura: ");
        height = input.nextDouble();

        IMC = CalcularIMC(weight, height);

        System.out.printf(ClassificarIMC(IMC));
    }

    public static double CalcularIMC(double weight, double height) {
        return weight / ( height * height);
    }

    public static String ClassificarIMC(double IMC) {
        if (IMC < 18.5) {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Abaixo do Peso!\n";
        } else if (IMC >= 18.5 && IMC < 24.99) {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Eutrófico!\n";
        } else if (IMC >= 25 && IMC < 29.99) {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Sobrepeso!\n";
        } else if (IMC >= 30 && IMC < 34.99) {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Obesidade Grau I!\n";
        } else if (IMC >= 35 && IMC < 39.99) {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Obesidade Grau II!\n";
        } else {
            return "\nSeu IMC é: " + IMC + "\nClassificação: Obesidade Grau III!\n";
        }
    }
}
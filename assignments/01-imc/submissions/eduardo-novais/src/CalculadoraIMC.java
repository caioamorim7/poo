import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        double weight, height, IMC;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu peso: ");  
        weight = input.nextDouble();

        System.out.print("Digite sua altura: ");
        height = input.nextDouble();

        IMC = calcularIMC(weight, height);

        System.out.printf(classificarIMC(IMC));
    }

    public static double calcularIMC(double weight, double height) {
        return weight / ( height * height);
    }

    public static String classificarIMC(double IMC) {
        if (IMC < 18.5) {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Abaixo do Peso!\n", IMC);
        } else if (IMC >= 18.5 && IMC < 24.99) {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Eutrófico!\n", IMC);
        } else if (IMC >= 25 && IMC < 29.99) {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Sobrepeso!\n", IMC);
        } else if (IMC >= 30 && IMC < 34.99) {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Obesidade Grau I!\n", IMC);
        } else if (IMC >= 35 && IMC < 39.99) {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Obesidade Grau II!\n", IMC);
        } else {
            return String.format("\nSeu IMC é: %.2f \nClassificação: Obesidade Grau III!\n", IMC);
        }
    }
}
import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

<<<<<<< HEAD
        System.out.print("Digite seu peso em quilogramas: "); // entrada
=======
        System.out.print("Digite seu peso em quilogramas: "); //entrada
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

<<<<<<< HEAD
        double imc = calcularIMC(peso, altura); // calculo

        String classificacao = classificarIMC(imc); // classifica

        System.out.printf("Seu IMC é: %.2f%n", imc); // mostrando resultado
=======
        double imc = calcularIMC(peso, altura); //calculo

        String classificacao = classificarIMC(imc); //classifica

        System.out.printf("Seu IMC é: %.2f%n", imc); //printando
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25.0) {
            return "Eutrófico";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else if (imc < 35.0) {
            return "Obesidade grau I";
        } else if (imc < 40.0) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}

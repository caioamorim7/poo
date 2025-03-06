import java.util.Scanner;

public class IMCCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe seu peso (kg): ");
        double peso = input.nextDouble();

        System.out.print("Informe sua altura (m): ");
        double altura = input.nextDouble();

        double indiceIMC = calcularIndiceIMC(peso, altura);
        String statusIMC = determinarClassificacao(indiceIMC);

        System.out.printf("Seu Índice de Massa Corporal (IMC) é: %.2f%n", indiceIMC);
        System.out.println("Categoria: " + statusIMC);

        input.close();
    }

    public static double calcularIndiceIMC(double peso, double altura) {
        return peso / Math.pow(altura, 2);
    }

    public static String determinarClassificacao(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidade grau I";
        if (imc < 40) return "Obesidade grau II";
        return "Obesidade grau III";
    }
}

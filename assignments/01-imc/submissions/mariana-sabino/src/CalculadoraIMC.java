import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args){
    Scanner leitor = new Scanner(System.in);

    System.out.println("Digite o seu peso em quilogramas: ");
    double peso = leitor.nextDouble();

    System.out.println("Digite a sua altura em metros: ");
    double altura = leitor.nextDouble();

    double imc = calcularIMC(peso, altura);
    String classificacao = classificarIMC(imc);

    System.out.printf("Seu IMC eh: %.2f%n", imc);
    System.out.println("Classificacao: " + classificacao);

    leitor.close();
   
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);

    }

    public static String classificarIMC (double imc){
        if (imc < 18.50) {

            return "Abaixo do peso";

        } else if (imc >= 18.50 && imc < 24.99) {

            return "Eutrofico";

        } else if (imc >= 25.0 && imc < 29.99){

            return "Sobrepeso";

        } else if (imc >= 30.0 && imc < 34.99){
            
            return "Obesidade grau 1";

        } else if (imc >= 35.0 && imc < 39.99){

            return "Obesidade grau 2";

        } else {

            return "Obesidade grau 3";

        }

    }
}


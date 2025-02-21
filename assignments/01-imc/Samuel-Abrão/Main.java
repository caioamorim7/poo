import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        IMC pessoa = new IMC(peso, altura);

        System.out.println("Seu IMC é: " + pessoa.calcularIMC());
        System.out.println("Classificação: " + pessoa.classificarIMC());

        scanner.close();
        }
}
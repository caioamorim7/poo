import java.util.Scanner;

public class Imc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu peso em kilogramas: ");
        byte peso = scanner.nextByte();
        ////System.out.println("Seu peso é: " + peso);

        System.out.print("Digite sua altura em metros: ");
        float altura = scanner.nextFloat();
        ////System.out.println("Sua altura é: " + altura);
        
        float imc = (float) peso / (altura * altura);
        System.out.println("Seu IMC é: " + imc);
        System.out.print("Classificação: ");

        if (imc < 18.5f)
            System.out.println("Abaixo do peso");

        else if (18.5f < imc & imc < 24.99f)
            System.out.println("Eutrófico");

        else if (25.0f < imc & imc < 29.99f)
            System.out.println("Sobrepeso");

        else if (30.0f < imc & imc < 34.99f)
            System.out.println("Obesidade grau I");

        else if (35.0f < imc & imc < 39.99f)
            System.out.println("Obesidade grau II");

        else if (imc > 40.0f)
            System.out.println("Obesidade grau III");

        scanner.close();
    }
}

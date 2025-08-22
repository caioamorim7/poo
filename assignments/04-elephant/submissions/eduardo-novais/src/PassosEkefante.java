import java.util.Scanner;

public class PassosElefante {
    public static void Main(String[] args) {
        int passos;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Número inválido! Digite um valor entre 1 e 1.000.000.");
            return;
        }

        passos = CalcularPassosMinimos(x);

        System.out.println(FormatarSaida(passos));
    }

    public static int CalcularPassosMinimos(int x) {
        int passos = x / 5;

        if (x % 5 != 0) {
            passos += 1;
        }

        return passos;
    }

    public static String FormatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}

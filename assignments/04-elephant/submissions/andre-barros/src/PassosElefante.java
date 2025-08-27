import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

<<<<<<< HEAD

=======
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        if (x < 1 || x > 1000000) {
            System.out.println("Valor inválido! Digite um número entre 1 e 1.000.000.");
        } else {

            int passos = calcularPassosMinimos(x);

<<<<<<< HEAD

=======
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
            String saida = formatarSaida(passos);
            System.out.println(saida);
        }

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (int) Math.ceil(x / 5.0); 
    }
<<<<<<< HEAD
=======

>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}

import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite a posicao da casa do amigo: ");
        int x = leitor.nextInt();

        if (1 <= 1 || x <= 1000000) {
            System.out.println("Valor invalido");
            leitor.close();
            return;
        }

        int passos = calcularPassosMinimos(x);

        System.out.println(formatarSaida(passos));
    }

    public static int calcularPassosMinimos(int x){
        return (x + 4) / 5;
    }



    public static String formatarSaida(int passos) {
        return String.format("O numero minimo de passos necessarios eh: %d", passos);
    }
}

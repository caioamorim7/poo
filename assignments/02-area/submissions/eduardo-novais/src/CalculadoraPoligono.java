import java.util.Scanner;
import static java.lang.Math.PI;
import static java.lang.Math.tan;
import static java.lang.Math.pow;

public class CalculadoraPoligono {
    public static void Main(String[] args) {
        int n;
        double s, a;

        Scanner input = new Scanner(System.in);

        System.out.printf("Digite o numero de lados do Poligono: ");
        n = input.nextInt();

        System.out.printf("Digite o comprimento do lado em metros: ");
        s = input.nextDouble();

        input.close();

        a = calcularArea(n, s);

        System.out.println(fomatarSaida(a));
    }

    public static double calcularArea(int n, double s) {
        return (1 / 4) * pow(s, 2) * n * (1 / tan(PI / n));
    }

    public static String fomatarSaida(double area) {
        return String.format("A área do Polígono é: %.2f m²", area);
    }
}
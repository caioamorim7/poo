import java.util.Scanner;

public class CalculadoraPoligono {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o número de lados do polígono: ");
    Double n = scanner.nextDouble();
    System.out.println("Digite sua altura em metros: ");
    Double s = scanner.nextDouble();
    scanner.close();
    Double area = calcularArea(n, s);
    String areaFormatada = formatarArea(area);
    System.out.println(areaFormatada);
  }

  public static String formatarArea(Double area) {
    return "A área do polígono é " + area + " metros quadrados";
  }

  public static Double calcularArea(Double n, Double s) {
    return ((s*s)/4)*(n/(Math.tan(Math.PI/n)));
  }

}

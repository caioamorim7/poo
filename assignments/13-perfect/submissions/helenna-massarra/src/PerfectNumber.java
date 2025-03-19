import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {
        public static boolean isPerfect(int number) {
            if(number < 1) {
                return false;
            }
            int sum = 0;
            for(int i = 1; i <= number /2; i++) {
                if (number % i == 0) {
                sum += i;
            } 
        }
        return sum == number;
    }
        public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                List<Integer> factors = getFactors(i);
                System.out.printf("%d é um número perfeito. Fatores: %s\n", i, factors);
            }
        }

            System.out.print("\nTeste adicional:\nDigite um número para verificar se é perfeito: ");
                    int testNumber = scanner.nextInt();

                    if (isPerfect(testNumber)) {
                        List<Integer> factors = getFactors(testNumber);
                        System.out.printf("%d é um número perfeito. Fatores: %s\n", testNumber, factors);
                    } else {
                        System.out.printf("%d não é um número perfeito.\n", testNumber);
                    }

                    scanner.close();
    }
}
import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    System.out.println("Digite um número inteiro: ");
    int num = scanner.nextInt();    

    if (num <= 0) {
        System.out.println("Erro: O número deve ser um inteiro positivo.");
    } else {
        System.out.println("Sequência de Collatz: ");
        int soma = somaCollatz(num);
        System.out.println("Soma: " + soma);
    }
    }

    public static int proximoCollatz(int n){
          if( (n%2) == 0){
            return n/2;
          }else
          return (n*3) + 1;
    }

    public static int somaCollatz(int n){
        int soma = 0; 

        while (n != 1) {
            System.out.print(n + "→");
            soma += n; 
            n = proximoCollatz(n); 
        }
        System.out.print(n); 
        System.out.println();
        soma += n; 

        return soma; 

    }
}


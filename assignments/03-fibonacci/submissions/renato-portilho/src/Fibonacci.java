import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero inteiro não negativo: ");
        int n = scanner.nextInt();
        long ene = calcularFibonacci(n);
        System.out.println("O " + n + "º número da sequência de Fibonacci é: " + ene);
    }
    
    
    public static long calcularFibonacci(int n){
        if(n <= 1){
            return n;
        }else{
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}
import java.util.Scanner;


public class CalculadoraIMC {
    public static double altura;
    public static double peso;

    public static double calcularIMC(){
    return peso/ (altura * altura);
    }
    
    public static String classificarIMC(double imc){
        if(imc < 18.50){
                return "Abaixo do peso";
}else{
        if(imc >= 18.50 && imc < 24.99){
                return "Eutrófico";
}else{
        if (imc >= 24.99 && imc < 29.99) {
                return "Sobrepeso";               
}else{
        if (imc >= 29.99 && imc < 34.99) {
                return "Obesidade Grau I";
}else{
        if (imc >= 34.99 && imc < 39.99) {
                return "Obesidade Grau II";
}else{
                return "Obesidade Grau III";
                
                }
            }
        }
    }
}

}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculadoraIMC pessoa = new CalculadoraIMC();

        System.out.println("Digite sua altura:");
        pessoa.altura = sc.nextDouble();

        System.out.println("Digite seu peso:");
        pessoa.peso = sc.nextDouble();

        double imc = calcularIMC();

        System.out.println("Seu imc é: " + pessoa.calcularIMC());
        System.out.println("Sua classificação é: " + classificarIMC(imc));
    }

            
}

    




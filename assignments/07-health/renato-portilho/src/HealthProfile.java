import java.util.Scanner;

public class HealthProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println("Digite seu Primeiro nome: ");
         String primeiroNome = scanner.nextLine();

         System.out.println("Digite seu sobrenome: ");
         String sobrenome = scanner.nextLine();

         System.out.println("Digite o seu gênero: ");
         char genero = scanner.next().charAt(0);

         System.out.println("Digite a data do seu nascimento: ");
         int dia = scanner.nextInt(), mes = scanner.nextInt(), ano = scanner.nextInt();

         System.out.println("Digite sua altura em polegadas: ");
         double altura = scanner.nextDouble();

         System.out.println("Digite seu peso em libras: ");
         double peso = scanner.nextDouble();

         System.out.println("Altura: "+altura);
         System.out.println("Peso: "+peso);
         


         System.out.println("Nome: " +primeiroNome+ " " + sobrenome);
         System.out.println("Data de nascimento: " +dia+ "/" +mes+ "/" +ano);

         int idade = calcularIdade(dia, mes, ano);
         System.out.println("Idade: " +idade);

         int frequenciaMaxima = calcularfrequenciaMaxima(idade);
         System.out.println("Frequência cardíaca máxima: "+frequenciaMaxima+ "bpm");

         String frequenciaIdeal = frequenciaCardiacaIdeal(frequenciaMaxima);
         System.out.println(frequenciaIdeal);

         double bmi = calcularBMI(peso, altura);
         System.out.println("BMI: " +bmi);

         System.out.println("| **BMI**           | **Classificação**      |");
         System.out.println("|-------------------|------------------------|");
         System.out.println("| **Menos de 18.5** | Abaixo do peso         |");
         System.out.println("| **18.5 – 24.9**   | Peso normal            |");
         System.out.println("| **25.0 – 29.9**   | Sobrepeso              |");
         System.out.println("| **30.0 ou mais**  | Obesidade              |");


        

         



    }
    public static int  calcularIdade(int dia, int mes, int ano){
               
        int idade;
                if(dia < 0 || dia > 31 || mes > 12 || mes < 0 || ano > 2025 || ano < 1900){
                    idade = -1;
        }else{
                if(mes > 5 ){
                        idade = 2024 - ano;
        }else{
                if(mes < 5){
                        idade = 2025 - ano;
        }else{
                if(dia <= 5) {
                        idade = 2025 - ano;
                    
        }else{
                        idade = 2024 - ano;
                }

            }
        }
                }
        return idade;
    }

    public static int calcularfrequenciaMaxima(int idade){
         
        return 220 - idade;

    }

    public static String frequenciaCardiacaIdeal(int frequenciaMaxima){
        int frequenciaMaior = (int) (0.8 * frequenciaMaxima);
        int frequenciaMenor = (int) (0.5 * frequenciaMaxima);

        return "Frequência cardiaca ideal: "+frequenciaMenor+ "bpm - " +frequenciaMaior+ "bpm";

    }

    public static double calcularBMI(double peso, double altura){
       

        return (peso * 703) / (altura * altura);
    }
}


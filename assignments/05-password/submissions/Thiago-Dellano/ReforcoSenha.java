import java.util.Scanner;

public class ReforcoSenha {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String senha;

        do {
            System.out.print("Insira a senha: ");
            senha = input.nextLine();
        } while (senha.length() < 1 || senha.length() > 10 || !senha.matches("[a-z]+"));

        input.close();

        String senhaReforcada = gerarSenhaForte(senha);
        int duracaoDigitacao = calcularDuracaoDigitacao(senhaReforcada);

        System.out.println("Senha reforçada: " + senhaReforcada);
        System.out.println("Duração da digitação: " + duracaoDigitacao + " segundos");
    }

    public static String gerarSenhaForte(String senha) {
        String senhaMaisForte = "";
        int maiorDuracao = 0;

        for (int i = 0; i <= senha.length(); i++) {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                String novaSenha = senha.substring(0, i) + letra + senha.substring(i);
                int duracao = calcularDuracaoDigitacao(novaSenha);

                if (duracao > maiorDuracao) {
                    maiorDuracao = duracao;
                    senhaMaisForte = novaSenha;
                }
            }
        }

        return senhaMaisForte;
    }

    public static int calcularDuracaoDigitacao(String senha) {
        int tempoTotal = 2; 

        for (int i = 1; i < senha.length(); i++) {
            tempoTotal += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }

        return tempoTotal;
    }
}


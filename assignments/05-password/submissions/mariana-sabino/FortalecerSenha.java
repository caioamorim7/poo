import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);

        System.out.println("Digite a senha: ");
        String senha = leitor.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Senha invalida");
            leitor.close();
            return;
        }

        String senhaFortalecida = FortalecerSenha(senha);
        System.out.println("Senha fortalecida: " + senhaFortalecida);

        leitor.close();

    }

    public static String fortalecerSenha(String s){
        String melhorSenha = "";
        int maiorTempo = -1; 
        for (char letra = 'a'; letra <= 'z'; letra++) {
            // Testa todas as posições possíveis
            for (int i = 0; i <= s.length(); i++) {
                String novaSenha = s.substring(0, i) + letra + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }
}

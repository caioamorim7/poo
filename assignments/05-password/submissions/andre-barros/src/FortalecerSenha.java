import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

<<<<<<< HEAD

        System.out.print("Digite a senha: ");
        String s = scanner.next();


=======
        // Entrada do usuário
        System.out.print("Digite a senha: ");
        String s = scanner.next();

>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        if (s.length() < 1 || s.length() > 10) {
            System.out.println("Tamanho inválido! A senha deve ter entre 1 e 10 caracteres.");
            scanner.close();
            return;
        }

<<<<<<< HEAD

        String senhaFortalecida = fortalecerSenha(s);


=======
        String senhaFortalecida = fortalecerSenha(s);

        // Saída
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        System.out.println("Senha fortalecida: " + senhaFortalecida);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        int n = s.length();
        String melhor = null;
        int melhorTempo = -1;

        for (int pos = 0; pos <= n; pos++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidato = s.substring(0, pos) + c + s.substring(pos);
                int tempo = calcularTempoDigitacao(candidato);

                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhor = candidato;
                }

            }
        }

        return melhor;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;

<<<<<<< HEAD
        int tempo = 2; 
=======
        int tempo = 2;
>>>>>>> ba06837f6b0b66245252fb5f4ab931944ead3c04
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}

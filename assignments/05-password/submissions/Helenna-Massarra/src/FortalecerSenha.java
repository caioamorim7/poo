import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        String senha = scanner.next();
        
        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Tamanho inválido! A senha deve ter entre 1 e 10 caracteres.");
        } else {
            String senhaFortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        }
        
        scanner.close();
    }
    
    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;
        
        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String novaSenha = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(novaSenha);
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }
        
        return melhorSenha;
    }
    
    public static int calcularTempoDigitacao(String senha) {
        int tempo = 2; 
        
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        
        return tempo;
    }
}

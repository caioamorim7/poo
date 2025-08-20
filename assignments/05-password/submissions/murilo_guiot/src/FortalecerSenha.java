public class FortalecerSenha {

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        int tempo = 2;

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }

    public static String fortalecerSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            return "ab"; 
        }

        int tempoAtual = calcularTempoDigitacao(senha);

        if (tempoAtual >= 4 && senha.length() > 1) {
            char ultimoChar = senha.charAt(senha.length() - 1);
            char novoChar = (ultimoChar == 'z') ? 'a' : (char) (ultimoChar + 1);
            return senha + novoChar;
        }
        
        if (senha.length() == 1) {
            return senha + "b";
        }

        
        char ultimoChar = senha.charAt(senha.length() - 1);
        char novoChar = (ultimoChar == 'z') ? 'a' : (char) (ultimoChar + 1);
        return senha + novoChar;
    }

    public static void main(String[] args) {
        System.out.println("Testando o cálculo de tempo de digitação:");
        System.out.println("Tempo para 'a': " + calcularTempoDigitacao("a") + " (Esperado: 2)");
        System.out.println("Tempo para 'aa': " + calcularTempoDigitacao("aa") + " (Esperado: 3)");
        System.out.println("Tempo para 'ab': " + calcularTempoDigitacao("ab") + " (Esperado: 4)");
        System.out.println("Tempo para 'abc': " + calcularTempoDigitacao("abc") + " (Esperado: 6)");
        System.out.println("Tempo para 'abba': " + calcularTempoDigitacao("abba") + " (Esperado: 7)");
        
        System.out.println("\nTestando o fortalecimento de senhas:");
        String senhaCurta = "a";
        String senhaFortalecidaCurta = fortalecerSenha(senhaCurta);
        System.out.println("Senha original: '" + senhaCurta + "' -> Fortalecida: '" + senhaFortalecidaCurta + "' (Tempo: " + calcularTempoDigitacao(senhaFortalecidaCurta) + ")"); // Esperado: 'ab' -> 4

        String senhaMedia = "password";
        String senhaFortalecidaMedia = fortalecerSenha(senhaMedia);
        System.out.println("Senha original: '" + senhaMedia + "' -> Fortalecida: '" + senhaFortalecidaMedia + "' (Tempo: " + calcularTempoDigitacao(senhaFortalecidaMedia) + ")"); // Esperado: 'passwor' -> 16, 'passwored' -> 18

        String senhaVazia = "";
        String senhaFortalecidaVazia = fortalecerSenha(senhaVazia);
        System.out.println("Senha original: '" + senhaVazia + "' -> Fortalecida: '" + senhaFortalecidaVazia + "' (Tempo: " + calcularTempoDigitacao(senhaFortalecidaVazia) + ")"); // Esperado: 'ab' -> 4
    }
}
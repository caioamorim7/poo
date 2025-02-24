import java.util.Scanner;

public class FortalecerSenha {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite a senha: ");
    String senha = new String();
    do {
      senha = scanner.nextLine();
    } while (senha.length() > 10 || senha.length() < 0 || !senha.matches("[a-z]+"));
    scanner.close();
    String senhaNova = fortalecerSenha(senha);
    Integer tempo = calcularTempoDigitacao(senhaNova);
    System.out.println("Senha fortalecida : " + senhaNova);
    System.out.println(tempo);
  }

  public static String fortalecerSenha(String s){
    boolean temQueInserir = true;
    String ans = "";
    for (int i = 0; i < s.length() - 1; i++) {
      ans += s.charAt(i);
      if (s.charAt(i) == s.charAt(i + 1) && temQueInserir) {
        temQueInserir = false;
        if (s.charAt(i) == 'a') ans += 'b';
        else ans += 'a';
      }
    }
    ans += s.charAt(s.length()-1);
    if(temQueInserir){
      if(s.charAt(s.length()-1) == 'a') ans += 'b';
      else ans += 'a';
    }
    return ans;
  }
  public static int calcularTempoDigitacao(String s){
    int count = 2;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i-1)) count +=1;
      else count +=2;
    }
    return count;
  }
}

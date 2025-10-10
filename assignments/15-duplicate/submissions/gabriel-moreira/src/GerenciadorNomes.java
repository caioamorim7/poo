import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorNomes {

    public static void main(String[] args) {
        
        
        Set<String> nomesCadastrados = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);
        String entrada;

        
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (!entrada.isEmpty()) {
                nomesCadastrados.add(entrada);
            }
        }

        
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomesCadastrados);

        
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            if (!entrada.isEmpty()) {
                
                
                if (nomesCadastrados.contains(entrada)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }

        scanner.close();
    }
}
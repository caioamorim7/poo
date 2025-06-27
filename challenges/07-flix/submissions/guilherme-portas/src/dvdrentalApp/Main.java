package dvdrentalApp;

import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;

import dvdrentalApp.util.TextDBInserter;
import dvdrentalApp.dao.FilmDAO;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            while(true) {
                System.out.println("Digite uma opcao:\n");
                System.out.println("\t1 - Importar filmes do arquivo de texto");
                System.out.println("\t2 - Listar todos os filmes com duracao de locacao = 99");
                System.out.println("\t3 - Atualizar em 10% o valor de locacao de todos os filmes");
                System.out.println("\t0 - sair");

                int opcao = sc.nextInt();
                switch (opcao) {
                    case 0: return;
                    case 1: TextDBInserter.importNewFilms(); break;
                    case 2: FilmDAO.ListAllLocacao();
                            System.out.println("\nAperte <ENTER> para voltar para a tela inicial."); sc.nextLine(); sc.nextLine();
                            break;
                    case 3: FilmDAO.updateValorLocacao(); break;
                    default: System.out.println("Opcao inválida.");
                }
            }
        } catch(IOException ioex) {
            System.err.println("Erro ao ler arquivo de configuração - " + ioex.getMessage());
            return;
        } catch(SQLException sqlex) {
            System.err.println("Erro ao obter conexão com o banco de dados - " + sqlex.getMessage());
            return;
        }
    }
}
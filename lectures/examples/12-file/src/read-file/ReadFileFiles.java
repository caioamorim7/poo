import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileFiles {
    public static void main(String[] args){
        try {
            Path p = Paths.get("hello.txt");
            //Path p = Path.of("hello.txt");
            
            System.out.println(Files.readAllLines(p));

            System.out.println(Files.readString(p));

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}
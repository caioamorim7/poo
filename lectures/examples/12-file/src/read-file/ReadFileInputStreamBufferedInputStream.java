import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileInputStreamBufferedInputStream {
    public static void main(String[] args){

        try {
            Path p = Paths.get("hello.txt");
            //Path p = Path.of("hello.txt");

            try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(p.toFile()))){
                int byteLido;
                while((byteLido = reader.read()) != -1)
                    System.out.print((char)byteLido);
            }                        

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}

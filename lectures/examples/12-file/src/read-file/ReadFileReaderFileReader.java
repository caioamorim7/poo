import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileReaderFileReader {
    public static void main(String[] args){

        try {
            Path p = Paths.get("hello.txt");
            //Path p = Path.of("hello.txt");

            try(FileReader fileReader = new FileReader(p.toFile())){
                while(fileReader.ready())
                    System.out.print((char)fileReader.read());
            }                        

        } catch (FileNotFoundException fne){
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioe){
            System.out.println("Erro ao ler o arquivo.");
        } 
    }
}

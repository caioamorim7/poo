import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileOutputStreamBufferedOutputStream {
    public static void main(String[] args) {
        try {

            Path p = Paths.get("hello.txt");

            try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(p.toFile()))){
                output.write("Hello, World".getBytes());
            }
        } catch(FileNotFoundException fne){
            System.out.print("Arquivo não encontrado");
        } catch(IOException ioe){
            System.out.print("Arquivo não encontrado");
        }
    }
}

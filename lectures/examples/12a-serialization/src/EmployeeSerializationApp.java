
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmployeeSerializationApp {
    
    public static void main(String[] args) {
        Employee e = new Employee("Fabrico", "Santana", "123456" );

        try (OutputStream outputStream = Files.newOutputStream(Path.of("data/employee.txt"))){

            ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);

            objectStream.writeObject(e);
           
        } catch(IOException ex){
            System.out.printf("Erro ao serializar objeto: %s%n", ex);
        }
    }
    
}

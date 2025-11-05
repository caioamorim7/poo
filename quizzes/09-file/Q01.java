import java.io.IOException;
import java.nio.file.Path;
public final class Q01 {
    public static void main (String[] args) throws IOException {
        Path file = Path.of("./document", "../book/../chapter1");
    
        System.out.println(file.toAbsolutePath()); // (1)
        System.out.println(file.toRealPath()); // (2)
        System.out.println(file.normalize()); // (3)
        System.out.println(file.toString()); // (4)
        System.out.println(file.getParent()); // (5)
    }
}
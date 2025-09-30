import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class LogResource implements AutoCloseable {
    private final String name;

    LogResource(String name) {
        this.name = name;
        System.out.println("open " + name);
    }

    @Override
    public void close() {
        System.out.println("close " + name);
    }
}

public class Q15 {
    public static void main(String[] args) {
        ArrayList<Integer> levels = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
        try (LogResource resource = new LogResource("levels")) {
            Collections.sort(levels);
            levels.removeIf(v -> v % 2 == 0);
            int index = Collections.binarySearch(levels, 2);
            if (index < 0) {
                throw new IllegalStateException("missing");
            }
            System.out.println(levels.get(index));
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println(ex.getClass().getSimpleName());
        }
    }
}

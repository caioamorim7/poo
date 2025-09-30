public class Q05 {
    public static void main(String[] args) {
        var command = "compile";
        String tool = switch (command) {
            case "repl" -> "jshell";
            case "compile" -> {
                yield "javac";
            }
            case "run" -> "java";
            default -> "unknown";
        };
        System.out.println(tool);
    }
}

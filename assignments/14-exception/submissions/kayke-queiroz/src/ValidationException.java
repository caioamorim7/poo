public class ValidationException extends Exception {

    // Construtor que recebe apenas a mensagem de erro
    public ValidationException(String message) {
        super(message);
    }

    // Construtor que recebe a mensagem e a causa da exceção
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

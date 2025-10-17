/**
 * ValidationException é uma exceção personalizada para indicar erros de validação
 * de dados em objetos da aplicação.
 */
public class ValidationException extends Exception {

    /**
     * Construtor que recebe apenas a mensagem de erro.
     * @param message A descrição do erro.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Construtor que recebe a mensagem de erro e a causa original (exceção aninhada).
     * @param message A descrição do erro.
     * @param cause A exceção original que causou este erro.
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
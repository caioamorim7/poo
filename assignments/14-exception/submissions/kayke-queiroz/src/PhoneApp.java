public class PhoneApp {
    public static void main(String[] args) {
        // Teste 1: nome vazio
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 1: " + e.getMessage());
        }

        // Teste 2: número de série inválido (menos de 16 caracteres)
        try {
            Phone phone2 = new Phone("Samsung", "12345");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 2: " + e.getMessage());
        }

        // Teste 3: dados válidos
        try {
            Phone phone3 = new Phone("iPhone", "A1B2C3D4E5F6G7H8");
            System.out.println("Telefone criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar telefone 3: " + e.getMessage());
        }
    }
}

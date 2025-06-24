public class PhoneApp {
    public static void main(String[] args) {
        
        try {
            new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        
        try {
            new Phone("Galaxy", "12345");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        
        try {
            Phone valid = new Phone("iPhone", "1111222233334444");
            System.out.println("Telefone criado com sucesso: " + valid);
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}

public class PhoneApp {

    public static void main(String[] args) {
        
        System.out.println("--- Teste 1: Nome vazio ---");
        try {
            Phone p1 = new Phone("", "1234567890123456");
            System.out.println("Sucesso (não deveria ocorrer): " + p1.getName());
        } catch (ValidationException e) {
            System.out.println("Erro Capturado: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        System.out.println("--- Teste 2: Serial inválido ---");
        try {
            Phone p2 = new Phone("Galaxy Z", "12345");
            System.out.println("Sucesso (não deveria ocorrer): " + p2.getName());
        } catch (ValidationException e) {
            System.out.println("Erro Capturado: " + e.getMessage());
        }

        System.out.println("\n----------------------------\n");

        System.out.println("--- Teste 3: Dados Válidos ---");
        try {
            Phone p3 = new Phone("Xperia 10", "AABBCCDD11223344");
            System.out.println("Sucesso: Telefone '" + p3.getName() + "' criado com sucesso!");
        } catch (ValidationException e) {
            System.out.println("Erro Inesperado: " + e.getMessage());
        }
    }
}
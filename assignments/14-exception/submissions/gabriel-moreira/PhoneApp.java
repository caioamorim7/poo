public class PhoneApp {

    public static void main(String[] args) {

        // Teste 1: Nome vazio (lançamento da exceção)
        try {
            System.out.println("Tentativa 1: Nome vazio...");
            Phone p1 = new Phone("", "1234567890123456");
            System.out.println("Sucesso: " + p1.getName()); // Não deve chegar aqui
        } catch (ValidationException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        
        System.out.println("------------------------------------");

        // Teste 2: Número de série inválido (menos de 16 dígitos)
        try {
            System.out.println("Tentativa 2: Número de série com 10 dígitos...");
            Phone p2 = new Phone("Modelo X", "12345"); 
            System.out.println("Sucesso: " + p2.getName()); // Não deve chegar aqui
        } catch (ValidationException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("------------------------------------");

        // Teste 3: Dados válidos (sucesso)
        try {
            System.out.println("Tentativa 3: Dados válidos...");
            Phone p3 = new Phone("Modelo Y Pro", "ABCDEF0123456789");
            System.out.println("Sucesso! Telefone criado: " + p3.getName() + " (S/N: " + p3.getSerialNumber() + ")");
        } catch (ValidationException e) {
            System.err.println("Erro inesperado: " + e.getMessage()); // Não deve capturar
        }
    }
}
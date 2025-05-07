public class Phone {
    String name;
    String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        if(name == null || name.isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
        else if(serialNumber == null || serialNumber.isEmpty() || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }
        else {
            this.name = name;
            this.serialNumber = serialNumber;
        }
    }
}

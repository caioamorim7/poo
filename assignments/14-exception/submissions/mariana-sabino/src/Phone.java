public class Phone {
   Private String name;
   Private serialNumber;

public Phone(String name, String serialNumber) throws ValidationException {
    if (name == null || name.trim().isEmpty()) {
        throw new ValidationException("O nome do telefone não pode estar vazio.");
    }
    if (serialNumber == null || serialNumber.trim().isEmpty() || serialNumber.length() != 16) {
        throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
    }

    this.name = name;
    this.serialNumber = serialNumber;
}
public String getName() {
    return name;
}
publci String getSerialNumber() {
    return serialNumber;
    }
}

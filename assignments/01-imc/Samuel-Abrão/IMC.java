public class IMC {
    private double peso;
    private double altura;

    public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() { // Agora sem parâmetros
        return peso / (altura * altura);
    }

    public String classificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc >= 18.5 && imc < 24.99) return "Eutrófico";
        else if (imc >= 25 && imc < 29.99) return "Sobrepeso";
        else if (imc >= 30 && imc < 34.99) return "Obesidade grau I";
        else if (imc >= 35 && imc < 39.99) return "Obesidade grau II";
        else return "Obesidade Grau III";
    }
}

class MathUtils {
    int combine(int a, int b) {
        return a + b;
    }

    double combine(double a, double b) {
        return a * b;
    }

    String combine(String text, int repeat) {
        return text.repeat(repeat);
    }
}

public class Q11 {
    public static void main(String[] args) {
        MathUtils util = new MathUtils();
        System.out.println(util.combine(2, 3));
        System.out.println(util.combine(2.0, 3.0));
        System.out.println(util.combine("Hi", 2));
    }
}

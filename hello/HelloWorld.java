public class HelloWorld {
    public static void main (String[] args) {

        Student student = new Student("Fabricio Santana", 42, "Computer Science");

        System.out.printf("Hello, %s! You´re %s years old and are enroled in %s course.\n",
                                        student.getName(),
                                        student.getAge(),
                                        student.getCourse());
    }
}
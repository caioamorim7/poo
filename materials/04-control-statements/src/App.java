

public class App {
    public static void main(String[] args) throws Exception {
        
        Student student1 = new Student("Maria da Silva", 95.0);
        Student student2 = new Student("João da Silva", 70.0);

        System.out.printf("%s's letter grade is: %s%n", student1.getName(), student1.getLetterGrade());
        System.out.printf("%s's letter grade is: %s%n", student2.getName(), student2.getLetterGrade());
    }
}

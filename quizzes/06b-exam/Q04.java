public class Q04 {
    public static void main(String[] args) {
        int score = 78;
        String concept;
        if (score < 60) {
            concept = "F";
        } else if (score < 70) {
            concept = "D";
        } else if (score < 80) {
            concept = "C";
        } else if (score < 90) {
            concept = "B";
        } else {
            concept = "A";
        }
        boolean approved = concept.compareTo("C") <= 0 && score >= 70;
        System.out.println(concept + " " + approved);
    }
}

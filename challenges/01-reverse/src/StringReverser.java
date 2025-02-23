public class StringReverser {
    public String reverse(String input) {

        String res = new String();
  
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res.toString();
 
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(reverser.reverse(input));
    }

}
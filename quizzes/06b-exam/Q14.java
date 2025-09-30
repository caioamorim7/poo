import java.util.Arrays;

public class Q14 {
    public static void main(String[] args) {
        int[][] board = {
            {3, 1, 2},
            {6, 5, 4}
        };
        int[] flattened = Arrays.copyOf(board[0], 5);
        System.arraycopy(board[1], 0, flattened, 3, 2);
        Arrays.sort(flattened);
        System.out.println(Arrays.toString(flattened));
        System.out.println(Arrays.deepToString(board));
    }
}

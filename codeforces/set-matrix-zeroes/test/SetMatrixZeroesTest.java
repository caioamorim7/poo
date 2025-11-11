import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMatrixZeroesTest {

    @Test
    public void setMatrixZeroes_singleZero_setsEntireRowAndColumn() {
        int[][] matrix = {
                {5, 1, 9},
                {3, 0, 7},
                {8, 6, 2}
        };

        int[][] expected = {
                {5, 0, 9},
                {0, 0, 0},
                {8, 0, 2}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_multipleZeros_combinesAllRowsAndColumns() {
        int[][] matrix = {
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expected = {
                {0, 0, 0, 0},
                {0, 6, 0, 8},
                {0, 0, 0, 0},
                {0, 14, 0, 16}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_noZeros_keepsMatrixIntact() {
        int[][] matrix = {
                {9, 8},
                {7, 6}
        };

        int[][] expected = copyMatrix(matrix);

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_zeroInFirstRowOrColumn_hitsBoundaryRows() {
        int[][] matrix = {
                {0, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 6},
                {0, 0, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_oneZeroInMiddle() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };

        int[][] expected = {
                {1, 0, 3},
                {4, 0, 6},
                {0, 0, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_noZeros() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 4, 6}
        };

        int[][] expected = copyMatrix(matrix);

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_multipleZerosLargeMatrix() {
        int[][] matrix = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int[][] expected = {
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_centerZeroInSquare() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    @Test
    public void setMatrixZeroes_sampleCase_zeroInLastColumnAndMiddle() {
        int[][] matrix = {
                {3, 5, 2, 0},
                {1, 0, 4, 6},
                {7, 3, 2, 4}
        };

        int[][] expected = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {7, 0, 2, 0}
        };

        SetMatrixZeroes.setMatrixZeroes(matrix);

        assertMatrixEquals(expected, matrix);
    }

    private static void assertMatrixEquals(int[][] expected, int[][] actual) {
        for (int row = 0; row < expected.length; row++) {
            assertArrayEquals(expected[row], actual[row], "Row " + row + " mismatch");
        }
    }

    private static int[][] copyMatrix(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int row = 0; row < source.length; row++) {
            copy[row] = Arrays.copyOf(source[row], source[row].length);
        }
        return copy;
    }
}

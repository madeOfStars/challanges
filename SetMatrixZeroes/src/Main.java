/*
https://leetcode.com/problems/set-matrix-zeroes/
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>(matrix.length);
        Set<Integer> cols = new HashSet<>(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            Arrays.fill(matrix[row], 0);
        }

        for (int col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        m.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        m.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}

/*
https://leetcode.com/problems/reshape-the-matrix/
 */
import java.util.Arrays;

public class Main {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)
            return mat;

        int[][] result = new int[r][c];

        int matI = 0;
        int matJ = 0;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (matJ > mat[matI].length - 1) {
                    matJ = 0;
                    matI++;
                }

                result[i][j] = mat[matI][matJ];
                matJ++;
            }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] mat1 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(m.matrixReshape(mat1, 1, 4)));

        int[][] mat2 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(m.matrixReshape(mat1, 2, 4)));
    }
}

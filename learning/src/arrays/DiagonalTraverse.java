/*
https://leetcode.com/problems/diagonal-traverse/
 */
package arrays;

import java.util.Arrays;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];

        int i = 0;
        int j = 0;

        int index = 0;

        int finishI = mat.length - 1;
        int finishJ = mat[0].length - 1;

        int direction = 1;

        while (true) {
            result[index] = mat[i][j];
            index++;

            if (i == finishI && j == finishJ)
                break;

            if (direction == 1) {
                if (j == finishJ) {
                    i++;
                    direction = 0;
                } else if (i == 0) {
                    j++;
                    direction = 0;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == finishI) {
                    j++;
                    direction = 1;
                } else if (j == 0) {
                    i++;
                    direction = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse d = new DiagonalTraverse();

        int[][] mat1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] mat2 = new int[][]{
                {1, 2},
                {3, 4},
        };

        System.out.println(Arrays.toString(d.findDiagonalOrder(mat2)));
    }
}

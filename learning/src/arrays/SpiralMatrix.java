/*
https://leetcode.com/problems/spiral-matrix/
 */
package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int leftBorder = -1;
        int rightBorder = matrix[0].length;
        int upBorder = -1;
        int lowBorder = matrix.length;

        boolean visited;

        while (true) {
            visited = false;
            for (int i = leftBorder + 1; i < rightBorder; i++) {
                visited = true;
                result.add(matrix[upBorder + 1][i]);
            }

            if (!visited)
                break;

            upBorder++;

            visited = false;
            for (int i = upBorder + 1; i < lowBorder; i++) {
                visited = true;
                result.add(matrix[i][rightBorder - 1]);
            }

            if (!visited)
                break;

            rightBorder--;


            visited = false;
            for (int i = rightBorder - 1; i > leftBorder; i--) {
                visited = true;
                result.add(matrix[lowBorder - 1][i]);
            }

            if (!visited)
                break;

            lowBorder--;


            visited = false;
            for (int i = lowBorder - 1; i > upBorder; i--) {
                visited = true;
                result.add(matrix[i][leftBorder + 1]);
            }

            if (!visited)
                break;

            leftBorder++;

        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(sm.spiralOrder(matrix));
    }
}

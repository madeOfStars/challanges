/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
package recursion;

public class Search2DMatrixII_Iter {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;


        while (i >= 0 && j < matrix[0].length) {
            int startingPos = matrix[i][j];

            if (startingPos == target)
                return true;
            else if (startingPos > target)
                i--;
            else
                j++;

        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII_Iter s2 = new Search2DMatrixII_Iter();

        System.out.println(s2.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));

    }
}

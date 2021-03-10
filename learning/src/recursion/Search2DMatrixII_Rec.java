/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
package recursion;

public class Search2DMatrixII_Rec {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        return searchMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol, int target) {
        if (endRow < 0 || endRow >= matrix.length ||
                startRow < 0 || startRow >= matrix.length ||
                endCol >= matrix[0].length || endCol < 0 ||
                startCol < 0 || startCol >= matrix[0].length)
            return false;

        if (startRow > endRow || startCol > endCol)
            return false;

        int midCol = (startCol + endCol) / 2;

        if (midCol > matrix[0].length - 1)
            return false;

        int i = startRow;
        while (i <= endRow && matrix[i][midCol] <= target) {
            if (matrix[i][midCol] == target)
                return true;
            i++;
        }

        return searchMatrix(matrix, i, endRow, 0, midCol - 1, target) || searchMatrix(matrix, 0, i - 1, midCol + 1, endCol, target);
    }

    public static void main(String[] args) {
        Search2DMatrixII_Rec s2 = new Search2DMatrixII_Rec();

        System.out.println(s2.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(s2.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(s2.searchMatrix(new int[][]{{-1, 3}}, -1));
        System.out.println(s2.searchMatrix(new int[][]{{1, 3, 5}}, 1));

    }
}

/*
https://leetcode.com/problems/minimum-path-sum/
 */

public class Main1 {
    public static int minPathSum(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = 1; i < numRows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < numCols; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }

        return grid[numRows - 1][numCols - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] grid2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println(minPathSum(grid1));
        System.out.println(minPathSum(grid2));
    }
}

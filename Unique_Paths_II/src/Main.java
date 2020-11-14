/*
https://leetcode.com/problems/unique-paths-ii/
 */

public class Main {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[numRows - 1][numCols - 1] == 1)
            return 0;

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < numRows; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < numCols; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                else
                    obstacleGrid[i][j] = 0;
            }
        }

        return obstacleGrid[numRows - 1][numCols - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] obstacleGrid2 = new int[][]{
                {1, 0}
        };

        int[][] obstacleGrid3 = new int[][]{
                {0, 0}
        };

        int[][] obstacleGrid4 = new int[][]{
                {1, 0},
                {0, 0}
        };

        int[][] obstacleGrid5 = new int[][]{
                {0, 1},
                {0, 0}
        };

        int[][] obstacleGrid6 = new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid1));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
        System.out.println(uniquePathsWithObstacles(obstacleGrid3));
        System.out.println(uniquePathsWithObstacles(obstacleGrid4));
        System.out.println(uniquePathsWithObstacles(obstacleGrid5));
        System.out.println(uniquePathsWithObstacles(obstacleGrid6));
    }
}

/*
https://leetcode.com/problems/minimum-path-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    private static Map<String, Integer> locToSum;
    public static int minPathSum(int[][] grid) {
        locToSum = new HashMap<>();
        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private static int minPathSum(int[][] grid, int m, int n) {
        if (locToSum.containsKey(m+"|"+n))
            return locToSum.get(m+"|"+n);

        if (m == 0 && n == 0)
            return grid[0][0];
        else if (m == 0)
            return minPathSum(grid, 0, n - 1) + grid[0][n];
        else if (n == 0)
            return minPathSum(grid, m - 1, 0) + grid[m][0];
        else {
            int sum = Math.min(minPathSum(grid, m - 1, n), minPathSum(grid, m, n - 1)) + grid[m][n];
            locToSum.put(m+"|"+n, sum);
            return sum;
        }
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

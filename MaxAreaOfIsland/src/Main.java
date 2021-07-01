/*
https://leetcode.com/problems/max-area-of-island/
 */
public class Main {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int max = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1) {
                    int area = islandArea(grid, i, j);
                    max = Math.max(area, max);
                }

        return max;
    }

    private int islandArea(int[][] grid, int i, int j) {
        if (!isValid(grid, i, j))
            return 0;

        if (grid[i][j] != 1)
            return 0;

        grid[i][j] = -1;

        return 1 + islandArea(grid, i - 1, j) +
        islandArea(grid, i, j + 1) +
        islandArea(grid, i + 1, j) +
        islandArea(grid, i, j - 1);
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1)
            return false;

        return j >= 0 && j <= grid[i].length - 1;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] grid1 = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(m.maxAreaOfIsland(grid1));
    }
}

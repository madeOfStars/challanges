/*
https://leetcode.com/problems/unique-paths-iii/
 */
public class Main {
    private int[][] grid;
    private int ans = 0;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        int totalEmpty = 0;
        int startI = 0;
        int startJ = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    totalEmpty++;

                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        helper(startI, startJ, totalEmpty);

        return ans;
    }

    private void helper(int i, int j, int empty) {
        if (!isValid(i, j) || grid[i][j] < 0)
            return;

        if (grid[i][j] == 2 && empty != -1) {
            return;
        }

        if (grid[i][j] == 2 && empty == -1) {
            ans++;
            return;
        }

        grid[i][j] = -2;

        helper(i, j - 1, empty - 1);
        helper(i - 1, j, empty - 1);
        helper(i, j + 1, empty - 1);
        helper(i + 1, j, empty - 1);

        grid[i][j] = 0;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length);
    }

    public static void main(String[] args) {
        Main m = new Main();

        int [][]grid1 = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        System.out.println(m.uniquePathsIII(grid1));

        m = new Main();

        int [][]grid2 = new int[][] {
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };

        System.out.println(m.uniquePathsIII(grid2));
    }
}

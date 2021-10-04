/*
https://leetcode.com/problems/island-perimeter/
 */
public class Main {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (isValid(grid, i, j - 1) || grid[i][j - 1] == 0) {
                        sum++;
                    }

                    if (isValid(grid, i - 1, j) || grid[i - 1][j] == 0) {
                        sum++;
                    }

                    if (isValid(grid, i, j + 1) || grid[i][j + 1] == 0) {
                        sum++;
                    }

                    if (isValid(grid, i + 1, j) || grid[i + 1][j] == 0) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        return i > grid.length - 1 || i < 0 || j < 0 || j > grid[i].length - 1;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] grid1 = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
        };

        System.out.println(m.islandPerimeter(grid1));

        int[][] grid2 = {
                {1},
        };

        System.out.println(m.islandPerimeter(grid2));

        int[][] grid3 = {
                {1},
        };

        System.out.println(m.islandPerimeter(grid3));
    }
}

/*
https://leetcode.com/problems/number-of-islands/
 */

package amz;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }

        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j)) {
            return;
        }

        if (grid[i][j] != '1')
            return;

        grid[i][j] = 'V';

        helper(grid, i, j - 1);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i + 1, j);
    }

    private boolean isValid(char[][] grid, int i, int j) {
        return !(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length);
    }

    public static void main(String[] args) {
        NumberOfIslands m = new NumberOfIslands();

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };

        char[][] grid4 = {
                {'1'},
        };

        char[][] grid5 = {
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '0', '1'},
                {'1', '1', '1', '0', '1'},
        };

        System.out.println(m.numIslands(grid1));
        System.out.println(m.numIslands(grid2));
        System.out.println(m.numIslands(grid3));
        System.out.println(m.numIslands(grid4));
        System.out.println(m.numIslands(grid5));
    }
}

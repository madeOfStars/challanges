/*
https://leetcode.com/problems/number-of-islands/
 */

package queue_and_stack;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markAsVisited(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void markAsVisited(char[][] grid, int i, int j) {
        if ((i < 0 || i >= grid.length) || (j < 0 || j >= grid[i].length))
            return;

        if (grid[i][j] == '1')
            grid[i][j] = 'V';
        else
            return;

        markAsVisited(grid, i - 1, j);
        markAsVisited(grid, i, j + 1);
        markAsVisited(grid, i + 1, j);
        markAsVisited(grid, i, j - 1);
    }

    public static void main(String[] args) {
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

        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
        System.out.println(numIslands(grid3));
        System.out.println(numIslands(grid4));
        System.out.println(numIslands(grid5));
    }
}

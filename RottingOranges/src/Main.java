/*
https://leetcode.com/problems/rotting-oranges/
 */
import java.util.*;

public class Main {
    private static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int totalOranges = 0;
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    totalOranges++;
                if (grid[i][j] == 2)
                    queue.add(new Cell(i, j));
            }
        }

        if (totalOranges == 0)
            return 0;

        return bfs(grid, totalOranges, queue);
    }

    private int bfs(int[][] grid, int totalOranges, Queue<Cell> queue) {
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                Cell polledCell = queue.poll();
                final int row = polledCell.row;
                final int col = polledCell.col;

                if (isValid(grid, row, col - 1) && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new Cell(row, col - 1));
                    totalOranges--;
                }

                if (isValid(grid, row - 1, col) && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new Cell(row - 1, col));
                    totalOranges--;
                }

                if (isValid(grid, row, col + 1) && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new Cell(row, col + 1));
                    totalOranges--;
                }

                if (isValid(grid, row + 1, col) && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new Cell(row + 1, col));
                    totalOranges--;
                }
            }

            result++;
        }

        return totalOranges == 0 ? result - 1 : -1;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(m.orangesRotting(grid1)); //4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        System.out.println(m.orangesRotting(grid2)); //-1

        int[][] grid3 = {
                {0, 2},
        };

        System.out.println(m.orangesRotting(grid3)); //0

        int[][] grid4 = {
                {1},
        };

        System.out.println(m.orangesRotting(grid4)); //-1

        int[][] grid5 = {
                {0},
        };

        System.out.println(m.orangesRotting(grid5)); //0

        int[][] grid6 = {
                {0, 0, 0, 0},
        };

        System.out.println(m.orangesRotting(grid6)); //0

        int[][] grid7 = {
                {2, 1, 1},
                {1, 1, 1},
                {0, 1, 2},
        };

        System.out.println(m.orangesRotting(grid7)); //2
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (grid[0][0] == 1) {
            return -1;
        }

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] polledCell = queue.poll();

                if (polledCell[0] == grid.length - 1 && polledCell[1] == grid.length - 1)
                    return ans;

                if (isValid(visited, grid, new int[]{polledCell[0] - 1, polledCell[1] - 1})) {
                    queue.add(new int[]{polledCell[0] - 1, polledCell[1] - 1});
                    visited[polledCell[0] - 1][polledCell[1] - 1] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0] - 1, polledCell[1]})) {
                    queue.add(new int[]{polledCell[0] - 1, polledCell[1]});
                    visited[polledCell[0] - 1][polledCell[1]] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0] - 1, polledCell[1] + 1})) {
                    queue.add(new int[]{polledCell[0] - 1, polledCell[1] + 1});
                    visited[polledCell[0] - 1][polledCell[1] + 1] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0], polledCell[1] + 1})) {
                    queue.add(new int[]{polledCell[0], polledCell[1] + 1});
                    visited[polledCell[0]][polledCell[1] + 1] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0] + 1, polledCell[1] + 1})) {
                    queue.add(new int[]{polledCell[0] + 1, polledCell[1] + 1});
                    visited[polledCell[0] + 1][polledCell[1] + 1] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0] + 1, polledCell[1]})) {
                    queue.add(new int[]{polledCell[0] + 1, polledCell[1]});
                    visited[polledCell[0] + 1][polledCell[1]] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0] + 1, polledCell[1] - 1})) {
                    queue.add(new int[]{polledCell[0] + 1, polledCell[1] - 1});
                    visited[polledCell[0] + 1][polledCell[1] - 1] = true;
                }
                if (isValid(visited, grid, new int[]{polledCell[0], polledCell[1] - 1})) {
                    queue.add(new int[]{polledCell[0], polledCell[1] - 1});
                    visited[polledCell[0]][polledCell[1] - 1] = true;
                }
            }
            ans++;
        }

        return -1;
    }

    private boolean isValid(boolean[][] visited, int[][] grid, int[] cell) {
        int i = cell[0];
        int j = cell[1];

        return (i < grid.length && i >= 0 && j < grid[i].length && j >= 0) && grid[i][j] == 0 && !visited[i][j];
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] grid1 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        //System.out.println(m.shortestPathBinaryMatrix(grid1)); // 4

        int[][] grid2 = new int[][]{
                {0, 1},
                {1, 0},
        };

        //System.out.println(m.shortestPathBinaryMatrix(grid2)); // 2

        int[][] grid3 = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        //System.out.println(m.shortestPathBinaryMatrix(grid3)); // -1

        int[][] grid4 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid4)); // -1
    }
}

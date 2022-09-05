package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        final int N = grid.length;
        final int[][] deltas = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1}
        };

        int count = 0;

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                var polledNode = queue.poll();

                if (polledNode[0] == N - 1 && polledNode[1] == N - 1) {
                    return count;
                }

                for (int[] delta : deltas) {
                    int r = polledNode[0] + delta[0];
                    int c = polledNode[1] + delta[1];

                    if (isValid(r, c, N)) {
                        int[] nextNode = {r, c};

                        if (!visited[r][c] && grid[r][c] == 0) {
                            visited[r][c] = true;
                            queue.add(nextNode);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix m = new ShortestPathInBinaryMatrix();

        int[][] grid1 = {
                {0, 1},
                {1, 0}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid1)); //2

        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid2)); //4

        int[][] grid3 = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid3)); //-1

        int[][] grid4 = {
                {0}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid4)); //1

        int[][] grid5 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        };

        System.out.println(m.shortestPathBinaryMatrix(grid5)); //-1
    }
}

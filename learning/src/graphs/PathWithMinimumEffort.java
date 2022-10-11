/*
https://leetcode.com/problems/path-with-minimum-effort/
 */

package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private static class Cell {
        private final int x;
        private final int y;
        private final int dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        final int row = heights.length;
        final int col = heights[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] diffMatrix = new int[row][col];
        for (int[] eachRow : diffMatrix)
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        diffMatrix[0][0] = 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        boolean[][] visited = new boolean[row][col];

        queue.add(new Cell(0, 0, 0));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;

            if (curr.x == row - 1 && curr.y == col - 1)
                return curr.dist;

            for (int[] direction : directions) {
                int adjacentX = curr.x + direction[0];
                int adjacentY = curr.y + direction[1];

                if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y]);
                    int maxDifference = Math.max(currentDifference, diffMatrix[curr.x][curr.y]);

                    if (diffMatrix[adjacentX][adjacentY] > maxDifference) {
                        diffMatrix[adjacentX][adjacentY] = maxDifference;
                        queue.add(new Cell(adjacentX, adjacentY, maxDifference));
                    }
                }
            }
        }

        return diffMatrix[row - 1][col - 1];
    }

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }

    public static void main(String[] args) {
        PathWithMinimumEffort m = new PathWithMinimumEffort();

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5},
        };

        System.out.println(m.minimumEffortPath(heights));
    }
}

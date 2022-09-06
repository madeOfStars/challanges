/*
https://leetcode.com/problems/rotting-oranges/
 */

package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int remaining = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    remaining++;
                }

                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (remaining == 0) {
            return 0;
        }

        final int[][] deltas = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                var polledNode = queue.poll();

                for (int[] delta : deltas) {
                    int r = polledNode[0] + delta[0];
                    int c = polledNode[1] + delta[1];

                    if (isValid(r, c, grid) && grid[r][c] == 1) {
                        remaining--;
                        grid[r][c] = 2;
                        queue.add(new int[]{r, c});
                    }

                    if (remaining == 0) {
                        return count;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return r < grid.length && r >= 0 && c < grid[r].length && c >= 0;
    }

    public static void main(String[] args) {
        RottingOranges m = new RottingOranges();

        /*int[][] grid1 = {
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

        System.out.println(m.orangesRotting(grid7)); //2*/

        int[][] grid8 = {
                {2},
                {1},
        };

        System.out.println(m.orangesRotting(grid8)); //?1
    }
}

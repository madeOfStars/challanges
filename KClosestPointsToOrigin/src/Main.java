/*
https://leetcode.com/problems/k-closest-points-to-origin/
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            int x = point[0];
            int y = point[1];

            int dist = x * x + y * y;

            int[] entry = {dist, i};
            if (i < k) {
                queue.add(entry);
            } else if (queue.peek()[0] > dist) {
                queue.poll();
                queue.add(entry);
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            int index = queue.poll()[1];
            ans[i] = points[index];
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] points = new int[][]{
                {1, 3},
                {-2, 2}
        };

        System.out.println(Arrays.deepToString(m.kClosest(points, 1)));

        int[][] points1 = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        };

        System.out.println(Arrays.deepToString(m.kClosest(points1, 2)));
    }
}

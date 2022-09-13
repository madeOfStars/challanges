/*
https://leetcode.com/problems/min-cost-to-connect-all-points/
 */

package graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {
    private static class UnionFind {
        int[] root;
        int[] rank;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private record Point(int start, int end, int dist) {
    }

    public int minCostConnectPoints(int[][] points) {
        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));

        int size = points.length;

        for (int i = 0; i < size - 1; i++) {
            var c1 = points[i];
            for (int j = i + 1; j < size; j++) {
                var c2 = points[j];

                int dist = Math.abs(c1[0] - c2[0]) +
                        Math.abs(c1[1] - c2[1]);

                Point p = new Point(i, j, dist);

                queue.add(p);
            }
        }

        UnionFind uf = new UnionFind(size);

        int ans = 0;
        int count = size - 1;

        while (!queue.isEmpty() && count > 0) {
            Point p = queue.poll();

            if (!uf.connected(p.start, p.end)) {
                uf.union(p.start, p.end);
                ans += p.dist;
                count--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints m = new MinCostToConnectAllPoints();

        int[][] points1 = {
                {3, 12},
                {-2, 5},
                {-4, 1},
        };

        System.out.println(m.minCostConnectPoints(points1));

        int[][] points2 = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0},
        };

        System.out.println(m.minCostConnectPoints(points2));
    }
}

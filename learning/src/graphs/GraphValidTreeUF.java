/*
https://leetcode.com/problems/graph-valid-tree/
 */

package graphs;

public class GraphValidTreeUF {
    private int[] root;
    private int[] rank;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        initialize(n);

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    private void initialize(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int value) {
        if (root[value] == value) {
            return value;
        }

        return find(root[value]);
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }

    public static void main(String[] args) {
        GraphValidTreeUF gvt = new GraphValidTreeUF();

        int[][] edges1 = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        System.out.println(gvt.validTree(5, edges1));  //true

        int[][] edges2 = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        };

        System.out.println(gvt.validTree(5, edges2));  //false
    }
}

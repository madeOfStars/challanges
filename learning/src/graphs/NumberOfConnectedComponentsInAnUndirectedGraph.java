package graphs;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    private int[] root;
    private int[] rank;
    private int count;

    public int countComponents(int n, int[][] edges) {
        initialize(n);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return count;
    }

    private void initialize(int n) {
        root = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
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

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else {
            root[rootB] = rootA;
            rank[rootA]++;
        }

        count--;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph m = new NumberOfConnectedComponentsInAnUndirectedGraph();

        int[][] edges1 = new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(m.countComponents(5, edges1)); //2

        int[][] edges2 = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(m.countComponents(5, edges2)); //1
    }
}

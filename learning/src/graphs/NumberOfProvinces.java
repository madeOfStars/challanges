package graphs;

public class NumberOfProvinces {
    private int[] root;
    private int[] rank;
    private int count;

    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        initialize(size);
        count = size;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return count;
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

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }

        count--;
    }

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();

        int[][] isConnected1 = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(np.findCircleNum(isConnected1));

        int[][] isConnected2 = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println(np.findCircleNum(isConnected2));

        int[][] isConnected3 = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println(np.findCircleNum(isConnected3));
    }
}

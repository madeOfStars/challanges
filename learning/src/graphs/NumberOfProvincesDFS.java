/*
https://leetcode.com/problems/number-of-provinces/
 */

package graphs;

public class NumberOfProvincesDFS {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                helper(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    private void helper(int i, int[][] isConnected, boolean[] visited) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                helper(j, isConnected, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvincesDFS np = new NumberOfProvincesDFS();

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

/*
https://leetcode.com/problems/unique-paths/
 */

public class Main2 {
    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    paths[i][j] = 1;
                else
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;
        int m3 = 7, n3 = 3;
        int m4 = 3, n4 = 3;
        int m5 = 51, n5 = 9;

        System.out.println(uniquePaths(m1, n1));
        System.out.println(uniquePaths(m2, n2));
        System.out.println(uniquePaths(m3, n3));
        System.out.println(uniquePaths(m4, n4));
        System.out.println(uniquePaths(m5, n5));
    }
}

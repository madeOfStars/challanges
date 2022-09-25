/*
https://leetcode.com/problems/maximal-square/
 */
public class Main {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length + 1;
        int m = matrix[0].length + 1;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int i = 0; i < m; i++)
            dp[0][i] = 0;

        int max = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(m.maximalSquare(matrix));
    }
}

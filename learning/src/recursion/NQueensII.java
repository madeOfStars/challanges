/*
https://leetcode.com/problems/n-queens-ii/
 */
package recursion;

public class NQueensII {
    public int totalNQueens(int n) {
        if (n == 1)
            return 1;
        if (n == 2 || n == 3)
            return 0;

        boolean[][] board = new boolean[n][n];
        return totalNQueens(board, 0, n);
    }

    private int totalNQueens(boolean[][] board, int row, int n) {
        int count = 0;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = true;

                if (row + 1 == n)
                    count++;
                else
                    count += totalNQueens(board, row + 1, n);

                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col, int n) {

        for (int j = 0; j < n; j++) {
            if (board[row][j])
                return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][col])
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII nq = new NQueensII();

        System.out.println(nq.totalNQueens(4));
    }
}

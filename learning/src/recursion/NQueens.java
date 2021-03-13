/*
https://leetcode.com/problems/n-queens/
 */
package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        if (n == 1)
            return List.of(List.of("Q"));
        if (n == 2 || n == 3)
            return List.of();

        String[][] board = new String[n][n];
        List<List<String>> result = new ArrayList<>();
        initializeBoard(board);
        solveNQueens(board, 0, n, result);
        return result;
    }

    private void solveNQueens(String[][] board, int row, int n, List<List<String>> result) {
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = "Q";
                if (row + 1 == n)
                    result.add(parseBoard(board));
                else
                    solveNQueens(board, row + 1, n, result);
                board[row][col] = ".";
            }
        }

    }

    private void initializeBoard(String[][] board) {
        for (String[] strings : board) {
            Arrays.fill(strings, ".");
        }
    }

    private boolean isSafe(String[][] board, int row, int col, int n) {

        for (int j = 0; j < n; j++) {
            if (board[row][j].equals("Q"))
                return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q"))
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }

    private List<String> parseBoard(String[][] board) {
        List<String> result = new ArrayList<>();

        for (String[] strings : board) {
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                sb.append(string);
            }
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();

        System.out.println(nq.solveNQueens(4));
    }
}

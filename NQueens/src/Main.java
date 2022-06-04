/*
https://leetcode.com/problems/n-queens/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private final Set<Integer> cols = new HashSet<>();
    private final Set<Integer> diagonal = new HashSet<>();
    private final Set<Integer> antiDiagonal = new HashSet<>();

    private char[][] board;
    private final List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 1)
            return List.of(List.of("Q"));
        if (n == 2 || n == 3)
            return List.of();

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(n, 0);

        return ans;
    }

    private void helper(int n, int row) {
        if (row == n) {
            List<String> tmpList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmpList.add(new String(board[i]));
            }
            ans.add(tmpList);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                board[row][col] = 'Q';
                cols.add(col);
                diagonal.add(row - col);
                antiDiagonal.add(row + col);

                helper(n, row + 1);

                board[row][col] = '.';
                cols.remove(col);
                diagonal.remove(row - col);
                antiDiagonal.remove(row + col);
            }
        }
    }

    private boolean isValid(int row, int col) {
        return !cols.contains(col) && !diagonal.contains(row - col) && !antiDiagonal.contains(row + col);
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.solveNQueens(4));
    }
}

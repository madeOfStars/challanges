/*
https://leetcode.com/problems/design-tic-tac-toe/
 */

package amz;

public class TicTacToe {
    private final int[][] board;
    private final int n;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        if (isWinner(row, col, player)) {
            return player;
        }

        return 0;
    }

    private boolean isWinner(int row, int col, int player) {
        return checkRow(row, player) || checkCol(col, player) || (isDiagonal(row, col) && (checkMainDiagonal(player) || checkSecondaryDiagonal(player)));
    }

    private boolean checkRow(int row, int player) {
        for (int j = 0; j < n; j++) {
            if (board[row][j] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkMainDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkSecondaryDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (board[i][j] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean isDiagonal(int row, int col) {
        if (row == col)
            return true;

        return row + col == n - 1;
    }

    public static void main(String[] args) {
        TicTacToe m = new TicTacToe(3);

        System.out.println(m.move(0, 0, 1));
        System.out.println(m.move(0, 2, 2));
        System.out.println(m.move(2, 2, 1));
        System.out.println(m.move(1, 1, 2));
        System.out.println(m.move(2, 0, 1));
        System.out.println(m.move(1, 0, 2));
        System.out.println(m.move(2, 1, 1));

        m = new TicTacToe(2);
        System.out.println(m.move(0, 0, 2)); //0
        System.out.println(m.move(0, 1, 1)); //0
        System.out.println(m.move(1, 1, 2)); //2

        m = new TicTacToe(2);
        System.out.println(m.move(0, 1, 1)); //0
        System.out.println(m.move(1, 1, 2)); //0
        System.out.println(m.move(1, 0, 1)); //1
    }
}

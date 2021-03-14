/*
https://leetcode.com/problems/sudoku-solver/
 */
package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        List<FreeSpace> spaces = findSpaces(board);
        solveSudoku(board, spaces, 0, spaces.size());
    }

    private void solveSudoku(char[][] board, List<FreeSpace> spaces, int spacesIndex, int totalSpaces) {
        for (int value = 1; value <= 9; value++) {
            char charValue = Character.forDigit(value, 10);
            int row = spaces.get(spacesIndex).row;
            int col = spaces.get(spacesIndex).col;
            if (isValid(board, row, col, charValue)) {
                board[row][col] = charValue;
                if (spacesIndex + 1 == totalSpaces) {
                    System.out.println(Arrays.deepToString(board));
                    return;
                }
                solveSudoku(board, spaces, spacesIndex + 1, totalSpaces);
                board[row][col] = '.';
            }
        }
    }

    private List<FreeSpace> findSpaces(char[][] board) {
        List<FreeSpace> spaces = new ArrayList<>();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new FreeSpace(i, j));
                }
            }
        }

        return spaces;
    }

    private boolean isValid(char[][] board, int row, int col, char value) {
        if (board[row][col] != '.')
            return false;

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value)
                return false;
        }

        int sr = row / 3 * 3;
        int er = sr + 3;
        int sc = col / 3 * 3;
        int ec = sc + 3;

        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                if (board[i][j] == value)
                    return false;
            }
        }

        return true;
    }

    private static class FreeSpace {
        int row;
        int col;

        public FreeSpace(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();

        char[][] board = new char[][]{
                {'3', '.', '.', '9', '.', '.', '2', '.', '.'},
                {'8', '.', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '.', '1', '.', '3', '.', '.', '.'},
                {'.', '1', '8', '.', '.', '2', '.', '5', '.'},
                {'.', '9', '.', '.', '4', '.', '.', '.', '.'},
                {'.', '2', '.', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '9', '.', '4', '1', '.'},
                {'6', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '3', '.', '.', '2', '.'}
        };

        ss.solveSudoku(board);
    }
}

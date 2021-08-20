/*
https://leetcode.com/problems/valid-sudoku/
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>(9);
        Set<Character> rows = new HashSet<>(9);
        Map<String, Set<Character>> blocks = new HashMap<>(9);

        for (int i = 0; i < 9; i++) {
            cols.put(i, new HashSet<>());

            for (int j = 0; j < 9; j++) {
                String blockKey = (i / 3) + "|" + (j / 3);

                blocks.put(blockKey, new HashSet<>());
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char cell = board[i][j];

                if (cell == '.')
                    continue;

                if (rows.contains(cell))
                    return false;

                rows.add(cell);

                if (cols.get(j).contains(cell))
                    return false;

                cols.get(j).add(cell);

                String blockKey = (i / 3) + "|" + (j / 3);

                if (blocks.get(blockKey).contains(cell))
                    return false;

                blocks.get(blockKey).add(cell);
            }

            rows.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();

        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(m.isValidSudoku(board1));
    }
}

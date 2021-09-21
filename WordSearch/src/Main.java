/*
https://leetcode.com/problems/word-search/
 */
public class Main {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[i].length];

                    boolean ans = helper(board, i, j, word, 0, visited);

                    if (ans)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (!isValid(board, i, j) || visited[i][j])
            return false;

        if (index == word.length() - 1 && board[i][j] == word.charAt(index)) {
            return true;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean b = helper(board, i, j - 1, word, index + 1, visited)
                || helper(board, i - 1, j, word, index + 1, visited)
                || helper(board, i, j + 1, word, index + 1, visited)
                || helper(board, i + 1, j, word, index + 1, visited);

        visited[i][j] = false;
        return b;
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
    }

    public static void main(String[] args) {
        Main m = new Main();
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(m.exist(board1, "ABCCED"));
        System.out.println(m.exist(board1, "SEE"));
        System.out.println(m.exist(board1, "ABCB"));
        System.out.println(m.exist(board1, "EEDFCCES"));
        System.out.println(m.exist(board1, "EEDAF"));

        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(m.exist(board2, "ABCESEEEFS"));
    }
}

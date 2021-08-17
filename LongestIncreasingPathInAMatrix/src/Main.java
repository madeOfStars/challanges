/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
import java.util.HashMap;
import java.util.Map;

public class Main {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = helper(matrix, i, j, map);
                result = Math.max(result, value);
            }
        }
        return result;
    }

    private int helper(int[][] matrix, int i, int j, Map<String, Integer> map) {
        if (i >= matrix.length || i < 0 || j >= matrix[i].length || j < 0)
            return 0;

        int left = 0;
        int up = 0;
        int right = 0;
        int down = 0;

        String key = i + "|" + j;

        if (map.containsKey(key))
            return map.get(key);

        if (j > 0 && matrix[i][j] < matrix[i][j - 1])
            left = helper(matrix, i, j - 1, map);

        if (i > 0 && matrix[i][j] < matrix[i - 1][j])
            up = helper(matrix, i - 1, j, map);

        if (j < matrix[i].length - 1 && matrix[i][j] < matrix[i][j + 1])
            right = helper(matrix, i, j + 1, map);

        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j])
            down = helper(matrix, i + 1, j, map);

        map.put(key, 1 + Math.max(Math.max(left, up), Math.max(right, down)));

        return map.get(key);
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] matrix1 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };

        System.out.println(m.longestIncreasingPath(matrix1));

        int[][] matrix2 = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1},
        };

        System.out.println(m.longestIncreasingPath(matrix2));

        int[][] matrix3 = {
                {7, 7, 5},
                {2, 4, 6},
                {8, 2, 0},
        };

        System.out.println(m.longestIncreasingPath(matrix3));

        int[][] matrix4 = {
                {7, 8, 9},
                {9, 7, 6},
                {7, 2, 3}};

        System.out.println(m.longestIncreasingPath(matrix4));
    }
}

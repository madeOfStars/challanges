/*
https://leetcode.com/problems/range-addition-ii/
 */
public class Main {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return n * m;

        int minRow = m + 1;
        int minCol = n + 1;

        for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];

            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] ops1 = {
                {2, 2},
                {3, 3}
        };

        System.out.println(m.maxCount(3, 3, ops1));

        int[][] ops2 = {
                {2, 2},
                {3, 3},
                {3, 3},
                {3, 3},
                {2, 2},
                {3, 3},
                {3, 3},
                {3, 3},
                {2, 2},
                {3, 3},
                {3, 3},
                {3, 3}
        };

        System.out.println(m.maxCount(3, 3, ops2));

        System.out.println(m.maxCount(3, 3, new int[][]{}));
    }
}

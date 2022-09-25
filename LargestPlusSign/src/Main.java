import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.stream(mines).forEach(el -> {
            set.add(Arrays.asList(el[0], el[1]));
        });

        int[][] dp = new int[n][n];
        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < 2 || j < 2 || i > n - 2 || j > n - 2) {
                    dp[i][j] = set.contains(Arrays.asList(i, j)) ? 0 : 1;
                } else if (!set.contains(Arrays.asList(i, j))) {
                    int left = score(dp, set, i, j - 1);
                    int right = score(dp, set, i - 1, j);

                    dp[i][j] = Math.max(left, right);
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max + 1;
    }

    private int score(int[][] dp, Set<List<Integer>> set, int i, int j) {
        int n = dp.length;
        int delta = dp[i][j];
        if (!set.contains(Arrays.asList(i, j - delta)) && !set.contains(Arrays.asList(i - delta, j))
                && !set.contains(Arrays.asList(i, j + delta)) && !set.contains(Arrays.asList(i, delta + j)) &&
                isValid(n, i, j - delta) && isValid(n, i - delta, j) && isValid(n, i, j + delta) && isValid(n, i, delta + j)) {
            return dp[i][j] + 1;
        }
        return 0;
    }

    private boolean isValid(int n, int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        Main m = new Main();

        //System.out.println(m.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        //System.out.println(m.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
        System.out.println(m.orderOfLargestPlusSign(5, new int[][]{}));
    }
}

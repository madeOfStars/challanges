/*
https://leetcode.com/problems/distinct-subsequences/
 */
public class Main {
    public int numDistinct(String s, String t) {
        int[][] res = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= Math.min(i, t.length()); j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = 1;
                } else if (j == 0) {
                    res[i][j] = 1;
                } else if (i == 0) {
                    res[i][j] = 0;
                } else {
                    if (s.charAt(i - 1) != t.charAt(j - 1)) {
                        res[i][j] = res[i - 1][j];
                    } else {
                        res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                    }
                }
            }
        }

        return res[s.length()][t.length()];
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.numDistinct("rabbbit", "rabbit"));
        System.out.println(m.numDistinct("babgbag", "bag"));
    }
}

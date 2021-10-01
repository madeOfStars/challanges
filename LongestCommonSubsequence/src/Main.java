/*
https://leetcode.com/problems/longest-common-subsequence/
 */
public class Main {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] ans = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    ans[i][j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        ans[i][j] = ans[i - 1][j - 1] + 1;
                    } else {
                        ans[i][j] = ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
                    }
                }
            }
        }

        return ans[n][m];
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.longestCommonSubsequence("abcde", "ace"));
        System.out.println(m.longestCommonSubsequence("abc", "abc"));
        System.out.println(m.longestCommonSubsequence("abc", "def"));
        System.out.println(m.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}

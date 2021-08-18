/*
https://leetcode.com/problems/decode-ways/
 */
public class Main {
    public int numDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) != '0') {
            return 1;
        }

        if (s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' < 7)) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.numDecodings("11106"));
        System.out.println(m.numDecodings("12"));
        System.out.println(m.numDecodings("226"));
        System.out.println(m.numDecodings("0"));
        System.out.println(m.numDecodings("111"));
    }
}

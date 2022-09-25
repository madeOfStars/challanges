/*
https://leetcode.com/problems/palindromic-substrings/
 */
public class Main {
    public int countSubstrings(String s) {
        if (s.length() == 1)
            return 1;

        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        int ans = n;

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i <= j + 1 || isPalindrome[i - 1][j + 1])) {
                    isPalindrome[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.countSubstrings("abc")); // 3
        System.out.println(m.countSubstrings("aaa")); // 6
    }
}

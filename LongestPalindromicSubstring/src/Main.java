/*
https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Main {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        int n = s.length();
        int max = -1;
        int maxI = 0;
        int maxJ = 0;

        int[][] matrix = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i > j)
                    continue;

                if (i == j)
                    matrix[i][j] = 1;
                else {
                    boolean value = s.charAt(j) == s.charAt(i);

                    if (j != i + 1)
                        value = value && matrix[i + 1][j - 1] == 1;

                    if (value) {
                        matrix[i][j] = 1;

                        if (j - i > max) {
                            max = j - i;
                            maxI = i;
                            maxJ = j;
                        }
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.longestPalindrome("babad"));
        System.out.println(m.longestPalindrome("cbbd"));
        System.out.println(m.longestPalindrome("ac"));
        System.out.println(m.longestPalindrome("aca"));
        System.out.println(m.longestPalindrome("ccc"));
        System.out.println(m.longestPalindrome("bb"));
        System.out.println(m.longestPalindrome("abb"));
        System.out.println(m.longestPalindrome("xyzabbb"));
        System.out.println(m.longestPalindrome("xaabacxcabaaxcabaax")); //"xaabacxcabaax"
        System.out.println(m.longestPalindrome("aaaa"));
        System.out.println(m.longestPalindrome("aacabdkacaa")); //aca
        System.out.println(m.longestPalindrome("bacabab"));
        System.out.println(m.longestPalindrome("abbcccbbbcaaccbababcbcabca")); //"bbcccbb"
    }
}

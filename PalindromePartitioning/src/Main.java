/*
https://leetcode.com/problems/palindrome-partitioning/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>> ans = new ArrayList<>();
        helper(0, ans, new LinkedList<>(), dp, s);
        return ans;
    }

    private void helper(int start, List<List<String>> ans, LinkedList<String> tmpList, boolean[][] dp, String s) {
        if (start == s.length())
            ans.add(new ArrayList<>(tmpList));

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == s.charAt(i) && (i - start <= 2 || dp[start + 1][i - 1])) {
                dp[start][i] = true;
                tmpList.add(s.substring(start, i + 1));
                helper(i + 1, ans, tmpList, dp, s);
                tmpList.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        String s1 = "abcba";
        System.out.println(m.partition(s1));
    }
}

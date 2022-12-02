/*
https://leetcode.com/problems/word-break-ii/
 */

package amz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        helper(s, dict, 0, ans, new LinkedList<>());
        return ans;
    }

    private void helper(String s, Set<String> dict, int start, List<String> ans, LinkedList<String> tmp) {
        if (start == s.length()) {
            ans.add(createString(tmp));
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (dict.contains(substring)) {
                tmp.add(substring);
                helper(s, dict, end, ans, tmp);
                tmp.removeLast();
            }
        }
    }

    private String createString(List<String> strings) {
        return String.join(" ", strings);
    }

    public static void main(String[] args) {
        WordBreakII m = new WordBreakII();
        System.out.println(m.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
}

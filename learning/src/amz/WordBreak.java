package amz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak m = new WordBreak();
//        System.out.println(m.wordBreak("leetcode", List.of("leet", "code")));
//        System.out.println(m.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(m.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}

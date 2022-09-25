/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> word = new HashMap<>(p.length());
        Map<Character, Integer> map = new HashMap<>(p.length());

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            word.put(p.charAt(i), word.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if (i >= p.length()) {
                char r = s.charAt(i - p.length());

                map.put(r, map.get(r) - 1);

                if (map.get(r) == 0) {
                    map.remove(r);
                }
            }

            if (map.equals(word)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.findAnagrams("cbaebabacd", "abc"));
        System.out.println(m.findAnagrams("abab", "ab"));
        System.out.println(m.findAnagrams("abca", "abc"));
        System.out.println(m.findAnagrams("baa", "aa"));
    }
}

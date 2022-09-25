/*
https://leetcode.com/problems/letter-case-permutation/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (Character c : s.toCharArray()) {
            int size = ans.size();

            if (Character.isLetter(c)) {
                for (int i = 0; i < size; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(size + i).append(Character.toUpperCase(c));
                }
            } else {
                for (StringBuilder an : ans) an.append(c);
            }
        }

        return ans.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.letterCasePermutation("abc"));
    }
}

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

package amz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, List<Character>> digitsMap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return List.of();

        List<String> ans = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void helper(String digits, int index, StringBuilder sb, List<String> ans) {
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }

        var digit = digits.charAt(index);

        List<Character> characters = digitsMap.get(digit);
        for (Character character : characters) {
            sb.append(character);
            helper(digits, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber m = new LetterCombinationsOfAPhoneNumber();
        System.out.println(m.letterCombinations("234"));
    }
}

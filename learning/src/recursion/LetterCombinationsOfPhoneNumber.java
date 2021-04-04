/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    private static final Map<Character, List<Character>> LETTER_PER_DIGIT = Map.of(
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

        List<String> result = new ArrayList<>();

        letterCombinations(digits, 0, result, new StringBuilder());

        return result;
    }

    private void letterCombinations(String digits, int key, List<String> result, StringBuilder sb) {
        if (key >= digits.length())
            return;

        if (digits.charAt(key) == '0' || digits.charAt(key) == '1')
            return;

        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(key);

        for (int i = 0; i < LETTER_PER_DIGIT.get(c).size(); i++) {
            sb.append(getLeter(c, i));
            if (sb.length() == digits.length())
                result.add(sb.toString());
            else
                letterCombinations(digits, key + 1, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    private Character getLeter(Character key, int position) {
        return LETTER_PER_DIGIT.get(key).get(position);
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lc = new LetterCombinationsOfPhoneNumber();

        System.out.println(lc.letterCombinations("23"));
    }
}

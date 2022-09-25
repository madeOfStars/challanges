import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Character, List<Character>> map = Map.of(
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
        helper(digits, 0, new char[digits.length()], ans);
        return ans;
    }

    private void helper(String digits, int index, char[] buffer, List<String> ans) {
        if (index >= digits.length()) {
            ans.add(new String(buffer));
            return;
        }

        for (char c : map.get(digits.charAt(index))) {
            buffer[index] = c;
            helper(digits, index + 1, buffer, ans);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.letterCombinations("23"));
        System.out.println(m.letterCombinations(""));
        System.out.println(m.letterCombinations("2"));
        System.out.println(m.letterCombinations("234"));
    }
}

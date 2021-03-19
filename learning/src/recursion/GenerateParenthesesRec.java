package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParenthesesRec {
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return List.of();
        List<String> result = new ArrayList<>();

        generateParenthesis(n, "", '(', result);

        return result;
    }

    private void generateParenthesis(int n, String s, char parenthesis, List<String> result) {
        String newString = s + parenthesis;

        if (!isValid(newString, n))
            return;

        if (newString.length() == 2 * n) {
            result.add(newString);
            return;
        }

        generateParenthesis(n, newString, '(', result);
        generateParenthesis(n, newString, ')', result);
    }

    private boolean isValid(String s, int n) {
        Deque<Character> stack = new ArrayDeque<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > n)
                    return false;

                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GenerateParenthesesRec gp = new GenerateParenthesesRec();

        System.out.println(gp.generateParenthesis(3));
    }
}

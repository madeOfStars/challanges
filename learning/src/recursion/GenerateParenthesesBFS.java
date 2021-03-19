/*
https://leetcode.com/problems/generate-parentheses/
 */
package recursion;

import java.util.*;

public class GenerateParenthesesBFS {
    public List<String> generateParenthesis(int n) {
        if (n == 1)
            return List.of("()");

        List<String> result = new ArrayList<>();
        List<String> parenthesis = List.of("(", ")");

        Queue<String> queue = new LinkedList<>();
        queue.add("(");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String polledElement = queue.poll();

                for (String s : parenthesis) {
                    String newString = polledElement.concat(s);

                    if (!isValid(newString, n))
                        continue;

                    if (newString.length() == 2 * n) {
                        result.add(newString);
                        continue;
                    }

                    queue.add(newString);
                }
            }
        }

        return result;
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
        GenerateParenthesesBFS gp = new GenerateParenthesesBFS();

        System.out.println(gp.generateParenthesis(3));
    }
}

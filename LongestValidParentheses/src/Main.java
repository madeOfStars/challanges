/*
https://leetcode.com/problems/longest-valid-parentheses/q
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public int longestValidParentheses(String s) {
        if (s.isEmpty())
            return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.peek() != -1 && s.charAt(stack.peek()) == '(' && c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            } else {
                stack.push(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.longestValidParentheses("(()")); // 2
        System.out.println(m.longestValidParentheses(")()())")); // 4
        System.out.println(m.longestValidParentheses("")); // 0
        System.out.println(m.longestValidParentheses("())")); // 2
    }
}

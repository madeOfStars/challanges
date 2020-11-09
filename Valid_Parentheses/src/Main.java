/*
https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> parenthesis = new Stack<>();
        parenthesis.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char peekedChar = parenthesis.isEmpty() ? ' ' : parenthesis.peek();
            Character popCharacter = null;
            switch (peekedChar) {
                case '(':
                    if (s.charAt(i) == ')')
                        popCharacter = parenthesis.pop();
                    break;
                case '{':
                    if (s.charAt(i) == '}')
                        popCharacter = parenthesis.pop();
                    break;
                case '[':
                    if (s.charAt(i) == ']')
                        popCharacter = parenthesis.pop();
                    break;
            }

            if (popCharacter == null)
                parenthesis.push(s.charAt(i));
        }

        return parenthesis.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "()";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }
}

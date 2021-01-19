/*
https://leetcode.com/problems/decode-string/
 */
package queue_and_stack;

import java.util.Stack;

public class DecodeString {
    private static class Pair {
        int left;
        String right;

        public Pair(int left, String right) {
            this.left = left;
            this.right = right;
        }
    }
    public String decodeString(String s) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(1, ""));

        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '[') {
                stack.push(new Pair(left, ""));
                left = 0;
            } else if (currentChar == ']') {
                Pair pair = stack.pop();
                StringBuilder sb = new StringBuilder();

                sb.append(String.valueOf(pair.right).repeat(Math.max(0, pair.left)));

                pair = stack.pop();
                pair.right += sb.toString();
                stack.push(pair);
            } else if (!Character.isDigit(currentChar)) {
                Pair pair = stack.pop();
                String currentString = pair.right;
                currentString += currentChar;
                pair.right = currentString;
                stack.push(pair);
            } else {
                left = left * 10 + Character.getNumericValue(currentChar);
            }
        }

        return stack.peek().right;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();

        String s1 = "3[a]2[bc]";
        System.out.println(ds.decodeString(s1));

        String s2 = "3[a2[c]]";
        System.out.println(ds.decodeString(s2));

        String s3 = "2[abc]3[cd]ef";
        System.out.println(ds.decodeString(s3));

        String s4 = "abc3[cd]xyz";
        System.out.println(ds.decodeString(s4));

        String s5 = "100[leetcode]";
        System.out.println(ds.decodeString(s5));
    }
}

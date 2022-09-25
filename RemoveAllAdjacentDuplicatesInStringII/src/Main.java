/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public String removeDuplicates(String s, int k) {
        if (s.length() == 1)
            return s;

        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> count = new LinkedList<>();

        stack.push(s.charAt(0));
        count.push(1);

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == currChar) {
                count.push(count.isEmpty() ? 0 : count.peek() + 1);
            } else {
                count.push(1);
            }
            stack.push(currChar);

            if (!stack.isEmpty() && !count.isEmpty() && count.peek() >= k) {
                Character poppedChar = stack.pop();
                count.pop();

                while (!stack.isEmpty() && poppedChar == stack.peek()) {
                    poppedChar = stack.pop();
                    count.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.removeDuplicates("abcd", 2)); //abcd
        System.out.println(m.removeDuplicates("deeedbbcccbdaa", 3)); //aa
        System.out.println(m.removeDuplicates("pbbcggttciiippooaais", 2)); //ps
        System.out.println(m.removeDuplicates("aaa", 3)); //ps
    }
}

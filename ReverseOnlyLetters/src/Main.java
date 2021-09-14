/*
https://leetcode.com/problems/reverse-only-letters/
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public String reverseOnlyLetters(String s) {
        Queue<Integer> pos = new LinkedList<>();
        Stack<Character> data = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isAlphabetic(c)) {
                pos.add(i);
            } else {
                data.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        int top = pos.isEmpty() ? -1 : pos.poll();
        int index = 0;

        while (index < s.length()){
            if (index == top) {
                sb.append(s.charAt(top));
                top = pos.isEmpty() ? -1 : pos.poll();
            } else {
                char c = data.isEmpty() ? ' ' : data.pop();
                sb.append(c);
            }
            index++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();

        //System.out.println(m.reverseOnlyLetters("ab-cd"));
        //System.out.println(m.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(m.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

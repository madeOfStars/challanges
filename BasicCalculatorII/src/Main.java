/*
https://leetcode.com/problems/basic-calculator-ii/
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public int calculate(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }

        Deque<Integer> values = new ArrayDeque<>();
        char lastOp = ' ';

        int value = 0;

        boolean decrement = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;

            while (Character.isDigit(c)) {
                value = value * 10 + (c - '0');
                i++;
                decrement = true;
                if (i >= s.length()) {
                    break;
                }
                c = s.charAt(i);
            }

            if (decrement) {
                i--;
                decrement = false;

                if (values.isEmpty()) {
                    values.push(value);
                } else if (lastOp == '+') {
                    values.push(value);
                } else if (lastOp == '-') {
                    values.push(-value);
                } else if (lastOp == '*') {
                    values.push(values.pop() * value);
                } else {
                    values.push(values.pop() / value);
                }
                value = 0;
            } else {
                lastOp = c;
            }
        }

        int result = 0;
        while (!values.isEmpty()) {
            result += values.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.calculate("3+2*2")); // 7
        System.out.println(m.calculate(" 3/2 ")); // 1
        System.out.println(m.calculate(" 3+5 / 2 ")); // 5
        System.out.println(m.calculate("1+1+1")); // 3
        System.out.println(m.calculate("14/3*2")); // 8
        System.out.println(m.calculate("1*2-3/4+5*6-7*8+9/10")); // -24
        /*
        2-0+30-56+0
         */
    }
}

/*
https://leetcode.com/problems/baseball-game/
 */

import java.util.Stack;

public class Main {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String op : ops) {
            switch (op) {
                case "+" -> {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second);
                    stack.add(first);
                    stack.add(first + second);
                }
                case "D" -> stack.add(2 * stack.peek());
                case "C" -> stack.pop();
                default -> stack.add(Integer.parseInt(op));
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(m.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(m.calPoints(new String[]{"1"}));
    }
}

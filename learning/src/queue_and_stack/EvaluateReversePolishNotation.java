/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
package queue_and_stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String> items = new Stack<>();
        items.push(tokens[0]);
        if (tokens.length > 1)
            items.push(tokens[1]);

        for (int i = 2; i < tokens.length; i++) {
            String token = tokens[i];

            switch (token) {
                case "+" -> {
                    String item1 = items.pop();
                    String item2 = items.pop();
                    int result = Integer.parseInt(item1) + Integer.parseInt(item2);
                    items.push(result + "");
                }
                case "-" -> {
                    String item1 = items.pop();
                    String item2 = items.pop();
                    int result = Integer.parseInt(item2) - Integer.parseInt(item1);
                    items.push(result + "");
                }
                case "*" -> {
                    String item1 = items.pop();
                    String item2 = items.pop();
                    int result = Integer.parseInt(item1) * Integer.parseInt(item2);
                    items.push(result + "");
                }
                case "/" -> {
                    String item1 = items.pop();
                    String item2 = items.pop();
                    int result = Integer.parseInt(item2) / Integer.parseInt(item1);
                    items.push(result + "");
                }
                default -> items.push(token);
            }
        }

        return Integer.parseInt(items.pop());
    }

    public static void main(String[] args) {
        String[] token1 = new String[]{"2", "1", "+", "3", "*"};
        String[] token2 = new String[]{"4", "13", "5", "/", "+"};
        String[] token3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] token4 = new String[]{"18"};

        System.out.println(evalRPN(token1));
        System.out.println(evalRPN(token2));
        System.out.println(evalRPN(token3));
        System.out.println(evalRPN(token4));
    }
}

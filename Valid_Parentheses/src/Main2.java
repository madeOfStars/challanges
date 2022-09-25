import java.util.Stack;

public class Main2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() < 2)
            return false;

        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Main2 m = new Main2();

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "()";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "((";
        String s7 = "(){}}{";

        System.out.println(m.isValid(s1));
        System.out.println(m.isValid(s2));
        System.out.println(m.isValid(s3));
        System.out.println(m.isValid(s4));
        System.out.println(m.isValid(s5));
        System.out.println(m.isValid(s6));
        System.out.println(m.isValid(s7));
    }
}

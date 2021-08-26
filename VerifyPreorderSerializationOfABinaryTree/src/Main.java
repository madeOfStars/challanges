/*
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
import java.util.Stack;

public class Main {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();

        String[] nodes = preorder.split(",");

        for (String node : nodes) {
            if (node.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();

                    if (stack.isEmpty())
                        return false;

                    stack.pop();
                }
            }

            stack.push(node);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(m.isValidSerialization("1,#"));
        System.out.println(m.isValidSerialization("9,#,#,1"));
        System.out.println(m.isValidSerialization("#"));
        System.out.println(m.isValidSerialization("9,#,92,#,#"));
    }
}

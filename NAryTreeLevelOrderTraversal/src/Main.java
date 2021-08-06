/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return List.of();

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node polledElement = queue.poll();

                temp.add(polledElement.val);

                if (polledElement.children != null)
                    queue.addAll(polledElement.children);
            }

            result.add(new ArrayList<>(temp));
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        Node n1 = new Node(1);
        n1.children = new ArrayList<>();
        n1.children.add(new Node(3));
        n1.children.add(new Node(2));
        n1.children.add(new Node(4));

        n1.children.get(0).children = new ArrayList<>();
        n1.children.get(0).children.add(new Node(5));
        n1.children.get(0).children.add(new Node(6));

        System.out.println(m.levelOrder(n1));
    }
}

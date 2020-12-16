/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public static Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node polledNode = queue.poll();

                if (i != size - 1)
                    polledNode.next = queue.peek();

                if (polledNode.left != null)
                    queue.add(polledNode.left);
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        Node root1 = new Node(1);
        root1.left = new Node(2);

        Node connect = connect(root);
        System.out.println(connect);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }
}

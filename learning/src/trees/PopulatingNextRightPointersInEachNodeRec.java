/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeRec {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
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


    public Node connect(Node root) {
        if (root == null)
            return null;

        helper(root);

        return root;
    }

    private void helper(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;

        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeRec m = new PopulatingNextRightPointersInEachNodeRec();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(m.connect(root));
    }
}

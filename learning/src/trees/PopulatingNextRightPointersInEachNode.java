/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int k = 1;
        int l = 0;

        while (!queue.isEmpty()) {
            Node polledNode = queue.poll();

            if (k == Math.pow(2, l)) {
                l++;
                k = 0;
            } else {
                polledNode.next = queue.peek();

            }

            if (polledNode.left != null)
                queue.add((Node) polledNode.left);
            if (polledNode.right !=null)
                queue.add((Node) polledNode.right);

            k++;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(connect(root));
    }
}

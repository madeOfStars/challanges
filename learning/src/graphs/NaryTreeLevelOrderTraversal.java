/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */

package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    // Definition for a Node.
    static class Node {
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
            return Collections.emptyList();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        var result = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            var innerList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var polledNode = queue.poll();

                innerList.add(polledNode.val);

                queue.addAll(polledNode.children);
            }

            result.add(new ArrayList<>(innerList));
        }

        return result;
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal m = new NaryTreeLevelOrderTraversal();


        Node root1 = new Node(1);
        Node root3 = new Node(3);
        Node root2 = new Node(2);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);

        root1.children = List.of(root3, root2, root4);
        root3.children = List.of(root5, root6);

        System.out.println(m.levelOrder(root1));
    }
}

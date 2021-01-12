/*
https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

package queue_and_stack;

import trees.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode peekedNode = stack.peek();

            if (peekedNode.left != null && !visited.contains(peekedNode)) {
                stack.push(peekedNode.left);
                visited.add(peekedNode);
            } else {
                nodes.add(peekedNode.val);
                peekedNode = stack.pop();

                if (peekedNode.right != null)
                    stack.push(peekedNode.right);
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversalIterative main = new BinaryTreeInorderTraversalIterative();
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        TreeNode t2 = null;
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode t5 = new TreeNode(1, null, new TreeNode(2, null, null));

        System.out.println(main.inorderTraversal(t1));
        System.out.println(main.inorderTraversal(t2));
        System.out.println(main.inorderTraversal(t3));
        System.out.println(main.inorderTraversal(t4));
        System.out.println(main.inorderTraversal(t5));
    }
}

/*
https://leetcode.com/problems/boundary-of-binary-tree/
 */

package amz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        if (!isLeaf(root)) {
            ans.add(root.val);
        }

        TreeNode t = root.left;

        while (t != null) {
            if (!isLeaf(t)) {
                ans.add(t.val);
            }

            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }

        addLeaves(root, ans);

        Deque<Integer> deq = new ArrayDeque<>();

        t = root.right;

        while (t != null) {
            if (!isLeaf(t)) {
                deq.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }

        while (!deq.isEmpty()) {
            ans.add(deq.pop());
        }

        return ans;
    }

    private void addLeaves(TreeNode root, List<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(root.left, ans);
            }
            if (root.right != null) {
                addLeaves(root.right, ans);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

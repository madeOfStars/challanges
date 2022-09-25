/*
https://leetcode.com/problems/binary-tree-right-side-view/
 */

import java.util.ArrayList;
import java.util.List;

public class MainDFS {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private int max = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode root, int level, List<Integer> ans) {
        if (root == null)
            return;

        if (level > max) {
            max = level;
            ans.add(root.val);
        }

        helper(root.right, level + 1, ans);
        helper(root.left, level + 1, ans);
    }

    public static void main(String[] args) {
        MainDFS m = new MainDFS();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(4);

        t1.left.right.left = new TreeNode(6);

        System.out.println(m.rightSideView(t1));
    }
}

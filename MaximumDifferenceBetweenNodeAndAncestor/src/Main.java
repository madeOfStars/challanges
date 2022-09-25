/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

public class Main {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        int[] helper = helper(root);
        return helper[2];
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return null;

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int val = root.val;

        if (left == null) {
            left = new int[]{val, val, -val};
        }

        if (right == null) {
            right = new int[]{val, val, -val};
        }

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        int ans = Math.max(Math.max(Math.max(Math.abs(val - min), Math.abs(val - max)), left[2]), right[2]);

        return new int[]{Math.min(val, min), Math.max(val, max), ans};
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(8);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(10);

        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(6);

        t1.right.right = new TreeNode(14);

        t1.left.right.left = new TreeNode(4);
        t1.left.right.right = new TreeNode(7);

        t1.right.right.left = new TreeNode(13);

        System.out.println(m.maxAncestorDiff(t1));

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(0);
        t2.right.right.left = new TreeNode(3);

        System.out.println(m.maxAncestorDiff(t2));
    }
}

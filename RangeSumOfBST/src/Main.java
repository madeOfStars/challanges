/*
https://leetcode.com/problems/range-sum-of-bst/
 */

public class Main {
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


    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }

    private int helper(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int val = 0;

        if (root.val >= low && root.val <= high)
            val += root.val;

        if (low <= root.val)
            val += helper(root.left, low, high);

        if (high >= root.val)
            val += helper(root.right, low, high);

        return val;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(15);

        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(7);

        t1.right.right = new TreeNode(18);

        System.out.println(m.rangeSumBST(t1, 7, 15));
    }
}

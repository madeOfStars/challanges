/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
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

    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int tmpSum) {
        if (root == null)
            return 0;

        int sum = tmpSum * 2 + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return helper(root.left, sum) + helper(root.right, sum);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(0);
        t1.right = new TreeNode(1);

        t1.left.left = new TreeNode(0);
        t1.left.right = new TreeNode(1);

        t1.right.left = new TreeNode(0);
        t1.right.right = new TreeNode(1);

        System.out.println(m.sumRootToLeaf(t1));

        System.out.println(m.sumRootToLeaf(new TreeNode(0)));
    }
}

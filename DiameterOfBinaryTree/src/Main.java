/*
https://leetcode.com/problems/diameter-of-binary-tree/
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

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        this.diameter = Math.max(left + right, diameter);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
//        t1.right = new TreeNode(3);
//
//        t1.left.left = new TreeNode(4);
//        t1.left.right = new TreeNode(5);

        System.out.println(m.diameterOfBinaryTree(t1));
    }
}

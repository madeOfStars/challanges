/*
https://leetcode.com/problems/binary-tree-tilt/
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

    private int sum = 0;

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        helper(root);

        return sum;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        sum += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(9);

        t1.left.left = new TreeNode(3);
        t1.right.right = new TreeNode(7);

        t1.left.right = new TreeNode(5);

        System.out.println(m.findTilt(t1));
    }
}

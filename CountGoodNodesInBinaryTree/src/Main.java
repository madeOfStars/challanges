/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
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

    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int max) {
        if (root == null)
            return 0;

        int count = root.val >= max ? 1 : 0;

        return count + helper(root.left, Math.max(root.val, max)) + helper(root.right, Math.max(root.val, max));
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);

        t1.left.left = new TreeNode(3);

        t1.right.left = new TreeNode(1);
        t1.right.right = new TreeNode(5);

        System.out.println(m.goodNodes(t1));

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(3);

        t2.left.left = new TreeNode(4);
        t2.left.right = new TreeNode(2);

        System.out.println(m.goodNodes(t2));
    }
}

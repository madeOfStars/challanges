/*
https://leetcode.com/problems/invert-binary-tree/
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        helper(left);
        helper(right);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);

        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);

        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(9);

        System.out.println(m.invertTree(t1));
    }
}

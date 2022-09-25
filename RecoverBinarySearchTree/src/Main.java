/*
https://leetcode.com/problems/recover-binary-search-tree/
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

    private TreeNode prev;
    private TreeNode x;
    private TreeNode y;

    public void recoverTree(TreeNode root) {
        helper(root);
        swap();
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        if (prev != null && root.val < prev.val) {
            y = root;
            if (x == null)
                x = prev;
            else
                return;
        }

        prev = root;
        helper(root.right);
    }

    private void swap() {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);

        t1.right.left = new TreeNode(2);

        //m.recoverTree(t1);
        //System.out.println(t1);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.left.right = new TreeNode(2);

        System.out.println(t2);
        m.recoverTree(t2);
        System.out.println(t2);
    }
}

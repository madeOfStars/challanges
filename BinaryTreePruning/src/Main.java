/*
https://leetcode.com/problems/binary-tree-pruning/
 */
public class Main {
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

    public TreeNode pruneTree(TreeNode root) {
        root = helper(root);
        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null)
            return null;

        root.left = helper(root.left);
        root.right = helper(root.right);

        if (root.left == null && root.right == null && root.val == 0)
            root = null;

        return root;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(0);
        t1.right.left = new TreeNode(0);
        t1.right.right = new TreeNode(1);

        System.out.println(m.pruneTree(t1));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(0);
        t2.left.left = new TreeNode(0);
        t2.left.right = new TreeNode(0);

        t2.right = new TreeNode(1);
        t2.right.left = new TreeNode(0);
        t2.right.right = new TreeNode(1);

        System.out.println(m.pruneTree(t2));

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(1);
        t3.left.left = new TreeNode(1);
        t3.left.right = new TreeNode(1);
        t3.left.left.left = new TreeNode(0);

        t3.right = new TreeNode(0);
        t3.right.left = new TreeNode(0);
        t3.right.right = new TreeNode(1);

        System.out.println(m.pruneTree(t3));
    }
}

/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root, val);
    }

    private TreeNode helper(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = helper(root.left, val);
        } else {
            root.right = helper(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);

        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);

        System.out.println(m.insertIntoBST(t1, 5));
    }
}

/*
https://leetcode.com/problems/increasing-order-search-tree/
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

    TreeNode ans = new TreeNode();
    TreeNode curr = ans;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return ans.right;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        helper(root.right);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(6);

        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(4);

        t1.right.right = new TreeNode(8);

        t1.left.left.left = new TreeNode(1);

        t1.right.right.left = new TreeNode(7);
        t1.right.right.right = new TreeNode(9);

        System.out.println(m.increasingBST(t1));
    }
}

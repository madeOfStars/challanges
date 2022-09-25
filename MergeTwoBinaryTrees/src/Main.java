/*
https://leetcode.com/problems/merge-two-binary-trees/
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;

        TreeNode ans = new TreeNode();
        ans.left = new TreeNode();

        helper(root1, root2, ans.left);

        return ans.left;
    }

    private void helper(TreeNode root1, TreeNode root2, TreeNode result) {
        if (root1 == null && root2 == null) {
            return;
        }


        int val1 = root1 != null ? root1.val : 0;
        int val2 = root2 != null ? root2.val : 0;

        result.val = val1 + val2;
        if ((root1 != null && root1.left != null) || (root2 != null && root2.left != null)) {
            result.left = new TreeNode();
        }

        if ((root1 != null && root1.right != null) || (root2 != null && root2.right != null)) {
            result.right = new TreeNode();
        }

        helper(root1 != null ? root1.left : null, root2 != null ? root2.left : null, result.left);
        helper(root1 != null ? root1.right : null, root2 != null ? root2.right : null, result.right);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);

        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);

        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        System.out.println(m.mergeTrees(t1, t2));
    }
}

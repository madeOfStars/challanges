package trees;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3, new TreeNode(9, new TreeNode(5), null), new TreeNode(20, new TreeNode(15, new TreeNode(77), null), new TreeNode(7)));

        System.out.println(maxDepth(t1));
    }
}

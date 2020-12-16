package trees;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        else if (sum - root.val == 0 && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(1);

        TreeNode t10 = new TreeNode(1);
        t10.left = t8;

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;

        t4.left = t7;
        t4.right = t8;

        t6.right = t9;

        System.out.println(hasPathSum(t1, 22));
    }
}

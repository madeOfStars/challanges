/*
https://leetcode.com/problems/validate-binary-search-tree/
 */

public class MainAttempt2 {
    static class TreeNode {
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
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && min >= root.val) || (max != null && max <= root.val))
            return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public static void main(String[] args) {
        MainAttempt2 m = new MainAttempt2();

        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(60);

        t1.right.left = new TreeNode(50);
        t1.right.right = new TreeNode(70);

        t1.right.left.left = new TreeNode(40);
        t1.right.left.right = new TreeNode(55);

        t1.right.right.left = new TreeNode(65);
        t1.right.right.right = new TreeNode(90);

        System.out.println(m.isValidBST(t1)); // true

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(1);

        System.out.println(m.isValidBST(t2)); // false

        TreeNode t3 = new TreeNode(2);
        t3.left = new TreeNode(1);
        t3.right = new TreeNode(3);

        System.out.println(m.isValidBST(t3)); // true

        TreeNode t4 = new TreeNode(5);
        t4.left = new TreeNode(1);
        t4.right = new TreeNode(4);

        t4.right.left = new TreeNode(3);
        t4.right.right = new TreeNode(6);

        System.out.println(m.isValidBST(t4)); // false

        TreeNode t5 = new TreeNode(5);
        t5.left = new TreeNode(4);
        t5.right = new TreeNode(6);

        t5.right.left = new TreeNode(3);
        t5.right.right = new TreeNode(7);

        System.out.println(m.isValidBST(t5)); // false

        TreeNode t6 = new TreeNode(0);
        t6.right = new TreeNode(1);

        System.out.println(m.isValidBST(t6)); // true
    }
}

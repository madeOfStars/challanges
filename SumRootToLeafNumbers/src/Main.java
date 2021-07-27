/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        if (root == null)
            return 0;

        num = num * 10 + root.val;

        if (root.left == null && root.right == null)
            return num;

        return helper(root.left, num) + helper(root.right, num);
    }

    public static void main(String[] args) {
        Main m = new Main();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

//        System.out.println(m.sumNumbers(t1));

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(0);

        t2.left.left = new TreeNode(5);
        t2.left.right = new TreeNode(1);

        System.out.println(m.sumNumbers(t2));
    }
}

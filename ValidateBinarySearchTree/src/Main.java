public class Main {
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
        if (root.left == null && root.right == null)
            return true;

        int[] left = isValid(root.left);
        int[] right = isValid(root.right);

        return left[0] + right[0] > 1 && root.val > left[2] & root.val < right[1];
    }

    private int[] isValid(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = isValid(root.left);
        int[] right = isValid(root.right);

        int val = root.val;

        boolean k1 = val > left[2] && val < right[1];

        return new int[]{k1 ? 1 : 0, Math.min(val, left[1]), Math.max(val, right[2])};
    }

    public static void main(String[] args) {
        Main m = new Main();

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
